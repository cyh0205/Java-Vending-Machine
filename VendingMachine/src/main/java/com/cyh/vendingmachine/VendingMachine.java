/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cyh.vendingmachine;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




/**
 *
 * @author esilv
 */
public class VendingMachine extends javax.swing.JFrame {
    /**
     * Creates new form VendingMachine
     */
    public VendingMachine() {
        initComponents();
        //call date function
        setDate();
        //load all the item into GUI
        loaditem();
        //disable the insert money panel and balance panel button
        resetButton.setEnabled(false);
        tenCentsButton.setEnabled(false);
        fiftyCentsButton.setEnabled(false);
        twentyCentsButton.setEnabled(false);
        rmoneButton.setEnabled(false);
        rmfiveButton.setEnabled(false);
        confirmInsertButton.setEnabled(false);
        reinsertButton.setEnabled(false);
        balanceCollectButton.setEnabled(false);
    }
    
    private String date;
    public String getDate(){
        return date;
    }
    
    public void setDate(){
        //display date and time with SimpleDateFormat import
        String date = new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new Date());
        this.date = date;
        //set the date into text field
        dateTF.setText(date);
    }
    
    public final void loaditem(){
        File file = new File("item.txt");
        try {
            //read file to obtain data
            BufferedReader br = new BufferedReader(new FileReader(file));
            //create a variable to store data from the file
            String temp = br.readLine();
            
            //create an array to store the data for retrieval later
            String [] col;
            //read lines from files
            temp = br.readLine();
            //trim the data in the file to avoid whitespace and split the item accordingly 
            col = temp.trim().split(":");
            //set the value gain into the GUI
            item1B.setText(col[1]);
            item1Price.setText(col[2]);
            stock1TF.setText(col[3]);
            //get value from files to determine the stock
            int stock1 = Integer.valueOf(col[3]);
            //changes to alert user out of stock
            if (stock1 == 0){
                item1B.setForeground(Color.RED);
            }
            
            temp = br.readLine();
            col = temp.trim().split(":");
            item2B.setText(col[1]);
            item2Price.setText(col[2]);
            stock2TF.setText(col[3]);
            int stock2 = Integer.valueOf(col[3]);
            if (stock2 == 0){
                item2B.setForeground(Color.RED);
            }
            
            temp = br.readLine();
            col = temp.trim().split(":");
            item3B.setText(col[1]);
            item3Price.setText(col[2]);
            stock3TF.setText(col[3]);
            int stock3 = Integer.valueOf(col[3]);
            if (stock3 == 0){
                item3B.setForeground(Color.RED);
            }
            
            temp = br.readLine();
            col = temp.trim().split(":");
            item4B.setText(col[1]);
            item4Price.setText(col[2]);
            stock4TF.setText(col[3]);
            int stock4 = Integer.valueOf(col[3]);
            if (stock4 == 0){
                item4B.setForeground(Color.RED);
            }
            
            temp = br.readLine();
            col = temp.trim().split(":");
            item5B.setText(col[1]);
            item5Price.setText(col[2]);
            stock5TF.setText(col[3]);
            int stock5 = Integer.valueOf(col[3]);
            if (stock5 == 0){
                item5B.setForeground(Color.RED);
            }
            
            temp = br.readLine();
            col = temp.trim().split(":");
            item6B.setText(col[1]);
            item6Price.setText(col[2]);
            stock6TF.setText(col[3]);
            int stock6 = Integer.valueOf(col[3]);
            if (stock6 == 0){
                item6B.setForeground(Color.RED);
            }
         //print the error code
        }catch (FileNotFoundException e) {
            Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void purchase(){
        File file = new File("item.txt");
        try {
            //use bufferedreader to read the data in text file
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                //validation by getting value from the text field where user has chosen
                String itemName = selectedItem.getText();
                //create array to store data
                String [] col;
                //create variable to determine the old and new stock
                String oldStock,newStock;
                //read the data into an object array
                Object [] allCol = br.lines().toArray();
                //loop in the array to get stock value
                for (int i = 1; i < allCol.length; ++i){
                    //trim the data and split it accordingly
                    col = allCol[i].toString().trim().split(":");
                    //validate the selected item by getting their name and compare it to the data in the text file
                    if (col[1].equalsIgnoreCase(itemName)){
                        oldStock = col[3];
                        //convert the stock data in text file into integer and subtract it by 1
                        newStock = (Integer.parseInt(oldStock)-1)+":";
                        col[3] = newStock;
                        String newrec = "";
                        
                        for (int x = 0; x < col.length; ++x) {
                            newrec = newrec + col[x] + ":";
                        }
                        allCol[i] = newrec;
                    }
                    //use buffered writer to write the new value into the file
                }  try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    for (Object allCol1 : allCol) {
                        bw.write(allCol1 + "\n");
                    }
                }
            }
        //catch error logs and print out
        }catch (FileNotFoundException e) {
            Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        item1B = new javax.swing.JButton();
        item2B = new javax.swing.JButton();
        item3B = new javax.swing.JButton();
        item4B = new javax.swing.JButton();
        item5B = new javax.swing.JButton();
        item6B = new javax.swing.JButton();
        stock1TF = new javax.swing.JTextField();
        stock3TF = new javax.swing.JTextField();
        stock2TF = new javax.swing.JTextField();
        stock5TF = new javax.swing.JTextField();
        stock6TF = new javax.swing.JTextField();
        stock4TF = new javax.swing.JTextField();
        item5Price = new javax.swing.JTextField();
        item2Price = new javax.swing.JTextField();
        item1Price = new javax.swing.JTextField();
        item3Price = new javax.swing.JTextField();
        item4Price = new javax.swing.JTextField();
        item6Price = new javax.swing.JTextField();
        totalDisplay = new javax.swing.JPanel();
        selectedLabel = new javax.swing.JLabel();
        totalPrice = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        selectedItem = new javax.swing.JTextField();
        totalTF = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fiftyCentsButton = new javax.swing.JButton();
        rmoneButton = new javax.swing.JButton();
        rmfiveButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        twentyCentsButton = new javax.swing.JButton();
        tenCentsButton = new javax.swing.JButton();
        checkoutPanel = new javax.swing.JPanel();
        confirmInsertButton = new javax.swing.JButton();
        reinsertButton = new javax.swing.JButton();
        insertedAmountTF = new javax.swing.JTextField();
        balancePanel = new javax.swing.JPanel();
        balanceLabel = new javax.swing.JLabel();
        balanceCollectButton = new javax.swing.JButton();
        exitPanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        balanceTF = new javax.swing.JTextField();
        dtPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dateTF = new javax.swing.JTextField();
        adminButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("C&L Vending Machine");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Select an item"));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        item1B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item1BActionPerformed(evt);
            }
        });

        item2B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item2BActionPerformed(evt);
            }
        });

        item3B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item3BActionPerformed(evt);
            }
        });

        item4B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item4BActionPerformed(evt);
            }
        });

        item5B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item5BActionPerformed(evt);
            }
        });

        item6B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item6BActionPerformed(evt);
            }
        });

        stock1TF.setEditable(false);

        stock3TF.setEditable(false);

        stock2TF.setEditable(false);

        stock5TF.setEditable(false);

        stock6TF.setEditable(false);

        stock4TF.setEditable(false);

        item5Price.setEditable(false);
        item5Price.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        item2Price.setEditable(false);
        item2Price.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        item1Price.setEditable(false);
        item1Price.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        item3Price.setEditable(false);
        item3Price.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        item4Price.setEditable(false);
        item4Price.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        item6Price.setEditable(false);
        item6Price.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(item2B, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(item1B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(stock1TF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(item3B, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stock3TF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(item4B, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stock4TF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(stock2TF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item6B, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item5B, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stock5TF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stock6TF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(item2Price, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245)
                .addComponent(item4Price, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(item6Price, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(item1Price, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248)
                .addComponent(item3Price, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(item5Price, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(item1B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(item5B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(item3B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stock5TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(item5Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(item1Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(item3Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stock6TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(item6B, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(item6Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(item4B, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(item4Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(stock3TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stock4TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(stock1TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(stock2TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(item2B, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(item2Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        totalDisplay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        selectedLabel.setText("You have selected:");

        totalPrice.setText("Total: RM");

        selectedItem.setEditable(false);
        selectedItem.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        selectedItem.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        totalTF.setEditable(false);

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout totalDisplayLayout = new javax.swing.GroupLayout(totalDisplay);
        totalDisplay.setLayout(totalDisplayLayout);
        totalDisplayLayout.setHorizontalGroup(
            totalDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalDisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectedItem)
                    .addGroup(totalDisplayLayout.createSequentialGroup()
                        .addGroup(totalDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectedLabel)
                            .addGroup(totalDisplayLayout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(totalDisplayLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(resetButton)
                .addGap(50, 50, 50))
        );
        totalDisplayLayout.setVerticalGroup(
            totalDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalDisplayLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(selectedLabel)
                .addGap(18, 18, 18)
                .addComponent(selectedItem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(totalDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalPrice)
                    .addComponent(resetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        jLabel2.setText("Please insert your money:");

        fiftyCentsButton.setBackground(new java.awt.Color(255, 255, 102));
        fiftyCentsButton.setText("RM 0.50");
        fiftyCentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyCentsButtonActionPerformed(evt);
            }
        });

        rmoneButton.setBackground(new java.awt.Color(51, 204, 255));
        rmoneButton.setText("RM 1");
        rmoneButton.setDefaultCapable(false);
        rmoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmoneButtonActionPerformed(evt);
            }
        });

        rmfiveButton.setBackground(new java.awt.Color(153, 255, 153));
        rmfiveButton.setText("RM 5");
        rmfiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmfiveButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("You have inserted: RM");

        twentyCentsButton.setBackground(new java.awt.Color(204, 204, 0));
        twentyCentsButton.setText("RM 0.20");
        twentyCentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twentyCentsButtonActionPerformed(evt);
            }
        });

        tenCentsButton.setBackground(new java.awt.Color(204, 204, 204));
        tenCentsButton.setText("RM 0.10");
        tenCentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenCentsButtonActionPerformed(evt);
            }
        });

        checkoutPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        confirmInsertButton.setBackground(new java.awt.Color(51, 255, 0));
        confirmInsertButton.setText("Confirm Enter Amount");
        confirmInsertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmInsertButtonActionPerformed(evt);
            }
        });

        reinsertButton.setBackground(new java.awt.Color(255, 0, 51));
        reinsertButton.setText("Reinsert Amount");
        reinsertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reinsertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checkoutPanelLayout = new javax.swing.GroupLayout(checkoutPanel);
        checkoutPanel.setLayout(checkoutPanelLayout);
        checkoutPanelLayout.setHorizontalGroup(
            checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reinsertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmInsertButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        checkoutPanelLayout.setVerticalGroup(
            checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(confirmInsertButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reinsertButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        insertedAmountTF.setEditable(false);
        insertedAmountTF.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(rmfiveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 86, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(insertedAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 8, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(fiftyCentsButton)
                                            .addComponent(tenCentsButton))
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(twentyCentsButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(rmoneButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(35, 35, 35)))))
                .addComponent(checkoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tenCentsButton)
                            .addComponent(twentyCentsButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rmoneButton)
                            .addComponent(fiftyCentsButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rmfiveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(insertedAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        balancePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        balanceLabel.setText("Your Balance:");

        balanceCollectButton.setText("Collect Balance");
        balanceCollectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceCollectButtonActionPerformed(evt);
            }
        });

        exitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        exitButton.setForeground(new java.awt.Color(204, 0, 51));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout exitPanelLayout = new javax.swing.GroupLayout(exitPanel);
        exitPanel.setLayout(exitPanelLayout);
        exitPanelLayout.setHorizontalGroup(
            exitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(exitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        exitPanelLayout.setVerticalGroup(
            exitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitPanelLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addGap(27, 27, 27))
        );

        balanceTF.setEditable(false);

        javax.swing.GroupLayout balancePanelLayout = new javax.swing.GroupLayout(balancePanel);
        balancePanel.setLayout(balancePanelLayout);
        balancePanelLayout.setHorizontalGroup(
            balancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(balancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balanceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(balanceCollectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );
        balancePanelLayout.setVerticalGroup(
            balancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(balancePanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(balancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(balanceCollectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setText("Date:");

        dateTF.setEditable(false);

        javax.swing.GroupLayout dtPanelLayout = new javax.swing.GroupLayout(dtPanel);
        dtPanel.setLayout(dtPanelLayout);
        dtPanelLayout.setHorizontalGroup(
            dtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTF, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        dtPanelLayout.setVerticalGroup(
            dtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        adminButton.setForeground(new java.awt.Color(255, 51, 51));
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(balancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(adminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(180, 180, 180)
                        .addComponent(dtPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(adminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(balancePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(totalDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void item1BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item1BActionPerformed
        int stock = Integer.valueOf(stock1TF.getText());
            if (stock == 0){
                JOptionPane.showMessageDialog(rootPane,item1B.getText()+" is out of stock!","Error",JOptionPane.WARNING_MESSAGE);
            }
            else{
                selectedItem.setText(item1B.getText());
                totalTF.setText(item1Price.getText());
                resetButton.setEnabled(true);
                tenCentsButton.setEnabled(true);
                fiftyCentsButton.setEnabled(true);
                twentyCentsButton.setEnabled(true);
                rmoneButton.setEnabled(true);
                rmfiveButton.setEnabled(true);
                item1B.setEnabled(false);
                item2B.setEnabled(false);
                item3B.setEnabled(false);
                item4B.setEnabled(false);
                item5B.setEnabled(false);
                item6B.setEnabled(false);
            }
       
    }//GEN-LAST:event_item1BActionPerformed

    private void fiftyCentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiftyCentsButtonActionPerformed
        double result = Double.valueOf(insertedAmountTF.getText()) + 0.5;
        String amount = "" +result;
        insertedAmountTF.setText(amount+"0");
        confirmInsertButton.setEnabled(true);
        reinsertButton.setEnabled(true);
        
    }//GEN-LAST:event_fiftyCentsButtonActionPerformed

    private void rmoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmoneButtonActionPerformed
        String pattern = "0.00";
        DecimalFormat df = new DecimalFormat(pattern);
        double result = Double.valueOf(insertedAmountTF.getText()) + 1.0;
        insertedAmountTF.setText(df.format(result));
        confirmInsertButton.setEnabled(true);
        reinsertButton.setEnabled(true);
    }//GEN-LAST:event_rmoneButtonActionPerformed

    private void reinsertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reinsertButtonActionPerformed
        insertedAmountTF.setText("0.00");
    }//GEN-LAST:event_reinsertButtonActionPerformed

    private void confirmInsertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmInsertButtonActionPerformed
        //enable back item button
        item1B.setEnabled(true);
        item2B.setEnabled(true);
        item3B.setEnabled(true);
        item4B.setEnabled(true);
        item5B.setEnabled(true);
        item6B.setEnabled(true);
        
        //get value of inserted money and total
        double money = Double.valueOf(insertedAmountTF.getText());
        double itemPrice = Double.valueOf(totalTF.getText());
        //display purchase succesful message and disable the features of inserting money
        if (itemPrice == money){
            JOptionPane.showMessageDialog(rootPane, "Purchase Successful! Enjoy! ");
            purchase();
            selectedItem.setText(null);
            totalTF.setText(null);
            tenCentsButton.setEnabled(false);
            fiftyCentsButton.setEnabled(false);
            twentyCentsButton.setEnabled(false);
            rmoneButton.setEnabled(false);
            rmfiveButton.setEnabled(false);
            confirmInsertButton.setEnabled(false);
            reinsertButton.setEnabled(false);
            resetButton.setEnabled(false);
            insertedAmountTF.setText("0.00");
            
        }
        //alert user to enter the sufficient amount of money to purchase item with message dialog
        else if (itemPrice > money){
            JOptionPane.showMessageDialog(rootPane, "Please insert the correct amount to purchase item! ","Error",JOptionPane.WARNING_MESSAGE);
            resetButton.setEnabled(true);
            tenCentsButton.setEnabled(true);
            fiftyCentsButton.setEnabled(true);
            twentyCentsButton.setEnabled(true);
            rmoneButton.setEnabled(true);
            rmfiveButton.setEnabled(true);
        }
        //remind user to collect balance before proceed if there's any
        else if (itemPrice < money){
            JOptionPane.showMessageDialog(rootPane, "Purchase Successful! Please collect your balance before you leave! ");
            purchase();
            item1B.setEnabled(false);
            item2B.setEnabled(false);
            item3B.setEnabled(false);
            item4B.setEnabled(false);
            item5B.setEnabled(false);
            item6B.setEnabled(false);
            //enable the collect balance button
            balanceCollectButton.setEnabled(true);
            //get value of inserted money and total
            double amount = Double.valueOf(insertedAmountTF.getText());
            double total = Double.valueOf(totalTF.getText());
            //subtraction to get the balance amount
            double balance = amount - total;
            balanceTF.setText("RM"+balance+"0");
            selectedItem.setText(null);
            totalTF.setText(null);
            tenCentsButton.setEnabled(false);
            fiftyCentsButton.setEnabled(false);
            twentyCentsButton.setEnabled(false);
            rmoneButton.setEnabled(false);
            rmfiveButton.setEnabled(false);
            confirmInsertButton.setEnabled(false);
            reinsertButton.setEnabled(false);
            resetButton.setEnabled(false);
            insertedAmountTF.setText("0.00");
            
        }
        else{
            insertedAmountTF.setText("0.00");
            tenCentsButton.setEnabled(false);
            fiftyCentsButton.setEnabled(false);
            twentyCentsButton.setEnabled(false);
            rmoneButton.setEnabled(false);
            rmfiveButton.setEnabled(false);
            confirmInsertButton.setEnabled(false);
            resetButton.setEnabled(false);
            reinsertButton.setEnabled(false);
        }
        
        //to load all the refreshed value again
        loaditem();
    
    }//GEN-LAST:event_confirmInsertButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void item3BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item3BActionPerformed
        //Getting stock value from text field
        int stock = Integer.valueOf(stock3TF.getText());
            //Display alert message if no stock, otherwise able to buy item
            if (stock == 0){
                JOptionPane.showMessageDialog(rootPane,item1B.getText()+" is out of stock!"); 
            }
            else{
                selectedItem.setText(item3B.getText());
                totalTF.setText(item3Price.getText());
                resetButton.setEnabled(true);
                tenCentsButton.setEnabled(true);
                fiftyCentsButton.setEnabled(true);
                twentyCentsButton.setEnabled(true);
                rmoneButton.setEnabled(true);
                rmfiveButton.setEnabled(true);
                item1B.setEnabled(false);
                item2B.setEnabled(false);
                item3B.setEnabled(false);
                item4B.setEnabled(false);
                item5B.setEnabled(false);
                item6B.setEnabled(false);
            }
    }//GEN-LAST:event_item3BActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        selectedItem.setText(null);
        totalTF.setText(null);
        insertedAmountTF.setText("0.00");
        tenCentsButton.setEnabled(false);
        fiftyCentsButton.setEnabled(false);
        twentyCentsButton.setEnabled(false);
        rmoneButton.setEnabled(false);
        rmfiveButton.setEnabled(false);
        confirmInsertButton.setEnabled(false);
        reinsertButton.setEnabled(false);
        item1B.setEnabled(true);
        item2B.setEnabled(true);
        item3B.setEnabled(true);
        item4B.setEnabled(true);
        item5B.setEnabled(true);
        item6B.setEnabled(true);
        
    }//GEN-LAST:event_resetButtonActionPerformed

    private void rmfiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmfiveButtonActionPerformed
        //create a variable that specify the pattern of the decimal value
        String pattern = "0.00";
        //create object "df" to use the importation DecimalFormat to store the pattern
        DecimalFormat df = new DecimalFormat(pattern);
        //convert the value of inserted amount into double value and add it with the correct amount
        double result = Double.valueOf(insertedAmountTF.getText()) + 5.0;
        //format the final value using the specified pattern
        insertedAmountTF.setText(df.format(result));
        confirmInsertButton.setEnabled(true);
        reinsertButton.setEnabled(true);
    }//GEN-LAST:event_rmfiveButtonActionPerformed

    private void item5BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item5BActionPerformed
        int stock = Integer.valueOf(stock5TF.getText());
            if (stock == 0){
                JOptionPane.showMessageDialog(rootPane,item5B.getText()+" is out of stock!");
            }
            else{
                selectedItem.setText(item5B.getText());
                totalTF.setText(item5Price.getText());
                resetButton.setEnabled(true);
                tenCentsButton.setEnabled(true);
                fiftyCentsButton.setEnabled(true);
                twentyCentsButton.setEnabled(true);
                rmoneButton.setEnabled(true);
                rmfiveButton.setEnabled(true);
                item1B.setEnabled(false);
                item2B.setEnabled(false);
                item3B.setEnabled(false);
                item4B.setEnabled(false);
                item5B.setEnabled(false);
                item6B.setEnabled(false);
            }
    }//GEN-LAST:event_item5BActionPerformed

    private void item2BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item2BActionPerformed
        int stock = Integer.valueOf(stock2TF.getText());
            if (stock == 0){
                JOptionPane.showMessageDialog(rootPane,item2B.getText()+" is out of stock!");
            }
            else{
                selectedItem.setText(item2B.getText());
                totalTF.setText(item2Price.getText());
                resetButton.setEnabled(true);
                tenCentsButton.setEnabled(true);
                fiftyCentsButton.setEnabled(true);
                twentyCentsButton.setEnabled(true);
                rmoneButton.setEnabled(true);
                rmfiveButton.setEnabled(true);
                item1B.setEnabled(false);
                item2B.setEnabled(false);
                item3B.setEnabled(false);
                item4B.setEnabled(false);
                item5B.setEnabled(false);
                item6B.setEnabled(false);
            }
        
    }//GEN-LAST:event_item2BActionPerformed

    private void item4BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item4BActionPerformed
        int stock = Integer.valueOf(stock4TF.getText());
            if (stock == 0){
                JOptionPane.showMessageDialog(rootPane,item4B.getText()+" is out of stock!");
            }
            else{
                selectedItem.setText(item4B.getText());
                totalTF.setText(item4Price.getText());
                resetButton.setEnabled(true);
                tenCentsButton.setEnabled(true);
                fiftyCentsButton.setEnabled(true);
                twentyCentsButton.setEnabled(true);
                rmoneButton.setEnabled(true);
                rmfiveButton.setEnabled(true);
                item1B.setEnabled(false);
                item2B.setEnabled(false);
                item3B.setEnabled(false);
                item4B.setEnabled(false);
                item5B.setEnabled(false);
                item6B.setEnabled(false);
            }
    }//GEN-LAST:event_item4BActionPerformed

    private void item6BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item6BActionPerformed
        int stock = Integer.valueOf(stock6TF.getText());
            if (stock == 0){
                JOptionPane.showMessageDialog(rootPane,item6B.getText()+" is out of stock!");
            }
            else{
                selectedItem.setText(item6B.getText());
                totalTF.setText(item6Price.getText());
                resetButton.setEnabled(true);
                tenCentsButton.setEnabled(true);
                fiftyCentsButton.setEnabled(true);
                twentyCentsButton.setEnabled(true);
                rmoneButton.setEnabled(true);
                rmfiveButton.setEnabled(true);
                item1B.setEnabled(false);
                item2B.setEnabled(false);
                item3B.setEnabled(false);
                item4B.setEnabled(false);
                item5B.setEnabled(false);
                item6B.setEnabled(false);
            }
    }//GEN-LAST:event_item6BActionPerformed

    private void tenCentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenCentsButtonActionPerformed
        String pattern = "0.00";
        DecimalFormat df = new DecimalFormat(pattern);
        double result = Double.valueOf(insertedAmountTF.getText()) + 0.1;
        insertedAmountTF.setText(df.format(result));
        confirmInsertButton.setEnabled(true);
        reinsertButton.setEnabled(true);
        
        
    }//GEN-LAST:event_tenCentsButtonActionPerformed

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        //create an object of class VMAdmin
        VMAdmin admin = new VMAdmin();
        //set the JFrame visible
        admin.setVisible(true);
        //destroy the old JFrame
        dispose();
    }//GEN-LAST:event_adminButtonActionPerformed

    private void balanceCollectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceCollectButtonActionPerformed
        //display a message to alert user balance has been collected
        JOptionPane.showMessageDialog(rootPane,balanceTF.getText()+" of balance is collected! Thank You!");
        item1B.setEnabled(true);
        item2B.setEnabled(true);
        item3B.setEnabled(true);
        item4B.setEnabled(true);
        item5B.setEnabled(true);
        item6B.setEnabled(true);
        tenCentsButton.setEnabled(false);
        fiftyCentsButton.setEnabled(false);
        twentyCentsButton.setEnabled(false);
        rmoneButton.setEnabled(false);
        rmfiveButton.setEnabled(false);
        confirmInsertButton.setEnabled(false);
        reinsertButton.setEnabled(false);
        balanceCollectButton.setEnabled(false);
        balanceTF.setText(null);
        
    }//GEN-LAST:event_balanceCollectButtonActionPerformed

    private void twentyCentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twentyCentsButtonActionPerformed
        String pattern = "0.00";
        DecimalFormat df = new DecimalFormat(pattern);
        double result = Double.valueOf(insertedAmountTF.getText()) + 0.2;
        insertedAmountTF.setText(df.format(result));
        confirmInsertButton.setEnabled(true);
        reinsertButton.setEnabled(true);
    }//GEN-LAST:event_twentyCentsButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendingMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VendingMachine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButton;
    private javax.swing.JButton balanceCollectButton;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JPanel balancePanel;
    private javax.swing.JTextField balanceTF;
    private javax.swing.JPanel checkoutPanel;
    private javax.swing.JButton confirmInsertButton;
    private javax.swing.JTextField dateTF;
    private javax.swing.JPanel dtPanel;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel exitPanel;
    private javax.swing.JButton fiftyCentsButton;
    private javax.swing.JTextField insertedAmountTF;
    private javax.swing.JButton item1B;
    private javax.swing.JTextField item1Price;
    private javax.swing.JButton item2B;
    private javax.swing.JTextField item2Price;
    private javax.swing.JButton item3B;
    private javax.swing.JTextField item3Price;
    private javax.swing.JButton item4B;
    private javax.swing.JTextField item4Price;
    private javax.swing.JButton item5B;
    private javax.swing.JTextField item5Price;
    private javax.swing.JButton item6B;
    private javax.swing.JTextField item6Price;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton reinsertButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton rmfiveButton;
    private javax.swing.JButton rmoneButton;
    private javax.swing.JTextField selectedItem;
    private javax.swing.JLabel selectedLabel;
    private javax.swing.JTextField stock1TF;
    private javax.swing.JTextField stock2TF;
    private javax.swing.JTextField stock3TF;
    private javax.swing.JTextField stock4TF;
    private javax.swing.JTextField stock5TF;
    private javax.swing.JTextField stock6TF;
    private javax.swing.JButton tenCentsButton;
    private javax.swing.JPanel totalDisplay;
    private javax.swing.JLabel totalPrice;
    private javax.swing.JTextField totalTF;
    private javax.swing.JButton twentyCentsButton;
    // End of variables declaration//GEN-END:variables

    void date(String date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
