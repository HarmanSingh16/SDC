package sdc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

//Importing resource functions
import sdc.resource.*;

public class intrfc extends javax.swing.JFrame implements ActionListener , ItemListener {
    Image backgroundImage = Toolkit.getDefaultToolkit().getImage("C:/Users/singh/Desktop/sdc/src/sdc/resource/bg.jpg");
        //Element variables
        static mySql sql;
        static Frame f;
        static Panel p , p1 , p2 , p3,p4;
        static TextField t,t1;
               Button b ;
        static Font f1,f2,f3;
        static GridLayout g,g2,g3;
        static JComboBox Class,sec;
        static JLabel l1,l2,l3,l4,l5,l6;


    //REMOVE THIS AFTER WORK IS DONE

    intrfc(mySql ref){
        sql = ref;
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
              super.paintComponent(g);
              g.drawImage(backgroundImage, 0, 0, null);
            }
          });
          pack();
          setVisible(true);
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


        f.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
            });  
    }
    //createFrame() ends
    
    
    //Action listener to listen when submit button is pressed
    public void actionPerformed(ActionEvent e) {
        
        //Trying to add values to database
        try{
            //Storing values from textfield in variables
            String uid = t.getText();
            String name = t1.getText();
            int std = Integer.parseInt((String)Class.getSelectedItem());
            String section = (String)sec.getSelectedItem();

            //Creating mySql class object
            sql.insertStudentDetails(uid,name,std,section);

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
            
            l6.setText(msg);
        }
        catch(Exception err){}
    }

    //Extra
    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'itemStateChanged'");
    }
    
}//Class ends
