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
public class frame_menu extends javax.swing.JFrame
{
    boolean admin;

    /**
     * Creates new form frame_menu
     */
    public frame_menu(boolean admin)
    {
        initComponents();
        this.admin=admin;
        
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

        jPanel1 = new javax.swing.JPanel();
        film_button = new javax.swing.JButton();
        serie_button = new javax.swing.JButton();
        jeu_button = new javax.swing.JButton();
        menu_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        film_button.setText("Rechercher un film");
        film_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                film_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(film_button);

        serie_button.setText("Rechercher une série");
        serie_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                serie_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(serie_button);

        jeu_button.setText("Rechercher un jeu");
        jeu_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jeu_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(jeu_button);

        menu_button.setText("Revenir au menu");
        menu_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menu_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(menu_button);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menu_buttonActionPerformed
    {//GEN-HEADEREND:event_menu_buttonActionPerformed
        this.dispose();
    }//GEN-LAST:event_menu_buttonActionPerformed

    private void film_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_film_buttonActionPerformed
    {//GEN-HEADEREND:event_film_buttonActionPerformed
        frame_film ff=new frame_film(admin);
        ff.setVisible(true);
    }//GEN-LAST:event_film_buttonActionPerformed

    private void serie_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_serie_buttonActionPerformed
    {//GEN-HEADEREND:event_serie_buttonActionPerformed
        frame_serie fs=new frame_serie(admin);
        fs.setVisible(true);
    }//GEN-LAST:event_serie_buttonActionPerformed

    private void jeu_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jeu_buttonActionPerformed
    {//GEN-HEADEREND:event_jeu_buttonActionPerformed
        frame_jeu fj=new frame_jeu(admin);
        fj.setVisible(true);
    }//GEN-LAST:event_jeu_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(frame_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(frame_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(frame_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(frame_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton film_button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jeu_button;
    private javax.swing.JButton menu_button;
    private javax.swing.JButton serie_button;
    // End of variables declaration//GEN-END:variables
}
