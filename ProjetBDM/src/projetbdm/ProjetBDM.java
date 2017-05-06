/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.episode;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Yann
 */
public class ProjetBDM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException 
    {
      /* try
        {*/
            frame_con test= new frame_con();
            test.setVisible(true);
          /* Connection con=connexionUtils.getInstance().getConnexion();
            Statement st=con.createStatement();
            OracleResultSet rs=(OracleResultSet) st.executeQuery("SELECT id FROM PBDM_Saison WHERE DEREF(serie).nom='Test'");
            while(rs.next())
            {
                System.out.println(rs.getInt(1));
                
            }
            rs.close();
            st.close();
            
            
        }*/
      /*  catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ProjetBDM.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
