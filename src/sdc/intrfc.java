package sdc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

//Importing resource functions
import sdc.resource.*;
import sdc.screens.loginPage;
import sdc.client;

public class intrfc extends javax.swing.JFrame implements ActionListener , ItemListener {
        //Element variables
        static mySql sql;
        static Frame f;
        static Panel p , p1 , p2 , p3,p4;
        static TextField t,t1;
               Button b,b1,b2 ;
        static Font f1,f2,f3;
        static GridLayout g,g2,g3;
        static JComboBox Class,sec;
        static JLabel l1,l2,l3,l4,l5,l6;


    //REMOVE THIS AFTER WORK IS DONE
    intrfc(mySql ref){
        sql = ref;
    }
    //Function to createFrame()
    void createFrame(){
        
        //Font settings
        f2 = new Font("Montserrat",Font.ITALIC,40);
        f1 = new Font("Montserrat",Font.BOLD,80);
        f3 = new Font("Monsterrat",Font.BOLD,20);
        //Drop down options
        String s1[] = {"1","2","3","4","4","5","6","7","8","9","10","11","12"};
        String s2[] = {"A", "B", "C"};
        
        //Labels
        l1 = new JLabel("Select Your Class");
        l1.setForeground(Color.BLACK);
        l1.setFont(f3);

        l2 = new JLabel("Select Your Section");
        l2.setFont(f3);
        l2.setForeground(Color.BLACK);

        l3 = new JLabel(" Succesfully Submitted ");
        l3.setForeground(Color.GREEN);
        l3.setFont(f3);
        
        l4 = new JLabel("Enter UID");
        l4.setForeground(Color.BLACK);
        l4.setFont(f3);

        l5 = new JLabel("Enter Your Name");
        l5.setForeground(Color.BLACK);
        l5.setFont(f3);

        l6 = new JLabel("");
        l6.setForeground(Color.red);
        l6.setFont(f3);
        //End of labels


        //Drop down menu using combobox
        Class = new JComboBox(s1);
        sec = new  JComboBox(s2);


        //Creating frame and panel
        f = new Frame("Login Page");
        p = new Panel();
        p2 = new Panel();
        p1 = new Panel();
        p3 = new Panel();
        p4 = new Panel();

         
        //Text field for UID
        t = new TextField(1);
        t.setBackground(Color.WHITE);
        t.setFont(f3);

        //Text field for name
        t1 = new TextField(1);
        t1.setFont(f3);
        t1.setBackground(Color.WHITE);

        //Submit button
        b = new Button("SUBMIT");
        b.setBackground(Color.blue);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        b.setFont(f2);

        //Go to login page button
        b1 = new Button("Go to login page");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setFont(f2);


        //go to add detail
        b2 = new Button("Go to previous screen");
        b2.setBackground(Color.blue);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setFont(f2);

        //Layout 
        g = new GridLayout(7,0,10,10);
        g.setHgap(50);
        g2 = new GridLayout(0,2,10,10);
        g3 = new GridLayout(1,0,10,10);
        g3.setHgap(25);
        
        //For panel p
        p.setLayout(g);
        p.add(l4);
        p.add(t);
        p.add(l5);
        p.add(t1);
        p.add(l6,Component.CENTER_ALIGNMENT);
        
        
        //For panel p1
        p1.add(l3);
        
        
        //For panel p2

        //For panel p3
        p3.setLayout(g);
        p3.add(l1);
        p3.add(Class);
        p3.add(l2);
        p3.add(sec);

        //For panel p4
        p4.add(b,b.RIGHT_ALIGNMENT);
        p4.add(b1,b1.LEFT_ALIGNMENT);

//JLabel background = new JLabel(new ImageIcon("C:/Users/singh/Desktop/sdc/src/sdc/resource/bg.jpg"));

        //For frame
        //f.add(background);
        f.add(p);
        f.add(p3);
        f.add(p2);
        f.add(p4);
        f.setLayout(g2);

        f.setBackground(Color.LIGHT_GRAY);
        f.setSize(800,600);    
        f.setVisible(true);

        // f.addWindowListener(new WindowAdapter(){
        //     @Override
        //     public void windowClosing(WindowEvent e){
        //         System.out.println("Hey");
        //         sql.closeConnection();
                
        //    //     System.exit(0);
        //     }
        //     });  

            /*Some piece of code*/
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            if (JOptionPane.showConfirmDialog(f, 
             "Are you sure you want to close this window?", "Close Window?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            sql.closeConnection();
            System.exit(0);
        }
    }
});
    }

    
    //createFrame() ends
    
    
    //Action listener to listen when submit button is pressed
    public void actionPerformed(ActionEvent e) {
        
        //Trying to add values to database
        if(e.getSource() == b1){
            new loginPage();
        }
        else if(e.getSource() == b){
            try{
                //Storing values from textfield in variables
                String uid = t.getText();
                String name = t1.getText();
                int std = Integer.parseInt((String)Class.getSelectedItem());
                String section = (String)sec.getSelectedItem();

                //Creating mySql class object
                sql.createNewStudent(uid,name,std,section,"hs@160201");

                //Removing frame p
                f.remove(p);
                f.remove(p2);
                f.remove(p3);
                f.remove(p4);

                //Adding frame p1 (includes "Successfully Submitted")
                f.add(p1);
                f.setVisible(true);
            }

            catch(SQLException err){
                //Handling Exception from database
                String msg = errorMessage.getMessage(err.getErrorCode());


                if(err.getErrorCode() == 0){
                    //Work on this code for communication link failure
                    // this.dispose();
                    // loginPage obj = new loginPage();
                    // obj.connectionInterface();
                }
                else{
                    JOptionPane.showMessageDialog(this, errorMessage.getMessage(err.getErrorCode()) , "Message" , JOptionPane.WARNING_MESSAGE);
                }

                System.out.println(err.getErrorCode() + err.getMessage() + "in intrfc.java");
            }
            catch(Exception err){}
        }
    }   

//     //Extra
    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'itemStateChanged'");
    }
}//Class ends
