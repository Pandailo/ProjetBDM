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
import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdVideo;

/**
 *
 * @author al128785
 */
public class frame_ajout_jeu extends javax.swing.JFrame {
    String cheminPhoto="";
    String cheminBA="";
    Image photo;
    
    /**
     * Creates new form frame_ajout_jeu
     */
    public frame_ajout_jeu() {
        initComponents();
    }

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

        label_frame = new javax.swing.JLabel();
        pan_principal = new javax.swing.JPanel();
        label_titre = new javax.swing.JLabel();
        field_titre = new javax.swing.JTextField();
        label_date = new javax.swing.JLabel();
        field_date = new javax.swing.JTextField();
        label_genre = new javax.swing.JLabel();
        field_genre = new javax.swing.JTextField();
        label_synopsis = new javax.swing.JLabel();
        pan_text = new javax.swing.JScrollPane();
        edition_synopsis = new javax.swing.JTextArea();
        pan_image = new javax.swing.JPanel();
        label_note = new javax.swing.JLabel();
        field_note = new javax.swing.JTextField();
        pan_buttons = new javax.swing.JPanel();
        button_ba = new javax.swing.JButton();
        button_image = new javax.swing.JButton();
        button_annuler = new javax.swing.JButton();
        button_valider = new javax.swing.JButton();

        label_frame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_frame.setText("Ajout d'un jeu");
        label_frame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_frame, java.awt.BorderLayout.NORTH);

        label_titre.setText("Titre");

        label_date.setText("Date de sortie");

        label_genre.setText("Genre");

        label_synopsis.setText("Synopsis");

        edition_synopsis.setColumns(20);
        edition_synopsis.setRows(5);
        pan_text.setViewportView(edition_synopsis);

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

        label_note.setText("Note");

        javax.swing.GroupLayout pan_principalLayout = new javax.swing.GroupLayout(pan_principal);
        pan_principal.setLayout(pan_principalLayout);
        pan_principalLayout.setHorizontalGroup(
            pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pan_text, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_synopsis)
                    .addGroup(pan_principalLayout.createSequentialGroup()
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_titre)
                            .addComponent(label_date)
                            .addComponent(label_genre)
                            .addComponent(label_note))
                        .addGap(79, 79, 79)
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_date, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(field_genre, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(field_titre, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(field_note))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(pan_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        pan_principalLayout.setVerticalGroup(
            pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_principalLayout.createSequentialGroup()
                        .addComponent(pan_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pan_principalLayout.createSequentialGroup()
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_titre)
                            .addComponent(field_titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_date)
                            .addComponent(field_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_genre)
                            .addComponent(field_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_note)
                            .addComponent(field_note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_synopsis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pan_text, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(pan_principal, java.awt.BorderLayout.CENTER);

        pan_buttons.setLayout(new java.awt.GridLayout(2, 2));

        button_ba.setText("Bande-annonce");
        button_ba.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_baActionPerformed(evt);
            }
        });
        pan_buttons.add(button_ba);

        button_image.setText("Image");
        button_image.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_imageActionPerformed(evt);
            }
        });
        pan_buttons.add(button_image);

        button_annuler.setText("Annuler");
        button_annuler.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_annulerActionPerformed(evt);
            }
        });
        pan_buttons.add(button_annuler);

        button_valider.setText("Valider");
        button_valider.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_validerActionPerformed(evt);
            }
        });
        pan_buttons.add(button_valider);

        getContentPane().add(pan_buttons, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_validerActionPerformed
        try
        {
            int index=0;
            Connection con=connexionUtils.getInstance().getConnexion();
            con.setAutoCommit(false);
            Statement s=null;
            s = con.createStatement();
            OracleResultSet rs=null;
            //(id NUMBER,dateSortie date, nom VARCHAR2(50), synopsis VARCHAR2(1000)) 
            rs=(OracleResultSet)s.executeQuery("SELECT max(id) FROM PBDM_JeuVideo");
            while(rs.next())
            {
                index=rs.getInt(1);
            }
            System.out.println(index);
            index++;
            rs=(OracleResultSet) s.executeQuery("INSERT INTO PBDM_JeuVideo VALUES("+index+",'"+this.field_date.getText()+"','"+this.field_titre.getText()+"','"+this.edition_synopsis.getText()+"','"+this.field_genre.getText()+"',"+this.field_note.getText()+",ORDSYS.ORDImage.init(),ORDSYS.ORDVideo.init())");
            index=-1;
            rs=(OracleResultSet)s.executeQuery("select id, image, bandeA from PBDM_JeuVideo where nom='"+this.field_titre.getText()+"' for update");
            while(rs.next())
            {
                index=rs.getInt(1);
                OrdImage imgObj= (OrdImage)rs.getORAData(2,OrdImage.getORADataFactory());
                OrdVideo vidObj= (OrdVideo)rs.getORAData(3,OrdVideo.getORADataFactory());
                String fich=this.cheminPhoto;
                String vid=this.cheminBA;
                imgObj.loadDataFromFile(fich);
                if(!this.cheminBA.equals(""))
                    vidObj.loadDataFromFile(vid);
                byte[] ctx[] = new byte [4000][1];
                imgObj.setProperties();
                if(!this.cheminBA.equals(""))
                    vidObj.setProperties(ctx);
                OraclePreparedStatement stmt1;
                if(!this.cheminBA.equals(""))
                {
                    stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_Film set image=?,bandeA=? where id="+index);
                    stmt1.setORAData(1,imgObj);
                    stmt1.setORAData(2,vidObj);
                }
                else
                {
                    stmt1=(OraclePreparedStatement)con.prepareStatement("update PBDM_Film set image=? where id="+index);
                    stmt1.setORAData(1,imgObj);
                }
                stmt1.execute();
                stmt1.close();
            }
            rs=(OracleResultSet)s.executeQuery("ALTER INDEX PBDM_indexJ REBUILD");
            rs=(OracleResultSet)s.executeQuery("ALTER INDEX PBDM_indexSJ REBUILD");
            rs.close();
            s.close();
            con.commit();
        }
        catch (SQLException | IOException | ClassNotFoundException ex)
        {
            Logger.getLogger(frame_ajout_jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_button_validerActionPerformed

    private void button_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_imageActionPerformed
                                 
                                               
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
    }//GEN-LAST:event_button_imageActionPerformed

    private void button_baActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_baActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir une vidéo");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Videos", "avi", "mkv", "mp4");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        if(fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            //Récupération de la video
            this.cheminBA = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_button_baActionPerformed

    private void button_annulerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_button_annulerActionPerformed
    {//GEN-HEADEREND:event_button_annulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_button_annulerActionPerformed

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
            java.util.logging.Logger.getLogger(frame_ajout_jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_ajout_jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_ajout_jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_ajout_jeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_ajout_jeu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_annuler;
    private javax.swing.JButton button_ba;
    private javax.swing.JButton button_image;
    private javax.swing.JButton button_valider;
    private javax.swing.JTextArea edition_synopsis;
    private javax.swing.JTextField field_date;
    private javax.swing.JTextField field_genre;
    private javax.swing.JTextField field_note;
    private javax.swing.JTextField field_titre;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_frame;
    private javax.swing.JLabel label_genre;
    private javax.swing.JLabel label_note;
    private javax.swing.JLabel label_synopsis;
    private javax.swing.JLabel label_titre;
    private javax.swing.JPanel pan_buttons;
    private javax.swing.JPanel pan_image;
    private javax.swing.JPanel pan_principal;
    private javax.swing.JScrollPane pan_text;
    // End of variables declaration//GEN-END:variables
}
