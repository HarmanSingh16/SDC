import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame implements ActionListener {

    JButton teacherLogin , login;
    JPanel p;
    static WelcomePage obj;
    public WelcomePage() {
        setTitle("Welcome Page");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,0));
 
        p = new JPanel();
        p.setLayout(new GridLayout(10,0));
        p.setBorder(BorderFactory.createEmptyBorder(100,200,0,200));


        JLabel title = new JLabel();
        title.setIcon(new ImageIcon("C:/Users/Ananya Pratap/Desktop/New folder/logo.png"));
        title.setBorder(BorderFactory.createEmptyBorder(100,200,0,200));
        title.setHorizontalAlignment(JLabel.CENTER);

        teacherLogin = new JButton(" Teacher/Admin Login ");
        teacherLogin.addActionListener(this);

        login = new JButton(" Student Login");
        login.addActionListener(this);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        p.add(teacherLogin);
        p.add(new JLabel());
        p.add(login);
        add(p);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == teacherLogin){
           
            new loginPage();
             obj.dispose();
            
        }
        else if(e.getSource() == login){
            obj.dispose();
            new loginPage();
            
        }
    }
    public static void main(String[] args) {
        obj = new WelcomePage();
    }
}
