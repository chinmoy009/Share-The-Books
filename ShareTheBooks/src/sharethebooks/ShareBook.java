/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharethebooks;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class ShareBook {
    Connection dbConnection;
    Statement quStatement;
    ResultSet result;
    String username;
    String email;
    public ShareBook(Connection dbConnection, String username,String email)
    {
        this.dbConnection = dbConnection;
        this.username = username;
        this.email = email;
        JFrame jfrm = new JFrame("Share Book");
        jfrm.setSize(600,400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jfrm.setLayout(null);
        
        jfrm.getContentPane().setBackground(Color.WHITE);
        JLabel bookName = new JLabel("Enter Book Name");
        JTextField bookTF = new JTextField(20);
        bookName.setBounds(50,200,180,50);
        bookTF.setBounds(200,200,250,50);
        JButton jb = new JButton("Share");
        jb.setBounds(250,280,100,40);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    quStatement = dbConnection.createStatement();
                    String quary = "INSERT INTO CHINMOY009.BOOKS"+" VALUES ("+1+", '"+username+"' ,'"+bookTF.getText()+"' , 'true')";
                    quStatement.executeUpdate(quary);
                } catch (SQLException ex) {
                    Logger.getLogger(ShareBook.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                JOptionPane.showMessageDialog(null, "Book Added Successfully");
                jfrm.setVisible(false);
                new Profile(dbConnection,username, email);
            }
        });
        jfrm.add(bookName);
        jfrm.add(bookTF);
        jfrm.add(jb);
        
        jfrm.setVisible(true);
    }
}
