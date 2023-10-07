package sdc.screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import sdc.*;
import sdc.resource.*;

public class studentInfoFillUp extends JFrame implements ActionListener {
    JPanel p,p1;
    JTextField namef, uidf ,fnamef,mnamef,phnum, classf, sectionf, dobf;
    JButton submitButton , back ;
    JLabel logo;
    JComboBox cls,sec;
    static studentInfoFillUp obj;
    int year;

    public studentInfoFillUp() {

        String Class[]= {"1","2","3","4","5","6","7","8","9","10","11","12"};
        String sect[] = {"A","B","C"};

        cls = new JComboBox(Class);
        sec = new JComboBox(sect);

        setTitle("Student Information Fillup Page");
        setSize(700, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,0));

        logo = new JLabel("",JLabel.CENTER);
        logo.setIcon(new ImageIcon("./Spring Dale College/src/sdc/logo.png"));
        add(logo);

        namef = new JTextField(null);
        namef.setMargin(new Insets(0,4,0,0));

        fnamef = new JTextField(null);
        fnamef.setMargin(new Insets(0,4,0,0));

        mnamef = new JTextField(null);
        mnamef.setMargin(new Insets(0,4,0,0));

        phnum = new JTextField(null);
        phnum.setMargin(new Insets(0,4,0,0));

        uidf = new JTextField(null);
        uidf.setMargin(new Insets(0,4,0,0));

        dobf = new JTextField(null);
        dobf.setMargin(new Insets(0,4,0,0));

        submitButton = new JButton("Submit");
        back = new JButton("Back");        

        p = new JPanel();
        p.setLayout(new GridLayout(10,0));
        p.setBorder(BorderFactory.createEmptyBorder(0, 150 , 0 , 150));

        p1 = new JPanel();
        p1.setLayout(new GridLayout(10,0));
        p1.setBorder(BorderFactory.createEmptyBorder(0 , 200 , 0 , 200));
        
        p.add(new JLabel("UID:"));
        p.add(uidf);
        p.add(new JLabel("Name:"));
        p.add(namef);
        p.add(new JLabel("Class:"));
        p.add(cls);
        p.add(new JLabel("Section:"));
        p.add(sec);
        p.add(new JLabel("Date of Birth (dd-MM-yyyy):"));
        p.add(dobf);
        p.add(new JLabel("Father's Name:"));
        p.add(fnamef);
        p.add(new JLabel("Mother's Name:"));
        p.add(mnamef);
        p.add(new JLabel("Phone Number:"));
        p.add(phnum);
        p.add(new JLabel(""));

        p1.add(submitButton);
        p1.add(back);
        
        add(p);
        add(p1);
    
        submitButton.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == submitButton) {
            //Retrieving all student details
            String uid = uidf.getText();

            String s_name = resourceFunctions.capitalize(namef.getText());
            String f_name = resourceFunctions.capitalize(fnamef.getText());
            String m_namef = resourceFunctions.capitalize(mnamef.getText());

            String ph_num = phnum.getText();

            //String dobText = dobf.getText();
            int Class = Integer.parseInt((String)cls.getSelectedItem());
            String section = (String)sec.getSelectedItem();

            //Populate them with input form comboBox for day, month and year
            int year = 2007;
            int month = 02;
            int day = 16;
            
            //Resolving the date
            boolean status = true;
            if(month == 2){
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    if(day>29){
                        status = false;
                    }
                }
                else{
                    if(day>28){
                        status = false;
                    }
                }
            }
            else if(month%2 == 0){
                if(day>30){
                    status = false;
                }
            }
            else{
                if(day>31){
                    status = false;
                }
            }

            if(status){
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR,year);
                cal.set(Calendar.MONTH,month);
                cal.set(Calendar.DAY_OF_MONTH,day);

                java.sql.Date dob = new java.sql.Date(cal.getTimeInMillis());

    
                try{

                    client.mySql.createNewStudent(uid,s_name,Class,section,(java.sql.Date)dob ,f_name,m_namef,ph_num,"hs@160201");
                    this.dispose();
                    new studentInfoFillUp();
                }
                catch(SQLException err){
                    //Handling Exception from database
                    String msg = errorMessage.getMessage(err.getErrorCode());


                    if(err.getErrorCode() == 0){
                        this.dispose();
                        loginPage obj = new loginPage();
                        obj.connectionInterface();
                    }
                    else{
                        System.out.println(err.getErrorCode());
                        JOptionPane.showMessageDialog(this, errorMessage.getMessage(err.getErrorCode()) , "Message" , JOptionPane.WARNING_MESSAGE);
                    }   

                System.out.println(err.getErrorCode() + err.getMessage() + "in studentInfoFillUp.java");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Incorrect Date !" , "Message" , JOptionPane.WARNING_MESSAGE);
            }
        }


        else if(e.getSource() == back){
            new teacherInterface();
            this.dispose();
        }

    }
}