/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import mapping.episode;

/**
 *
 * @author Monsieur Blu
 */
public class frame_episode extends javax.swing.JFrame {

    /**
     * Creates new form frame_episode
     * @param admin
     * @param idE
     * @param idS
     * @throws java.sql.SQLException
     */
    public frame_episode(boolean admin,int idE,int idS) throws SQLException {
        try
        {
            initComponents();
            Connection con=connexionUtils.getInstance().getConnexion();
            this.edition.setLineWrap(true);
            java.util.Map map = con.getTypeMap();
            map.put("YV965015.PBDM_EPISODE_TYPE", Class.forName("mapping.episode"));
            con.setTypeMap(map);
            if(!admin){
                this.pan_admin.removeAll();
            }
            OraclePreparedStatement st=(OraclePreparedStatement) con.prepareStatement("SELECT value(e) FROM THE(SELECT episodes FROM PBDM_Saison WHERE id=?) e WHERE e.id=?");
            st.setInt(1, idS);
            st.setInt(2,idE);
            episode ep = new episode();
            OracleResultSet rs=(OracleResultSet) st.executeQuery();
            while(rs.next())
            {
               ep =(episode) rs.getObject(1, map);
            }
            this.label_titre.setText(ep.getNom());
            this.edition.append("Nom :"+ep.getNom()+"\n Date de sortie :"+ep.getDate()+"\nGenre :"+ep.getGenre()+"\nSynopsis :"+ep.getSynopsis());
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(frame_episode.class.getName()).log(Level.SEVERE, null, ex);
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
        pan_text = new javax.swing.JScrollPane();
        edition = new javax.swing.JTextArea();
        pan_affiche = new javax.swing.JPanel();
        pan_admin = new javax.swing.JPanel();

        label_titre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titre.setText("titre episode");
        getContentPane().add(label_titre, java.awt.BorderLayout.NORTH);

        edition.setEditable(false);
        edition.setColumns(20);
        edition.setRows(5);
        pan_text.setViewportView(edition);

        getContentPane().add(pan_text, java.awt.BorderLayout.CENTER);

        pan_affiche.setLayout(new java.awt.BorderLayout());

        pan_admin.setLayout(new java.awt.GridLayout(1, 1));
        pan_affiche.add(pan_admin, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pan_affiche, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frame_episode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_episode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_episode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_episode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea edition;
    private javax.swing.JLabel label_titre;
    private javax.swing.JPanel pan_admin;
    private javax.swing.JPanel pan_affiche;
    private javax.swing.JScrollPane pan_text;
    // End of variables declaration//GEN-END:variables
}
