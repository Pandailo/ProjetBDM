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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;
import oracle.ord.im.OrdImage;

/**
 *
 * @author al128785
 */
public class frame_ajout_personne extends javax.swing.JFrame {
    String cheminPhoto="";
    Image photo;
    /**
     * Creates new form frame_ajout_personne
     */
    public frame_ajout_personne() {
        initComponents();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        if(this.photo!=null)
            this.affiche();
    }
    
    private void affiche()
    {
        Graphics g = this.pan_image.getGraphics();
        //this.pan_image.setSize(140,140*(photo.getWidth(null)/photo.getHeight(null)));
        g.drawImage(this.photo, 0, 0, this.pan_image.getWidth(), this.pan_image.getHeight(), this);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        label_frame = new javax.swing.JLabel();
        pan_principal = new javax.swing.JPanel();
        label_nom = new javax.swing.JLabel();
        field_nom = new javax.swing.JTextField();
        label_prenoms = new javax.swing.JLabel();
        field_prenoms = new javax.swing.JTextField();
        label_date = new javax.swing.JLabel();
        field_date = new javax.swing.JTextField();
        pan_image = new javax.swing.JPanel();
        image_button = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        pan_button = new javax.swing.JPanel();
        annuler_button = new javax.swing.JButton();
        valider_button = new javax.swing.JButton();

        label_frame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_frame.setText("Ajout d'une personne");
        getContentPane().add(label_frame, java.awt.BorderLayout.NORTH);

        label_nom.setText("Nom");

        label_prenoms.setText("Prenoms");

        label_date.setText("Date de naissance");

        pan_image.setPreferredSize(new java.awt.Dimension(100, 125));

        javax.swing.GroupLayout pan_imageLayout = new javax.swing.GroupLayout(pan_image);
        pan_image.setLayout(pan_imageLayout);
        pan_imageLayout.setHorizontalGroup(
            pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pan_imageLayout.setVerticalGroup(
            pan_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        image_button.setText("Image");
        image_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                image_buttonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Réalisateur");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Acteur");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Taille");

        javax.swing.GroupLayout pan_principalLayout = new javax.swing.GroupLayout(pan_principal);
        pan_principal.setLayout(pan_principalLayout);
        pan_principalLayout.setHorizontalGroup(
            pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_principalLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_principalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pan_principalLayout.createSequentialGroup()
                                .addComponent(label_nom)
                                .addGap(133, 133, 133))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pan_principalLayout.createSequentialGroup()
                                .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_date, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_prenoms, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(field_prenoms, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(field_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(field_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pan_principalLayout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(image_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pan_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61))
        );
        pan_principalLayout.setVerticalGroup(
            pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pan_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pan_principalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_nom)
                            .addComponent(field_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_prenoms)
                            .addComponent(field_prenoms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_date)
                            .addComponent(field_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1))))
                .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_principalLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(image_button))
                    .addGroup(pan_principalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(pan_principal, java.awt.BorderLayout.CENTER);

        pan_button.setLayout(new java.awt.GridLayout(1, 2));

        annuler_button.setText("Annuler");
        annuler_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                annuler_buttonActionPerformed(evt);
            }
        });
        pan_button.add(annuler_button);

        valider_button.setText("Valider");
        valider_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                valider_buttonActionPerformed(evt);
            }
        });
        pan_button.add(valider_button);

        getContentPane().add(pan_button, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void image_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image_buttonActionPerformed
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
        }
    }//GEN-LAST:event_image_buttonActionPerformed

    private void valider_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_valider_buttonActionPerformed
    {//GEN-HEADEREND:event_valider_buttonActionPerformed
        try
        {
            Connection con=connexionUtils.getInstance().getConnexion();
            con.setAutoCommit(false);
            OracleResultSet rs=null;
            String nom=this.field_nom.getText();
            String ddn=this.field_date.getText();
            String[] split=null;
            String[] prenoms=new String[3];
            if(this.field_prenoms.getText().contains(" "))
                split=this.field_prenoms.getText().split(" ");
            else
            {        
                prenoms[0]=this.field_prenoms.getText();
                prenoms[1]="";
                prenoms[2]="";
            }
            int taille=-1;
            int index=-1;
            if(this.jRadioButton1.isSelected())
            {
                try
                {
                    taille=Integer.parseInt(this.jTextField1.getText());
                    System.out.println(taille);
                }
                catch(NumberFormatException  e)
                {
                    //message erreur
                }
            }
            if(split!=null&&split.length<=3)
            {
                for(int i=0;i<3;i++)
                {
                    if(split.length>=i+1)
                    {
                        prenoms[i]=split[i];
                    }
                    else
                    {
                        prenoms[i]="";
                    }
                }
            }
            if(this.cheminPhoto!=""&&this.cheminPhoto!=null)
            {
                if(this.jRadioButton1.isSelected()&&taille!=-1)
                {
                    OraclePreparedStatement s=(OraclePreparedStatement)con.prepareStatement("INSERT INTO PBDM_Acteur VALUES(0,?,?,PBDM_PrenomsV_Type(PBDM_prenom_type(?),PBDM_prenom_type(?),PBDM_prenom_type(?)),ORDImage.init(),?)"); 
                    s.setString(1, ddn);
                    s.setString(2, nom);
                    s.setString(3, prenoms[0]);
                    s.setString(4, prenoms[1]);
                    s.setString(5, prenoms[2]);
                    s.setInt(6,taille);
                    s.execute();
                    
                    OracleStatement st=(OracleStatement)con.createStatement();
                    rs=(OracleResultSet)st.executeQuery("select id, photo from PBDM_Acteur where nom='"+nom+"' for update");
                    rs.next();
                    
                        index=rs.getInt(1);
                        OrdImage imgObj= (OrdImage)rs.getORAData(2,OrdImage.getORADataFactory());
                        String fich=this.cheminPhoto;
                        imgObj.loadDataFromFile(fich);
                        imgObj.setProperties();
                        if(imgObj.checkProperties())
                        {
                            System.out.println("photo mise à jour");
                        }
                        OraclePreparedStatement stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_Acteur set photo=? where id="+index);
                        stmt1.setORAData(1,imgObj);
                        stmt1.execute();
                        stmt1.close();
                    con.createStatement().execute("ALTER INDEX PBDM_indexA REBUILD");
                    con.commit();
                    s.close();
                }
                else
                {
                    OraclePreparedStatement s=(OraclePreparedStatement)con.prepareStatement("INSERT INTO PBDM_Realisateur VALUES(0,?,?,PBDM_PrenomsV_Type(PBDM_prenom_type(?),PBDM_prenom_type(?),PBDM_prenom_type(?)),ORDImage.init(),PBDM_Films_Type())"); 
                    s.setString(1, ddn);
                    s.setString(2, nom);
                    s.setString(3, prenoms[0]);
                    s.setString(4, prenoms[1]);
                    s.setString(5, prenoms[2]);
                    s.execute();
                    OracleStatement st=(OracleStatement)con.createStatement();
                    rs=(OracleResultSet)st.executeQuery("select id, photo from PBDM_Realisateur where nom='"+nom+"' for update");
                    rs.next();
                    
                        index=rs.getInt(1);
                        OrdImage imgObj= (OrdImage)rs.getORAData(2,OrdImage.getORADataFactory());
                        String fich=this.cheminPhoto;
                        imgObj.loadDataFromFile(fich);
                        imgObj.setProperties();
                        if(imgObj.checkProperties())
                        {
                            System.out.println("photo mise à jour");
                        }
                        OraclePreparedStatement stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_Realisateur set photo=? where id="+index);
                        stmt1.setORAData(1,imgObj);
                        stmt1.execute();
                        stmt1.close();
                        con.createStatement().execute("ALTER INDEX PBDM_indexR REBUILD");
                       con.commit();
                        s.close();
            }
        }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(frame_ajout_personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(frame_ajout_personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(frame_ajout_personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_valider_buttonActionPerformed


    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButton2ActionPerformed
    {//GEN-HEADEREND:event_jRadioButton2ActionPerformed
        if(this.jRadioButton2.isSelected())
        {
            this.jLabel1.setVisible(false);
            this.jTextField1.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButton1ActionPerformed
    {//GEN-HEADEREND:event_jRadioButton1ActionPerformed
        this.jLabel1.setVisible(true);
        this.jTextField1.setVisible(true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void annuler_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_annuler_buttonActionPerformed
    {//GEN-HEADEREND:event_annuler_buttonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_annuler_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(frame_ajout_personne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_ajout_personne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_ajout_personne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_ajout_personne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_ajout_personne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annuler_button;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField field_date;
    private javax.swing.JTextField field_nom;
    private javax.swing.JTextField field_prenoms;
    private javax.swing.JButton image_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_frame;
    private javax.swing.JLabel label_nom;
    private javax.swing.JLabel label_prenoms;
    private javax.swing.JPanel pan_button;
    private javax.swing.JPanel pan_image;
    private javax.swing.JPanel pan_principal;
    private javax.swing.JButton valider_button;
    // End of variables declaration//GEN-END:variables
}
