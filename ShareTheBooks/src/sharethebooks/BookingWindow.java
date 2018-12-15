/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharethebooks;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingWindow {
    Connection dbConnection;
    Statement quStatement;
    ResultSet result;
    String username;
    String email;
    public BookingWindow(Connection dbConnection, String username, String email)
    {
        this.dbConnection = dbConnection;
        this.username = username;
        this.email = email;
        
        JFrame jfrm = new JFrame("Share Book");
        jfrm.setSize(600,400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jfrm.setLayout(null);
        
        jfrm.getContentPane().setBackground(Color.WHITE);
        JLabel bookName = new JLabel("Enter Book ID");
        JTextField bookTF = new JTextField(20);
        bookName.setBounds(50,200,180,50);
        bookTF.setBounds(200,200,250,50);
        JButton jb = new JButton("BOOK");
        jb.setBounds(250,280,100,40);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    quStatement = dbConnection.createStatement();
                    String query = "UPDATE CHINMOY009"+" SET AVAILABLE = false WHERE BOOKID = '"+bookTF.getText()+"'";
                    quStatement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Booked successfully");
                    jfrm.setVisible(false);
                    new Profile(dbConnection,username,email);
                } catch (SQLException ex) {
                    Logger.getLogger(BookingWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        jfrm.add(bookName);
        jfrm.add(bookTF);
        jfrm.add(jb);
        jfrm.setVisible(true);
    }
}