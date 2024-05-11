package View;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class UserMainView extends JFrame{

    JPanel currentRentPanel;
    JPanel newRentPanel;
    JPanel carSelectionPanel;
    JTabbedPane optionBar;
    String[] columnNames = {"Vehicle Model", "Rental Place", "Delivery Place", "Rental Date", "Delivery Date"};
    String[][] data = {
            {"Yaris","İstanbul","Trabzon","12/05/2024","15/05/2024"},
            {"Yaris","İstanbul","Trabzon","12/05/2024","15/05/2024"}
    };
    JTable rentListTable;
    String place[] = {"İstanbul", "Ankara", "Trabzon", "Çankırı", "Rize","Erzurum","Gaziantep"};
    String day[] = {"01","02","03","04","05","06","07","08","09",
                    "10","11","12","13","14","15","16","17","18",
                    "19","21","22","23","24","25","26","27","28",
                    "29","30","31"};
    String month[] = {"01","02","03","04","05","06","07","08","09",
                      "10","11","12"};
    String year[] = {"2024","2025","2026"};
    JComboBox rentalPlace;
    JComboBox deliveryPlace;
    JComboBox rentalDateDay;
    JComboBox rentalDateMonth;
    JComboBox rentalDateYear;
    JComboBox deliveryDateDay;
    JComboBox deliveryDateMonth;
    JComboBox deliveryDateYear;
    JComboBox gearTypeComboBox;
    String gear[] = {"Automatic", "Manual"};
    JComboBox colorComboBox;
    String color[] = {"Black","Yellow", "White","Red", "Blue"};
    JComboBox brandComboBox;
    String brand[] = {"Toyota", "Volkswagen","MG","Volvo"};
    JComboBox carTypeComboBox;
    String carType[] = {"Sedan", "SUV", "Hatchback"};
    JComboBox passengerAmountComboBox;
    String passengerAmount[] = {"2", "5", "7"};
    JButton searchButton;
    JRadioButton driverOptionYes;
    JRadioButton driverOptionNo;
    JLabel pageNameLabel;
    JScrollPane scrollPane;
    JScrollPane carSelectionPane;
    ImageIcon logo;
    public UserMainView(){

        this.setTitle("VeloCity");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(248,239,217));

        logo = new ImageIcon("Velocity.png");
        this.setIconImage(logo.getImage());


        currentRentPanel = new JPanel();
        currentRentPanel.setBackground(new Color(248,239,217));
        rentListTable = new JTable(data,columnNames);
        scrollPane = new JScrollPane(rentListTable);
        currentRentPanel.add(scrollPane);

        rentalPlace = new JComboBox(place);
        rentalPlace.setBounds(300,300, 300,50);
        rentalPlace.setFont(new Font("Metropolis", Font.PLAIN,20));
        rentalPlace.setForeground(new Color(255,81,0));

        deliveryPlace = new JComboBox(place);
        deliveryPlace.setBounds(900,300, 300,50);
        deliveryPlace.setFont(new Font("Metropolis", Font.PLAIN,20));
        deliveryPlace.setForeground(new Color(255,81,0));

        pageNameLabel = new JLabel("New Rent");
        pageNameLabel.setBounds(300,150,600,60);
        pageNameLabel.setForeground(new Color(255,81,0));
        pageNameLabel.setFont(new Font("Franklin Gothic Heavy",Font.BOLD, 50));

        rentalDateDay = new JComboBox(day);
        rentalDateDay.setBounds(300,450, 70,50);
        rentalDateDay.setFont(new Font("Metropolis", Font.PLAIN,20));
        rentalDateDay.setForeground(new Color(255,81,0));

        rentalDateMonth = new JComboBox(month);
        rentalDateMonth.setBounds(400,450, 70,50);
        rentalDateMonth.setFont(new Font("Metropolis", Font.PLAIN,20));
        rentalDateMonth.setForeground(new Color(255,81,0));

        rentalDateYear = new JComboBox(year);
        rentalDateYear.setBounds(500,450, 100,50);
        rentalDateYear.setFont(new Font("Metropolis", Font.PLAIN,20));
        rentalDateYear.setForeground(new Color(255,81,0));

        deliveryDateDay = new JComboBox(day);
        deliveryDateDay.setBounds(900,450, 70,50);
        deliveryDateDay.setFont(new Font("Metropolis", Font.PLAIN,20));
        deliveryDateDay.setForeground(new Color(255,81,0));

        deliveryDateMonth = new JComboBox(month);
        deliveryDateMonth.setBounds(1000,450, 70,50);
        deliveryDateMonth.setFont(new Font("Metropolis", Font.PLAIN,20));
        deliveryDateMonth.setForeground(new Color(255,81,0));

        deliveryDateYear = new JComboBox(year);
        deliveryDateYear.setBounds(1100,450, 100,50);
        deliveryDateYear.setFont(new Font("Metropolis", Font.PLAIN,20));
        deliveryDateYear.setForeground(new Color(255,81,0));

        carSelectionPanel = new JPanel();
        carSelectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT,60,60));
        carSelectionPanel.setBackground(new Color(225, 211, 189));
        carSelectionPanel.setBounds(300,550,900,400);

        brandComboBox = new JComboBox(brand);
        brandComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        brandComboBox.setForeground(new Color(255,81,0));

        carTypeComboBox = new JComboBox(carType);
        carTypeComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        carTypeComboBox.setForeground(new Color(255,81,0));

        colorComboBox = new JComboBox(color);
        colorComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        colorComboBox.setForeground(new Color(255,81,0));

        gearTypeComboBox = new JComboBox(brand);
        gearTypeComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        gearTypeComboBox.setForeground(new Color(255,81,0));

        passengerAmountComboBox = new JComboBox(passengerAmount);
        passengerAmountComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        passengerAmountComboBox.setForeground(new Color(255,81,0));

        carSelectionPanel.add(brandComboBox);
        carSelectionPanel.add(carTypeComboBox);
        carSelectionPanel.add(colorComboBox);
        carSelectionPanel.add(gearTypeComboBox);
        carSelectionPanel.add(passengerAmountComboBox);

        newRentPanel = new JPanel();
        newRentPanel.setBackground(new Color(248,239,217));
        newRentPanel.setLayout(null);
        newRentPanel.add(rentalPlace);
        newRentPanel.add(deliveryPlace);
        newRentPanel.add(pageNameLabel);
        newRentPanel.add(rentalDateDay);
        newRentPanel.add(rentalDateMonth);
        newRentPanel.add(rentalDateYear);
        newRentPanel.add(deliveryDateDay);
        newRentPanel.add(deliveryDateMonth);
        newRentPanel.add(deliveryDateYear);
        newRentPanel.add(carSelectionPanel);

        optionBar = new JTabbedPane();
        optionBar.setBounds(0,0,1920,1080);
        optionBar.setForeground(new Color(255,81,0));
        optionBar.setBackground(new Color(248,239,217));
        optionBar.add("Current Rent", currentRentPanel);
        optionBar.add("New Rent",newRentPanel);

        this.add(optionBar);
        this.setVisible(true);


    }
}
