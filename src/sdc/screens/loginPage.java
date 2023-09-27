package sdc.screens;
import javax.swing.*;

import sdc.*;
import sdc.resource.errorMessage;
import sdc.resource.resourceFunctions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class loginPage extends JFrame implements ActionListener {
    
     JLabel username, password , sdc , bg;
     JTextField usernamef;
     JPasswordField passwordf;
     JButton loginButton;
     JPanel p,p1;

     public String uid,pass;
     public loginPage() { 
        // setContentPane(new JLabel(new ImageIcon("C:/Users/Ananya Pratap/Desktop/New folder/bglogo1.jpeg")));
        setTitle("Login Page");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // this.setContentPane(new JLabel(new ImageIcon("../logo.png")));  
        setLayout(new GridLayout(3,0)); 
        setSize(599,699); 
        setSize(600, 700);

        username = new JLabel("Username/UID:",JLabel.LEFT);
        password = new JLabel("Password:",JLabel.LEFT);
        sdc = new JLabel("",JLabel.CENTER);

        sdc.setIcon(new ImageIcon("C:\\Users\\singh\\Desktop\\sdc\\src\\sdc\\logo.png"));
        usernamef = new JTextField();
        passwordf = new JPasswordField();
        loginButton = new JButton("Login");

        p = new JPanel();
        p.setLayout(new GridLayout(6,0));
        p.setBorder(BorderFactory.createEmptyBorder(30, 150, 0, 150));

        p1 = new JPanel();
        p1.setLayout(new GridLayout(6,0));
        p1.setBorder(BorderFactory.createEmptyBorder(0, 200, 10, 200));

        add(sdc);

        p.add(username);
        p.add(usernamef);
        p.add(password);
        p.add(passwordf);

        p1.add(loginButton);

        add(p);
        add(p1);

        loginButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            uid = usernamef.getText().toLowerCase();
            pass = new String(passwordf.getPassword());

            connectionInterface(); 
            }
        }



    //loginInterface
    public void connectionInterface(){
        try{
                client.username = uid;
                client.password = pass;
                
                client.connectToDB();
                //client.mySql.createNewTeacher("TR005028", "Harman","\"1A\"" , "\"XI\",\"A\"", "\"Physics\"", "hs@160201");
                //Take us to next page

                if(JOptionPane.showConfirmDialog(this,"Now you will be taken to the profile page, Do You Wish To Continue ? ","Login successful!",JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION);{
                    // Code to Proceed further after receiving choice to continue.
                    try{
                        this.dispose();
                        client.frame();
                    }
                    catch(Exception err){

                    }
                    //ask here to close on no and cancel and proceed on yes
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
            catch(SQLException err){
                System.out.println(err.getMessage());
                System.out.println(err.getErrorCode());

                //displaying this message only when connection is not established
                if(err.getErrorCode() == 0){
                    if(JOptionPane.showConfirmDialog(this, errorMessage.getMessage(err.getErrorCode()) , "Message" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                       connectionInterface();
                    }
                    else{
                        this.dispose();
                        new loginPage();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,errorMessage.getMessage(err.getErrorCode()),"Message",JOptionPane.YES_NO_CANCEL_OPTION);
                }

            }
            catch(Exception err){
                System.out.println(err.getMessage() + "at loginPage");
            }
        }
}