/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

/**
 *
 * @author Yann
 */
public class frame_serie extends javax.swing.JFrame
{

    /**
     * Creates new form frame_serie
     */
    public frame_serie()
    {
        initComponents();
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
        pan_button = new javax.swing.JPanel();
        pan_saison = new javax.swing.JPanel();
        cb_saison = new javax.swing.JComboBox<>();
        button_saison = new javax.swing.JButton();
        button_ba = new javax.swing.JButton();

        label_titre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titre.setText("titre serie");
        getContentPane().add(label_titre, java.awt.BorderLayout.NORTH);

        pan_principal.setLayout(new java.awt.GridLayout(1, 2));

        edition.setEditable(false);
        edition.setColumns(20);
        edition.setRows(5);
        pan_text.setViewportView(edition);

        pan_principal.add(pan_text);

        pan_affiche.setLayout(new java.awt.GridLayout(2, 0));

        javax.swing.GroupLayout pan_imageLayout = new javax.swing.GroupLayout(pan_image);
        pan_image.setLayout(pan_imageLayout);
        pan_imageLayout.setHorizontalGroup(
            pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        pan_imageLayout.setVerticalGroup(
            pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        pan_affiche.add(pan_image);

        pan_principal.add(pan_affiche);

        getContentPane().add(pan_principal, java.awt.BorderLayout.CENTER);

        pan_button.setLayout(new java.awt.GridLayout(2, 0));

        pan_saison.setLayout(new java.awt.GridLayout(1, 2));

        cb_saison.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pan_saison.add(cb_saison);

        button_saison.setText("Aller à la saison");
        button_saison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saisonActionPerformed(evt);
            }
        });
        pan_saison.add(button_saison);

        pan_button.add(pan_saison);

        button_ba.setText("Bande-annonce");
        pan_button.add(button_ba);

        getContentPane().add(pan_button, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_saisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saisonActionPerformed
        frame_saison saison = new frame_saison();
        saison.setVisible(true);
    }//GEN-LAST:event_button_saisonActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new frame_serie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ba;
    private javax.swing.JButton button_saison;
    private javax.swing.JComboBox<String> cb_saison;
    private javax.swing.JTextArea edition;
    private javax.swing.JLabel label_titre;
    private javax.swing.JPanel pan_affiche;
    private javax.swing.JPanel pan_button;
    private javax.swing.JPanel pan_image;
    private javax.swing.JPanel pan_principal;
    private javax.swing.JPanel pan_saison;
    private javax.swing.JScrollPane pan_text;
    // End of variables declaration//GEN-END:variables
}
