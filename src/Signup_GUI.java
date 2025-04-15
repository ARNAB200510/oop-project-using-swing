import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class Signup_GUI extends JFrame {
    JLabel label1, label2, label3, label4, label5, label6,label7;

    JTextField textMail, textName, textPhone;
    JPasswordField passwordField, confirmPasswordField;
    JDateChooser dateChooser;
    JButton signupButton;


    HashMap<JLabel, Pair<Boolean, JLabel>> messageMap;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    Signup_GUI() {
        setTitle("Sign Up");
        setSize(540, 680);
        setLocation(400, 30);
        setBackground(new Color(245, 245, 220));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        messageMap = new HashMap<>();
        
        ImageIcon mIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/HotelIcon.png"));
        Image scaled_mIcon = mIcon.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        JLabel tImage = new JLabel(new ImageIcon(scaled_mIcon));
        tImage.setBounds(230, 5, 70, 50);
        add(tImage);

        label1 = new JLabel("Name:");
        label1.setFont(new Font("Raleway", Font.PLAIN, 18));
        label1.setForeground(Color.BLACK);
        label1.setBounds(40, 90, 200, 30);
        add(label1);

        textName = new JTextField(20);
        textName.setBounds(40, 120, 440, 30);
        textName.setFont(new Font("Arial", Font.PLAIN, 14));
        Pattern nameVerifier = Pattern.compile("^[a-zA-Z ]+$");
        add(textName);
        label2 = new JLabel("Email:");
        label2.setFont(new Font("Raleway", Font.PLAIN, 18));
        label2.setForeground(Color.BLACK);
        label2.setBounds(40, 170, 200, 30);
        add(label2);
        textMail = new JTextField(30);
        textMail.setBounds(40, 200, 440, 30);
        textMail.setFont(new Font("Arial", Font.PLAIN, 14));
        Pattern mailVerifier = Pattern.compile("^[A-Z0-9a-z*#+-_/{|}!%&()=]+@[A-Z0-9a-z-]+(\\.[A-Z0-9a-z-]+)+$");
        add(textMail);
        label3 = new JLabel("Phone:");
        label3.setFont(new Font("Raleway", Font.PLAIN, 18));
        label3.setForeground(Color.BLACK);
        label3.setBounds(40, 250, 200, 30);
        add(label3);
        textPhone = new JTextField(20);
        textPhone.setBounds(40, 280, 440, 30);
        textPhone.setFont(new Font("Arial", Font.PLAIN, 14));
        Pattern phoneVerifier = Pattern.compile("^[0-9]{10}$");
        add(textPhone);

        label4 = new JLabel("Date of Birth:");
        label4.setFont(new Font("Raleway", Font.PLAIN, 18));
        label4.setForeground(Color.BLACK);
        label4.setBounds(40, 330, 200, 30);
        add(label4);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(40, 360, 440, 30);
        dateChooser.setFont(new Font("Arial", Font.PLAIN, 14));
        add(dateChooser);
        label5 = new JLabel("Password: ");
        label5.setFont(new Font("Raleway", Font.PLAIN, 18));
        label5.setForeground(Color.BLACK);
        label5.setBounds(40, 410, 200, 30);
        add(label5);
        passwordField = new JPasswordField();
        passwordField.setBounds(40, 440, 440, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        Pattern passwordVerifier = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\W).{10,}$");
        add(passwordField);

        label6 = new JLabel("Confirm Password: ");
        label6.setFont(new Font("Raleway", Font.PLAIN, 18));
        label6.setForeground(Color.BLACK);
        label6.setBounds(40, 490, 200, 30);
        add(label6);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(40, 520, 440, 30);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(confirmPasswordField);

        signupButton = new JButton("Sign up");
        Color signupButtonColor = Color.decode("#16AEF5");
        signupButton.setBackground(signupButtonColor);
        signupButton.setForeground(Color.BLACK);
        signupButton.setFont(new Font("Raleway", Font.BOLD, 20));
        signupButton.setBounds(150, 580, 220, 40);
        signupButton.addActionListener(evt -> signupButtonActionPerformed(evt));
        add(signupButton);

        messageMap.put(label1, new Pair(false, new JLabel("Invalid name")));
        messageMap.put(label2, new Pair(false, new JLabel("Enter a valid email")));
        messageMap.put(label3, new Pair(false, new JLabel("Enter a valid phone number")));
        messageMap.put(label4, new Pair(false, new JLabel("Enter a DOB")));
        messageMap.put(label5, new Pair(false, new JLabel("Valid:10 characters,uppercase + lowercase + digit + special ")));
        messageMap.put(label6, new Pair(false, new JLabel("Passwords don't match")));
        for (JLabel label : messageMap.keySet()) {

            JLabel errorText = messageMap.get(label).getTwo();
            errorText.setForeground(Color.red);
            errorText.setFont(new Font("Raleway", Font.PLAIN, 14));
            errorText.setBounds(label.getX() + label.getWidth() + 5, label.getY(), 280, 20);
            errorText.setVisible(false);
            add(errorText);
        }

        ValidationSystemListener.labelFieldMap = messageMap;
        textName.getDocument().addDocumentListener(new ValidationSystemListener(label1, textName, nameVerifier));
        textMail.getDocument().addDocumentListener(new ValidationSystemListener(label2, textMail, mailVerifier));
        textPhone.getDocument().addDocumentListener(new ValidationSystemListener(label3, textPhone, phoneVerifier));
        passwordField.getDocument().addDocumentListener(new ValidationSystemListener(label5, passwordField, passwordVerifier));
        setVisible(true);
        setLayout(null);
    }

 

    public void signupButtonActionPerformed(ActionEvent evt) {
        int i = 1;
        for (JLabel label : messageMap.keySet()) {
            Pair<Boolean, JLabel> pair = messageMap.get(label);
            i++;
            System.out.println("label" + i + pair.getOne());
            if (!pair.getOne()) {
                pair.getTwo().setVisible(true);
                return;
            } else {
                pair.getTwo().setVisible(false);
                
            }
        }
        //Additional validations 
        if (dateChooser.getDate() == null) {
            messageMap.get(label4).setOne(false);
            messageMap.get(label4).getTwo().setVisible(true);
        } else {
            messageMap.get(label4).setOne(true);
            messageMap.get(label4).getTwo().setVisible(false);
        }
        if (new String(passwordField.getPassword()).equals(new String(confirmPasswordField.getPassword()))
                && new String(passwordField.getPassword()).length() > 0) {
            messageMap.get(label6).setOne(true);
            messageMap.get(label6).getTwo().setVisible(false);
            
        }
        else {
            messageMap.get(label6).setOne(false);
            messageMap.get(label6).getTwo().setVisible(true);
            
        }
        

        String name = textName.getText();
        String email = textMail.getText();
        String phone = textPhone.getText();
        Date date = dateChooser.getDate();
        String dob = "";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dob = sdf.format(date);
        String password = new String(passwordField.getPassword());
        try {
            Connector conn = new Connector();
            String ins = "insert into Users values('" + email + "','" + name + "','" + phone + "','" + dob + "','"
                    + password + "')";
            conn.st.executeUpdate(ins);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup_GUI();

    }
}

class Pair<K, T> {
    private K one;
    private T two;

    Pair() {
        
    }

    Pair(K one, T two) {
        this.one = one;
        this.two = two;
    }

    public K getOne() {
        return one;
    }

    public T getTwo() {
        return two;
    }

    public void setOne(K one) {
        this.one = one;
    }

    public void setTwo(T two) {
        this.two = two;
    }

   
}