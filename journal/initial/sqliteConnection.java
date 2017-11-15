/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initial;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Hantao
 */
public class sqliteConnection {
       
    Connection conn=null;
    
    public static Connection dbConnector()
    {
        try{
            
            Class.forName("org.sqlite.JDBC");
            Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Vincent\\Google Drive\\School\\2017 - Fall\\CS 3332\\Fitness Journal\\journal\\lib\\sql\\TrainingSoftware.sqlite");
            JOptionPane.showMessageDialog(null, "Connection Successful");
            return conn;
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
