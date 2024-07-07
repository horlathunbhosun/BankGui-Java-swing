package org.olatunbosun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccountGui extends JFrame  implements ActionListener {

    JTextField balance,bank;

    JButton validate;

     boolean dataValid = false;

int curnmb;


    public BankAccountGui(int nb){

        super("Bank Account "+nb);
        curnmb=nb;

        // Add the components to the frame
        JPanel contentPane = new JPanel();
        // Create the text fields
        JLabel bankLabel = new JLabel("Bank:");

        JLabel balanceLabel = new JLabel("Balance:");


        bankLabel.setBounds(10,50,100,50);
        balanceLabel.setBounds(10  ,100,120,50);

        contentPane.add(bankLabel);
        contentPane.add(balanceLabel);



        bank = new JTextField(20);
        bank.setBounds(120,50,250,50);



        balance = new JTextField(20);
        balance.setBounds(120,100,250,50);


        // Create the buttons
        validate = new JButton("Validate");
        validate.setBackground(new Color(94, 176, 194));
        validate.setOpaque(true);
        validate.setBorderPainted(false);
        validate.setBounds(120,150,150,50);
        validate.addActionListener(this);



        contentPane.add(bank);
        contentPane.add(balance);
        contentPane.add(validate);



        setContentPane(contentPane);


        contentPane.setLayout(null);

        setVisible(true);
        pack();
        setSize(400,400);

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String bankValue = bank.getText();
        String balanceValue = balance.getText();

        if (bankValue.isEmpty() &&  balanceValue.isEmpty()){
            JOptionPane.showMessageDialog(null, "Fields are Required");
        }

        if (isValid(bankValue, balanceValue)) {
            JOptionPane.showMessageDialog(null, "Validation successful");
             dataValid = true;
            System.out.println("current"+curnmb);
            if(curnmb > 0){
                new EmployeeGui(curnmb - 1);dispose();
            }else{
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Validation failed");
        }

    }

    private boolean isValid(String bankValue, String balanceValue) {
        return !bankValue.isEmpty() && !balanceValue.isEmpty();
    }

    public boolean isDataValid() {
        return dataValid;
    }



}
