/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JCheckBox;

/**
 *
 * @author yv965015
 */
public class frame_recherche extends javax.swing.JFrame
{
    boolean admin;
    String type_media;
    /**
     * Creates new form frame_recherche
     */
    public frame_recherche(boolean admin,String typeM)
    {
        initComponents();
        this.admin=admin;
        this.type_media=typeM;
        switch (this.type_media) {
                case "film" : this.film_chb.setSelected(true);break;
                case "serie": this.serie_chb.setSelected(true);break;
                case "jeu" : this.jeuvideo_chb.setSelected(true);break;
                case "personne" : this.acteur_chb.setSelected(true);
                                    this.realisateur_chb.setSelected(true);break;
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

        lab_typeM = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        annuler_button = new javax.swing.JButton();
        valider_button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_rech_nom = new javax.swing.JTextField();
        pan_chb = new javax.swing.JPanel();
        jeuvideo_chb = new javax.swing.JCheckBox();
        film_chb = new javax.swing.JCheckBox();
        serie_chb = new javax.swing.JCheckBox();
        saison_chb = new javax.swing.JCheckBox();
        realisateur_chb = new javax.swing.JCheckBox();
        acteur_chb = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lab_typeM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_typeM.setText("Recherche");
        getContentPane().add(lab_typeM, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridLayout());

        annuler_button.setText("Annuler");
        jPanel4.add(annuler_button);

        valider_button.setText("Valider");
        valider_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                valider_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(valider_button);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setText("Rechercher dans le nom");
        jPanel3.add(jLabel1);
        jPanel3.add(tf_rech_nom);

        jPanel1.add(jPanel3);

        pan_chb.setLayout(new java.awt.GridLayout(3, 2));

        jeuvideo_chb.setText("Jeu vidéo");
        pan_chb.add(jeuvideo_chb);

        film_chb.setText("Film");
        pan_chb.add(film_chb);

        serie_chb.setText("Serie");
        pan_chb.add(serie_chb);

        saison_chb.setText("Saison");
        pan_chb.add(saison_chb);

        realisateur_chb.setText("Réalisateur");
        pan_chb.add(realisateur_chb);

        acteur_chb.setText("Acteur");
        pan_chb.add(acteur_chb);

        jPanel1.add(pan_chb);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valider_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_valider_buttonActionPerformed
    {//GEN-HEADEREND:event_valider_buttonActionPerformed
        ArrayList<String> l_types=new ArrayList();
        for(int i=0;i<((GridLayout)(this.pan_chb.getLayout())).getColumns()*((GridLayout)(this.pan_chb.getLayout())).getRows();i++)
        {
            
            if(this.pan_chb.getComponent(i).getClass()==JCheckBox.class)
            {
                JCheckBox jb=((JCheckBox)(this.pan_chb.getComponent(i)));
                if(jb.isSelected())
                {
                    String type=jb.getName();
                    l_types.add(type); 
                }
            }
        }
        if(this.tf_rech_nom.getText()!=null&&this.tf_rech_nom.getText()!="")
        {
            //Recherche avec InterMediaText
        }
        else
        {
            for(int i=0;i<l_types.size();i++)
            {
                Connection con=connexionUtils2.getInstance();
                
            }
        }
    }//GEN-LAST:event_valider_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(frame_recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(frame_recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(frame_recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(frame_recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox acteur_chb;
    private javax.swing.JButton annuler_button;
    private javax.swing.JCheckBox film_chb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JCheckBox jeuvideo_chb;
    private javax.swing.JLabel lab_typeM;
    private javax.swing.JPanel pan_chb;
    private javax.swing.JCheckBox realisateur_chb;
    private javax.swing.JCheckBox saison_chb;
    private javax.swing.JCheckBox serie_chb;
    private javax.swing.JTextField tf_rech_nom;
    private javax.swing.JButton valider_button;
    // End of variables declaration//GEN-END:variables
}
