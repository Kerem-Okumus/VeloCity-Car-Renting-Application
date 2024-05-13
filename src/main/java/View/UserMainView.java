package View;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class UserMainView extends JFrame{

    JPanel currentRentPanel;
    JPanel newRentPanel;
    JPanel carSelectionPanel;
    JPanel driverPanel;
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
    JComboBox pickUpPlace;
    JComboBox deliveryPlace;
    JComboBox pickUpDateDay;
    JComboBox pickUpDateMonth;
    JComboBox pickUpDateYear;
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
    JButton confirmButton;
    JRadioButton driverOptionYes;
    JRadioButton driverOptionNo;
    JLabel pageNameLabel;
    JLabel pickUpPlaceLabel;
    JLabel deliveryPlaceLabel;
    JLabel pickUpDateLabel;
    JLabel deliveryDateLabel;

    //Labels for car selection panel
    JLabel brandLabel;
    JLabel colorLabel;
    JLabel categoryLabel;
    JLabel gearTypeLabel;
    JLabel passengerAmountLabel;
    JScrollPane scrollPane;
    JScrollPane carSelectionPane;
    ImageIcon logo;
    ButtonGroup driverOption = new ButtonGroup();
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

        pickUpPlace = new JComboBox(place);
        pickUpPlace.setBounds(300,300, 300,50);
        pickUpPlace.setFont(new Font("Metropolis", Font.PLAIN,20));
        pickUpPlace.setForeground(new Color(255,81,0));


        deliveryPlace = new JComboBox(place);
        deliveryPlace.setBounds(900,300, 300,50);
        deliveryPlace.setFont(new Font("Metropolis", Font.PLAIN,20));
        deliveryPlace.setForeground(new Color(255,81,0));

        pageNameLabel = new JLabel("New Rent");
        pageNameLabel.setBounds(300,150,600,60);
        pageNameLabel.setForeground(new Color(255,81,0));
        pageNameLabel.setFont(new Font("Franklin Gothic Heavy",Font.BOLD, 50));

        pickUpDateDay = new JComboBox(day);
        pickUpDateDay.setBounds(300,450, 70,50);
        pickUpDateDay.setFont(new Font("Metropolis", Font.PLAIN,20));
        pickUpDateDay.setForeground(new Color(255,81,0));

        pickUpDateMonth = new JComboBox(month);
        pickUpDateMonth.setBounds(400,450, 70,50);
        pickUpDateMonth.setFont(new Font("Metropolis", Font.PLAIN,20));
        pickUpDateMonth.setForeground(new Color(255,81,0));

        pickUpDateYear = new JComboBox(year);
        pickUpDateYear.setBounds(500,450, 100,50);
        pickUpDateYear.setFont(new Font("Metropolis", Font.PLAIN,20));
        pickUpDateYear.setForeground(new Color(255,81,0));

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

        pickUpPlaceLabel = new JLabel("Pick Up Place:");
        pickUpPlaceLabel.setBounds(300,250,300,50);
        pickUpPlaceLabel.setForeground(new Color(255,81,0));
        pickUpPlaceLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        deliveryPlaceLabel = new JLabel("Delivery Place:");
        deliveryPlaceLabel.setBounds(900,250,300,50);
        deliveryPlaceLabel.setForeground(new Color(255,81,0));
        deliveryPlaceLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        pickUpDateLabel = new JLabel("Pick Up Date(dd/mm/yy):");
        pickUpDateLabel.setBounds(300,400,300,50);
        pickUpDateLabel.setForeground(new Color(255,81,0));
        pickUpDateLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        deliveryDateLabel = new JLabel("Delivery Date(dd/mm/yy):");
        deliveryDateLabel.setBounds(900,400,300,50);
        deliveryDateLabel.setForeground(new Color(255,81,0));
        deliveryDateLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        carSelectionPanel = new JPanel();
        carSelectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT,60,60));
        carSelectionPanel.setBackground(new Color(225, 211, 189));
        carSelectionPanel.setBounds(300,550,900,400);

        driverPanel = new JPanel();
        driverPanel.setLayout(new FlowLayout(FlowLayout.LEFT,70,100));
        driverPanel.setBackground(new Color(225, 211, 189));
        driverPanel.setBounds(1300,300,300,650);

        driverOption.add(driverOptionYes);
        driverOption.add(driverOptionNo);

        driverOptionYes = new JRadioButton("Yes");
        driverOptionYes.setBounds(800,670,100,20);
        driverOptionYes.setForeground(new Color(255,81,0));
        driverOptionYes.setBackground(new Color(248,239,217));


        driverOptionNo = new JRadioButton("No");
        driverOptionNo.setBounds(900,670,100,20);
        driverOptionNo.setForeground(new Color(255,81,0));
        driverOptionNo.setBackground(new Color(248,239,217));

        brandComboBox = new JComboBox(brand);
        brandComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        brandComboBox.setForeground(new Color(255,81,0));

        carTypeComboBox = new JComboBox(carType);
        carTypeComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        carTypeComboBox.setForeground(new Color(255,81,0));

        colorComboBox = new JComboBox(color);
        colorComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        colorComboBox.setForeground(new Color(255,81,0));

        gearTypeComboBox = new JComboBox(gear);
        gearTypeComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        gearTypeComboBox.setForeground(new Color(255,81,0));

        passengerAmountComboBox = new JComboBox(passengerAmount);
        passengerAmountComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        passengerAmountComboBox.setForeground(new Color(255,81,0));

        brandLabel = new JLabel("Brand:");
        brandLabel.setBounds(360,550,300,50);
        brandLabel.setForeground(new Color(255,81,0));
        brandLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(550,550,300,50);
        categoryLabel.setForeground(new Color(255,81,0));
        categoryLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        colorLabel = new JLabel("Color:");
        colorLabel.setBounds(730,550,300,50);
        colorLabel.setForeground(new Color(255,81,0));
        colorLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        gearTypeLabel = new JLabel("Gear Type:");
        gearTypeLabel.setBounds(880,550,300,50);
        gearTypeLabel.setForeground(new Color(255,81,0));
        gearTypeLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        passengerAmountLabel = new JLabel("Passenger:");
        passengerAmountLabel.setBounds(1050,550,300,50);
        passengerAmountLabel.setForeground(new Color(255,81,0));
        passengerAmountLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(1350,850,200,50);
        confirmButton.setBorderPainted(false);
        confirmButton.setFocusPainted(false);
        confirmButton.setBackground(new Color(255,81,0));
        confirmButton.setForeground(new Color(248,239,217));

        searchButton = new JButton("Search");
        searchButton.setBounds(900,850,200,50);
        searchButton.setBorderPainted(false);
        searchButton.setFocusPainted(false);
        searchButton.setBackground(new Color(255,81,0));
        searchButton.setForeground(new Color(248,239,217));

        carSelectionPanel.add(brandComboBox);
        carSelectionPanel.add(carTypeComboBox);
        carSelectionPanel.add(colorComboBox);
        carSelectionPanel.add(gearTypeComboBox);
        carSelectionPanel.add(passengerAmountComboBox);

        newRentPanel = new JPanel();
        newRentPanel.setBackground(new Color(248,239,217));
        newRentPanel.setLayout(null);
        newRentPanel.add(pickUpPlace);
        newRentPanel.add(deliveryPlace);
        newRentPanel.add(pageNameLabel);
        newRentPanel.add(pickUpDateDay);
        newRentPanel.add(pickUpDateMonth);
        newRentPanel.add(pickUpDateYear);
        newRentPanel.add(deliveryDateDay);
        newRentPanel.add(deliveryDateMonth);
        newRentPanel.add(deliveryDateYear);
        newRentPanel.add(pickUpPlaceLabel);
        newRentPanel.add(deliveryPlaceLabel);
        newRentPanel.add(pickUpDateLabel);
        newRentPanel.add(deliveryDateLabel);
        newRentPanel.add(brandLabel);
        newRentPanel.add(categoryLabel);
        newRentPanel.add(colorLabel);
        newRentPanel.add(gearTypeLabel);
        newRentPanel.add(passengerAmountLabel);
        newRentPanel.add(searchButton);
        newRentPanel.add(carSelectionPanel);
        newRentPanel.add(confirmButton);
        newRentPanel.add(driverPanel);


        driverPanel.add(driverOptionYes);
        driverPanel.add(driverOptionNo);

        rentListTable.getTableHeader().setReorderingAllowed(false);
        rentListTable.getTableHeader().setResizingAllowed(false);

        optionBar = new JTabbedPane();
        optionBar.setBounds(0,0,1920,1080);
        optionBar.setForeground(new Color(255,81,0));
        optionBar.setBackground(new Color(248,239,217));
        optionBar.add("Current Rent", currentRentPanel);
        optionBar.add("New Rent",newRentPanel);

        this.add(optionBar);
        this.setVisible(false);


    }
}
