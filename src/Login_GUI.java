import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login_GUI extends JFrame{
    JLabel label1, label2,label3,label4, loginText;
    
    JTextField mailField;

    JPasswordField passwordField;

    JButton loginButton;

    Login_GUI() {
        setTitle("Login");
        setSize(540, 650);
        setLocation(400, 70);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        loginText = new JLabel("Sign in");
        loginText.setForeground(Color.BLACK);
        loginText.setFont(new Font("Monaco", Font.BOLD, 35));
        loginText.setBounds(40, 10, 200, 100);
        add(loginText);

        ImageIcon mIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/HotelIcon.png"));
        Image scaled_mIcon = mIcon.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        JLabel tImage = new JLabel(new ImageIcon(scaled_mIcon));
        tImage.setBounds(230, 5, 70, 50);
        add(tImage);

        label1 = new JLabel("Email or Phone:");
        label1.setFont(new Font("Raleway", Font.PLAIN, 18));
        label1.setForeground(Color.BLACK);
        label1.setBounds(40, 100, 200, 40);
        add(label1);
        mailField = new JTextField(20);
        mailField.setBounds(40, 140, 440, 40);
        mailField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(mailField);

        label2 = new JLabel("Password:");
        label2.setFont(new Font("Raleway", Font.PLAIN, 18));
        label2.setForeground(Color.BLACK);
        label2.setBounds(40, 200, 200, 40);
        add(label2);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(40, 240, 440, 40);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(passwordField);

        loginButton = new JButton("Sign in");
        Color loginButtonColor = Color.decode("#16AEF5");
        loginButton.setBackground(loginButtonColor);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(new Font("Raleway", Font.BOLD, 20));
        loginButton.setBounds(40, 350, 440, 40);
        //This calls the action listerner interface whenever a button is clicked
        loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        add(loginButton);

        label3 = new JLabel("Don't have an account?");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("Arial", Font.BOLD, 14));
        label3.setBounds(140, 400, 170, 20);
        add(label3);

        label4 = new JLabel("SignUp");
        label4.setForeground(Color.BLUE);
        label4.setFont(new Font("Arail", Font.PLAIN, 14));
        label4.setBounds(315, 400, 100, 20);
        label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Signup_GUI();
                setVisible(false);
            }
        });
        add(label4);

        setLayout(null); 
        setVisible(true);
    }

    private void loginButtonActionPerformed(ActionEvent evt) {
        String email = mailField.getText();
        String password = new String(passwordField.getPassword());
        try {
            Connector conn = new Connector();
            String ins = "Select * from users where name =? AND password =? ";
            PreparedStatement ps = conn.connection.prepareStatement(ins);
            ps.setString(1, email);
            ps.setString(2, password);

        

            
            conn.st.executeUpdate(ins);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login_GUI(); 
    }
}
