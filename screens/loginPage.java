import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginPage extends JFrame implements ActionListener {

     JLabel username, password , sdc , bg;
     JTextField usernamef;
     JPasswordField passwordf;
     JButton loginButton;
     JPanel p,p1;

     loginPage() { 
        // setContentPane(new JLabel(new ImageIcon("C:/Users/Ananya Pratap/Desktop/New folder/bglogo1.jpeg")));
        setTitle("Login Page");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JLabel(new ImageIcon("C:/Users/Ananya Pratap/Desktop/New folder/bglogo1.jpeg")));  
        setLayout(new GridLayout(3,0)); 
     
        

        username = new JLabel("UID:",JLabel.LEFT);
        password = new JLabel("Password:",JLabel.LEFT);
        sdc = new JLabel("",JLabel.CENTER);

        sdc.setIcon(new ImageIcon("../New folder/logo.png"));
        usernamef = new JTextField();
        usernamef.setFont(new Font("Calibri",Font.PLAIN,16));
        usernamef.setMargin(new Insets(0,4,0,0));

        passwordf = new JPasswordField();
        passwordf.setMargin(new Insets(0,4,0,0));
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
            String username = usernamef.getText();
            String password = new String(passwordf.getPassword());

            if (username.equals("admin") && password.equals("password")) {
                // JOptionPane.showMessageDialog(this,"Now you will be taken to the profile page.","Login Succeccfull !",JOptionPane.INFORMATION_MESSAGE);
                if(JOptionPane.showConfirmDialog(this,"Now you will be taken to the next page, Do You Wish To Continue ? ","Login Succefull !",JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
                    // Code to Proceed further after receiving choice to continue.
                    this.dispose();
                    new TeacherInterface();
                }
                else if(JOptionPane.showConfirmDialog(this,"Now you will be taken to the next page, Do You Wish To Continue ? ","Login Succefull !",JOptionPane.INFORMATION_MESSAGE) == JOptionPane.NO_OPTION){
                    this.dispose();
                } 
            } else {
                JOptionPane.showMessageDialog(this, "Please try again." , "Invalid credentials !" , JOptionPane.WARNING_MESSAGE);
                usernamef.setText(null);
                passwordf.setText(null);
            }

        }
    }

    public static void main(String[] args) {
        new loginPage();
    }
}