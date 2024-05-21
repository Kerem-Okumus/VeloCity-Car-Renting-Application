package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserMainView extends JFrame{

    JPanel currentRentPanel;
    JPanel newRentPanel;
    JPanel carSelectionPanel;
    JPanel extrasPanel;
    JPanel extrasPricePanel;
    JTabbedPane optionBar;
    String[] columnNames = {"Vehicle Model", "Rental Place", "Delivery Place", "Rental Date", "Delivery Date"};
    String[] carColumnNames = {"Model", "Brand", "Color", "Gear Type", "Car Type", "Fuel Type", "Passenger Amount", "Daily Price"};
    String[][] data;
    String[][] carData;
    JTable rentListTable;
    JTable carListTable;
    String place[] = {"İstanbul", "Ankara", "Trabzon", "Çankırı", "Rize","Erzurum","Gaziantep"};
    String[] day = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String[] month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
    String[] year = {"2024", "2025", "2026"};


    JComboBox pickUpPlace;
    JComboBox deliveryPlace;
    JComboBox pickUpDateDay;
    JComboBox pickUpDateMonth;
    JComboBox pickUpDateYear;
    JComboBox deliveryDateDay;
    JComboBox deliveryDateMonth;
    JComboBox deliveryDateYear;
    JComboBox gearTypeComboBox;
    String gear[] = {"ALL","Automatic", "Manual"};
    JComboBox colorComboBox;
    String color[] = {"ALL","Black","Grey", "White","Red", "Blue"};
    JComboBox brandComboBox;
    String brand[] = {"ALL","Toyota", "Volkswagen","MG","Volvo","Fiat","Renault","Lamborghini","Mazda","BMW","Tesla","Mercedes","Hyundai"};
    JComboBox carTypeComboBox;
    String carType[] = {"ALL","Sedan", "SUV", "Hatchback","Roadster","Panel-Van"};
    JComboBox passengerAmountComboBox;
    String passengerAmount[] = {"ALL","2", "5", "7"};
    JComboBox fuelTypeComboBox;
    String fuelType[] = {"ALL","Gasoline","Diesel","Electric","Hybrid"};
    JButton searchButton;
    JButton confirmButton;
    JButton clearButton;
    JRadioButton driverOptionYes;
    JRadioButton driverOptionNo;
    JRadioButton normalDriver;
    JRadioButton professionalDriver;
    JRadioButton tireChainYes;
    JRadioButton tireChainNo;
    JRadioButton childSeat;
    JRadioButton babySeat;
    JRadioButton roofBoxYes;
    JRadioButton roofBoxNo;
    JRadioButton bigProtection;
    JRadioButton mediumProtection;
    JRadioButton additionalProtection;
    JRadioButton noProtection;
    JLabel pageNameLabel;
    JLabel pickUpPlaceLabel;
    JLabel deliveryPlaceLabel;
    JLabel pickUpDateLabel;
    JLabel deliveryDateLabel;


    JLabel brandLabel;
    JLabel colorLabel;
    JLabel categoryLabel;
    JLabel gearTypeLabel;
    JLabel passengerAmountLabel;
    JLabel fuelTypeLabel;
    JScrollPane scrollPane;


    JLabel extrasLabel;
    JLabel driverOptionLabel;
    JLabel driverLevelLabel;
    JLabel seatOptionLabel;
    JLabel tireChainLabel;
    JLabel roofBoxLabel;
    JLabel protectionLabel;


    JLabel driverPriceLabel;
    JLabel driverLevelPriceLabel;
    JLabel seatPriceLabel;
    JLabel tireChainPriceLabel;
    JLabel roofBoxPriceLabel;
    JLabel protectionPriceLabel;
    JLabel driverPriceLabel2;
    JLabel driverLevelPriceLabel2;
    JLabel seatPriceLabel2;
    JLabel tireChainPriceLabel2;
    JLabel roofBoxPriceLabel2;
    JLabel protectionPriceLabel2;
    JScrollPane carSelectionPane;
    ImageIcon logo;
    ButtonGroup driverOption = new ButtonGroup();
    ButtonGroup driverQuality = new ButtonGroup();
    ButtonGroup seatOption = new ButtonGroup();
    ButtonGroup tireChain = new ButtonGroup();
    ButtonGroup roofBox = new ButtonGroup();
    ButtonGroup protectionPackages = new ButtonGroup();

    public UserMainView(){

        this.setTitle("VeloCity");
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(248,239,217));

        logo = new ImageIcon("Velocity.png");
        this.setIconImage(logo.getImage());


        currentRentPanel = new JPanel();
        currentRentPanel.setBackground(new Color(248,239,217));

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
        carSelectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT,40,60));
        carSelectionPanel.setBackground(new Color(225, 211, 189));
        carSelectionPanel.setBounds(300,550,900,400);

        extrasPricePanel = new JPanel();
        extrasPricePanel.setLayout(new FlowLayout(FlowLayout.LEFT,60,52));
        extrasPricePanel.setBackground(new Color(225, 211, 189));
        extrasPricePanel.setBounds(50,300,200,650);

        driverPriceLabel = new JLabel("Driver Fee:");
        driverPriceLabel.setBounds(70,320,200,30);
        driverPriceLabel.setForeground(new Color(255,81,0));
        driverPriceLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        driverLevelPriceLabel = new JLabel("Experienced Driver:");
        driverLevelPriceLabel.setBounds(70,395,200,30);
        driverLevelPriceLabel.setForeground(new Color(255,81,0));
        driverLevelPriceLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        seatPriceLabel = new JLabel("Seat:");
        seatPriceLabel.setBounds(70,470,200,30);
        seatPriceLabel.setForeground(new Color(255,81,0));
        seatPriceLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        tireChainPriceLabel = new JLabel("Tire Chain:");
        tireChainPriceLabel.setBounds(70,545,200,30);
        tireChainPriceLabel.setForeground(new Color(255,81,0));
        tireChainPriceLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        roofBoxPriceLabel = new JLabel("Roof Box:");
        roofBoxPriceLabel.setBounds(70,625,200,30);
        roofBoxPriceLabel.setForeground(new Color(255,81,0));
        roofBoxPriceLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        protectionPriceLabel = new JLabel("Protection:");
        protectionPriceLabel.setBounds(70,700,200,30);
        protectionPriceLabel.setForeground(new Color(255,81,0));
        protectionPriceLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        driverPriceLabel2 = new JLabel("500 ₺");
        driverPriceLabel2.setBounds(70,350,200,30);
        driverPriceLabel2.setForeground(new Color(255,81,0));
        driverPriceLabel2.setFont(new Font("Metropolis",Font.PLAIN, 20));

        driverLevelPriceLabel2 = new JLabel("750 ₺");
        driverLevelPriceLabel2.setBounds(70,425,200,30);
        driverLevelPriceLabel2.setForeground(new Color(255,81,0));
        driverLevelPriceLabel2.setFont(new Font("Metropolis",Font.PLAIN, 20));

        seatPriceLabel2 = new JLabel("50 / 30 ₺");
        seatPriceLabel2.setBounds(70,500,200,30);
        seatPriceLabel2.setForeground(new Color(255,81,0));
        seatPriceLabel2.setFont(new Font("Metropolis",Font.PLAIN, 20));

        tireChainPriceLabel2 = new JLabel("10 ₺");
        tireChainPriceLabel2.setBounds(70,575,200,30);
        tireChainPriceLabel2.setForeground(new Color(255,81,0));
        tireChainPriceLabel2.setFont(new Font("Metropolis",Font.PLAIN, 20));

        roofBoxPriceLabel2 = new JLabel("40 ₺");
        roofBoxPriceLabel2.setBounds(70,655,200,30);
        roofBoxPriceLabel2.setForeground(new Color(255,81,0));
        roofBoxPriceLabel2.setFont(new Font("Metropolis",Font.PLAIN, 20));

        protectionPriceLabel2 = new JLabel("200 / 150 / 100 ₺");
        protectionPriceLabel2.setBounds(70,730,200,30);
        protectionPriceLabel2.setForeground(new Color(255,81,0));
        protectionPriceLabel2.setFont(new Font("Metropolis",Font.PLAIN, 20));

        extrasPanel = new JPanel();
        extrasPanel.setLayout(new FlowLayout(FlowLayout.LEFT,60,52));
        extrasPanel.setBackground(new Color(225, 211, 189));
        extrasPanel.setBounds(1300,300,300,650);

        driverOptionYes = new JRadioButton("Yes");
        driverOptionYes.setForeground(new Color(255,81,0));
        driverOptionYes.setBackground(new Color(248,239,217));

        driverOptionNo = new JRadioButton("No");
        driverOptionNo.setForeground(new Color(255,81,0));
        driverOptionNo.setBackground(new Color(248,239,217));

        extrasLabel = new JLabel("Extras");
        extrasLabel.setBounds(50,245,200,50);
        extrasLabel.setForeground(new Color(255,81,0));
        extrasLabel.setFont(new Font("Franklin Gothic Heavy",Font.BOLD, 50));

        driverOptionLabel = new JLabel("Driver:");
        driverOptionLabel.setBounds(1360,320,200,30);
        driverOptionLabel.setForeground(new Color(255,81,0));
        driverOptionLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        normalDriver = new JRadioButton("Normal");
        normalDriver.setForeground(new Color(255,81,0));
        normalDriver.setBackground(new Color(248,239,217));

        professionalDriver = new JRadioButton("Experienced");
        professionalDriver.setForeground(new Color(255,81,0));
        professionalDriver.setBackground(new Color(248,239,217));

        driverLevelLabel = new JLabel("Driver Preferences:");
        driverLevelLabel.setBounds(1360,395,200,30);
        driverLevelLabel.setForeground(new Color(255,81,0));
        driverLevelLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        childSeat = new JRadioButton("Child Seat");
        childSeat.setForeground(new Color(255,81,0));
        childSeat.setBackground(new Color(248,239,217));

        babySeat = new JRadioButton("Baby Seat");
        babySeat.setForeground(new Color(255,81,0));
        babySeat.setBackground(new Color(248,239,217));

        seatOptionLabel = new JLabel("Seat:");
        seatOptionLabel.setBounds(1360,470,200,30);
        seatOptionLabel.setForeground(new Color(255,81,0));
        seatOptionLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        tireChainYes = new JRadioButton("Yes");
        tireChainYes.setForeground(new Color(255,81,0));
        tireChainYes.setBackground(new Color(248,239,217));

        tireChainNo = new JRadioButton("No");
        tireChainNo.setForeground(new Color(255,81,0));
        tireChainNo.setBackground(new Color(248,239,217));

        tireChainLabel = new JLabel("Tire Chain:");
        tireChainLabel.setBounds(1360,545,200,30);
        tireChainLabel.setForeground(new Color(255,81,0));
        tireChainLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        roofBoxYes = new JRadioButton("Yes");
        roofBoxYes.setForeground(new Color(255,81,0));
        roofBoxYes.setBackground(new Color(248,239,217));

        roofBoxNo = new JRadioButton("No");
        roofBoxNo.setForeground(new Color(255,81,0));
        roofBoxNo.setBackground(new Color(248,239,217));

        roofBoxLabel = new JLabel("Roof Box:");
        roofBoxLabel.setBounds(1360,625,200,30);
        roofBoxLabel.setForeground(new Color(255,81,0));
        roofBoxLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        bigProtection = new JRadioButton("High");
        bigProtection.setForeground(new Color(255,81,0));
        bigProtection.setBackground(new Color(248,239,217));

        mediumProtection = new JRadioButton("Medium");
        mediumProtection.setForeground(new Color(255,81,0));
        mediumProtection.setBackground(new Color(248,239,217));

        additionalProtection = new JRadioButton("Additional");
        additionalProtection.setForeground(new Color(255,81,0));
        additionalProtection.setBackground(new Color(248,239,217));

        noProtection = new JRadioButton("No");
        noProtection.setForeground(new Color(255,81,0));
        noProtection.setBackground(new Color(248,239,217));

        protectionLabel = new JLabel("Protection:");
        protectionLabel.setBounds(1360,700,200,30);
        protectionLabel.setForeground(new Color(255,81,0));
        protectionLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        driverOption.add(driverOptionYes);
        driverOption.add(driverOptionNo);

        driverQuality.add(normalDriver);
        driverQuality.add(professionalDriver);

        seatOption.add(childSeat);
        seatOption.add(babySeat);

        tireChain.add(tireChainYes);
        tireChain.add(tireChainNo);

        roofBox.add(roofBoxYes);
        roofBox.add(roofBoxNo);

        protectionPackages.add(bigProtection);
        protectionPackages.add(mediumProtection);
        protectionPackages.add(additionalProtection);
        protectionPackages.add(noProtection);

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

        fuelTypeComboBox = new JComboBox(fuelType);
        fuelTypeComboBox.setFont(new Font("Metropolis", Font.PLAIN,20));
        fuelTypeComboBox.setForeground(new Color(255,81,0));

        brandLabel = new JLabel("Brand:");
        brandLabel.setBounds(340,550,300,50);
        brandLabel.setForeground(new Color(255,81,0));
        brandLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(520,550,300,50);
        categoryLabel.setForeground(new Color(255,81,0));
        categoryLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        colorLabel = new JLabel("Color:");
        colorLabel.setBounds(680,550,300,50);
        colorLabel.setForeground(new Color(255,81,0));
        colorLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        gearTypeLabel = new JLabel("Gear Type:");
        gearTypeLabel.setBounds(800,550,300,50);
        gearTypeLabel.setForeground(new Color(255,81,0));
        gearTypeLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        passengerAmountLabel = new JLabel("Passenger:");
        passengerAmountLabel.setBounds(950,550,300,50);
        passengerAmountLabel.setForeground(new Color(255,81,0));
        passengerAmountLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        fuelTypeLabel = new JLabel("Fuel Type:");
        fuelTypeLabel.setBounds(1060,550,300,50);
        fuelTypeLabel.setForeground(new Color(255,81,0));
        fuelTypeLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(1350,850,200,50);
        confirmButton.setBorderPainted(false);
        confirmButton.setFocusPainted(false);
        confirmButton.setBackground(new Color(255,81,0));
        confirmButton.setForeground(new Color(248,239,217));

        clearButton = new JButton("Clear");
        clearButton.setBounds(1380,910,140,30);
        clearButton.setBorderPainted(false);
        clearButton.setFocusPainted(false);
        clearButton.setBackground(new Color(102, 102, 102, 255));
        clearButton.setForeground(new Color(248,239,217));

        searchButton = new JButton("Search");
        searchButton.setBounds(675,950,200,50);
        searchButton.setBorderPainted(false);
        searchButton.setFocusPainted(false);
        searchButton.setBackground(new Color(255,81,0));
        searchButton.setForeground(new Color(248,239,217));

        carSelectionPanel.add(brandComboBox);
        carSelectionPanel.add(carTypeComboBox);
        carSelectionPanel.add(colorComboBox);
        carSelectionPanel.add(gearTypeComboBox);
        carSelectionPanel.add(passengerAmountComboBox);
        carSelectionPanel.add(fuelTypeComboBox);

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
        newRentPanel.add(fuelTypeLabel);
        newRentPanel.add(searchButton);
        newRentPanel.add(carSelectionPanel);
        newRentPanel.add(confirmButton);
        newRentPanel.add(clearButton);
        newRentPanel.add(extrasLabel);
        newRentPanel.add(driverOptionLabel);
        newRentPanel.add(driverLevelLabel);
        newRentPanel.add(seatOptionLabel);
        newRentPanel.add(roofBoxLabel);
        newRentPanel.add(tireChainLabel);
        newRentPanel.add(driverPriceLabel);
        newRentPanel.add(driverLevelPriceLabel);
        newRentPanel.add(seatPriceLabel);
        newRentPanel.add(tireChainPriceLabel);
        newRentPanel.add(roofBoxPriceLabel);
        newRentPanel.add(protectionPriceLabel);
        newRentPanel.add(driverPriceLabel2);
        newRentPanel.add(driverLevelPriceLabel2);
        newRentPanel.add(seatPriceLabel2);
        newRentPanel.add(tireChainPriceLabel2);
        newRentPanel.add(roofBoxPriceLabel2);
        newRentPanel.add(protectionPriceLabel2);
        newRentPanel.add(protectionLabel);
        newRentPanel.add(extrasPricePanel);
        newRentPanel.add(extrasPanel);


        extrasPanel.add(driverOptionYes);
        extrasPanel.add(driverOptionNo);
        extrasPanel.add(normalDriver);
        extrasPanel.add(professionalDriver);
        extrasPanel.add(childSeat);
        extrasPanel.add(babySeat);
        extrasPanel.add(tireChainYes);
        extrasPanel.add(tireChainNo);
        extrasPanel.add(roofBoxYes);
        extrasPanel.add(roofBoxNo);
        extrasPanel.add(bigProtection);
        extrasPanel.add(mediumProtection);
        extrasPanel.add(additionalProtection);
        extrasPanel.add(noProtection);


        optionBar = new JTabbedPane();
        optionBar.setBounds(0,0,1920,1080);
        optionBar.setForeground(new Color(255,81,0));
        optionBar.setBackground(new Color(248,239,217));
        optionBar.add("Current Rent", currentRentPanel);
        optionBar.add("New Rent",newRentPanel);

        this.add(optionBar);
        this.setVisible(false);
        getProfessionalDriver().setEnabled(false);
        getNormalDriver().setEnabled(false);

    }

    public void createTable(){
        rentListTable = new JTable(data,columnNames);
        rentListTable.getTableHeader().setReorderingAllowed(false);
        rentListTable.getTableHeader().setResizingAllowed(false);
        rentListTable.setDefaultEditor(Object.class, null);
        scrollPane = new JScrollPane(rentListTable);
        currentRentPanel.add(scrollPane);
    }

    public void createCarTable(){
        carListTable = new JTable(carData,carColumnNames);
        carListTable.getTableHeader().setReorderingAllowed(false);
        carListTable.getTableHeader().setResizingAllowed(false);
        carListTable.setDefaultEditor(Object.class, null);
        carSelectionPane = new JScrollPane(carListTable);
        carSelectionPane.setPreferredSize(new Dimension(790,220));
        carSelectionPanel.add(carSelectionPane);
        carSelectionPanel.setVisible(false);
        carSelectionPanel.setVisible(true);
        carListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void clearCarTable(){
        if(carListTable != null){
            carSelectionPanel.remove(carSelectionPane);
        }
    }

    public void clearReservationTable(){
        currentRentPanel.remove(scrollPane);
    }
    
    public void setExtrasPanelVisibilityFalse(){
        extrasPanel.setVisible(false);
        confirmButton.setVisible(false);
        driverLevelLabel.setVisible(false);
        driverOptionLabel.setVisible(false);
        seatOptionLabel.setVisible(false);
        tireChainLabel.setVisible(false);
        roofBoxLabel.setVisible(false);
        protectionLabel.setVisible(false);
        clearButton.setVisible(false);
    }
    public void setExtrasPanelVisibilityTrue(){
        extrasPanel.setVisible(true);
        confirmButton.setVisible(true);
        driverLevelLabel.setVisible(true);
        driverOptionLabel.setVisible(true);
        seatOptionLabel.setVisible(true);
        tireChainLabel.setVisible(true);
        roofBoxLabel.setVisible(true);
        protectionLabel.setVisible(true);
        clearButton.setVisible(true);

    }

    public JPanel getCurrentRentPanel() {
        return currentRentPanel;
    }

    public JPanel getCarSelectionPanel() {
        return carSelectionPanel;
    }

    public JTabbedPane getOptionBar() {
        return optionBar;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public JComboBox getPickUpPlace() {
        return pickUpPlace;
    }

    public JComboBox getDeliveryPlace() {
        return deliveryPlace;
    }

    public JComboBox getPickUpDateDay() {
        return pickUpDateDay;
    }

    public JComboBox getPickUpDateMonth() {
        return pickUpDateMonth;
    }

    public JComboBox getPickUpDateYear() {
        return pickUpDateYear;
    }

    public JComboBox getDeliveryDateDay() {
        return deliveryDateDay;
    }

    public JComboBox getDeliveryDateMonth() {
        return deliveryDateMonth;
    }

    public JComboBox getDeliveryDateYear() {
        return deliveryDateYear;
    }

    public JComboBox getGearTypeComboBox() {
        return gearTypeComboBox;
    }

    public JComboBox getColorComboBox() {
        return colorComboBox;
    }

    public JComboBox getBrandComboBox() {
        return brandComboBox;
    }

    public JComboBox getCarTypeComboBox() {
        return carTypeComboBox;
    }

    public JComboBox getPassengerAmountComboBox() {
        return passengerAmountComboBox;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JRadioButton getDriverOptionYes() {
        return driverOptionYes;
    }

    public JRadioButton getDriverOptionNo() {
        return driverOptionNo;
    }

    public void setCarData(String[][] carData) {
        this.carData = carData;
    }

    public JTable getCarListTable() {
        return carListTable;
    }

    public JComboBox getFuelTypeComboBox() {
        return fuelTypeComboBox;
    }

    public JRadioButton getNormalDriver() {
        return normalDriver;
    }

    public JRadioButton getProfessionalDriver() {
        return professionalDriver;
    }

    public JRadioButton getTireChainYes() {
        return tireChainYes;
    }

    public JRadioButton getTireChainNo() {
        return tireChainNo;
    }

    public JRadioButton getChildSeat() {
        return childSeat;
    }

    public JRadioButton getBabySeat() {
        return babySeat;
    }

    public JRadioButton getRoofBoxYes() {
        return roofBoxYes;
    }

    public JRadioButton getRoofBoxNo() {
        return roofBoxNo;
    }

    public JRadioButton getBigProtection() {
        return bigProtection;
    }

    public JRadioButton getMediumProtection() {
        return mediumProtection;
    }

    public JRadioButton getAdditionalProtection() {
        return additionalProtection;
    }

    public JRadioButton getNoProtection() {
        return noProtection;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public ButtonGroup getDriverOption() {
        return driverOption;
    }

    public ButtonGroup getDriverQuality() {
        return driverQuality;
    }

    public ButtonGroup getSeatOption() {
        return seatOption;
    }

    public ButtonGroup getTireChain() {
        return tireChain;
    }

    public ButtonGroup getRoofBox() {
        return roofBox;
    }

    public ButtonGroup getProtectionPackages() {
        return protectionPackages;
    }

}
