package View;

import javax.swing.*;
import java.awt.*;

public class UserMainView extends JFrame{

    JPanel currentRentPanel;
    JPanel newRentPanel;
    JPanel carSelectionPanel;
    JPanel driverPanel;
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
    JLabel fuelTypeLabel;
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

        driverPanel = new JPanel();
        driverPanel.setLayout(new FlowLayout(FlowLayout.LEFT,70,100));
        driverPanel.setBackground(new Color(225, 211, 189));
        driverPanel.setBounds(1300,300,300,650);



        driverOptionYes = new JRadioButton("Yes");
        driverOptionYes.setBounds(800,670,100,20);
        driverOptionYes.setForeground(new Color(255,81,0));
        driverOptionYes.setBackground(new Color(248,239,217));


        driverOptionNo = new JRadioButton("No");
        driverOptionNo.setBounds(900,670,100,20);
        driverOptionNo.setForeground(new Color(255,81,0));
        driverOptionNo.setBackground(new Color(248,239,217));

        driverOption.add(driverOptionYes);
        driverOption.add(driverOptionNo);

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

        fuelTypeLabel = new JLabel("Fuel T:");
        fuelTypeLabel.setBounds(1060,550,300,50);
        fuelTypeLabel.setForeground(new Color(255,81,0));
        fuelTypeLabel.setFont(new Font("Metropolis",Font.PLAIN, 20));

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(1350,850,200,50);
        confirmButton.setBorderPainted(false);
        confirmButton.setFocusPainted(false);
        confirmButton.setBackground(new Color(255,81,0));
        confirmButton.setForeground(new Color(248,239,217));

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
        newRentPanel.add(driverPanel);


        driverPanel.add(driverOptionYes);
        driverPanel.add(driverOptionNo);


        optionBar = new JTabbedPane();
        optionBar.setBounds(0,0,1920,1080);
        optionBar.setForeground(new Color(255,81,0));
        optionBar.setBackground(new Color(248,239,217));
        optionBar.add("Current Rent", currentRentPanel);
        optionBar.add("New Rent",newRentPanel);

