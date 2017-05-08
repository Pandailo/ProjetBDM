/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdVideo;

/**
 *
 * @author Yann
 */
public class frame_jeu extends javax.swing.JFrame
{
    boolean admin;
    String cheminPhoto;
    int id;
    String fich="",vid="",aud="";
    Image photo;
    Connection con;
    /**
     * Creates new form frame_jeu
     */
    public frame_jeu(boolean admin,int idJ) throws SQLException, IOException
    {
        this.id=idJ;
        try
        {
            initComponents();
            this.edition.setLineWrap(true);
            this.admin=admin;
            if(!admin){
                this.pan_buttons.remove(button_ajout_ba);
                this.pan_admin.removeAll();
                this.pan_buttons.setLayout(new java.awt.GridLayout(1, 1));
            }
            con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            String titre="";
            String synopsis="";
            String temp="";
            String nomA="";
            String genre="";
            String DDS="";
            int note=0;
            //REMPLISSAGE DU RESUME
            OracleResultSet rs=(OracleResultSet)st.executeQuery("SELECT nom,synopsis,genre,dateSortie,note FROM PBDM_JeuVideo WHERE id="+idJ);
            while(rs.next())
            {
                titre=rs.getString(1);
                synopsis=rs.getString(2);
                genre=rs.getString(3);
                DDS=rs.getString(4);
                note=rs.getInt(5);
            }
            this.label_titre.setText(titre);
            rs=(OracleResultSet)st.executeQuery("SELECT DEREF(acteurMA).nom FROM PBDM_MedVidActeur WHERE DEREF(MedVidMa).id="+idJ+" order by DEREF(acteurMA).nom");
            while(rs.next())
            {
                temp=rs.getString(1);
                if(temp==null)
                {
                    temp="";
                }
                nomA+=temp+"\n";
            }
            this.edition.append("Titre du jeu : "+titre+"\n");
            this.edition.append("Note moyenne obtenue : "+note+"\n");
            this.edition.append("Acteurs :"+nomA+"\n");
            this.edition.append("Genre :"+genre+"\n");
            this.edition.append("Date de sortie :"+DDS+"\n");
            this.edition.append("Synopsis : "+synopsis+"\n");
            
            //AFFICHAGE DE L'IMAGE
            rs=(OracleResultSet)st.executeQuery("select image from PBDM_JeuVideo where id="+idJ);
            while(rs.next())
            {
                OrdImage imgObj= (OrdImage)rs.getORAData(1,OrdImage.getORADataFactory());
                fich=""+titre+".jpg";
                imgObj.getDataInFile(fich);
                photo=this.pan_affiche.getToolkit().getImage(fich);
                affiche();
                File fichiertemp = new File(fich);
                if(fichiertemp.exists())
                    fichiertemp.delete();
            }
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(frame_jeu.class.getName()).log(Level.SEVERE, null, ex);
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

        label_titre = new javax.swing.JLabel();
        pan_buttons = new javax.swing.JPanel();
        button_ba = new javax.swing.JButton();
        button_ajout_ba = new javax.swing.JButton();
        button_recherche = new javax.swing.JButton();
        pan_principal = new javax.swing.JPanel();
        pan_text = new javax.swing.JScrollPane();
        edition = new javax.swing.JTextArea();
        pan_affiche = new javax.swing.JPanel();
        pan_image = new javax.swing.JPanel();
        pan_imaffiche = new javax.swing.JPanel();
        pan_admin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pan_ajout = new javax.swing.JPanel();
        button_modif_affiche = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(720, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        label_titre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titre.setText("titre jeu");
        getContentPane().add(label_titre, java.awt.BorderLayout.NORTH);

        pan_buttons.setLayout(new java.awt.GridLayout(1, 2));

        button_ba.setText("Bande-annonce");
        button_ba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_baActionPerformed(evt);
            }
        });
        pan_buttons.add(button_ba);

