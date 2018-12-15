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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class SearchBook {
    Connection dbConncetion;
    Statement quStatement;
    ResultSet result;
    String username;
    String email;
    
    public SearchBook(Connection dbConnection, String username, String email)
    {
        this.dbConncetion = dbConnection;
        this.username = username;
        this.email = email;
        JFrame jfrm = new JFrame("Search Book");
        jfrm.setSize(600,400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jfrm.setLayout(null);
        
        jfrm.getContentPane().setBackground(Color.WHITE);
        JLabel bookName = new JLabel("Enter Book Name");
        JTextField bookTF = new JTextField(20);
        bookName.setBounds(50,200,180,50);
        bookTF.setBounds(200,200,250,50);
        JButton jb = new JButton("Search");
        jb.setBounds(250,280,100,40);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                ArrayList <String> searchResults = new ArrayList();
                try {
                    quStatement = dbConnection.createStatement();
                    String quary = "SELECT * FROM CHINMOY009.BOOKS"+" WHERE BOOKNAME = '"+bookTF.getText()+"'";
                    result = quStatement.executeQuery(quary);
                    while(result.next())
                    {
                        String book = result.getString("BOOKNAME");
                        int bookId = result.getInt("BOOKID");
                        boolean availability = result.getBoolean("AVAILABLE");
                        String owner = result.getString("OWNER");
                        String email="";
                        Statement st = dbConnection.createStatement();
                        String query2 = "SELECT EMAIL FROM CHINMOY009.USERS"+" WHERE USERNAME = '"+owner+"'";
                        ResultSet result2 = st.executeQuery(query2);
                        while(result2.next())
                        {
                            email = result2.getString("EMAIL");
                        }
                        String str =bookId+" "+book+" "+owner+" "+email+" "+availability; 
                        searchResults.add(str);
                    }
                    jfrm.setVisible(false);
                    new SearchResult(dbConnection, username,email,searchResults);
                } catch (SQLException ex) {
                    Logger.getLogger(ShareBook.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                jfrm.setVisible(false);
                //new Profile(dbConnection,username, email);
            }
        });
        jfrm.add(bookName);
        jfrm.add(bookTF);
        jfrm.add(jb);
        
        jfrm.setVisible(true);
    }
}
