/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharethebooks;

import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class ShareTheBooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Connection dbConnection = null;
      Statement quStatement = null;
      ResultSet result = null;
      
      try{
          dbConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/BookSharingDB", "Chinmoy009", "123456");
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      new WelComeWindow(dbConnection);
    }
    
}
