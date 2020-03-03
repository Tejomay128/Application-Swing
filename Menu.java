package com.mycompany.myproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Admin {
	//@SuppressWarnings("deprecation")
	public Admin(JFrame frame) {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//JFrame frame=new JFrame("Food Delivery Application");
		JPanel panel1=new JPanel();
		
		JLabel l1=new JLabel("Username:");
		JLabel l2=new JLabel("Password:");
		
		JLabel l3=new JLabel("Admin Login Window");
		JTextField t1=new JTextField(20);
		JPasswordField t2=new JPasswordField(20);
		JButton b1=new JButton("Login");
		String username, password;
		frame.setSize(500,500);
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		username=t1.getText();
		password=String.valueOf(t2.getPassword());
		
		b1.addActionListener((ActionEvent e) -> {
			//add code for verifying login credentials
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
			JPanel panel1=new JPanel();
			JLabel lb1=new JLabel("Username:");
			JLabel lb2=new JLabel("Password:");
			
			JLabel lb3=new JLabel("User Login Window");
			JTextField tf1=new JTextField(20);
			JPasswordField tf2=new JPasswordField(20);
			JButton bt1=new JButton("Login");
			String username, password;
			frame.setSize(500,500);
			frame.setLocationByPlatform(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			username=tf1.getText();
			password=String.valueOf(tf2.getPassword());
			
			bt1.addActionListener((ActionEvent ev) -> {
				//add code for verifying login credentials
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
			JTextField tf1=new JTextField(20);
			JTextField tf2=new JTextField(20);
			JTextField tf3=new JTextField(20);
			JPasswordField tf4=new JPasswordField(20);
			JTextField tf5=new JTextField(20);
			JButton bt1=new JButton("Register");
			String username, password, age, email, phoneno;
			frame.setSize(500,500);
			frame.setLocationByPlatform(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			username=tf1.getText();
			age=tf2.getText();
			email=tf3.getText();
			password=String.valueOf(tf4.getPassword());
			phoneno=tf5.getText();
			bt1.addActionListener((ActionEvent ev) -> {
				//add code for updating database
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
			panel2.add(lb5, g1);
			g1.gridx=1;
			g1.gridy=5;
			//g.anchor=GridBagConstraints.LINE_END;
			g1.gridwidth=1;
			panel2.add(tf5, g1);
			g1.gridx=0;
			g1.gridy=6;
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


public class Menu {
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
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
	
}
