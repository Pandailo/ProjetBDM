/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import init_connexion.init_co;
import java.sql.SQLException;

/**
 *
 * @author Yann
 */
public class ProjetBDM {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException 
    {
            init_co i=new init_co();
            i.init();
            frame_con test= new frame_con();
            test.setVisible(true);
    } 
}