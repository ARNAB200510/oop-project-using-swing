import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainPage extends JFrame {
    boolean isValidated = false;
    MainPage() {
        setTitle("Homepage");
        setSize(850, 480);
        setLocation(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        ImageIcon hIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/homepage.png"));
        setIconImage(hIcon.getImage());
        
        JLabel welcome = new JLabel("WELCOME!");
        welcome.setFont(new Font("serif", Font.BOLD, 38));
        welcome.setForeground(Color.WHITE);
        welcome.setBounds(300, 18, 450, 30);
        add(welcome);

        JButton loginButton = new JButton();
        loginButton.setText("Login?/Signup");
        Color loginColor = Color.decode("#DA70D6");
        loginButton.setBackground(loginColor);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.setForeground(Color.WHITE);

        ImageIcon mIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/HotelIcon.png"));
        Image scaled_mIcon = mIcon.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        JLabel tImage = new JLabel(new ImageIcon(scaled_mIcon));
        tImage.setBounds(10, 20, 70, 50);
        add(tImage);
        
        ImageIcon backIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/Background_mainpage.png"));
        Image scaled_backIcon = backIcon.getImage().getScaledInstance(850, 120, Image.SCALE_DEFAULT);
        JLabel backgroundImage = new JLabel(new ImageIcon(scaled_backIcon));
        backgroundImage.setBounds(0, 0, 850, 120);
        add(backgroundImage);
        
        setLayout(null); 
        setVisible(true);
    }
    public static void main(String[] args) {
        new MainPage(); 
    }
}