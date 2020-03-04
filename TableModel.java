package com.mycompany.myproject;


import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.SQLException;
import javax.swing.*;


public class TableModel extends JFrame {
    private JTable userTable;
    private UserModel usermodel = new UserModel();
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
        
        add(buildButtonPanel(),BorderLayout.NORTH);
        userTable = buildTable();
        add(new JScrollPane(userTable),BorderLayout.CENTER);
//        setVisible(true);
    }

    private JPanel buildButtonPanel(){
        JPanel panel = new JPanel();
        JButton addBtn = new JButton("add");
        addBtn.addActionListener((ActionEvent) -> {
            doAddBtn();
        });
        panel.add(addBtn);
        
         JButton editBtn = new JButton("edit");
        editBtn.addActionListener((ActionEvent) -> {
            doEditBtn();
        });
        panel.add(editBtn);
        
         JButton deleteBtn = new JButton("delete");
        deleteBtn.addActionListener((ActionEvent) -> {
            doDeleteBtn();
        });
        panel.add(deleteBtn);
        
        return panel;
        
        
    }
    
    private void doAddBtn(){
        JOptionPane.showMessageDialog(this, "not implemented","not implemented", JOptionPane.ERROR_MESSAGE);
    }
    
     private void doEditBtn(){
        JOptionPane.showMessageDialog(this, "not implemented","not implemented", JOptionPane.ERROR_MESSAGE);
    }
     
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
