import Objects.*;
import View.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Controller implements ActionListener, MouseListener {

    private Model model;
    private View view;
    int pDay,pMonth,pYear,dDay,dMonth,dYear;
    Date pickupDate,deliverDate;
    int driverIdtobeAssigned=-1;


    public Controller(Model model, View view) throws SQLException {
        this.model = model;
        this.view = view;
        addActionListenerToButtons();
        addMouseListener();
        model.addPaymentInformation("1234","123","1928","06","2",model.getUserArrayList().get(0));
    }

    public void addActionListenerToButtons(){
        for(int i = 0; i<view.getButtons().size(); i++){
           // System.out.println("aağğ");
            view.getButtons().get(i).addActionListener(this);
        }
    }
    public void addMouseListener(){
        for(int i = 0; i<view.getcBoxes().size(); i++){
            view.getcBoxes().get(i).addMouseListener(this);
        }
    }

    /**
     * burda kullanıcı ne yapmış nelere basmış kontrol edip ona göre modelin fonksiyonlarını kullanıcaz
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        SignUpView signUpView = view.getsView();
        LoginView lv = view.getlView();
        UserMainView userMainView = view.getuView();
        PaymentInformationView paymentView = view.getpView();

        if(e.getSource()==signUpView.getSignUpButton()){

            String username = signUpView.getUserNameTextField().getText();
            String password = signUpView.getPasswordTextField().getText();
            String passwordCheck = signUpView.getPasswordCheckTextField().getText();
            String nameSurname = signUpView.getUserNameTextField().getText();
            String eMail = signUpView.getMailTextField().getText();
            String phoneNumber = signUpView.getPhoneNumberTextField().getText();
            String age = signUpView.getBirthdayTextField().getText();
            String gender=null;
            if(signUpView.getFemaleButton().isSelected()){
                gender="female";
            }else if(signUpView.getMaleButton().isSelected()){
                gender="male";
            }

            try {
                if(model.signUp(username, password, passwordCheck, eMail, age, phoneNumber, gender)==true){
                    signUpView.setVisible(false);
                    lv.getPasswordTextField().setText("");
                    lv.getUserNameTextField().setText("");
                    lv.setVisible(true);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }


        if(e.getSource()==lv.getLogInButton()){
            String username=lv.getUserNameTextField().getText();
            String password=lv.getPasswordTextField().getText();
            try {
                if(model.logIn(username,password)==true){
                    lv.setVisible(false);
                    //Reservation list
                    ArrayList<String> tempList = getUsersReservations(username);
                    String[][] tempArray = getData(tempList);
                    userMainView.setData(tempArray);
                    userMainView.createTable();
                    userMainView.setVisible(true);
                    view.getuView().setExtrasPanelVisibilityFalse();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            lv.getPasswordTextField().setText("");
            lv.getUserNameTextField().setText("");
        }



        if(e.getSource()==lv.getSignUpButton()){
            lv.setVisible(false);
            signUpView.getUserNameTextField().setText("");
            signUpView.getPasswordTextField().setText("");
            signUpView.getPasswordCheckTextField().setText("");
            signUpView.getPhoneNumberTextField().setText("");
            signUpView.getMailTextField().setText("");
            signUpView.getBirthdayTextField().setText("");
            signUpView.getGenderButton().clearSelection();
            signUpView.setVisible(true);
        }
        if(e.getSource()instanceof JComboBox)
            view.getuView().clearCarTable();
        if(e.getSource()==userMainView.getSearchButton()){
             pDay = Integer.parseInt(userMainView.getPickUpDateDay().getSelectedItem().toString());
             pMonth = Integer.parseInt(userMainView.getPickUpDateMonth().getSelectedItem().toString());
             pYear = Integer.parseInt(userMainView.getPickUpDateYear().getSelectedItem().toString());
             dDay= Integer.parseInt(userMainView.getDeliveryDateDay().getSelectedItem().toString());
             dMonth= Integer.parseInt(userMainView.getDeliveryDateMonth().getSelectedItem().toString());
             dYear= Integer.parseInt(userMainView.getDeliveryDateYear().getSelectedItem().toString());
             pickupDate = new Date(pYear - 1900, pMonth-1, pDay);
             deliverDate = new Date(dYear - 1900, dMonth-1, dDay);
            int passenger;
            if(userMainView.getPassengerAmountComboBox().getSelectedItem().toString().equals("ALL")){
                passenger=-1;
            }
            else{
                 passenger= Integer.parseInt(userMainView.getPassengerAmountComboBox().getSelectedItem().toString());
            }

            String brand=userMainView.getBrandComboBox().getSelectedItem().toString();
            String color=userMainView.getColorComboBox().getSelectedItem().toString();
            String category=userMainView.getCarTypeComboBox().getSelectedItem().toString();
            String gearType=userMainView.getGearTypeComboBox().getSelectedItem().toString();
            String fuelType=userMainView.getFuelTypeComboBox().getSelectedItem().toString();
            LocalDate startDate = LocalDate.of(pYear, pMonth, pDay); // Example start date
            LocalDate returnDate = LocalDate.of(dYear, dMonth, dDay); // Example return date
            if(startDate.isBefore(returnDate)){
                try {
                    ArrayList<Vehicle> tempCars = model.showFilteredCars(model.filterCars(brand,category,color,gearType,fuelType,passenger,pickupDate,deliverDate));
                    String[][] tempCarsData = carsToTable(tempCars);
                    userMainView.setCarData(tempCarsData);
                    userMainView.clearCarTable();
                    userMainView.createCarTable();
                    view.getuView().setExtrasPanelVisibilityTrue();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else{
                System.out.println("Dates are not valid.");
                JOptionPane.showMessageDialog(new JFrame(),"!! PLEASE ENTER A VALID DATE !!");
            }
        }




        if(e.getSource() == userMainView.getConfirmButton()){
            boolean validation=false;
            boolean isExperienced=false;
            boolean hasDriver=false;
            if(view.getuView().getDriverOptionYes().isSelected()){
                hasDriver=true;
                if(view.getuView().getNormalDriver().isSelected()){
                    isExperienced=false;
                }
                if(view.getuView().getProfessionalDriver().isSelected()){
                    isExperienced=true;
                }
            }

                if(hasDriver){
                    try {
                        driverIdtobeAssigned= model.validateDriver(pickupDate,deliverDate,isExperienced);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if(driverIdtobeAssigned!=-1){
                        JOptionPane.showMessageDialog(new JFrame(),driverIdtobeAssigned);
                    }
                }

            if(userMainView.getCarListTable()==null){
                JOptionPane.showMessageDialog(new JFrame(),"!! FIRST SEARCH A CAR AND THEN SELECT ONE !!");
            }
            else if(hasDriver&& driverIdtobeAssigned==-1){
                String s;
                if(isExperienced)
                    s="EXPERIENCED";
                else{
                    s="NORMAL";
                }
                JOptionPane.showMessageDialog(new JFrame(),"THERE IS NO " +s+ " DRIVER AVAILABLE BETWEEN THE DATES YOU'VE ENTERED!!");
            }
            else if(userMainView.getCarListTable().getSelectedRowCount() < 1){
                JOptionPane.showMessageDialog(new JFrame(),"!! PLEASE SELECT A CAR !!");
            }else {
                String selectedDriver = null;
                String selectedDriverPreference = null;
                String selectedSeat = null;
                String selectedTireChain = null;
                String selectedRoofBox = null;
                String selectedProtection = null;
                if (1 == 1 /* get selected radio buttons function here */) {
                    ////////////////////////////////////////////////////////////
                    if (userMainView.getDriverOptionNo().isSelected()) {
                        selectedDriver = "No";
                    } else if (userMainView.getDriverOptionYes().isSelected()) {
                        selectedDriver = "Yes";
                    }
                    ////////////////////////////////////////////////////////////
                    if (userMainView.getNormalDriver().isSelected()) {
                        selectedDriverPreference = "Normal";
                    } else if (userMainView.getProfessionalDriver().isSelected()) {
                        selectedDriverPreference = "Experienced";
                    }
                    ////////////////////////////////////////////////////////////
                    if (userMainView.getBabySeat().isSelected()) {
                        selectedSeat = "Baby";
                    } else if (userMainView.getChildSeat().isSelected()) {
                        selectedSeat = "Child";
                    }
                    ////////////////////////////////////////////////////////////
                    if (userMainView.getTireChainYes().isSelected()) {
                        selectedTireChain = new String("sa");
                    } else if (userMainView.getTireChainNo().isSelected()) {
                        selectedTireChain = "No";
                    }
                    ////////////////////////////////////////////////////////////
                    if (userMainView.getRoofBoxYes().isSelected()) {
                        selectedRoofBox = "Yes";
                    } else if (userMainView.getRoofBoxNo().isSelected()) {
                        selectedRoofBox = "No";
                    }
                    ////////////////////////////////////////////////////////////
                    if (userMainView.getBigProtection().isSelected()) {
                        selectedProtection = "High";
                    } else if (userMainView.getMediumProtection().isSelected()) {
                        selectedProtection = "Medium";
                    } else if (userMainView.getAdditionalProtection().isSelected()) {
                        selectedProtection = "Additional";
                    } else if (userMainView.getNoProtection().isSelected()) {
                        selectedProtection = "No";
                    }
                }

                if (model.extrasValidation(selectedDriver, selectedDriverPreference, selectedSeat, selectedTireChain, selectedRoofBox, selectedProtection)) {
                    System.out.println("TEST " + userMainView.getCarListTable().getValueAt(userMainView.getCarListTable().getSelectedRow(), 0));
                    userMainView.setVisible(false);
                    paymentView.setVisible(true);
                }
            }
        }

        if(e.getSource()==userMainView.getClearButton()){
            clearExtrasSelections(userMainView);
        }




        if(e.getSource()==paymentView.getConfirmButton()){
            String nameOnTheCard = paymentView.getNameOnCardTextField().getText();
            String cardNumber = paymentView.getCardNumberTextField().getText();
            String cvv = paymentView.getCvvTextField().getText();
            String promotionCode = paymentView.getPromotionCodeTextField().getText();
            String lastDateYear = Objects.requireNonNull(paymentView.getYearComboBox().getSelectedItem()).toString();
            String lastDateMonth = Objects.requireNonNull(paymentView.getMonthComboBox().getSelectedItem()).toString();

            if(model.paymentValidation(nameOnTheCard, cardNumber, cvv, promotionCode)){
                System.out.println("successful rent");
                paymentView.setVisible(false);
                String username = "";
                User user = null;
                for(int i = 0; i< model.getUserArrayList().size();i++){
                    if(model.getUserArrayList().get(i).getUserId() == (model.getLoggedUserId())){
                        username = model.getUserArrayList().get(i).getUsername();
                        user = model.getUserArrayList().get(i);
                    }
                }
                int vehicleId = -1;
                for(int j = 0; j<model.getVehicleArrayList().size();j++){
                    if(model.getVehicleArrayList().get(j).getModel().equals(userMainView.getCarListTable().getValueAt(userMainView.getCarListTable().getSelectedRow(), 0))){
                        vehicleId = model.getVehicleArrayList().get(j).getVehicleId();
                    }
                }
                try {
                    assert user != null;
                    model.addPaymentInformation(cardNumber,cvv,lastDateYear,lastDateMonth,"2",user);
                   int reservationId= model.addReservation(new Date(Integer.parseInt((Objects.requireNonNull(userMainView.getPickUpDateYear().getSelectedItem())).toString())-1900
                                    ,Integer.parseInt(Objects.requireNonNull(userMainView.getPickUpDateMonth().getSelectedItem()).toString()) -1
                                    ,Integer.parseInt(Objects.requireNonNull(userMainView.getPickUpDateDay().getSelectedItem()).toString()))
                            , new Date(Integer.parseInt(Objects.requireNonNull(userMainView.getDeliveryDateYear().getSelectedItem()).toString())-1900
                                    ,Integer.parseInt(Objects.requireNonNull(userMainView.getDeliveryDateMonth().getSelectedItem()).toString()) -1
                                    ,Integer.parseInt(Objects.requireNonNull(userMainView.getDeliveryDateDay().getSelectedItem()).toString()))
                            , Objects.requireNonNull(userMainView.getPickUpPlace().getSelectedItem()).toString()
                            , Objects.requireNonNull(userMainView.getDeliveryPlace().getSelectedItem()).toString()
                            , 1
                            , Double.parseDouble(userMainView.getCarListTable().getValueAt(userMainView.getCarListTable().getSelectedRow(), 7).toString())
                            , model.getLoggedUserId()
                            , vehicleId);
                    System.out.println(driverIdtobeAssigned);
                    if(driverIdtobeAssigned!=-1){
                        model.assignDriver(driverIdtobeAssigned,reservationId);
                        System.out.println("olm niye olmuyor");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                userMainView.clearReservationTable();
                ArrayList<String> tempList = getUsersReservations(username);
                String[][] tempArray = getData(tempList);
                userMainView.setData(tempArray);
                userMainView.createTable();


                ArrayList<Integer> chosenExtras = getChosenExtras(userMainView);
                int resID = model.getReservationArrayList().get(model.getReservationArrayList().size()-1).getReservationId();
                try {
                    model.addExtrastoReservation(resID,chosenExtras);
                    for(int l=0;l<chosenExtras.size();l++){
                        model.getReservationExtrasArrayList().add(new ReservationExtras(resID,chosenExtras.get(l)));
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                userMainView.setVisible(true);
            }

        }



        if(e.getSource()==paymentView.getBackButton()){
            userMainView.clearCarTable();
            view.getuView().setExtrasPanelVisibilityFalse();
            paymentView.getCardNumberTextField().setText("");
            paymentView.getCvvTextField().setText("");
            paymentView.getNameOnCardTextField().setText("");
            paymentView.getPromotionCodeTextField().setText("");
            paymentView.setVisible(false);
            userMainView.setVisible(true);
        }
    }

    public ArrayList<String> getUsersReservations(String username){
        ArrayList<String> data = new ArrayList<>();
        for(int i = 0; i<model.getReservationArrayList().size(); i++){
            Reservation r = model.getReservationArrayList().get(i);
            if(model.getLoggedUserId() == r.getUserId()){
                for(int j = 0; j<model.getVehicleArrayList().size(); j++){
                    Vehicle v = model.getVehicleArrayList().get(j);
                    if(r.getVehicleId() == v.getVehicleId()){
                        data.add(v.getModel());
                        data.add(r.getPickupLocation());
                        data.add(r.getReturnLocation());
                        data.add(r.getPickupDate().toString());
                        data.add(r.getReturnDate().toString());
                    }
                }
            }
        }
        return data;
    }

    public String[][] getData(ArrayList<String> data){
        String[][] dataArray = new String[data.size()/5][5];
        int counter = 0, columnCounter = 0;
        for(int i = 0; i<data.size(); i++){
            dataArray[columnCounter][counter] = data.get(i);
            counter++;
            if(counter % 5 == 0){
                columnCounter++;
                counter = 0;
            }
        }
        return dataArray;
    }

    public String[][] carsToTable(ArrayList<Vehicle> vehicles){
        String[][] carArray = new String[vehicles.size()][8];
        for(int i = 0; i<vehicles.size(); i++){
            carArray[i][0] = vehicles.get(i).getModel();
            carArray[i][1] = vehicles.get(i).getBrand();
            carArray[i][2] = vehicles.get(i).getColor();
            carArray[i][3] = vehicles.get(i).getGearType();
            carArray[i][4] = vehicles.get(i).getCarType();
            carArray[i][5] = vehicles.get(i).getFuelType();
            carArray[i][6] = vehicles.get(i).getPassengerAmount();
            carArray[i][7] = vehicles.get(i).getDailyPrice();
        }
        return carArray;
    }

    public ArrayList<Integer> getChosenExtras(UserMainView userMainView){
        ArrayList<Integer> extraIds = new ArrayList<>();
        if(userMainView.getBabySeat().isSelected()){
            extraIds.add(5);
        }
        if(userMainView.getChildSeat().isSelected()){
            extraIds.add(4);
        }
        if(userMainView.getRoofBoxYes().isSelected()){
            extraIds.add(6);
        }
        if(userMainView.getTireChainYes().isSelected()){
            extraIds.add(7);
        }
        if(userMainView.getBigProtection().isSelected()){
            extraIds.add(1);
        }
        if(userMainView.getMediumProtection().isSelected()){
            extraIds.add(2);
        }
        if(userMainView.getAdditionalProtection().isSelected()){
            extraIds.add(3);
        }
        return extraIds;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        view.getuView().clearCarTable();
        view.getuView().getCarSelectionPanel().setVisible(false);
        view.getuView().getCarSelectionPanel().setVisible(true);
        view.getuView().setExtrasPanelVisibilityFalse();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void clearExtrasSelections(UserMainView userMainView){
        userMainView.getDriverOption().clearSelection();
        userMainView.getRoofBox().clearSelection();
        userMainView.getTireChain().clearSelection();
        userMainView.getDriverQuality().clearSelection();
        userMainView.getProtectionPackages().clearSelection();
        userMainView.getSeatOption().clearSelection();
    }

}
