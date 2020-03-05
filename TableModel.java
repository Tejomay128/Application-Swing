package com.mycompany.myproject;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;


public class TableModel extends JFrame {
    private JTable userTable;
    private UserModel usermodel = new UserModel();
    JPanel buttonPanel;
    public TableModel(String s) {
        setTitle(s);
        
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            System.err.println("Unsupported look and feel");
        }
        setSize(1000, 750);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buttonPanel = new JPanel();
        buttonPanel = buildButtonPanel();
        add(buttonPanel,BorderLayout.NORTH);
        userTable = buildTable();
        add(new JScrollPane(userTable),BorderLayout.CENTER);
//        setVisible(true);
    }

    private JPanel buildButtonPanel(){
        JPanel panel = new JPanel();
        JButton addBtn = new JButton("add");
        addBtn.addActionListener((ActionEvent) -> {
//            remove(buttonPanel);
//            remove(userTable);
            //this.setVisible(false);
            doAddBtn();
        });
        panel.add(addBtn);
        
/*         JButton editBtn = new JButton("edit");
        editBtn.addActionListener((ActionEvent) -> {
            doEditBtn();
        });
        panel.add(editBtn);*/
        
         JButton deleteBtn = new JButton("delete");
        deleteBtn.addActionListener((ActionEvent) -> {
            doDeleteBtn();
        });
        panel.add(deleteBtn);
        
        return panel;
        
        
    }
    
    private void doAddBtn(){
//        JOptionPane.showMessageDialog(this, "not implemented","not implemented", JOptionPane.ERROR_MESSAGE);
                this.setVisible(false);
                JFrame fr = new JFrame();
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
			fr.setSize(500,500);
			fr.setLocationByPlatform(true);
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			int age;
                        boolean error = false;
                        age=Integer.parseInt(tf2.getText());
			username=tf1.getText();
                        if(tf1.getText().isEmpty()){
                            error = true;
                                   
                        }
                        try {
					
				if(age<18 || age>120) {
					JOptionPane.showMessageDialog(this, "Age is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                                        error = true;
                                }
			}
			catch(NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Age is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                                error = true;
			}
			email=tf3.getText();
			password1=String.valueOf(tf4.getPassword());
			password2=String.valueOf(tf6.getPassword());
                        phoneno=tf5.getText();
			try {
					
				if(tf5.getText().length() !=10) {
					JOptionPane.showMessageDialog(this, "Phone number is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                                        error = true;
				}
			}
			catch(NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Phone number is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                                error = true;
			}
			if(!password1.equals(password2)) {
				JOptionPane.showMessageDialog(this, "Passwords do not match", "Error!", JOptionPane.ERROR_MESSAGE);
                                error = true;
			}
			Pattern p=Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
			Matcher m=p.matcher(email);
			if(!m.find()) {
				JOptionPane.showMessageDialog(this, "Email is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                                error = true;
			}
			if(!error){
                                User user = new User();
                                user.setUsrname(username);
                                user.setAge(age);
                                user.setEmail(email);
                                user.setPasswd(password2);
                                user.setPhoneno(phoneno);
                                UserDB.add(user);
                                JOptionPane.showMessageDialog(this,"User" + username + " is registered successfully");
                        }
				
                    });
                this.add(panel2);
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
                        fr.add(panel2);
			fr.setVisible(true);
		
    }
    
//     private void doEditBtn(){
//        JOptionPane.showMessageDialog(this, "not implemented","not implemented", JOptionPane.ERROR_MESSAGE);
//    }
     
    private void doDeleteBtn(){
        //System.out.println("dodelete");
        int row = userTable.getSelectedRow();
//        System.out.println(row);
//        JOptionPane.showMessageDialog(this,row);
        if(row == -1){
            JOptionPane.showMessageDialog(this,"No row is Selected","Cannot perform operation",JOptionPane.ERROR_MESSAGE);
        }
        else{
            User user = usermodel.getUser(row);
//            JOptionPane.showMessageDialog(this, user.getUsrname());
            int ask = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete "+ user.usrname +" from the table?","Confirm delete",JOptionPane.YES_NO_OPTION);
            if(ask == JOptionPane.YES_OPTION){
                UserDB.delete(user);
                usermodel.databaseUpdated();
            }   
        }
    }
    
    private JTable buildTable(){
        usermodel.databaseUpdated();
        JTable table = new JTable(usermodel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setBackground(null);
        return table;
    }
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


 



    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
