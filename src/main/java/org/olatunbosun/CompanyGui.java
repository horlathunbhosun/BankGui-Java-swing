package org.olatunbosun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CompanyGui extends JFrame implements ActionListener {

    JTextField name, address, numberOfEmployee;
    JButton addEmployeeButton;
    int numberOfEmployees;
     int currentEmployeeIndex = 0;

    private int totalEmployees;

    public CompanyGui() {
        super("Company Information");

        // Add the components to the frame
        JPanel contentPane = new JPanel();


        // Create the text fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 50, 100, 50);


        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10, 100, 120, 50);


        JLabel numberOfEmployeeLabel = new JLabel("No of Employees:");
        numberOfEmployeeLabel.setBounds(10, 150, 140, 50);


        contentPane.add(nameLabel);
        contentPane.add(addressLabel);
        contentPane.add(numberOfEmployeeLabel);


        name = new JTextField();
        name.setBounds(120, 50, 250, 50);

        name.addActionListener(this);


        address = new JTextField();
        address.setBounds(120, 100, 250, 50);

        name.addActionListener(this);
        numberOfEmployee = new JTextField();
        numberOfEmployee.setBounds(120, 150, 250, 50);

        // Create the buttons
        addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setBackground(new Color(158, 49, 49));
        addEmployeeButton.setOpaque(true);
        addEmployeeButton.setBorderPainted(false);
        addEmployeeButton.setBounds(120, 230, 150, 50);

        addEmployeeButton.addActionListener(this);


        contentPane.add(name);
        contentPane.add(address);
        contentPane.add(numberOfEmployee);
        contentPane.add(addEmployeeButton);


        setContentPane(contentPane);


        contentPane.setLayout(null);

        setVisible(true);
        pack();
        setSize(400, 400);
    }


    public void actionPerformed(ActionEvent e) {

        if (Objects.equals(name.getText(), "") && Objects.equals(address.getText(), "") & Objects.equals(numberOfEmployee.getText(),"")){
            JOptionPane.showMessageDialog(null, "All Fields Are Required");
        }

        if (Objects.equals(name.getText(), "")){
            JOptionPane.showMessageDialog(null, "Name Field is Required");
        }else if( Objects.equals(address.getText(), "") ){
            JOptionPane.showMessageDialog(null, "Address Field is Required");

        }else if( Objects.equals(numberOfEmployee.getText(),"")){
            JOptionPane.showMessageDialog(null, "Number of Employees Field is Required");
        }


          String number = numberOfEmployee.getText();


            if (isInt(number)) {
                 totalEmployees =  Integer.parseInt(numberOfEmployee.getText());

                   new EmployeeGui(totalEmployees);

                   dispose();

            }


    }





//    private void openEmployeeForm() {
//        if (currentEmployeeIndex < totalEmployees) {
//            EmployeeGui employeeGui = new EmployeeGui();
//            employeeGui.addWindowListener(new java.awt.event.WindowAdapter() {
//                @Override
//                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//                    if (JOptionPane.showConfirmDialog(employeeGui,
//                            "Are you sure you want to close this employee form?", "Close Employee Form",
//                            JOptionPane.YES_NO_OPTION,
//                            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
//
//                        if (employeeGui.isDataValid()) {
//                            // Save or process the employee data here
//                            currentEmployeeIndex++;
//                            openEmployeeForm();
//                        }
//                      // Open the next Employee form
//                    }
//                }
//            });
//        }
//    }


    public static boolean isInt(String numberOfEmployee)
    {
        try{
            Integer.parseInt(numberOfEmployee);
        }catch (Exception e){
           return false;
        }
        return true;
    }
}
