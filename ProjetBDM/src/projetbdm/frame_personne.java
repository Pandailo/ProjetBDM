/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import oracle.jdbc.*;

import oracle.ord.im.OrdImage;
import oracle.sql.ARRAY;
import oracle.sql.STRUCT;

/**
 *
 * @author Monsieur Blu
 */
public class frame_personne extends javax.swing.JFrame {
    boolean admin;
    String cheminPhoto;
    Image photo;
    /**
     * Creates new form frame_personne
     */
    public frame_personne(boolean admin,String nomP) throws SQLException, ClassNotFoundException, IOException {
        initComponents();
        this.admin=admin;
        
        if(!admin){
            this.pan_admin.removeAll();
        }
        String nom="";
        String ddn="";
        String pnom="";
        int taille=-1;
        OrdImage imgObj;
        Connection con=connexionUtils.getInstance().getConnexion();
        Statement st=con.createStatement();
        OracleResultSet rs=(OracleResultSet)st.executeQuery("SELECT id,nom,dateNaiss,prenoms,taille FROM PBDM_Acteur WHERE nom='"+nomP+"'");
        if(rs.next())
        {
            nom=rs.getString(2);
            ddn=rs.getString(3);
            taille=rs.getInt(5);
            ARRAY prenoms = rs.getARRAY(4);
            Object[] pnoms = (Object[])prenoms.getArray();
            pnom=(((STRUCT)pnoms[0]).getAttributes()[0].toString())+" ";
            if(((STRUCT)pnoms[1]).getAttributes()[0]!=null)
                pnom=(((STRUCT)pnoms[1]).getAttributes()[0].toString())+" ";
            if(((STRUCT)pnoms[2]).getAttributes()[0]!=null)
                pnom=(((STRUCT)pnoms[2]).getAttributes()[0].toString())+" ";
        }
        else
        {
            rs=(OracleResultSet)st.executeQuery("SELECT id,nom,dateNaiss,prenoms FROM PBDM_Realisateur WHERE nom='"+nomP+"'");
            rs.next();
            nom=rs.getString(2);
            ddn=rs.getString(3);
            ARRAY prenoms = rs.getARRAY(4);
            Object[] pnoms = (Object[])prenoms.getArray();
            pnom=(((STRUCT)pnoms[0]).getAttributes()[0].toString())+"\n";
            if(((STRUCT)pnoms[1]).getAttributes()[0]!=null)
                pnom=(((STRUCT)pnoms[1]).getAttributes()[0].toString())+"\n";
            if(((STRUCT)pnoms[2]).getAttributes()[0]!=null)
                pnom=(((STRUCT)pnoms[2]).getAttributes()[0].toString())+"\n";
        }
        rs=(OracleResultSet)st.executeQuery("SELECT photo FROM PBDM_Acteur WHERE nom='"+nomP+"'");
        if(rs.next())
        {
            imgObj= (OrdImage)rs.getORAData(1,OrdImage.getORADataFactory());
            String fich="imtemp.jpg";
            imgObj.getDataInFile(fich);
            photo=this.pan_image.getToolkit().getImage(fich);
            affiche();
            
        }
        else
        {
            rs=(OracleResultSet)st.executeQuery("SELECT photo FROM PBDM_Realisateur WHERE nom='"+nomP+"'");
            rs.next();
            imgObj= (OrdImage)rs.getORAData(1,OrdImage.getORADataFactory());
            String fich="imtemp.jpg";
            imgObj.getDataInFile(fich);
            photo=this.pan_image.getToolkit().getImage(fich);
            affiche();
        }
                

        this.edition.append("Nom :"+nom+"\n");
        this.edition.append("Prenom :"+pnom+" \n");
        this.edition.append("Date de naissance :"+ddn+"\n");
        if(taille!=-1)
            this.edition.append("Taille :"+taille);
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

        label_nom = new javax.swing.JLabel();
        pan_principal = new javax.swing.JPanel();
        pan_text = new javax.swing.JScrollPane();
        edition = new javax.swing.JTextArea();
        pan_affiche = new javax.swing.JPanel();
        pan_image = new javax.swing.JPanel();
        pan_imaffiche = new javax.swing.JPanel();
        pan_admin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pan_ajout = new javax.swing.JPanel();
        button_chgt_infos = new javax.swing.JButton();
        button_modif_photo = new javax.swing.JButton();
        pan_button = new javax.swing.JPanel();
        vb_media = new javax.swing.JComboBox<>();
        button_media = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(720, 600));

        label_nom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_nom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nom.setText("nom personne");
        getContentPane().add(label_nom, java.awt.BorderLayout.NORTH);

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ajouter une photo");
        pan_admin.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        pan_ajout.setLayout(new java.awt.GridLayout(1, 2));

        button_chgt_infos.setText("Changer les informations");
        pan_ajout.add(button_chgt_infos);

        button_modif_photo.setText("Modifier la photo");
        button_modif_photo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_modif_photoActionPerformed(evt);
            }
        });
        pan_ajout.add(button_modif_photo);

        pan_admin.add(pan_ajout, java.awt.BorderLayout.CENTER);

        pan_affiche.add(pan_admin, java.awt.BorderLayout.SOUTH);

        pan_principal.add(pan_affiche);

        getContentPane().add(pan_principal, java.awt.BorderLayout.CENTER);

        pan_button.setLayout(new java.awt.GridLayout(1, 2));

        vb_media.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        vb_media.setSelectedIndex(-1);
        pan_button.add(vb_media);

        button_media.setText("Aller au média");
        pan_button.add(button_media);

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
    private void affiche()
    {
        Graphics g = this.pan_image.getGraphics();
        g.drawImage(this.photo, 0, 0, this.pan_imaffiche.getWidth(), this.pan_imaffiche.getHeight(), this);
        
    }
    private void button_modif_photoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_button_modif_photoActionPerformed
    {//GEN-HEADEREND:event_button_modif_photoActionPerformed
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
    }//GEN-LAST:event_button_modif_photoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException, ClassNotFoundException, IOException {
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
            java.util.logging.Logger.getLogger(frame_personne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_personne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_personne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_personne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        frame_personne oui = new frame_personne(true,"");
            oui.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_chgt_infos;
    private javax.swing.JButton button_media;
    private javax.swing.JButton button_modif_photo;
    private javax.swing.JTextArea edition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_nom;
    private javax.swing.JPanel pan_admin;
    private javax.swing.JPanel pan_affiche;
    private javax.swing.JPanel pan_ajout;
    private javax.swing.JPanel pan_button;
    private javax.swing.JPanel pan_imaffiche;
    private javax.swing.JPanel pan_image;
    private javax.swing.JPanel pan_principal;
    private javax.swing.JScrollPane pan_text;
    private javax.swing.JComboBox<String> vb_media;
    // End of variables declaration//GEN-END:variables
}
