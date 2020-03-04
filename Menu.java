package com.mycompany.myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

class Admin {
	//@SuppressWarnings("deprecation")
	public Admin(JFrame frame) {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//JFrame frame=new JFrame("Food Delivery Application");
		JPanel panel1=new JPanel();
		
		JLabel l1=new JLabel("Email:");
		JLabel l2=new JLabel("Password:");
		
		JLabel l3=new JLabel("Admin Login Window");
		JTextField t1=new JTextField(20);
		JPasswordField t2=new JPasswordField(20);
		JButton b1=new JButton("Login");
		
		//frame.setSize(500,500);
		//frame.setLocationByPlatform(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
			System.err.println("Unsupported look and feel");
		}
		//t1.setColumns(100);
		t1.setEditable(true);
		t1.setEnabled(true);
		//t2.setColumns(100);
		t2.setEditable(true);
		t2.setEnabled(true);
		
		b1.addActionListener((ActionEvent) -> {
                    //add code for verifying login credentials
                    String email=t1.getText();
                    String password=String.valueOf(t2.getPassword());
                    TableModel tableFrame = new TableModel("User Details");

                    try{
                        Connection conn = DBUtil.getConn();
                        String sql = "SELECT * FROM admin " + "WHERE email=? and passwd=?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, email);
                        ps.setString(2, password);
                        ResultSet rs = ps.executeQuery();
                        if(rs.next()){
                            tableFrame.setVisible(true);
                            frame.setVisible(false);
                        }    
                        else{
                            JOptionPane.showMessageDialog(frame,"Incorrect Email or Password","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }catch(SQLException ex){
                        Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                  
		});
		frame.add(panel1);
		panel1.setLayout(new GridBagLayout());
		GridBagConstraints g=new GridBagConstraints();
		g.insets=new Insets(10, 40, 10, 40);
		g.gridx=0;
		g.gridy=0;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=2;
		panel1.add(l3, g);
		g.gridx=0;
		g.gridy=1;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=1;
		panel1.add(l1, g);
		g.gridx=1;
		g.gridy=1;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=1;
		panel1.add(t1, g);
		g.gridx=0;
		g.gridy=2;
		//g.anchor=GridBagConstraints.LINE_START;
		g.gridwidth=1;
		panel1.add(l2, g);
		g.gridx=1;
		g.gridy=2;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=1;
		panel1.add(t2, g);
		g.gridx=0;
		g.gridy=3;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=2;
		panel1.add(b1, g);
		//add all elements to panel before setting frame as visible
		frame.setVisible(true);
	}
}

class User1 {
	public User1(JFrame frame) {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//JFrame frame=new JFrame("Food Delivery Application");
		JPanel panel=new JPanel();
		JButton b1=new JButton("Login");
		JButton b2=new JButton("Register");
		JLabel l1=new JLabel("User Login/Register Window");
		JLabel l2=new JLabel("Please select required option:");
		
		JLabel l3=new JLabel();
		
		//frame.setSize(500,500);
		//frame.setLocationByPlatform(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
			System.err.println("Unsupported look and feel");
		}
		b1.addActionListener((ActionEvent e) -> {
			//add code for changing frame
			//l3.setText("Button 1 clicked");
			frame.remove(panel);
			frame.setVisible(false);
			JPanel panel1=new JPanel();
			JLabel lb1=new JLabel("Email:");
			JLabel lb2=new JLabel("Password:");
			
			JLabel lb3=new JLabel("User Login Window");
			JTextField tf1=new JTextField(20);
			JPasswordField tf2=new JPasswordField(20);
			JButton bt1=new JButton("Login");
			//String username, password;
			//frame.setSize(500,500);
			//frame.setLocationByPlatform(true);
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ev) {
				System.err.println("Unsupported look and feel");
			}
			//t1.setColumns(100);
			tf1.setEditable(true);
			tf1.setEnabled(true);
			//t2.setColumns(100);
			tf2.setEditable(true);
			tf2.setEnabled(true);
			
			
			bt1.addActionListener((ActionEvent ev) -> {
				boolean error = false;
				String email=tf1.getText();
				String password=String.valueOf(tf2.getPassword());
                                if(email.isEmpty()){
                                    JOptionPane.showMessageDialog(frame, "Email can't be empty!!!");
                                    error = true;
                                }
                                 if(password.isEmpty()){
                                    JOptionPane.showMessageDialog(frame, "Password can't be empty!!!");
                                    error = true;
                                }
                                //add after login frame here
                                if(!error){
                                    try{
                                    	String s;
                                        Connection conn = DBUtil.getConn();
                                        String sql1 = "SELECT * FROM user " + "WHERE email=? and passwd=?";
                                        PreparedStatement ps = conn.prepareStatement(sql1);
                                        String sql2 = "SELECT usrname FROM user " + "WHERE email=? and passwd=?";
                                        PreparedStatement ps1=conn.prepareStatement(sql2);
                                        ps.setString(1, email);
                                        ps.setString(2, password);
                                        ps1.setString(1,  email);
                                        ps1.setString(2, password);
                                        ResultSet rs = ps.executeQuery();
                                        ResultSet rs1=ps1.executeQuery();
                                        if(rs.next()){
                                        	s=rs1.getString("usrname");
                                            frame.remove(panel1);
                                            frame.setVisible(false);
                                            PizzaDelivery pd = new PizzaDelivery(frame, s);
                                        }    
                                        else{
                                            JOptionPane.showMessageDialog(frame,"Incorrect Email or Password","Error",JOptionPane.ERROR_MESSAGE);
                                        }
                                    }catch(SQLException ex){
                                        Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
                                    }    
                                }    
			});
			frame.add(panel1);
			panel1.setLayout(new GridBagLayout());
			GridBagConstraints g1=new GridBagConstraints();
			g1.insets=new Insets(10, 40, 10, 40);
			g1.gridx=0;
			g1.gridy=0;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=2;
			panel1.add(lb3, g1);
			g1.gridx=0;
			g1.gridy=1;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel1.add(lb1, g1);
			g1.gridx=1;
			g1.gridy=1;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel1.add(tf1, g1);
			g1.gridx=0;
			g1.gridy=2;
			//g.anchor=GridBagConstraints.LINE_START;
			g1.gridwidth=1;
			panel1.add(lb2, g1);
			g1.gridx=1;
			g1.gridy=2;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel1.add(tf2, g1);
			g1.gridx=0;
			g1.gridy=3;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=2;
			panel1.add(bt1, g1);
			//add all elements to panel before setting frame as visible
			frame.setVisible(true);
		});
		b2.addActionListener((ActionEvent e) -> {
			//add code for changing frame
			//l3.setText("Button 2 clicked");
			frame.remove(panel);
			frame.setVisible(false);
			JPanel panel2=new JPanel();
			JLabel lb1=new JLabel("Username:");
			JLabel lb2=new JLabel("Age:");
			JLabel lb3=new JLabel("Email:");
			JLabel lb4=new JLabel("Password:");
			JLabel lb5=new JLabel("Phone number:");
			JLabel lb6=new JLabel("User Register Window");
			JLabel lb7=new JLabel("Re-enter Password:");
			JTextField tf1=new JTextField(20);
			JTextField tf2=new JTextField(20);
			JTextField tf3=new JTextField(20);
			JPasswordField tf4=new JPasswordField(20);
			JPasswordField tf6=new JPasswordField(20);
			JTextField tf5=new JTextField(20);
			JButton bt1=new JButton("Register");
			
			//frame.setSize(500,500);
			//frame.setLocationByPlatform(true);
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ev) {
				System.err.println("Unsupported look and feel");
			}
			//t1.setColumns(100);
			tf1.setEditable(true);
			tf1.setEnabled(true);
			//t2.setColumns(100);
			tf2.setEditable(true);
			tf2.setEnabled(true);
			tf3.setEditable(true);
			tf3.setEnabled(true);
			tf4.setEditable(true);
			tf4.setEnabled(true);
			tf5.setEditable(true);
			tf5.setEnabled(true);
			
			bt1.addActionListener((ActionEvent ev) -> {
				//add code for updating database
				//add code for validating credentials
				
				String username, password1, password2, email, phoneno;
                                int age=0;
                                boolean error = false;
                                
				username=tf1.getText();
                                if(username.isEmpty()){
                                    JOptionPane.showMessageDialog(frame,"Username can't be empty!!!","Empty Field",JOptionPane.ERROR_MESSAGE);
                                    error = true;    
                                }
                                
                                if(tf2.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(frame,"Age can't be empty!!!","Empty Field",JOptionPane.ERROR_MESSAGE);
                                    error = true;
                                }
                                else{
                                    try {
					int temp_age;
                                        temp_age=Integer.parseInt(tf2.getText());
                                        age = temp_age;
                                        if(temp_age<18 || temp_age>120) {
                                            JOptionPane.showMessageDialog(frame, "Age is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                                            error = true;
                                        }
                                    }
                                    catch(NumberFormatException exp) {
					JOptionPane.showMessageDialog(frame, "Age is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                                        error = true;
                                    }
                                }
                                email=tf3.getText();
                                if(email.isEmpty()){
                                    JOptionPane.showMessageDialog(frame,"Email can't be empty!!!","Empty Field",JOptionPane.ERROR_MESSAGE);
                                    error = true;
                                }
                                else{
                                    Pattern p=Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
                                    Matcher m=p.matcher(email);
                                    if(!m.find()) {
					JOptionPane.showMessageDialog(frame, "Email is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                                        error = true;
                                    }
                                }							
				
				password1=String.valueOf(tf4.getPassword());
				password2=String.valueOf(tf6.getPassword());
                                phoneno=tf5.getText();
                                if(phoneno.isEmpty()){
                                    JOptionPane.showMessageDialog(frame,"Phoneno can't be empty!!!","Empty Field",JOptionPane.ERROR_MESSAGE);
                                    error = true;
                                }
                                else{
                                    try {
					
                                    if(tf5.getText().length() !=10) {
					JOptionPane.showMessageDialog(frame, "Phone number is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                                        error = true;
                                    }
				}
                                    catch(NumberFormatException exp) {
                                        JOptionPane.showMessageDialog(frame, "Phone number is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                                        error = true;
                                    }
                                }
                                if(password1.isEmpty() || password2.isEmpty()){
                                    JOptionPane.showMessageDialog(frame,"Password can't be empty!!!","Empty Field",JOptionPane.ERROR_MESSAGE);
                                    error = true;
                                }
                                else{
                                    if(!password1.equals(password2)) {
                                        JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error!", JOptionPane.ERROR_MESSAGE);
                                        error = true;
                                    }				
				}
				
				if(!error){
                                    User user = new User();
                                    user.setUsrname(username);
                                    user.setAge(age);
                                    user.setEmail(email);
                                    user.setPasswd(password2);
                                    user.setPhoneno(phoneno);
                                    UserDB.add(user);
                                    JOptionPane.showMessageDialog(frame,"User " + username + " is registered successfully");
                                    frame.remove(panel2);
                                    frame.setVisible(false);
                                    PizzaDelivery pd = new PizzaDelivery(frame, username);
                                }
				
			});
			frame.add(panel2);
			panel2.setLayout(new GridBagLayout());
			GridBagConstraints g1=new GridBagConstraints();
			g1.insets=new Insets(10, 40, 10, 40);
			g1.gridx=0;
			g1.gridy=0;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=2;
			panel2.add(lb6, g1);
			g1.gridx=0;
			g1.gridy=1;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel2.add(lb1, g1);
			g1.gridx=1;
			g1.gridy=1;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel2.add(tf1, g1);
			g1.gridx=0;
			g1.gridy=2;
			//g.anchor=GridBagConstraints.LINE_START;
			g1.gridwidth=1;
			panel2.add(lb2, g1);
			g1.gridx=1;
			g1.gridy=2;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel2.add(tf2, g1);
			g1.gridx=0;
			g1.gridy=3;
			//g.anchor=GridBagConstraints.LINE_START;
			g1.gridwidth=1;
			panel2.add(lb3, g1);
			g1.gridx=1;
			g1.gridy=3;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel2.add(tf3, g1);
			g1.gridx=0;
			g1.gridy=4;
			//g.anchor=GridBagConstraints.LINE_START;
			g1.gridwidth=1;
			panel2.add(lb4, g1);
			g1.gridx=1;
			g1.gridy=4;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel2.add(tf4, g1);
			g1.gridx=0;
			g1.gridy=5;
			//g.anchor=GridBagConstraints.LINE_START;
			g1.gridwidth=1;
			panel2.add(lb7, g1);
			g1.gridx=1;
			g1.gridy=5;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel2.add(tf6, g1);
			g1.gridx=0;
			g1.gridy=6;
			//g.anchor=GridBagConstraints.LINE_START;
			g1.gridwidth=1;
			panel2.add(lb5, g1);
			g1.gridx=1;
			g1.gridy=6;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel2.add(tf5, g1);
			g1.gridx=0;
			g1.gridy=7;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=2;
			panel2.add(bt1, g1);
			//add all elements to panel before setting frame as visible
			frame.setVisible(true);
		});
		frame.add(panel);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints g=new GridBagConstraints();
		g.insets=new Insets(10, 40, 10, 40);
		g.gridx=0;
		g.gridy=0;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=2;
		panel.add(l1, g);
		g.gridx=0;
		g.gridy=1;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=2;
		panel.add(l2, g);
		g.gridx=0;
		g.gridy=2;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=1;
		panel.add(b1, g);
		g.gridx=1;
		g.gridy=2;
		//g.anchor=GridBagConstraints.LINE_START;
		g.gridwidth=1;
		panel.add(b2, g);
		g.gridx=0;
		g.gridy=3;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=2;
		panel.add(l3, g);
		
		//add all elements to panel before setting frame as visible
		frame.setVisible(true);
	}
}

public class Menu extends JFrame {
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        //JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame=new JFrame("Food Delivery Application");
		JPanel panel=new JPanel();
		JButton b1=new JButton("Admin");
		JButton b2=new JButton("User");
		JLabel l1=new JLabel("Welcome to Food Delivery Application!");
		JLabel l2=new JLabel("Please select required option:");
		
		JLabel l3=new JLabel();
		frame.setSize(500,500);
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
			System.err.println("Unsupported look and feel");
		}
		b1.addActionListener((ActionEvent e) -> {
			//add code for changing frame
			//l3.setText("Button 1 clicked");
			frame.remove(panel);
			frame.setVisible(false);
			Admin ad=new Admin(frame);
		});
		b2.addActionListener((ActionEvent e) -> {
			//add code for changing frame
			//l3.setText("Button 2 clicked");
			frame.remove(panel);
			frame.setVisible(false);
			User1 us=new User1(frame);
		});
		frame.add(panel);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints g=new GridBagConstraints();
		g.insets=new Insets(10, 40, 10, 40);
		g.gridx=0;
		g.gridy=0;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=2;
		panel.add(l1, g);
		g.gridx=0;
		g.gridy=1;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=2;
		panel.add(l2, g);
		g.gridx=0;
		g.gridy=2;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=1;
		panel.add(b1, g);
		g.gridx=1;
		g.gridy=2;
		//g.anchor=GridBagConstraints.LINE_START;
		g.gridwidth=1;
		panel.add(b2, g);
		g.gridx=0;
		g.gridy=3;
		//g.anchor=GridBagConstraints.LINE_END;
		g.gridwidth=2;
		panel.add(l3, g);
		
		//add all elements to panel before setting frame as visible
		frame.setVisible(true);
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
