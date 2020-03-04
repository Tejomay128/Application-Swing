package com.mycompany.myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class PizzaDelivery{
	//JFrame jf=new JFrame();
	JPanel jp=new JPanel();
	JLabel l1=new JLabel("Welcome to Pizza Delivery Application!");
	JLabel l2=new JLabel("Fill in the required details:");
	JLabel l3=new JLabel("Enter delivery location:");
	JLabel l4=new JLabel("Select restaurant:");
	JLabel l5=new JLabel("Select dish:");
	JLabel l6=new JLabel("Enter coupon code:");
	JLabel l7=new JLabel("Today's offer code: 5X98@$");
	JButton btn=new JButton("Order");
	ButtonGroup gr=new ButtonGroup();
	JRadioButton b1=new JRadioButton("Dominoes");
	JRadioButton b2=new JRadioButton("Pizza Hut");
	JCheckBox cb1=new JCheckBox("Vegetarian");
	JCheckBox cb2=new JCheckBox("Non-Vegetarian");
	JTextField t1=new JTextField(20);
	JTextField t2=new JTextField(20);
	public PizzaDelivery(JFrame jf) {
		jf.setTitle("Pizza Delivery Application");
        jf.setSize(500, 500);
        jf.setLocationByPlatform(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            System.err.println("Unsupported look and feel");
        }
        t1.setEditable(true);
        t1.setEnabled(true);
        t2.setEditable(true);
        t2.setEnabled(true);
        gr.add(b1);
        gr.add(b2);

        btn.addActionListener((ActionEvent e) -> {
        	String location=t1.getText();
        	if(!t2.getText().isEmpty()) {
        		JOptionPane.showMessageDialog(jf, "Coupon applied!", "Coupon", JOptionPane.DEFAULT_OPTION);
        	}
        	if(!location.isEmpty()) {
        		String msg="Order placed!\nOrder will be delivered to "+location+" in 30 minutes.\nThank you!";
            	JOptionPane.showMessageDialog(jf, msg, "Order Placed", JOptionPane.DEFAULT_OPTION);
        	}
		});  
        
        jp.setLayout(new GridBagLayout());
        GridBagConstraints g=new GridBagConstraints();
		g.insets=new Insets(10, 40, 10, 40);
		g.gridx=0;
		g.gridy=0;
		g.gridwidth=2;
		jp.add(l1, g);
		g.gridx=0;
		g.gridy=1;
		g.gridwidth=2;
		jp.add(l7, g);
		g.gridx=0;
		g.gridy=2;
		g.gridwidth=2;
		jp.add(l2, g);
		g.gridx=0;
		g.gridy=3;
		g.gridwidth=1;
		jp.add(l3, g);
		g.gridx=1;
		g.gridy=3;
		g.gridwidth=1;
		jp.add(t1, g);
		g.gridx=0;
		g.gridy=4;
		g.gridwidth=2;
		jp.add(l4, g);
		g.gridx=0;
		g.gridy=5;
		g.gridwidth=1;
		jp.add(b1, g);
		g.gridx=1;
		g.gridy=5;
		g.gridwidth=1;
		jp.add(b2, g);
		g.gridx=0;
		g.gridy=6;
		g.gridwidth=2;
		jp.add(l5, g);
		g.gridx=0;
		g.gridy=7;
		g.gridwidth=1;
		jp.add(cb1, g);
		g.gridx=1;
		g.gridy=7;
		g.gridwidth=1;
		jp.add(cb2, g);
		g.gridx=0;
		g.gridy=8;
		g.gridwidth=1;
		jp.add(l6, g);
		g.gridx=1;
		g.gridy=8;
		g.gridwidth=1;
		jp.add(t2, g);
		g.gridx=0;
		g.gridy=9;
		g.gridwidth=2;
		jp.add(btn, g);
		jf.add(jp);
        jf.setVisible(true);
	}
}
