/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Yann
 */
public class frame_con_admin extends javax.swing.JFrame {

    /**
     * Creates new form frame_con_admin
     */
    private String uname;
    private String pw;
    private String droits;
    public frame_con_admin() {
        initComponents();
        text_error_pw.setVisible(false);
        text_error_uname.setVisible(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        user_text = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        user_pw = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        cancel_button = new javax.swing.JButton();
        connect_button = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        text_error_pw = new javax.swing.JLabel();
        text_error_uname = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridLayout(6, 1));

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nom d'utilisateur");
        jPanel2.add(jLabel1);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));
        jPanel3.add(user_text);

        jPanel1.add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mot de passe");
        jPanel4.add(jLabel2);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));
        jPanel5.add(user_pw);

        jPanel1.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        cancel_button.setText("Annuler");
        cancel_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancel_buttonActionPerformed(evt);
            }
        });
        jPanel6.add(cancel_button);

        connect_button.setText("Connexion");
        connect_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                connect_buttonActionPerformed(evt);
            }
        });
        jPanel6.add(connect_button);

        jPanel1.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        text_error_pw.setForeground(new java.awt.Color(204, 0, 0));
        text_error_pw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_error_pw.setText(" Mot de passe incorrect.");
        jPanel7.add(text_error_pw);

        text_error_uname.setForeground(new java.awt.Color(255, 0, 0));
        text_error_uname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_error_uname.setText("Nom d'utilisateur incorrect.");
        jPanel7.add(text_error_uname);

        jPanel1.add(jPanel7);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void connect_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_buttonActionPerformed
        try 
        {
            //encodage du pw en MD5 pour vérif avec la valeur hexa stockée dans la base
            
            String pw_temp;
            this.uname=user_text.getText();
            pw_temp=user_pw.getText();
            MD5Password md5=new MD5Password();
            this.pw=md5.getEncodedPassword(pw_temp);
            String pwt="";
            ArrayList<String> unames=null;
            Boolean unameIsIn=false;
            //vérif de la bonne entrée des infos de connexion
            
            Connection con=null;
            con=connexionUtils.getConnexion();
            Statement st=con.createStatement();
            ResultSet rset = st.executeQuery("SELECT uname FROM PBDM_table_connexion");
            while(rset.next())
            {
                unames.add(rset.getString("UNAME"));
            }
            if(unames.contains(this.uname))
            {
                unameIsIn=true;
                rset = st.executeQuery("SELECT pw FROM PBDM_table_connexion WHERE uname="+this.uname);
                while(rset.next())
                {
                    pwt=rset.getString("PW");
                }
                rset.close();
                st.close();
                try
                {
                    if(md5.testPassword(pwt, this.pw))                
                    {
                        //Ouverture prochaine fenetre en administrateur.
                    }
                    else
                    {
                        text_error_pw.setVisible(true);
                    }
                }
                catch (NoSuchAlgorithmException ex)
                {
                    Logger.getLogger(frame_con_admin.class.getName()).log(Level.SEVERE, null, ex);                
                }
            }
            else
            {
                text_error_uname.setVisible(true);
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(frame_con_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_connect_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(frame_con_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_con_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_con_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_con_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_con_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JButton connect_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel text_error_pw;
    private javax.swing.JLabel text_error_uname;
    private javax.swing.JTextField user_pw;
    private javax.swing.JTextField user_text;
    // End of variables declaration//GEN-END:variables
}
