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


public class SignUpWindow {
    Connection dbConnection;
    Statement quStatement;
    ResultSet result;
    
    public SignUpWindow(Connection dbConnection)
    {
        this.dbConnection = dbConnection;
        JFrame jfrm = new JFrame("Sign Up Window");
        jfrm.setSize(600,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jfrm.setLayout(null);
        
        jfrm.getContentPane().setBackground(Color.BLUE);
        JLabel userName = new JLabel("USER NAME:");
        JLabel pass = new JLabel("PASSWORD:");
        JLabel conpass = new JLabel("CONFIRM PASSWORD");
        JLabel email = new JLabel("EMAIL");
        JLabel phoneNumber = new JLabel("PHONE NUMBER");
       
        JTextField userTF = new JTextField(20);
        JTextField passTF = new JTextField(20);
        JTextField conpassTF = new JTextField(20);
        JTextField emailTF = new JTextField(20);
        JTextField phoneNumberTF = new JTextField(20);
        
        
        JButton jb = new JButton("SIGN UP");
        
        userName.setBounds(60,15,160,62);
        userName.setForeground(Color.WHITE);
        //userName.setOpaque(true);
        userTF.setBounds(170,15,300,62);
        pass.setBounds(60,92,160,62);
        pass.setForeground(Color.WHITE);
        //pass.setOpaque(true);
        passTF.setBounds(170,92,300,62);
        conpass.setBounds(60,169,160,62);
        conpass.setForeground(Color.WHITE);
        //pass.setOpaque(true);
        conpassTF.setBounds(170,169,300,62);
        email.setBounds(60,246,160,62);
        email.setForeground(Color.WHITE);
        //pass.setOpaque(true);
        emailTF.setBounds(170,246,300,62);
        phoneNumber.setBounds(60,323,160,62);
        phoneNumber.setForeground(Color.WHITE);
        //pass.setOpaque(true);
        phoneNumberTF.setBounds(170,323,300,62);
        jb.setBounds(300,400,80,20);
        
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    quStatement = dbConnection.createStatement();
                    String query = "INSERT INTO CHINMOY009.USERS"+" VALUES ('"+userTF.getText()+"' , '"+passTF.getText()+"' , '"+emailTF.getText()+"' , "+phoneNumberTF.getText()+")";
                    quStatement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "SIGN UP SUCCESSFUL");
                    jfrm.setVisible(false);
                    new Profile(dbConnection,userTF.getText(),emailTF.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(SignUpWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        jfrm.add(userName);
        jfrm.add(userTF);
        jfrm.add(pass);
        jfrm.add(passTF);
        jfrm.add(conpass);
        jfrm.add(conpassTF);
        jfrm.add(email);
        jfrm.add(emailTF);
        jfrm.add(phoneNumber);
        jfrm.add(phoneNumberTF);
        jfrm.add(jb);
        jfrm.setVisible(true);
    }
}
