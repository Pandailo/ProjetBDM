/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yann
 */
public class ProjetBDM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        frame_con test= new frame_con();
        test.setVisible(true);
        MD5Password md5=new MD5Password();
        String pw=md5.getEncodedPassword("admin");
        try {
            if(md5.testPassword("admin", pw))
            {
                System.out.println("cé bo");
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ProjetBDM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            Connection con=null;
            con=connexionUtils2.getInstance();
            Statement st=con.createStatement();
            st.executeQuery("INSERT INTO PBDM_table_connexion VALUES('admin','"+pw+"','admin')");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ProjetBDM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