        this.add(optionBar);
        this.setVisible(true);


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
    }

    public void clearCarTable(){
        if(carListTable != null){
            carSelectionPanel.remove(carSelectionPane);
        }
    }

    public JPanel getCurrentRentPanel() {
        return currentRentPanel;
    }

    public void setCurrentRentPanel(JPanel currentRentPanel) {
        this.currentRentPanel = currentRentPanel;
    }

    public JPanel getNewRentPanel() {
        return newRentPanel;
    }

    public void setNewRentPanel(JPanel newRentPanel) {
        this.newRentPanel = newRentPanel;
    }

    public JPanel getCarSelectionPanel() {
        return carSelectionPanel;
    }

    public void setCarSelectionPanel(JPanel carSelectionPanel) {
        this.carSelectionPanel = carSelectionPanel;
    }

    public JPanel getDriverPanel() {
        return driverPanel;
    }

    public void setDriverPanel(JPanel driverPanel) {
        this.driverPanel = driverPanel;
    }

    public JTabbedPane getOptionBar() {
        return optionBar;
    }

    public void setOptionBar(JTabbedPane optionBar) {
        this.optionBar = optionBar;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public JTable getRentListTable() {
        return rentListTable;
    }

    public void setRentListTable(JTable rentListTable) {
        this.rentListTable = rentListTable;
    }

    public String[] getPlace() {
        return place;
    }

    public void setPlace(String[] place) {
        this.place = place;
    }

    public String[] getDay() {
        return day;
    }

    public void setDay(String[] day) {
        this.day = day;
    }

    public String[] getMonth() {
        return month;
    }

    public void setMonth(String[] month) {
        this.month = month;
    }

    public String[] getYear() {
        return year;
    }

    public void setYear(String[] year) {
        this.year = year;
    }

    public JComboBox getPickUpPlace() {
        return pickUpPlace;
    }

    public void setPickUpPlace(JComboBox pickUpPlace) {
        this.pickUpPlace = pickUpPlace;
    }

    public JComboBox getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(JComboBox deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public JComboBox getPickUpDateDay() {
        return pickUpDateDay;
    }

    public void setPickUpDateDay(JComboBox pickUpDateDay) {
        this.pickUpDateDay = pickUpDateDay;
    }

    public JComboBox getPickUpDateMonth() {
        return pickUpDateMonth;
    }

    public void setPickUpDateMonth(JComboBox pickUpDateMonth) {
        this.pickUpDateMonth = pickUpDateMonth;
    }

    public JComboBox getPickUpDateYear() {
        return pickUpDateYear;
    }

    public void setPickUpDateYear(JComboBox pickUpDateYear) {
        this.pickUpDateYear = pickUpDateYear;
    }

    public JComboBox getDeliveryDateDay() {
        return deliveryDateDay;
    }

    public void setDeliveryDateDay(JComboBox deliveryDateDay) {
        this.deliveryDateDay = deliveryDateDay;
    }

    public JComboBox getDeliveryDateMonth() {
        return deliveryDateMonth;
    }

    public void setDeliveryDateMonth(JComboBox deliveryDateMonth) {
        this.deliveryDateMonth = deliveryDateMonth;
    }

    public JComboBox getDeliveryDateYear() {
        return deliveryDateYear;
    }

    public void setDeliveryDateYear(JComboBox deliveryDateYear) {
        this.deliveryDateYear = deliveryDateYear;
    }

    public JComboBox getGearTypeComboBox() {
        return gearTypeComboBox;
    }

    public void setGearTypeComboBox(JComboBox gearTypeComboBox) {
        this.gearTypeComboBox = gearTypeComboBox;
    }

    public String[] getGear() {
        return gear;
    }

    public void setGear(String[] gear) {
        this.gear = gear;
    }

    public JComboBox getColorComboBox() {
        return colorComboBox;
    }

    public void setColorComboBox(JComboBox colorComboBox) {
        this.colorComboBox = colorComboBox;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public JComboBox getBrandComboBox() {
        return brandComboBox;
    }

    public void setBrandComboBox(JComboBox brandComboBox) {
        this.brandComboBox = brandComboBox;
    }

    public String[] getBrand() {
        return brand;
    }

    public void setBrand(String[] brand) {
        this.brand = brand;
    }

    public JComboBox getCarTypeComboBox() {
        return carTypeComboBox;
    }

    public void setCarTypeComboBox(JComboBox carTypeComboBox) {
        this.carTypeComboBox = carTypeComboBox;
    }

    public String[] getCarType() {
        return carType;
    }

    public void setCarType(String[] carType) {
        this.carType = carType;
    }

    public JComboBox getPassengerAmountComboBox() {
        return passengerAmountComboBox;
    }

    public void setPassengerAmountComboBox(JComboBox passengerAmountComboBox) {
        this.passengerAmountComboBox = passengerAmountComboBox;
    }

    public String[] getPassengerAmount() {
        return passengerAmount;
    }

    public void setPassengerAmount(String[] passengerAmount) {
        this.passengerAmount = passengerAmount;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(JButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    public JRadioButton getDriverOptionYes() {
        return driverOptionYes;
    }

    public void setDriverOptionYes(JRadioButton driverOptionYes) {
        this.driverOptionYes = driverOptionYes;
    }

    public JRadioButton getDriverOptionNo() {
        return driverOptionNo;
    }

    public void setDriverOptionNo(JRadioButton driverOptionNo) {
        this.driverOptionNo = driverOptionNo;
    }

    public String[][] getCarData() {
        return carData;
    }

    public void setCarData(String[][] carData) {
        this.carData = carData;
    }

    public JTable getCarListTable() {
        return carListTable;
    }
}
