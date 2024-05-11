package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class LoginView extends JFrame{

    //buraya label button textfieldları  vs tanımlama

    JButton logInButton;
    JButton signUpButton;
    JTextField userNameTextField;
    JPasswordField passwordTextField;
    JLabel applicationNameLabel;
    JLabel userNameLabel;
    JLabel passwordLabel;
    ImageIcon logo;
    ActionListener actionListener;

    public LoginView(){

        this.setTitle("VeloCity");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(800,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(248,239,217));

        logo = new ImageIcon("Velocity.png");
        this.setIconImage(logo.getImage());


        applicationNameLabel = new JLabel("VELOCITY");
        applicationNameLabel.setForeground(new Color(255,81,0));
        applicationNameLabel.setFont(new Font("Franklin Gothic Heavy",Font.ITALIC, 50));
        applicationNameLabel.setBounds(275,60,800,60);

        logInButton = new JButton("Log In");
        logInButton.setBounds(275,350,100,40);
        logInButton.setBorderPainted(false);
        logInButton.setFocusPainted(false);
        logInButton.setBackground(new Color(255,81,0));
        logInButton.setForeground(new Color(248,239,217));

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(400,350,100,40);
        signUpButton.setBorderPainted(false);
        signUpButton.setFocusPainted(false);
        signUpButton.setBackground(new Color(255,81,0));
        signUpButton.setForeground(new Color(248,239,217));

        userNameTextField = new JTextField();
        userNameTextField.setBounds(235, 150,300,50);
        userNameTextField.setFont(new Font("Metropolis",Font.PLAIN,20));

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(235, 250,300,50);
        passwordTextField.setFont(new Font("Metropolis",Font.PLAIN,20));

        this.add(applicationNameLabel);
        this.add(signUpButton);
        this.add(logInButton);
        this.add(userNameTextField);
        this.add(passwordTextField);
        this.setVisible(true);
        signUpButton.addActionListener(actionListener);


    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public void setLogInButton(JButton logInButton) {
        this.logInButton = logInButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }

    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    public void setUserNameTextField(JTextField userNameTextField) {
        this.userNameTextField = userNameTextField;
    }

    public JPasswordField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JPasswordField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }
    /*
    public LoginView(ActionListener actionListener){

        // yukarıdakileri add(label1) tarzı eklemece

        //üst classtaki button arraylisitni de unutma buttons.add(button1) hesabı

        //en önemlisi actionlistener ekleme button1.addActionListener(actionListener)

    }

 */

}
