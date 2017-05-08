/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init_connexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;
import projetbdm.connexionUtils;

/**
 *
 * @author Yann
 */
public class init_co
{
    public static void main(String[] args)
    {
        try
        {
            MD5Password md=new MD5Password();
            String pw="admin";
            Connection con=connexionUtils.getInstance().getConnexion();
            OraclePreparedStatement ops=(OraclePreparedStatement)con.prepareStatement("INSERT INTO PBDM_table_connexion VALUES('admin',?,'admin')");
            String pwC=md.getEncodedPassword(pw);
            ops.setString(1, pwC);
            ops.executeQuery();
            con.commit();
                    }
        catch (SQLException ex)
        {
            Logger.getLogger(init_co.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(init_co.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
