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

public class WelComeWindow {
    JLabel jlab;
    JButton jb;
    JButton jb2;
    Connection dbConnection;
    public WelComeWindow(Connection dbConnection)
    {
        this.dbConnection = dbConnection;
        JFrame jfrm = new JFrame("ShareTheBooks");
        JLabel jlb = new JLabel("SHARE THE BOOKS");
        jfrm.setSize(600,400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jfrm.getContentPane().setBackground(Color.GREEN);
        jfrm.setLayout(null);
        jfrm.setContentPane(new JLabel(new ImageIcon("bookShare.png")));
        jb = new JButton("Sign In");
        jb2 = new JButton("Sign Up");
        jlb.setBounds(20,20,180,50);
        jlb.setFont(new Font("Serif", Font.PLAIN, 20));
        //jlb.setBackground(Color.WHITE);
        jlb.setForeground(Color.BLACK);
        jlb.setOpaque(true);
        jb2.setBackground(Color.gray);
        jb2.setForeground(Color.cyan);
        jb2.setOpaque(true);
        jb2.setBounds(80,320,80,20);
        jb.setBackground(Color.gray);
        jb.setForeground(Color.cyan);
        jb.setOpaque(true);
        jb.setBounds(420,320,80,20);
        jb.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent ae)
           {
               jfrm.setVisible(false);
               new SignInWindow(dbConnection);
           }
        });
       jb2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae)
           {
               jfrm.setVisible(false);
               new SignUpWindow(dbConnection);
           }
       });
       jfrm.add(jb);
       jfrm.add(jb2);
       jfrm.add(jlb);
       jfrm.setVisible(true);
        
    }
}
