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
import javax.swing.*;
import java.sql.*;

public class Profile {
    Connection dbConnection;
    Statement quStatement;
    ResultSet result;
    String userName;
    String email;
    JFrame jfrm;
    public Profile(Connection dbConnection, String userName,String email)
    {
        this.dbConnection = dbConnection;
        this.userName = userName;
        this.email = email;
        jfrm =  new JFrame("User Profile");
        jfrm.setSize(600,400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jfrm.setLayout(null);
        
        jfrm.getContentPane().setBackground(Color.WHITE);
        JLabel uname = new JLabel(userName);
        JLabel em = new JLabel(email);
        JButton shareBook = new JButton("Share Book");
        JButton searchBook = new JButton("Search Book");
        uname.setBounds(100, 57, 400, 58);
        em.setBounds(100,114,400,58);
        shareBook.setBounds(115,171,100,50);
        searchBook.setBounds(400,171,140,50);
        
        shareBook.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ae)
             {
                 jfrm.setVisible(false);
                 new ShareBook(dbConnection,userName,email);
             }
        });
        
        searchBook.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                jfrm.setVisible(false);
                new SearchBook(dbConnection,userName,email);
            }
        });
        jfrm.add(uname);
        jfrm.add(em);
        jfrm.add(shareBook);
        jfrm.add(searchBook);
        jfrm.setVisible(true);
 
        
    }
}
