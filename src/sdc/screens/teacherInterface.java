package sdc.screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sdc.*;

public class teacherInterface extends JFrame implements ActionListener {
    JButton addStudentdetail , Profile , Logout;
    JPanel p;
    
    public teacherInterface () {
        setTitle(" Teacher Interface ");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,0));
 
        p = new JPanel();
        p.setLayout(new GridLayout(10,0));
        p.setBorder(BorderFactory.createEmptyBorder(100,200,0,200));


        JLabel title = new JLabel();
        title.setIcon(new ImageIcon("./Spring Dale College/src/sdc/logo.png"));
        title.setBorder(BorderFactory.createEmptyBorder(100,200,0,200));
        title.setHorizontalAlignment(JLabel.CENTER);

        addStudentdetail = new JButton(" Add Student Detail ");
        addStudentdetail.addActionListener(this);

        Profile = new JButton(" View Profile ");
        Profile.addActionListener(this);
        Logout = new JButton("Logout");
        Logout.addActionListener(this);

        setLayout(new BorderLayout());  
        add(title, BorderLayout.NORTH);
        p.add(addStudentdetail);
        p.add(new JLabel());
        p.add(Profile);
        p.add(new JLabel());
        p.add(Logout);
        add(p);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addStudentdetail){
            new studentInfoFillUp();
            this.dispose();
        }
        else if(e.getSource() == Profile){
            this.dispose();
        }
        else if(e.getSource() == Logout){
            //Clearing out all the login data
            new loginPage();
            client.username = "";
            client.password = "";
            client.db = null;
            client.type = -1;

            this.dispose();
        }
    }
}