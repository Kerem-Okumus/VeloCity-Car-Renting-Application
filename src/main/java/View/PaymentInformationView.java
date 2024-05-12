package View;

import javax.swing.*;
import java.awt.*;

public class PaymentInformationView extends JFrame{
    JTextField nameOnCardTextField;
    JTextField promotionCodeTextField;
    JTextField cvvTextField;
    JTextField cardNumberTextField;
    JComboBox monthComboBox;
    String month[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    JComboBox yearComboBox;
    String year[] = {"2025","2026","2027","2028","2029","2030"};
    JButton confirmButton;
    JLabel expirationDateLabel;
    JLabel nameOnCardLabel;
    JLabel promotionCodeLabel;
    JLabel cvvLabel;
    JLabel cardNumberLabel;
    JLabel pageNameLabel;
    ImageIcon logo;

    public PaymentInformationView() {

        this.setTitle("VeloCity");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(248,239,217));

        logo = new ImageIcon("Velocity.png");
        this.setIconImage(logo.getImage());

        pageNameLabel = new JLabel("Payment Information");
        pageNameLabel.setBounds(300,150,600,60);
        pageNameLabel.setForeground(new Color(255,81,0));
        pageNameLabel.setFont(new Font("Franklin Gothic Heavy",Font.BOLD, 50));

        nameOnCardTextField = new JTextField();
        nameOnCardTextField.setBounds(300,350,300,50);
        nameOnCardTextField.setFont(new Font("Metropolis", Font.PLAIN,20));

        cardNumberTextField = new JTextField();
        cardNumberTextField.setBounds(700,350,300,50);
        cardNumberTextField.setFont(new Font("Metropolis", Font.PLAIN, 20));


        cvvTextField = new JTextField();
        cvvTextField.setBounds(300,550,300,50);
        cvvTextField.setFont(new Font("Metropolis", Font.PLAIN,20));

        promotionCodeTextField = new JTextField();
        promotionCodeTextField.setBounds(700,550,300,50);
        promotionCodeTextField.setFont(new Font("Metropolis", Font.PLAIN, 20));

        nameOnCardLabel = new JLabel("Name on the Card:");
        nameOnCardLabel.setBounds(300,280, 300,50);
        nameOnCardLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        nameOnCardLabel.setForeground(new Color(255,81,0));

        cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(700,280,300,50);
        cardNumberLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        cardNumberLabel.setForeground(new Color(255,81,0));


        cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(300,480, 300,50);
        cvvLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        cvvLabel.setForeground(new Color(255,81,0));

        promotionCodeLabel = new JLabel("Promotion Code:");
        promotionCodeLabel.setBounds(700,480, 300,50);
        promotionCodeLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        promotionCodeLabel.setForeground(new Color(255,81,0));

        expirationDateLabel = new JLabel("Expiration Date:");
        expirationDateLabel.setBounds(300,680, 300,50);
        expirationDateLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        expirationDateLabel.setForeground(new Color(255,81,0));

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(700,750,300,50);
        confirmButton.setBorderPainted(false);
        confirmButton.setFocusPainted(false);
        confirmButton.setBackground(new Color(255,81,0));
        confirmButton.setForeground(new Color(248,239,217));

        monthComboBox = new JComboBox(month);
        monthComboBox.setBounds(300,750, 100,50);
        monthComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        monthComboBox.setForeground(new Color(255,81,0));

        yearComboBox = new JComboBox(year);
        yearComboBox.setBounds(500,750, 100,50);
        yearComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        yearComboBox.setForeground(new Color(255,81,0));

        this.add(pageNameLabel);
        this.add(nameOnCardTextField);
        this.add(cardNumberTextField);
        this.add(cvvTextField);
        this.add(promotionCodeTextField);
        this.add(monthComboBox);
        this.add(yearComboBox);
        this.add(nameOnCardLabel);
        this.add(cardNumberLabel);
        this.add(cvvLabel);
        this.add(expirationDateLabel);
        this.add(promotionCodeLabel);
        this.add(confirmButton);
        this.setVisible(false);
    }

    public JTextField getNameOnCardTextField() {
        return nameOnCardTextField;
    }

    public void setNameOnCardTextField(JTextField nameOnCardTextField) {
        this.nameOnCardTextField = nameOnCardTextField;
    }

    public JTextField getPromotionCodeTextField() {
        return promotionCodeTextField;
    }

    public void setPromotionCodeTextField(JTextField promotionCodeTextField) {
        this.promotionCodeTextField = promotionCodeTextField;
    }

    public JTextField getCvvTextField() {
        return cvvTextField;
    }

    public void setCvvTextField(JTextField cvvTextField) {
        this.cvvTextField = cvvTextField;
    }

    public JTextField getCardNumberTextField() {
        return cardNumberTextField;
    }

    public void setCardNumberTextField(JTextField cardNumberTextField) {
        this.cardNumberTextField = cardNumberTextField;
    }

    public JComboBox getMonthComboBox() {
        return monthComboBox;
    }

    public void setMonthComboBox(JComboBox monthComboBox) {
        this.monthComboBox = monthComboBox;
    }

    public JComboBox getYearComboBox() {
        return yearComboBox;
    }

    public void setYearComboBox(JComboBox yearComboBox) {
        this.yearComboBox = yearComboBox;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(JButton confirmButton) {
        this.confirmButton = confirmButton;
    }
}

