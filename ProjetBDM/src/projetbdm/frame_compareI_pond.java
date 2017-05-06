/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author yv965015
 */
public class frame_compareI_pond extends javax.swing.JFrame
{
    List<Integer> resultat=new ArrayList();
    boolean admin;
    int idJ;
    /**
     * Creates new form frame_compareI_pond
     */
    public frame_compareI_pond(boolean admin,int idJ)
    {
        initComponents();
        this.admin=admin;
        this.idJ=idJ;
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

        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pond_AvgColor = new javax.swing.JSlider();
        txt_avgc = new javax.swing.JTextField();
        pond_ColorHist = new javax.swing.JSlider();
        txt_colH = new javax.swing.JTextField();
        pond_Text = new javax.swing.JSlider();
        txt_text = new javax.swing.JTextField();
        pond_poscolor = new javax.swing.JSlider();
        txt_posC = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        annuler_button = new javax.swing.JButton();
        reinit_button = new javax.swing.JButton();
        valider_button = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(3, 0));

        jPanel3.setLayout(new java.awt.GridLayout(1, 4));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Valeur d'average color");
        jPanel3.add(jLabel1);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Valeur de color histogram");
        jPanel3.add(jLabel3);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Valeur de texture");
        jPanel3.add(jLabel2);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Valeur de positional Color");
        jPanel3.add(jLabel4);

        getContentPane().add(jPanel3);

        jPanel1.setLayout(new java.awt.GridLayout(1, 8));

        pond_AvgColor.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                pond_AvgColorKeyReleased(evt);
            }
        });
        jPanel1.add(pond_AvgColor);

        txt_avgc.setEditable(false);
        jPanel1.add(txt_avgc);

        pond_ColorHist.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                pond_ColorHistKeyReleased(evt);
            }
        });
        jPanel1.add(pond_ColorHist);

        txt_colH.setEditable(false);
        jPanel1.add(txt_colH);

        pond_Text.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                pond_TextKeyReleased(evt);
            }
        });
        jPanel1.add(pond_Text);

        txt_text.setEditable(false);
        jPanel1.add(txt_text);

        pond_poscolor.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                pond_poscolorKeyReleased(evt);
            }
        });
        jPanel1.add(pond_poscolor);

        txt_posC.setEditable(false);
        jPanel1.add(txt_posC);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(1, 3));

        annuler_button.setText("Annuler");
        jPanel2.add(annuler_button);

        reinit_button.setText("Reinitialiser");
        jPanel2.add(reinit_button);

        valider_button.setText("Valider");
        valider_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                valider_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(valider_button);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valider_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_valider_buttonActionPerformed
    {//GEN-HEADEREND:event_valider_buttonActionPerformed
        //TODO constructeur avec score mini -> renvoi que ceux concernés.
        
        resultat.clear();
        double avgC = this.pond_AvgColor.getValue()/100;
        //this.pond_AvgColor
        double histC = this.pond_ColorHist.getValue()/100;
        double posCol = this.pond_poscolor.getValue()/100;
       double  text= this.pond_Text.getValue()/100;
        try 
        {
            int idj2;
            String nomJ="";
            double score;
            CallableStatement cstmt = connexionUtils.getInstance().getConnexion().prepareCall("{?=call compareImage(?,?,?,?,?)}");

                cstmt.registerOutParameter(1, Types.DOUBLE);
                OraclePreparedStatement stmt2 = (OraclePreparedStatement)connexionUtils.getInstance().getConnexion().prepareStatement("SELECT id,nom FROM PBDM_JeuVideo WHERE id<>?");
                stmt2.setInt(1, this.idJ);
       
                OracleResultSet rs2 = (OracleResultSet)stmt2.executeQuery();
                while(rs2.next())
                {
                    idj2=rs2.getInt(1);
                    nomJ=rs2.getString(2);
                    cstmt.setInt(2, idj2);
                    cstmt.setDouble(3, avgC);
                    cstmt.setDouble(4, histC);
                    cstmt.setDouble(5, posCol);
                    cstmt.setDouble(6, text);
                    cstmt.execute();
                    score = cstmt.getDouble(1);
                    this.resultat.add(idJ);
                }
            //this.trierResultat();
            cstmt.close();
            rs2.close();
            stmt2.close();
            frame_transition ft=new frame_transition(this.admin,"jeu",this.resultat,null,"");
            ft.setVisible(true);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(frame_compareI_pond.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(frame_compareI_pond.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_valider_buttonActionPerformed

    private void pond_AvgColorKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_pond_AvgColorKeyReleased
    {//GEN-HEADEREND:event_pond_AvgColorKeyReleased
  
        double val=this.pond_AvgColor.getValue()/100;
        this.txt_avgc.setText("valeur :"+val);
    }//GEN-LAST:event_pond_AvgColorKeyReleased

    private void pond_ColorHistKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_pond_ColorHistKeyReleased
    {//GEN-HEADEREND:event_pond_ColorHistKeyReleased
       double val=this.pond_ColorHist.getValue()/100;
        this.txt_colH.setText(""+val);
    }//GEN-LAST:event_pond_ColorHistKeyReleased

    private void pond_TextKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_pond_TextKeyReleased
    {//GEN-HEADEREND:event_pond_TextKeyReleased
        double val=this.pond_ColorHist.getValue()/100;
        this.txt_text.setText(""+val);
    }//GEN-LAST:event_pond_TextKeyReleased

    private void pond_poscolorKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_pond_poscolorKeyReleased
    {//GEN-HEADEREND:event_pond_poscolorKeyReleased
        double val=this.pond_ColorHist.getValue()/100;
        this.txt_posC.setText(""+val);        
    }//GEN-LAST:event_pond_poscolorKeyReleased

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
            java.util.logging.Logger.getLogger(frame_compareI_pond.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(frame_compareI_pond.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(frame_compareI_pond.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(frame_compareI_pond.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new frame_compareI_pond(true,1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annuler_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider pond_AvgColor;
    private javax.swing.JSlider pond_ColorHist;
    private javax.swing.JSlider pond_Text;
    private javax.swing.JSlider pond_poscolor;
    private javax.swing.JButton reinit_button;
    private javax.swing.JTextField txt_avgc;
    private javax.swing.JTextField txt_colH;
    private javax.swing.JTextField txt_posC;
    private javax.swing.JTextField txt_text;
    private javax.swing.JButton valider_button;
    // End of variables declaration//GEN-END:variables
}