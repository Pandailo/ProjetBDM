/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yann
 */
public class connexionUtils {
	protected static final String LOGIN ="yv965015";
	protected static final String PASS ="yv965015";
	protected static final String URLFAC ="jdbc:oracle:thin:@butor:1521:ensb2016";
	protected static final String URLDIST="jdbc:oracle:thin:@ufrsciencestech.u-bourgogne.fr:25561:ensb2016";
	private static Logger log = Logger.getLogger(connexionUtils.class.getSimpleName());

	
	private connexionUtils()
	{
		
	}
	private static class connexionUtilsHolder
	{
		private final static connexionUtils instance=new connexionUtils();
	}
	public static connexionUtils getInstance()
	{
		return connexionUtilsHolder.instance;
	}
	public static Connection getConnexion() throws SQLException
	{
		Connection con=null;
		try 
        {
			con=getConnexion(URLFAC);
        } 
        catch (SQLException ex) 
        {
        	con=getConnexion(URLDIST);
        } 
		
		return con;
	}
	private static Connection getConnexion(String url) throws SQLException
	{
		Connection con=null;
		try 
        {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, LOGIN, PASS);
        } 
        catch (SQLException ex) 
        {
            try 
            {
                con = DriverManager.getConnection(url, LOGIN, PASS);
            } 
            catch (SQLException ex1) 
            {
                Logger.getLogger(connexionUtils.class.getSimpleName()).log(Level.SEVERE, null, ex1);
            }
        } 
		catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(connexionUtils.class.getSimpleName()).log(Level.SEVERE, null, ex);
        }
		return con;
	}
}

