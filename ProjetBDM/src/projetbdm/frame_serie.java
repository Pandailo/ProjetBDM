/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Yann
 */
public class frame_serie extends javax.swing.JFrame
{
    boolean admin;
    String cheminPhoto;
    Image photo;
    /**
     * Creates new form frame_serie
     */
    public frame_serie(boolean admin,int idS)
    {
        initComponents();
        this.admin=admin;

        
        if(!admin){
            this.pan_saison.remove(button_ajout_saison);
            this.pan_ba.remove(button_ajout_ba);
            this.pan_admin.removeAll();
            this.pan_saison.setLayout(new java.awt.GridLayout(1, 2));
            this.pan_ba.setLayout(new java.awt.GridLayout(1, 1));
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
        pan_principal = new javax.swing.JPanel();
        pan_text = new javax.swing.JScrollPane();
        edition = new javax.swing.JTextArea();
        pan_affiche = new javax.swing.JPanel();
        pan_image = new javax.swing.JPanel();
        pan_admin = new javax.swing.JPanel();
        lab_ajout_affiche = new javax.swing.JLabel();
        pan_ajout = new javax.swing.JPanel();
        button_chgt_infos = new javax.swing.JButton();
        button_modif_affiche = new javax.swing.JButton();
        pan_button = new javax.swing.JPanel();
        pan_saison = new javax.swing.JPanel();
        cb_saison = new javax.swing.JComboBox<>();
        button_saison = new javax.swing.JButton();
        button_ajout_saison = new javax.swing.JButton();
        pan_ba = new javax.swing.JPanel();
        button_ba = new javax.swing.JButton();
        button_ajout_ba = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(720, 600));

        label_titre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titre.setText("titre serie");
        getContentPane().add(label_titre, java.awt.BorderLayout.NORTH);

        pan_principal.setPreferredSize(new java.awt.Dimension(720, 500));
        pan_principal.setLayout(new java.awt.GridLayout(1, 2));

        edition.setEditable(false);
        edition.setColumns(20);
        edition.setRows(5);
        edition.setEnabled(false);
        pan_text.setViewportView(edition);

        pan_principal.add(pan_text);

        pan_affiche.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pan_imageLayout = new javax.swing.GroupLayout(pan_image);
        pan_image.setLayout(pan_imageLayout);
        pan_imageLayout.setHorizontalGroup(
            pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pan_imageLayout.setVerticalGroup(
            pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pan_affiche.add(pan_image, java.awt.BorderLayout.NORTH);

        pan_admin.setLayout(new java.awt.BorderLayout());

        lab_ajout_affiche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_ajout_affiche.setText("Ajouter une affiche");
        lab_ajout_affiche.setMaximumSize(new java.awt.Dimension(123456, 123456));
        pan_admin.add(lab_ajout_affiche, java.awt.BorderLayout.PAGE_START);

        pan_ajout.setLayout(new java.awt.GridLayout(1, 2));

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

        getContentPane().add(pan_principal, java.awt.BorderLayout.CENTER);

        pan_button.setLayout(new java.awt.GridLayout(2, 0));

        pan_saison.setLayout(new java.awt.GridLayout(1, 3));

        cb_saison.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pan_saison.add(cb_saison);

        button_saison.setText("Aller à la saison");
        button_saison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saisonActionPerformed(evt);
            }
        });
        pan_saison.add(button_saison);

        button_ajout_saison.setText("Ajouter une saison");
        button_ajout_saison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ajout_saisonActionPerformed(evt);
            }
        });
        pan_saison.add(button_ajout_saison);

        pan_button.add(pan_saison);

        pan_ba.setLayout(new java.awt.GridLayout(1, 2));

        button_ba.setText("Bande-annonce");
        pan_ba.add(button_ba);

        button_ajout_ba.setText("Ajouter une bande annonce");
        pan_ba.add(button_ajout_ba);

        pan_button.add(pan_ba);

        getContentPane().add(pan_button, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_saisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saisonActionPerformed
        frame_saison saison = new frame_saison(admin,1);
        saison.setVisible(true);
    }//GEN-LAST:event_button_saisonActionPerformed
    private void affiche()
    {
        Graphics g = this.pan_image.getGraphics();
        g.drawImage(this.photo, 0, 0, this.pan_image.getWidth(), this.pan_image.getHeight(), this);
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

    private void button_ajout_saisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ajout_saisonActionPerformed
        frame_ajout_saison fas = new frame_ajout_saison();
        fas.setVisible(true);
    }//GEN-LAST:event_button_ajout_saisonActionPerformed

    /**
     * @param args the command line arguments
     */
     public void paint(Graphics g)
    {
        super.paint(g);
        if(this.photo!=null)
            this.affiche();
    }
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
            java.util.logging.Logger.getLogger(frame_serie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(frame_serie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(frame_serie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(frame_serie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        frame_serie oui = new frame_serie(true,1);
        oui.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ajout_ba;
    private javax.swing.JButton button_ajout_saison;
    private javax.swing.JButton button_ba;
    private javax.swing.JButton button_chgt_infos;
    private javax.swing.JButton button_modif_affiche;
    private javax.swing.JButton button_saison;
    private javax.swing.JComboBox<String> cb_saison;
    private javax.swing.JTextArea edition;
    private javax.swing.JLabel lab_ajout_affiche;
    private javax.swing.JLabel label_titre;
    private javax.swing.JPanel pan_admin;
    private javax.swing.JPanel pan_affiche;
    private javax.swing.JPanel pan_ajout;
    private javax.swing.JPanel pan_ba;
    private javax.swing.JPanel pan_button;
    private javax.swing.JPanel pan_image;
    private javax.swing.JPanel pan_principal;
    private javax.swing.JPanel pan_saison;
    private javax.swing.JScrollPane pan_text;
    // End of variables declaration//GEN-END:variables
}
