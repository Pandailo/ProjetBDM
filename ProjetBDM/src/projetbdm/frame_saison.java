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
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdVideo;

/**
 *
 * @author Monsieur Blu
 */
public class frame_saison extends javax.swing.JFrame {
    boolean admin;
    String cheminPhoto;
    Image photo;
    int id;
    String fich="",vid="",titre="";
    Connection con;
    /**
     * Creates new form frame_saison
     * @param admin
     * @param idSa
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public frame_saison(boolean admin, int idSa) throws IOException, ClassNotFoundException {
        Connection con;
        this.id=idSa;
        try
        {
            initComponents();
            this.edition.setLineWrap(true);
            this.admin=admin;
            if(!admin){
                this.pan_episode.remove(button_ajout_ep);
                this.pan_ba.remove(button_ajout_ba);
                this.pan_admin.removeAll();
                this.pan_episode.setLayout(new java.awt.GridLayout(1, 2));
                this.pan_ba.setLayout(new java.awt.GridLayout(1, 1));
            }
        
            con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            String numS="";
            String Se="";
            String temp="";

            //REMPLISSAGE DU RESUME
            OracleResultSet rs=(OracleResultSet)st.executeQuery("SELECT id,numS FROM PBDM_Saison WHERE id="+idSa);
            while(rs.next())
            {
                numS=rs.getString(2);
            }
            this.label_titre.setText("Saison "+numS);
            rs=(OracleResultSet)st.executeQuery("SELECT DEREF(serie).nom FROM PBDM_Saison sa WHERE sa.id="+idSa);
            while(rs.next())
            {
                Se=rs.getString(1);
                if(Se==null)
                {
                    Se="";
                }
            }

            this.edition.append("Nom de la série : "+Se+"\n");
            this.edition.append("Numéro de saison : "+numS+"\n");
            this.edition.append("Episodes :\n");

            //AFFICHAGE DE L'IMAGE
            rs=(OracleResultSet)st.executeQuery("select image from PBDM_Saison where id="+idSa);
            while(rs.next())
            {
                OrdImage imgObj= (OrdImage)rs.getORAData(1,OrdImage.getORADataFactory());
                fich="im_temp.jpg";
                imgObj.getDataInFile(fich);
                photo=this.pan_affiche.getToolkit().getImage(fich);
                affiche();  
                File fichiertemp = new File(fich);
                if(fichiertemp.exists())
                    fichiertemp.delete();
            }
            rs.close();
            st.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(frame_saison.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            con=connexionUtils.getInstance().getConnexion();
            OraclePreparedStatement s=(OraclePreparedStatement)con.prepareStatement("SELECT nom,numero FROM THE(SELECT episodes FROM PBDM_Saison WHERE id=? ) ORDER BY numero ASC");
            s.setInt(1, this.id);
            OracleResultSet rs=(OracleResultSet)s.executeQuery();
            while(rs.next())
            {
                this.edition.append("Episode "+rs.getString(2)+": "+rs.getString(1)+"\n");
                this.cb_episode.addItem(rs.getString(1));
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(frame_saison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        label_titre = new javax.swing.JLabel();
        pan_principal = new javax.swing.JPanel();
        pan_text = new javax.swing.JScrollPane();
        edition = new javax.swing.JTextArea();
        pan_affiche = new javax.swing.JPanel();
        pan_image = new javax.swing.JPanel();
        pan_imaffiche = new javax.swing.JPanel();
        pan_admin = new javax.swing.JPanel();
        lab_ajout_affiche = new javax.swing.JLabel();
        pan_ajout = new javax.swing.JPanel();
        button_chgt_infos = new javax.swing.JButton();
        button_modif_affiche = new javax.swing.JButton();
        pan_button = new javax.swing.JPanel();
        pan_episode = new javax.swing.JPanel();
        cb_episode = new javax.swing.JComboBox<>();
        button_episode = new javax.swing.JButton();
        button_ajout_ep = new javax.swing.JButton();
        pan_ba = new javax.swing.JPanel();
        button_ba = new javax.swing.JButton();
        button_ajout_ba = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(720, 600));
        addWindowFocusListener(new java.awt.event.WindowFocusListener()
        {
            public void windowGainedFocus(java.awt.event.WindowEvent evt)
            {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt)
            {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        label_titre.setFont(label_titre.getFont().deriveFont(label_titre.getFont().getStyle() | java.awt.Font.BOLD, 11));
        label_titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titre.setText("titre saison");
        getContentPane().add(label_titre, java.awt.BorderLayout.NORTH);

        pan_principal.setLayout(new java.awt.GridLayout(1, 2));

        edition.setEditable(false);
        edition.setColumns(20);
        edition.setRows(5);
        edition.setEnabled(false);
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

        lab_ajout_affiche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_ajout_affiche.setText("Ajouter une affiche");
        lab_ajout_affiche.setMaximumSize(new java.awt.Dimension(123456, 123456));
        pan_admin.add(lab_ajout_affiche, java.awt.BorderLayout.PAGE_START);

        pan_ajout.setLayout(new java.awt.GridLayout(1, 2));

        button_chgt_infos.setText("Changer les infos");
        pan_ajout.add(button_chgt_infos);

        button_modif_affiche.setText("Modifier l'affiche");
        button_modif_affiche.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_modif_afficheActionPerformed(evt);
            }
        });
        pan_ajout.add(button_modif_affiche);

        pan_admin.add(pan_ajout, java.awt.BorderLayout.CENTER);

        pan_affiche.add(pan_admin, java.awt.BorderLayout.SOUTH);

        pan_principal.add(pan_affiche);

        getContentPane().add(pan_principal, java.awt.BorderLayout.CENTER);

        pan_button.setLayout(new java.awt.GridLayout(2, 1));

        pan_episode.setLayout(new java.awt.GridLayout(1, 3));

        pan_episode.add(cb_episode);

        button_episode.setText("Aller à l'épisode");
        button_episode.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_episodeActionPerformed(evt);
            }
        });
        pan_episode.add(button_episode);

        button_ajout_ep.setText("Ajouter un épisode");
        button_ajout_ep.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_ajout_epActionPerformed(evt);
            }
        });
        pan_episode.add(button_ajout_ep);

        pan_button.add(pan_episode);

        pan_ba.setLayout(new java.awt.GridLayout(1, 2));

        button_ba.setText("Bande-annonce");
        button_ba.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_baActionPerformed(evt);
            }
        });
        pan_ba.add(button_ba);

        button_ajout_ba.setText("Ajouter une bande-annonce");
        button_ajout_ba.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_ajout_baActionPerformed(evt);
            }
        });
        pan_ba.add(button_ajout_ba);

        pan_button.add(pan_ba);

        getContentPane().add(pan_button, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    @Override
     public void paint(Graphics g)
    {
        super.paint(g);
        if(this.photo!=null)
            this.affiche();
    }
    private void button_episodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_episodeActionPerformed
        String nomE=this.cb_episode.getSelectedItem().toString();
        int idE=0;
        try
        {
            con=connexionUtils.getInstance().getConnexion();
            OraclePreparedStatement s=(OraclePreparedStatement)con.prepareStatement("SELECT id FROM THE(SELECT episodes FROM PBDM_Saison WHERE id=?) WHERE nom=?");
            s.setInt(1,this.id);
            s.setString(2,nomE);
            OracleResultSet rs=(OracleResultSet) s.executeQuery();
            while(rs.next())
            {
                idE=rs.getInt(1);
            }
            frame_episode fe=new frame_episode(this.admin,idE,this.id);
            fe.setVisible(true);
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(frame_saison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_episodeActionPerformed

    private void button_baActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_button_baActionPerformed
    {//GEN-HEADEREND:event_button_baActionPerformed
        try {
            vid="";
            con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            OracleResultSet rs=(OracleResultSet)st.executeQuery("select bandeA from PBDM_Saison where id="+this.id);
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
            Logger.getLogger(frame_saison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_baActionPerformed
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
                con=connexionUtils.getInstance().getConnexion();
                con.setAutoCommit(false);
                Statement s=null;
                s = con.createStatement();
                OracleResultSet rs=null;
                rs=(OracleResultSet)s.executeQuery("select id, image from PBDM_Saison where id="+this.id+" for update");
                while(rs.next())
                {
                    OrdImage imgObj= (OrdImage)rs.getORAData(2,OrdImage.getORADataFactory());
                    String img =this.cheminPhoto;
                    imgObj.loadDataFromFile(img);
                    imgObj.setProperties();
                    OraclePreparedStatement stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_Saison set image=? where id="+id);
                    stmt1.setORAData(1,imgObj);
                    stmt1.execute();
                    stmt1.close();   
                }
                rs.close();
                s.close();
                con.commit();
            }
            catch (SQLException | IOException | ClassNotFoundException ex)
            {
                Logger.getLogger(frame_saison.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_modif_afficheActionPerformed

    private void button_ajout_epActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ajout_epActionPerformed
        frame_ajout_episode fae = new frame_ajout_episode(this.id);
        fae.setVisible(true);
    }//GEN-LAST:event_button_ajout_epActionPerformed

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

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowGainedFocus
    {//GEN-HEADEREND:event_formWindowGainedFocus
        try
        {
            this.edition.setText("");
            this.cb_episode.removeAllItems();
            con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            String numS="";
            String Se="";
            OracleResultSet rs=(OracleResultSet)st.executeQuery("SELECT DEREF(serie).nom,numS FROM PBDM_Saison sa WHERE sa.id="+this.id);
            while(rs.next())
            {
                numS=rs.getString(2);
                Se=rs.getString(1);
                if(Se==null)
                {
                    Se="";
                }
            }
            this.edition.append("Nom de la série : "+Se+"\n");
            this.edition.append("Numéro de saison : "+numS+"\n");
            this.edition.append("\nEpisodes :\n");
            con=connexionUtils.getInstance().getConnexion();
            OraclePreparedStatement s=(OraclePreparedStatement)con.prepareStatement("SELECT nom,numero FROM THE(SELECT episodes FROM PBDM_Saison WHERE id=? ) ORDER BY numero ASC");
            s.setInt(1, this.id);
            rs=(OracleResultSet)s.executeQuery();
            while(rs.next())
            {
                this.edition.append("Episode "+rs.getString(2)+": "+rs.getString(1)+"\n");
                this.cb_episode.addItem(rs.getString(1));
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(frame_saison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

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
                rs=(OracleResultSet)s.executeQuery("select id, bandeA from PBDM_Saison where id="+id+" for update");
                while(rs.next())
                {
                    index=rs.getInt(1);
                    OrdVideo vidObj= (OrdVideo)rs.getORAData(2,OrdVideo.getORADataFactory());
                    String vid =cheminBA;
                    vidObj.loadDataFromFile(vid);
                    byte[] ctx[] = new byte [4000][1];
                    vidObj.setProperties(ctx);
                    OraclePreparedStatement stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_Saison set bandeA=? where id="+index);
                    stmt1.setORAData(1,vidObj);
                    stmt1.execute();
                    stmt1.close();   
                }
                rs.close();
                s.close();
                con.commit();
            }
            catch (SQLException | IOException | ClassNotFoundException ex)
            {
                Logger.getLogger(frame_saison.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_button_ajout_baActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frame_saison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_saison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_saison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_saison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ajout_ba;
    private javax.swing.JButton button_ajout_ep;
    private javax.swing.JButton button_ba;
    private javax.swing.JButton button_chgt_infos;
    private javax.swing.JButton button_episode;
    private javax.swing.JButton button_modif_affiche;
    private javax.swing.JComboBox<String> cb_episode;
    private javax.swing.JTextArea edition;
    private javax.swing.JLabel lab_ajout_affiche;
    private javax.swing.JLabel label_titre;
    private javax.swing.JPanel pan_admin;
    private javax.swing.JPanel pan_affiche;
    private javax.swing.JPanel pan_ajout;
    private javax.swing.JPanel pan_ba;
    private javax.swing.JPanel pan_button;
    private javax.swing.JPanel pan_episode;
    private javax.swing.JPanel pan_imaffiche;
    private javax.swing.JPanel pan_image;
    private javax.swing.JPanel pan_principal;
    private javax.swing.JScrollPane pan_text;
    // End of variables declaration//GEN-END:variables
}