        button_ajout_ba.setText("Ajouter une bande-annonce");
        button_ajout_ba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ajout_baActionPerformed(evt);
            }
        });
        pan_buttons.add(button_ajout_ba);

        button_recherche.setText("Chercher des jeu similaires");
        button_recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_rechercheActionPerformed(evt);
            }
        });
        pan_buttons.add(button_recherche);

        getContentPane().add(pan_buttons, java.awt.BorderLayout.SOUTH);

        pan_principal.setLayout(new java.awt.GridLayout(1, 2));

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

        javax.swing.GroupLayout pan_imageLayout = new javax.swing.GroupLayout(pan_image);
        pan_image.setLayout(pan_imageLayout);
        pan_imageLayout.setHorizontalGroup(
            pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pan_imageLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pan_imaffiche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pan_imageLayout.setVerticalGroup(
            pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pan_imageLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pan_imaffiche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pan_affiche.add(pan_image, java.awt.BorderLayout.NORTH);

        pan_admin.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ajouter une affiche");
        pan_admin.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        pan_ajout.setLayout(new java.awt.GridLayout(1, 2));

        button_modif_affiche.setText("Modifier l'image de couverture");
        button_modif_affiche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modif_afficheActionPerformed(evt);
            }
        });
        pan_ajout.add(button_modif_affiche);

        pan_admin.add(pan_ajout, java.awt.BorderLayout.CENTER);

        pan_affiche.add(pan_admin, java.awt.BorderLayout.SOUTH);

        pan_principal.add(pan_affiche);

        getContentPane().add(pan_principal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
            this.affiche();
            try
            {
                int index=0;
                con=connexionUtils.getInstance().getConnexion();
                con.setAutoCommit(false);
                Statement s=null;
                s = con.createStatement();
                OracleResultSet rs=null;
                rs=(OracleResultSet)s.executeQuery("select id, image from PBDM_JeuVideo where nom='"+this.label_titre.getText()+"' for update");
                while(rs.next())
                {
                    index=rs.getInt(1);
                    OrdImage imgObj= (OrdImage)rs.getORAData(2,OrdImage.getORADataFactory());
                    String img=this.cheminPhoto;
                    imgObj.loadDataFromFile(img);
                    imgObj.setProperties();
                    OraclePreparedStatement stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_JeuVideo set image=? where id="+index);
                    stmt1.setORAData(1,imgObj);
                    stmt1.execute();
                    stmt1.close();   
                }
                rs=(OracleResultSet)s.executeQuery("ALTER INDEX PBDM_indexJ REBUILD");
                rs.close();
                s.close();
                con.commit();
            }
            catch (SQLException | IOException | ClassNotFoundException ex)
            {
                Logger.getLogger(frame_jeu.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }//GEN-LAST:event_button_modif_afficheActionPerformed

    private void button_baActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_baActionPerformed
        try {
            vid="";
            con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            OracleResultSet rs=(OracleResultSet)st.executeQuery("select bandeA from PBDM_JeuVideo where id="+id);
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
            
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(frame_jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_baActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        File imagetemp = new File(fich);
        File videotemp=null;
        if (vid!="")
            videotemp = new File(vid);
        if(imagetemp.exists())
            imagetemp.delete();
        if(videotemp!=null)
            videotemp.delete();
    }//GEN-LAST:event_formWindowClosing

    private void button_rechercheActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_button_rechercheActionPerformed
    {//GEN-HEADEREND:event_button_rechercheActionPerformed
        Double seuil=0.0;
        JOptionPane jop = new JOptionPane();
        seuil = Double.parseDouble(jop.showInputDialog(null, "Seuil mini ?", "", JOptionPane.QUESTION_MESSAGE));
        frame_compareI_pond fmcp=new frame_compareI_pond(this.admin,this.id,seuil);
        fmcp.setVisible(true);
    }//GEN-LAST:event_button_rechercheActionPerformed

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
                rs=(OracleResultSet)s.executeQuery("select id, bandeA from PBDM_JeuVideo where nom='"+this.label_titre.getText()+"' for update");
                while(rs.next())
                {
                    index=rs.getInt(1);
                    OrdVideo vidObj= (OrdVideo)rs.getORAData(2,OrdVideo.getORADataFactory());
                    String vid =cheminBA;
                    vidObj.loadDataFromFile(vid);
                    byte[] ctx[] = new byte [4000][1];
                    vidObj.setProperties(ctx);
                    OraclePreparedStatement stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_JeuVideo set bandeA=? where id="+index);
                    stmt1.setORAData(1,vidObj);
                    stmt1.execute();
                    stmt1.close();   
                }
                rs=(OracleResultSet)s.executeQuery("ALTER INDEX PBDM_indexJ REBUILD");
                rs.close();
                s.close();
                con.commit();
            }
            catch (SQLException | IOException | ClassNotFoundException ex)
            {
                Logger.getLogger(frame_jeu.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_button_ajout_baActionPerformed
    @Override
     public void paint(Graphics g)
    {
        super.paint(g);
        if(this.photo!=null)
            this.affiche();
    }
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
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(frame_jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(frame_jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(frame_jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(frame_jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ajout_ba;
    private javax.swing.JButton button_ba;
    private javax.swing.JButton button_modif_affiche;
    private javax.swing.JButton button_recherche;
    private javax.swing.JTextArea edition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_titre;
    private javax.swing.JPanel pan_admin;
    private javax.swing.JPanel pan_affiche;
    private javax.swing.JPanel pan_ajout;
    private javax.swing.JPanel pan_buttons;
    private javax.swing.JPanel pan_imaffiche;
    private javax.swing.JPanel pan_image;
    private javax.swing.JPanel pan_principal;
    private javax.swing.JScrollPane pan_text;
    // End of variables declaration//GEN-END:variables
}
