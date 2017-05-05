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
import javax.swing.filechooser.FileNameExtensionFilter;
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
    private Image photo;
    private String cheminPhoto;
    int id;
    Connection con;
    /**
     * Creates new form frame_film
     */
    public frame_film(boolean admin,int idF) throws ClassNotFoundException, IOException
    {
        this.id=idF;
        try
        {
            initComponents();
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
            String titre="";
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
            rs=(OracleResultSet)st.executeQuery("SELECT DEREF(realisateur).nom FROM PBDM_Film f WHERE f.id="+idF);
            while(rs.next())
            {
                nomR=rs.getString(1);
                if(nomR==null)
                {
                    nomR="";
                }
            }
            rs=(OracleResultSet)st.executeQuery("SELECT DEREF(acteurMA).nom FROM PBDM_MedVidActeur WHERE DEREF(MedVidMa).id="+idF);
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
                String fich="im_temp.jpg";
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
        button_chgt_infos = new javax.swing.JButton();
        button_modif_affiche = new javax.swing.JButton();
        pan_buttons = new javax.swing.JPanel();
        pan_bo = new javax.swing.JPanel();
        button_ajout_bo = new javax.swing.JButton();
        button_bo = new javax.swing.JButton();
        pan_ba = new javax.swing.JPanel();
        button_ajout_ba = new javax.swing.JButton();
        button_ba = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        jPanel1.setPreferredSize(new java.awt.Dimension(720, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        label_titre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titre.setText("titre film");
        jPanel1.add(label_titre, java.awt.BorderLayout.NORTH);

        pan_principal.setLayout(new java.awt.GridLayout(1, 0));

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

        button_chgt_infos.setText("Changer les informations");
        pan_ajout.add(button_chgt_infos);

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
            //TODO update dans la BD
            this.affiche();
        }
    }//GEN-LAST:event_button_modif_afficheActionPerformed

    private void button_ajout_baActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ajout_baActionPerformed

    }//GEN-LAST:event_button_ajout_baActionPerformed

    private void button_baActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_baActionPerformed
        try {
            String vid="";
            con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            OracleResultSet rs=(OracleResultSet)st.executeQuery("select bandeA from PBDM_Film where id="+id);
            while(rs.next())
            {
            OrdVideo vidObj= (OrdVideo)rs.getORAData(1,OrdVideo.getORADataFactory());
            vid="vid_temp.avi";
            vidObj.getDataInFile(vid);
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("vlc "+vid);
            }
            rs.close();
            st.close();
            
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_baActionPerformed

    private void button_boActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_boActionPerformed
        try {
            String aud="";
            con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            OracleResultSet rs=(OracleResultSet)st.executeQuery("select bandeO from PBDM_Film where id="+id);
            while(rs.next())
            {
            OrdAudio audObj= (OrdAudio)rs.getORAData(1,OrdAudio.getORADataFactory());
            aud="son_temp.mp3";
            audObj.getDataInFile(aud);
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("vlc "+aud);
            }
            rs.close();
            st.close();
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(frame_film.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_boActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, IOException
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
            java.util.logging.Logger.getLogger(frame_film.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(frame_film.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(frame_film.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(frame_film.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            frame_film oui = new frame_film(true,1);
            oui.setVisible(true);
        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ajout_ba;
    private javax.swing.JButton button_ajout_bo;
    private javax.swing.JButton button_ba;
    private javax.swing.JButton button_bo;
    private javax.swing.JButton button_chgt_infos;
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
