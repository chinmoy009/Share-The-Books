/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharethebooks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SignInWindow {
    Connection dbConnection;
    Statement quStatement;
    ResultSet result;
    
    public SignInWindow(Connection dbConnection)
    {
        this.dbConnection = dbConnection;
        JFrame jfrm = new JFrame("Sign In");
        jfrm.setSize(600,400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jfrm.setLayout(null);
        
        jfrm.getContentPane().setBackground(Color.BLUE);
        JLabel userName = new JLabel("USER NAME:");
        JLabel pass = new JLabel("PASSWORD:");
       
        JTextField userTF = new JTextField(20);
        JTextField passTF = new JTextField(20);
        
        
        JButton jb = new JButton("SIGN IN");
        
        userName.setBounds(60,62,160,50);
        userName.setForeground(Color.WHITE);
        //userName.setOpaque(true);
        userTF.setBounds(170,62,300,40);
        pass.setBounds(60,172,160,50);
        pass.setForeground(Color.WHITE);
        //pass.setOpaque(true);
        passTF.setBounds(170,172,300,40);
        jb.setBounds(300,296,80,20);
        
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                String username = userTF.getText();
                String password = passTF.getText();
                //System.out.println(username + "  "+password);
                try {
                    quStatement =  dbConnection.createStatement();
                    String tableColumn = "CHINMOY009.USERS";
                    String column1 = "USERNAME";
                    String column2 = "PASSWORD";
                    //username = "Chinmoy009";
                    //password = "123456";
                    //String quary = "SELECT * FROM CHINMOY009.USERS" + " WHERE USERNAME = 'Cristiano'";
                    String quary = "SELECT * FROM CHINMOY009.USERS"+" WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'";
                    result = quStatement.executeQuery(quary);
//                    if(!result.next())
//                    {
//                        System.out.println("Hello");
//                        JOptionPane.showMessageDialog(null,"Username or password is incorrect");
//                        return;
//                                
//                    }
                    while(result.next())
                    {
                        String uname = result.getString("USERNAME");
                        String em = result.getString("EMAIL");
                        System.out.println("u "+uname+" em "+em);
                        jfrm.setVisible(false);
                        new Profile(dbConnection,uname,em);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SignInWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
        
        jfrm.add(userName);
        jfrm.add(userTF);
        jfrm.add(pass);
        jfrm.add(passTF);
        jfrm.add(jb);
        jfrm.setVisible(true);
        
    }
}
