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
    JButton backButton;
    JLabel expirationDateLabel;
    JLabel nameOnCardLabel;
    JLabel promotionCodeLabel;
    JLabel cvvLabel;
    JLabel cardNumberLabel;
    JLabel pageNameLabel;

    //Calculation Part
    JTextField rentFeeTextField;
    JTextField extrasPriceTextField;
    JTextField discountTextfield;
    JTextField totalTextField;
    JLabel rentFeeLabel;
    JLabel extrasPriceLabel;
    JLabel discountLabel;
    JLabel totalLabel;
    ImageIcon logo;

    public PaymentInformationView() {

        this.setTitle("VeloCity");
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

        backButton = new JButton("Back");
        backButton.setBounds(1100,750,200,50);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setBackground(new Color(255,81,0));
        backButton.setForeground(new Color(248,239,217));

        monthComboBox = new JComboBox(month);
        monthComboBox.setBounds(300,750, 100,50);
        monthComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        monthComboBox.setForeground(new Color(255,81,0));

        yearComboBox = new JComboBox(year);
        yearComboBox.setBounds(500,750, 100,50);
        yearComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        yearComboBox.setForeground(new Color(255,81,0));

        rentFeeLabel = new JLabel("Rent Fee:");
        rentFeeLabel.setBounds(1100,280, 300,50);
        rentFeeLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        rentFeeLabel.setForeground(new Color(255,81,0));

        extrasPriceLabel = new JLabel("Extra Price:");
        extrasPriceLabel.setBounds(1100,380, 300,50);
        extrasPriceLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        extrasPriceLabel.setForeground(new Color(255,81,0));

        discountLabel = new JLabel("Discount:");
        discountLabel.setBounds(1100,480, 300,50);
        discountLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        discountLabel.setForeground(new Color(255,81,0));

        totalLabel = new JLabel("Total:");
        totalLabel.setBounds(1100,560, 300,50);
        totalLabel.setFont(new Font("Metropolis", Font.PLAIN,20));
        totalLabel.setForeground(new Color(255,81,0));

        rentFeeTextField = new JTextField();
        rentFeeTextField.setBounds(1300,280,300,50);
        rentFeeTextField.setBackground(new Color(248,239,217));
        rentFeeTextField.setForeground(new Color(255,81,0));
        rentFeeTextField.setBorder(BorderFactory.createLineBorder(new Color(248,239,217)));
        rentFeeTextField.setText("5400");
        rentFeeTextField.setEditable(false);
        rentFeeTextField.setFont(new Font("Metropolis", Font.PLAIN, 20));

        extrasPriceTextField = new JTextField();
        extrasPriceTextField.setBounds(1300,380,300,50);
        extrasPriceTextField.setBackground(new Color(248,239,217));
        extrasPriceTextField.setForeground(new Color(255,81,0));
        extrasPriceTextField.setBorder(BorderFactory.createLineBorder(new Color(248,239,217)));
        extrasPriceTextField.setText("790");
        extrasPriceTextField.setEditable(false);
        extrasPriceTextField.setFont(new Font("Metropolis", Font.PLAIN, 20));

        discountTextfield = new JTextField();
        discountTextfield.setBounds(1300,480,300,50);
        discountTextfield.setBackground(new Color(248,239,217));
        discountTextfield.setForeground(new Color(255,81,0));
        discountTextfield.setBorder(BorderFactory.createLineBorder(new Color(248,239,217)));
        discountTextfield.setText("1000");
        discountTextfield.setEditable(false);
        discountTextfield.setFont(new Font("Metropolis", Font.PLAIN, 20));

        totalTextField = new JTextField();
        totalTextField.setBounds(1300,560,300,50);
        totalTextField.setBackground(new Color(248,239,217));
        totalTextField.setForeground(new Color(255,81,0));
        totalTextField.setBorder(BorderFactory.createLineBorder(new Color(248,239,217)));
        totalTextField.setEditable(false);
        totalTextField.setText("5190");
        totalTextField.setFont(new Font("Metropolis", Font.PLAIN, 20));

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
        this.add(backButton);
        this.add(rentFeeLabel);
        this.add(extrasPriceLabel);
        this.add(discountLabel);
        this.add(totalLabel);
        this.add(rentFeeTextField);
        this.add(extrasPriceTextField);
        this.add(discountTextfield);
        this.add(totalTextField);
        this.setVisible(true);
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

    public JButton getBackButton() {
        return backButton;
    }
}

