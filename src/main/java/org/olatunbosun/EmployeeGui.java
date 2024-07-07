package org.olatunbosun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeGui extends JFrame implements ActionListener {

    JTextField name,age;

    JButton bankAccount;

    int numberOfUser;

     boolean dataValid = false;


    public EmployeeGui(int nb){
        super("Employee Information "+nb);
        JPanel contentPane = new JPanel();
        numberOfUser=nb;
        // Create the text fields
        JLabel nameLabel = new JLabel("Name:");

        JLabel ageLabel = new JLabel("Age:");


        nameLabel.setBounds(10,50,100,50);
        ageLabel.setBounds(10  ,100,120,50);

        contentPane.add(nameLabel);
        contentPane.add(ageLabel);



        age = new JTextField();
        age.setBounds(120,50,250,50);
        age.addActionListener(this);

        name = new JTextField();
        name.setBounds(120,100,250,50);
        name.addActionListener(this);

        // Create the buttons
        bankAccount = new JButton("Bank Account");
        bankAccount.setBackground(new Color(94, 176, 194));
        bankAccount.setOpaque(true);
        bankAccount.setBorderPainted(false);
        bankAccount.setBounds(120,150,150,50);

        bankAccount.addActionListener(this);
        // Add the components to the frame



        contentPane.add(name);
        contentPane.add(age);
        contentPane.add(bankAccount);



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

        if (name.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Name Field is Required");
        }else if(age.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Age Field is Required");
        }

        new BankAccountGui(numberOfUser);

         dispose();

    }


    public boolean isDataValid() {
        // You can add validation logic for the employee data here
        return dataValid;
    }
}
