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
public class connexionUtils2 {
	protected static final String LOGIN ="yv965015";
	protected static final String PASS ="yv965015";
	protected static final String URLFAC ="jdbc:oracle:thin:@butor:1521:ensb2016";
	protected static final String URLDIST="jdbc:oracle:thin:@ufrsciencestech.u-bourgogne.fr:25561:ensb2016";
	protected static Connection connect;
	private static Logger log = Logger.getLogger(connexionUtils2.class.getSimpleName());

	
	private connexionUtils2()
	{
            try 
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connect = DriverManager.getConnection(URLFAC, LOGIN, PASS);
                System.out.println("Connecté à la fac");
            } 
            catch (SQLException ex) 
            {
                try 
                {
                    connect = DriverManager.getConnection(URLDIST, LOGIN, PASS);
                    System.out.println("Connecté à distance");
                } 
                catch (SQLException ex1) 
                {
                    Logger.getLogger(connexionUtils2.class.getSimpleName()).log(Level.SEVERE, null, ex1);
                }
            }
            catch (ClassNotFoundException ex)
            {
            Logger.getLogger(connexionUtils.class.getSimpleName()).log(Level.SEVERE, null, ex);
            }
	}
	private static class connexionUtils2Holder
	{
		private final static connexionUtils2 instance=new connexionUtils2();
	}
	public static Connection getInstance()
	{
		if(connect == null){
			new connexionUtils2();
		}
		return connect;
	}
	
}

