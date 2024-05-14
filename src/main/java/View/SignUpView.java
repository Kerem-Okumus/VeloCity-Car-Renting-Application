package View;

import javax.swing.*;
import java.awt.*;

public class SignUpView extends JFrame{

    JTextField userNameTextField;
    JTextField birthdayTextField;
    JTextField phoneNumberTextField;
    JTextField mailTextField;
    JPasswordField passwordTextField;
    JPasswordField passwordCheckTextField;
    JRadioButton maleButton;
    JRadioButton femaleButton;
    JButton signUpButton;
    JLabel userNameLabel;
    JLabel birthdayLabel;
    JLabel phoneNumberLabel;
    JLabel mailLabel;
    JLabel genderLabel;
    JLabel passwordLabel;
    JLabel passwordCheckLabel;
    JLabel pageNameLabel;
    ImageIcon logo;
    ButtonGroup genderButton = new ButtonGroup();


    public SignUpView() {

        this.setTitle("VeloCity");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(248,239,217));

        logo = new ImageIcon("Velocity.png");
        this.setIconImage(logo.getImage());

        pageNameLabel = new JLabel("Create Account");
        pageNameLabel.setBounds(300,150,400,60);
        pageNameLabel.setForeground(new Color(255,81,0));
        pageNameLabel.setFont(new Font("Franklin Gothic Heavy",Font.BOLD, 50));

        userNameTextField = new JTextField("enter username");
        userNameTextField.setBounds(300,350,300,50);
        userNameTextField.setFont(new Font("Metropolis", Font.PLAIN,20));

        passwordTextField = new JPasswordField("enter password");
        passwordTextField.setBounds(700,350,300,50);
        passwordTextField.setFont(new Font("Metropolis", Font.PLAIN, 20));

        passwordCheckTextField = new JPasswordField("confirm password");
        passwordCheckTextField.setBounds(1100,350,300,50);
        passwordCheckTextField.setFont(new Font("Metropolis",Font.PLAIN,20));
        passwordCheckTextField.setToolTipText("confirm password");

        mailTextField = new JTextField();
        mailTextField.setBounds(300,550,300,50);
        mailTextField.setFont(new Font("Metropolis", Font.PLAIN,20));
        mailTextField.setToolTipText("example@abc.com");

        birthdayTextField = new JTextField("enter your age");
        birthdayTextField.setBounds(700,550,300,50);
        birthdayTextField.setFont(new Font("Metropolis", Font.PLAIN, 20));

        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setBounds(1100,550,300,50);
        phoneNumberTextField.setFont(new Font("Metropolis", Font.PLAIN,20));
        phoneNumberTextField.setToolTipText("05_________");

        maleButton = new JRadioButton("Male");
        maleButton.setBounds(800,670,100,20);
        maleButton.setForeground(new Color(255,81,0));
        maleButton.setBackground(new Color(248,239,217));

        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(900,670,100,20);
        femaleButton.setForeground(new Color(255,81,0));
        femaleButton.setBackground(new Color(248,239,217));

        genderButton.add(maleButton);
        genderButton.add(femaleButton);

        userNameLabel = new JLabel("User Name:");
        userNameLabel.setBounds(300,280, 300,50);
        userNameLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        userNameLabel.setForeground(new Color(255,81,0));

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(700,280,300,50);
        passwordLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        passwordLabel.setForeground(new Color(255,81,0));

        passwordCheckLabel = new JLabel("Password Check:");
        passwordCheckLabel.setBounds(1100,280,300,50);
        passwordCheckLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        passwordCheckLabel.setForeground(new Color(255,81,0));

        mailLabel = new JLabel("Email:");
        mailLabel.setBounds(300,480, 300,50);
        mailLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        mailLabel.setForeground(new Color(255,81,0));

        birthdayLabel = new JLabel("Age:");
        birthdayLabel.setBounds(700,480, 300,50);
        birthdayLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        birthdayLabel.setForeground(new Color(255,81,0));

        phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setBounds(1100,480, 300,50);
        phoneNumberLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        phoneNumberLabel.setForeground(new Color(255,81,0));

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(700,650, 300,50);
        genderLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        genderLabel.setForeground(new Color(255,81,0));

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(700,750,300,50);
        signUpButton.setBorderPainted(false);
        signUpButton.setFocusPainted(false);
        signUpButton.setBackground(new Color(255,81,0));
        signUpButton.setForeground(new Color(248,239,217));

        this.add(pageNameLabel);
        this.add(userNameTextField);
        this.add(passwordTextField);
        this.add(passwordCheckTextField);
        this.add(mailTextField);
        this.add(birthdayTextField);
        this.add(phoneNumberTextField);
        this.add(maleButton);
        this.add(femaleButton);
        this.add(userNameLabel);
        this.add(passwordLabel);
        this.add(passwordCheckLabel);
        this.add(mailLabel);
        this.add(birthdayLabel);
        this.add(phoneNumberLabel);
        this.add(genderLabel);
        this.add(signUpButton);
        this.setVisible(false);

    }

    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    public void setUserNameTextField(JTextField userNameTextField) {
        this.userNameTextField = userNameTextField;
    }

    public JTextField getBirthdayTextField() {
        return birthdayTextField;
    }

    public void setBirthdayTextField(JTextField birthdayTextField) {
        this.birthdayTextField = birthdayTextField;
    }

    public JTextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public void setPhoneNumberTextField(JTextField phoneNumberTextField) {
        this.phoneNumberTextField = phoneNumberTextField;
    }

    public JTextField getMailTextField() {
        return mailTextField;
    }

    public void setMailTextField(JTextField mailTextField) {
        this.mailTextField = mailTextField;
    }

    public JPasswordField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JPasswordField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public JPasswordField getPasswordCheckTextField() {
        return passwordCheckTextField;
    }

    public void setPasswordCheckTextField(JPasswordField passwordCheckTextField) {
        this.passwordCheckTextField = passwordCheckTextField;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }
    public ButtonGroup getGenderButton(){
        return genderButton;
    }

    public JRadioButton getMaleButton() {
        return maleButton;
    }

    public JRadioButton getFemaleButton() {
        return femaleButton;
    }
}
