import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StudentInfoFillup extends JFrame implements ActionListener {
    JPanel p,p1;
    JTextField namef, uidf ,fnamef,mnamef,phnum, classf, sectionf, dobf;
    JButton submitButton , back ;
    JLabel logo;
    JComboBox cls,sec;
    static StudentInfoFillup obj;
    int year;

    public StudentInfoFillup() {

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
        logo.setIcon(new ImageIcon("C:/Users/Ananya Pratap/Desktop/New folder/logo.png"));
        add(logo);

        namef = new JTextField("");
        namef.setMargin(new Insets(0,4,0,0));
        fnamef = new JTextField("");
        fnamef.setMargin(new Insets(0,4,0,0));
        mnamef = new JTextField("");
        mnamef.setMargin(new Insets(0,4,0,0));
        phnum = new JTextField("");
        phnum.setMargin(new Insets(0,4,0,0));

        uidf = new JTextField("");
        uidf.setMargin(new Insets(0,4,0,0));
        // classf = new JTextField("");
        // sectionf = new JTextField("");
        dobf = new JTextField("");
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
        //     String uid = uidf.getText();
        //     String name = namef.getText();
        //     String fname = fnamef.getText();
        //     String mnamef = mnamef.getText();
        //     String phnum = phnum.getText();
        //     int Class = Integer.parseInt((String)cls.getSelectedItem());
        //     String section = (String)sec.getSelectedItem();
            String dobText = dobf.getText();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date dob;

            try {
                dob = dateFormat.parse(dobText);
            }
            
            catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please use dd-MM-yyyy.");
                return;
            }

            // String message = "Child Information:\n"
            //         + "Name: " + name + "\n"
            //         + "UID: "  + uid  + "\n"
            //         + "Class: " + Class + "\n"
            //         + "Section: " + section + "\n"
            //         + "Date of Birth: " + dateFormat.format(dob);

            // JOptionPane.showMessageDialog(this, message);
           obj.dispose();
           obj = new StudentInfoFillup();
        }


        else if(e.getSource() == back){
            new TeacherInterface();
            this.dispose();
        }

        
    }
    
    public static void main(String[] args) {
       obj =  new StudentInfoFillup();
    }

}