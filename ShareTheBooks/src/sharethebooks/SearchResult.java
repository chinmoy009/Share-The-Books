/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharethebooks;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SearchResult {
    Connection dbConnection;
    Statement quStatement;
    ResultSet result;
    String username;
    String email;
    ArrayList<String>searchResults;
    
    public SearchResult(Connection dbConnection, String username, String email,ArrayList<String>searchResults)
    {
        this.dbConnection = dbConnection;
        this.username = username;
        this.email = email;
        this.searchResults = searchResults;
        JFrame jfrm = new JFrame("Search Book");
        jfrm.setSize(600,400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jfrm.setLayout(null);
        
        jfrm.getContentPane().setBackground(Color.WHITE);
        JLabel jlb1 = new JLabel("BookId");
        JLabel jlb2 = new JLabel("BookName");
        JLabel jlb3 = new JLabel("Owner");
        JLabel jlb4 = new JLabel("Email");
        JLabel jlb5 = new JLabel("Available");
        jlb1.setBounds(20,10,96,15);
        jlb2.setBounds(136,10,96,15);
        jlb3.setBounds(252,10,96,15);
        jlb4.setBounds(368,10,96,15);
        jlb5.setBounds(484,10,96,15);
        jfrm.add(jlb4);
        jfrm.add(jlb1);
        jfrm.add(jlb2);
        jfrm.add(jlb3);
        jfrm.add(jlb5);
        int length = searchResults.size();
        int x =20, y=30;
        for(int i = 0;i<length ; i++)
        {  
            for(String retVal:searchResults.get(i).split(" "))
            {
                JLabel jlb = new JLabel(retVal);
                jlb.setBounds(x,y,96,15);
                jfrm.add(jlb);
                x+=116;
            }
            x=20;
            y+=20;
        }
        JButton jb = new JButton("BOOK");
        jb.setBounds(520,320,80,50);
        jfrm.add(jb);
        jb.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent ae)
              {
                  
                  jfrm.setVisible(false);
                  new BookingWindow(dbConnection, username, email);
              }
        });
        jfrm.setVisible(true);
        
              
    }
}
