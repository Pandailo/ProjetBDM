/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.ord.im.OrdAudio;
import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdVideo;

/**
 *
 * @author Yann
 */
public class frame_film extends javax.swing.JFrame
{
    boolean admin;
    private Image photo=null;
    private String cheminPhoto="";
    int id=-1;
    String fich="",vid="",aud="",titre="";
    Connection con;
    ArrayList<Integer> l_id;

    /**
     * Creates new form frame_film
     * @param admin
     * @param idF
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public frame_film(boolean admin,int idF) throws ClassNotFoundException, IOException
    {
        this.id=idF;
        l_id=new ArrayList();
        
        try
        {
            initComponents();
            this.edition.setLineWrap(true);
            this.admin=admin;
            if(!admin){
                this.pan_bo.remove(button_ajout_bo);
                this.pan_ba.remove(button_ajout_ba);
                this.pan_admin.removeAll();
                this.pan_bo.setLayout(new java.awt.GridLayout(1, 1));
                this.pan_ba.setLayout(new java.awt.GridLayout(1, 1));
            }
            con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            String synopsis="";
            String nomR="";
            String temp="";
            String nomA="";
            String genre="";
            String DDS="";
            //REMPLISSAGE DU RESUME
            OracleResultSet rs=(OracleResultSet)st.executeQuery("SELECT nom,synopsis,genre,dateSortie FROM PBDM_Film WHERE id="+idF);
            while(rs.next())
            {
                titre=rs.getString(1);
                synopsis=rs.getString(2);
                genre=rs.getString(3);
                DDS=rs.getString(4);
            }
            this.label_titre.setText(titre);
            rs=(OracleResultSet)st.executeQuery("SELECT DEREF(realisateur).nom FROM PBDM_Film f WHERE f.id="+idF+"order by DEREF(realisateur).nom");
            while(rs.next())
            {
                nomR=rs.getString(1);
                if(nomR==null)
                {
                    nomR="";
                }
            }
            rs=(OracleResultSet)st.executeQuery("SELECT DEREF(acteurMA).nom FROM PBDM_MedVidActeur WHERE DEREF(MedVidMa).id="+idF+" order by DEREF(acteurMA).nom");
            while(rs.next())
            {
                temp=rs.getString(1);
                if(temp==null)
                {
                    temp="";
                }
                nomA+=temp+"\n";
            }
            this.edition.append("Titre du film : "+titre+"\n");
            this.edition.append("Nom du réalisateur : "+nomR+"\n");
            this.edition.append("Acteurs :"+nomA+"\n");
            this.edition.append("Genre :"+genre+"\n");
            this.edition.append("Date de sortie :"+DDS+"\n");
            this.edition.append("Synopsis : "+synopsis+"\n");
            
            //AFFICHAGE DE L'IMAGE
            rs=(OracleResultSet)st.executeQuery("select image from PBDM_Film where id="+idF);
            while(rs.next())
            {
                OrdImage imgObj= (OrdImage)rs.getORAData(1,OrdImage.getORADataFactory());
                fich=""+titre+".jpg";
                imgObj.getDataInFile(fich);
                photo=this.pan_affiche.getToolkit().getImage(fich);
                MediaTracker tracker=new MediaTracker(this);
                tracker.addImage(this.photo,0);
                try {tracker.waitForID(0);}
                catch(InterruptedException e) {}
                affiche();
                imgObj=null;
                File fichiertemp = new File(fich);
                if(fichiertemp.exists())
                    fichiertemp.delete();
                fich="";
            }
            rs.close();
            st.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_titre = new javax.swing.JLabel();
        pan_principal = new javax.swing.JPanel();
        pan_text = new javax.swing.JScrollPane();
        edition = new javax.swing.JTextArea();
        pan_affiche = new javax.swing.JPanel();
        pan_image = new javax.swing.JPanel();
        pan_imaffiche = new javax.swing.JPanel();
        compareFilm_button = new javax.swing.JButton();
        pan_admin = new javax.swing.JPanel();
        lab_ajout_affiche = new javax.swing.JLabel();
        pan_ajout = new javax.swing.JPanel();
        button_modif_affiche = new javax.swing.JButton();
        pan_buttons = new javax.swing.JPanel();
        pan_bo = new javax.swing.JPanel();
        button_ajout_bo = new javax.swing.JButton();
        button_bo = new javax.swing.JButton();
        pan_ba = new javax.swing.JPanel();
        button_ajout_ba = new javax.swing.JButton();
        button_ba = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        jPanel1.setPreferredSize(new java.awt.Dimension(720, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        label_titre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titre.setText("titre film");
        jPanel1.add(label_titre, java.awt.BorderLayout.NORTH);

        pan_principal.setLayout(new java.awt.GridLayout(1, 0));

        pan_text.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        edition.setEditable(false);
        edition.setColumns(20);
        edition.setRows(5);
        pan_text.setViewportView(edition);

        pan_principal.add(pan_text);

        pan_affiche.setLayout(new java.awt.BorderLayout());

        pan_imaffiche.setMinimumSize(new java.awt.Dimension(100, 125));
        pan_imaffiche.setPreferredSize(new java.awt.Dimension(100, 125));

        javax.swing.GroupLayout pan_imafficheLayout = new javax.swing.GroupLayout(pan_imaffiche);
        pan_imaffiche.setLayout(pan_imafficheLayout);
        pan_imafficheLayout.setHorizontalGroup(
            pan_imafficheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pan_imafficheLayout.setVerticalGroup(
            pan_imafficheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        compareFilm_button.setText("Rechercher des films à ambiance similaire");
        compareFilm_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compareFilm_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan_imageLayout = new javax.swing.GroupLayout(pan_image);
        pan_image.setLayout(pan_imageLayout);
        pan_imageLayout.setHorizontalGroup(
            pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_imageLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(pan_imaffiche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_imageLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(compareFilm_button, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pan_imageLayout.setVerticalGroup(
            pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_imageLayout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(pan_imaffiche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(compareFilm_button)
                .addContainerGap())
        );

        pan_affiche.add(pan_image, java.awt.BorderLayout.CENTER);

        pan_admin.setLayout(new java.awt.BorderLayout());

        lab_ajout_affiche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_ajout_affiche.setText("Ajouter une affiche");
        lab_ajout_affiche.setMaximumSize(new java.awt.Dimension(123456, 123456));
        pan_admin.add(lab_ajout_affiche, java.awt.BorderLayout.NORTH);

        pan_ajout.setLayout(new java.awt.GridLayout(1, 0));

        button_modif_affiche.setText("Modifier l'affiche");
        button_modif_affiche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modif_afficheActionPerformed(evt);
            }
        });
        pan_ajout.add(button_modif_affiche);

        pan_admin.add(pan_ajout, java.awt.BorderLayout.CENTER);

        pan_affiche.add(pan_admin, java.awt.BorderLayout.SOUTH);

        pan_principal.add(pan_affiche);

        jPanel1.add(pan_principal, java.awt.BorderLayout.CENTER);

        pan_buttons.setLayout(new java.awt.GridLayout(1, 2));

        pan_bo.setLayout(new java.awt.GridLayout(2, 1));

        button_ajout_bo.setText("Ajouter une bande originale");
        button_ajout_bo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ajout_boActionPerformed(evt);
            }
        });
        pan_bo.add(button_ajout_bo);

        button_bo.setText("Bande originale");
        button_bo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_boActionPerformed(evt);
            }
        });
        pan_bo.add(button_bo);

        pan_buttons.add(pan_bo);

        pan_ba.setLayout(new java.awt.GridLayout(2, 1));

        button_ajout_ba.setText("Ajouter une bande-annonce");
        button_ajout_ba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ajout_baActionPerformed(evt);
            }
        });
        pan_ba.add(button_ajout_ba);

        button_ba.setText("Bande-annonce");
        button_ba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_baActionPerformed(evt);
            }
        });
        pan_ba.add(button_ba);

        pan_buttons.add(pan_ba);

        jPanel1.add(pan_buttons, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if(this.photo!=null)
            this.affiche();
    }
    private void affiche()
    {
        Graphics g = this.pan_image.getGraphics();
        g.drawImage(this.photo, 0, 0, this.pan_imaffiche.getWidth(), this.pan_imaffiche.getHeight(), this);
        
    }
    private void button_modif_afficheActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_button_modif_afficheActionPerformed
    {//GEN-HEADEREND:event_button_modif_afficheActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir une photo");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "bmp", "jpg", "jpeg", "png");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        if(fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            //Récupération de l'image
            this.cheminPhoto = fileChooser.getSelectedFile().getAbsolutePath();
            this.photo = Toolkit.getDefaultToolkit().getImage(this.cheminPhoto);
            MediaTracker tracker=new MediaTracker(this);
            tracker.addImage(this.photo,0);
            try {tracker.waitForID(0);}
            catch(InterruptedException e) {}
            this.affiche();
            try
            {
                int index=0;
                con=connexionUtils.getInstance().getConnexion();
                con.setAutoCommit(false);
                Statement s=null;
                s = con.createStatement();
                OracleResultSet rs=null;
                rs=(OracleResultSet)s.executeQuery("select id, image from PBDM_Film where nom='"+this.label_titre.getText()+"' for update");
                while(rs.next())
                {
                    index=rs.getInt(1);
                    OrdImage imgObj= (OrdImage)rs.getORAData(2,OrdImage.getORADataFactory());
                    String img =this.cheminPhoto;
                    imgObj.loadDataFromFile(img);
                    imgObj.setProperties();
                    OraclePreparedStatement stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_Film set image=? where id="+index);
                    stmt1.setORAData(1,imgObj);
                    imgObj=null;
                    stmt1.execute();
                    stmt1.close();   
                }
                rs=(OracleResultSet)s.executeQuery("ALTER INDEX PBDM_indexF REBUILD");
                rs.close();
                s.close();
                con.commit();
            }
            catch (SQLException | IOException | ClassNotFoundException ex)
            {
                Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_button_modif_afficheActionPerformed

    private void button_ajout_baActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ajout_baActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir une vidéo");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Videos", "avi", "mkv", "mp4");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        if(fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            //Récupération de la video
            String cheminBA = fileChooser.getSelectedFile().getAbsolutePath();
            try
            {
                int index=0;
                con=connexionUtils.getInstance().getConnexion();
                con.setAutoCommit(false);
                Statement s=null;
                s = con.createStatement();
                OracleResultSet rs=null;
                rs=(OracleResultSet)s.executeQuery("select id, bandeA from PBDM_Film where nom='"+this.label_titre.getText()+"' for update");
                while(rs.next())
                {
                    index=rs.getInt(1);
                    OrdVideo vidObj= (OrdVideo)rs.getORAData(2,OrdVideo.getORADataFactory());
                    String vid =cheminBA;
                    vidObj.loadDataFromFile(vid);
                    byte[] ctx[] = new byte [4000][1];
                    vidObj.setProperties(ctx);
                    OraclePreparedStatement stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_Film set bandeA=? where id="+index);
                    stmt1.setORAData(1,vidObj);
                    stmt1.execute();
                    stmt1.close();   
                }
                rs=(OracleResultSet)s.executeQuery("ALTER INDEX PBDM_indexF REBUILD");
                rs.close();
                s.close();
                con.commit();
            }
            catch (SQLException | IOException | ClassNotFoundException ex)
            {
                Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_button_ajout_baActionPerformed

    private void button_baActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_baActionPerformed
        try {
            vid="";
            con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            OracleResultSet rs=(OracleResultSet)st.executeQuery("select bandeA from PBDM_Film where id="+id);
            while(rs.next())
            {
                OrdVideo vidObj= (OrdVideo)rs.getORAData(1,OrdVideo.getORADataFactory());
                vid="vid_temp.avi";
                vidObj.getDataInFile(vid);
                Runtime runtime = Runtime.getRuntime();
                try
                {
                    runtime.exec("vlc "+vid);
                }
                catch (IOException ex)
                {
                     try
                    {
                        Runtime.getRuntime().exec("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe "+vid);
                    }
                    catch (IOException ex1)
                    {
                        Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
            rs.close();
            st.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_baActionPerformed

    private void button_boActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_boActionPerformed
        try {
            aud="";
            con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            OracleResultSet rs=(OracleResultSet)st.executeQuery("select bandeO from PBDM_Film where id="+id);
            while(rs.next())
            {
                OrdAudio audObj= (OrdAudio)rs.getORAData(1,OrdAudio.getORADataFactory());
                aud="son_temp.mp3";
                audObj.getDataInFile(aud);
                Runtime runtime = Runtime.getRuntime();
                try
                {
                    runtime.exec("vlc "+aud);
                }
                catch (IOException ex)
                {
                    try
                    {
                        Runtime.getRuntime().exec("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe "+aud);
                    }
                    catch (IOException ex1)
                    {
                        Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                   
                }
            }
            rs.close();
            st.close();
        } catch (SQLException | ClassNotFoundException ex) {
           
           Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_button_boActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        File imagetemp = new File(fich);
        File videotemp=null;
        if (vid!="")
            videotemp = new File(vid);
        File audiotemp=null;
        if (aud!="")
            audiotemp = new File(aud);
        if(imagetemp.exists())
            imagetemp.delete();
        if(videotemp!=null)
            videotemp.delete();
        if(audiotemp!=null)
            audiotemp.delete();
    }//GEN-LAST:event_formWindowClosing

    private void compareFilm_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_compareFilm_buttonActionPerformed
    {//GEN-HEADEREND:event_compareFilm_buttonActionPerformed
        Double seuil=0.0;
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        seuil = Double.parseDouble(jop.showInputDialog(null, "Seuil mini ?", "", JOptionPane.QUESTION_MESSAGE));
        try
        {
            int idF=0;
            String nomJ="";
            double score;
            
            OraclePreparedStatement stmt2 = (OraclePreparedStatement)connexionUtils.getInstance().getConnexion().prepareStatement("SELECT id,nom FROM PBDM_Film WHERE id<>?");
            stmt2.setInt(1, this.id);
            OracleResultSet rs2 = (OracleResultSet)stmt2.executeQuery();
            CallableStatement cstmt = connexionUtils.getInstance().getConnexion().prepareCall("{?=call compareF(?,?)}");
            cstmt.registerOutParameter(1, Types.DOUBLE);
            while(rs2.next())
            {
                idF=rs2.getInt(1);
                nomJ=rs2.getString(2);
                cstmt.setInt(2, id);
                cstmt.setInt(3, idF);
                cstmt.execute();
                score = cstmt.getDouble(1);
                if(score<seuil)
                    this.l_id.add(idF);
            }
            cstmt.close();
            rs2.close();
            stmt2.close();
            frame_transition ft=new frame_transition(this.admin,"film",l_id,null,"");
            ft.setVisible(true);
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_compareFilm_buttonActionPerformed

    private void button_ajout_boActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ajout_boActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir une musique");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Musiques", "mp3", "wav","midi","flac");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        if(fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            //Récupération du fichier son
            String cheminBO = fileChooser.getSelectedFile().getAbsolutePath();
            try
            {
                int index=0;
                con=connexionUtils.getInstance().getConnexion();
                con.setAutoCommit(false);
                Statement s=null;
                s = con.createStatement();
                OracleResultSet rs=null;
                rs=(OracleResultSet)s.executeQuery("select id, bandeO from PBDM_Film where nom='"+this.label_titre.getText()+"' for update");
                while(rs.next())
                {
                    index=rs.getInt(1);
                    OrdAudio audObj= (OrdAudio)rs.getORAData(2,OrdAudio.getORADataFactory());
                    String aud =cheminBO;
                    audObj.loadDataFromFile(aud);
                    byte[] ctx[] = new byte [4000][1];
                    audObj.setProperties(ctx);
                    OraclePreparedStatement stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_Film set bandeO=? where id="+index);
                    stmt1.setORAData(1,audObj);
                    stmt1.execute();
                    stmt1.close();   
                }
                rs=(OracleResultSet)s.executeQuery("ALTER INDEX PBDM_indexF REBUILD");
                rs.close();
                s.close();
                con.commit();
            }
            catch (SQLException | IOException | ClassNotFoundException ex)
            {
                Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_button_ajout_boActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(frame_film.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ajout_ba;
    private javax.swing.JButton button_ajout_bo;
    private javax.swing.JButton button_ba;
    private javax.swing.JButton button_bo;
    private javax.swing.JButton button_modif_affiche;
    private javax.swing.JButton compareFilm_button;
    private javax.swing.JTextArea edition;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lab_ajout_affiche;
    private javax.swing.JLabel label_titre;
    private javax.swing.JPanel pan_admin;
    private javax.swing.JPanel pan_affiche;
    private javax.swing.JPanel pan_ajout;
    private javax.swing.JPanel pan_ba;
    private javax.swing.JPanel pan_bo;
    private javax.swing.JPanel pan_buttons;
    private javax.swing.JPanel pan_imaffiche;
    private javax.swing.JPanel pan_image;
    private javax.swing.JPanel pan_principal;
    private javax.swing.JScrollPane pan_text;
    // End of variables declaration//GEN-END:variables
}
