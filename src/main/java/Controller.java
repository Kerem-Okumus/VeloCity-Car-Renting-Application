import Objects.User;
import View.*;
import java.time.LocalDate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class Controller implements ActionListener {

    private Model model;
    private View view;

    public Controller(Model model, View view) throws SQLException {
        this.model = model;
        this.view = view;
        addActionListenerToButtons();
        model.addPaymentInformation("1234","123","1928","06","2",model.getUserArrayList().get(0));
    }

    public void addActionListenerToButtons(){
        for(int i = 0; i<view.getButtons().size(); i++){
            view.getButtons().get(i).addActionListener(this);
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
        if(e.getSource()==signUpView.getSignUpButton()){
            User newUser = new User(
                    signUpView.getUserNameTextField().getText(),signUpView.getPasswordTextField().getText(),
                    signUpView.getUserNameTextField().getText(),signUpView.getMailTextField().getText(),22,
                    signUpView.getPhoneNumberTextField().getText(),"male","12341231411"
            );
            model.addUser(newUser);
            signUpView.setVisible(false);
            lv.getPasswordTextField().setText("");
            lv.getUserNameTextField().setText("");
            lv.setVisible(true);
        }

        if(e.getSource()==lv.getLogInButton()){
            String username=lv.getUserNameTextField().getText();
            String password=lv.getPasswordTextField().getText();
            try {
                if(model.logIn(username,password)==true){
                    lv.setVisible(false);
                    userMainView.setVisible(true);
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
        if(e.getSource()==userMainView.getSearchButton()){
            int pDay = Integer.parseInt(userMainView.getPickUpDateDay().getSelectedItem().toString());
            int pMonth = Integer.parseInt(userMainView.getPickUpDateMonth().getSelectedItem().toString());
            int pYear = Integer.parseInt(userMainView.getPickUpDateYear().getSelectedItem().toString());
            int dDay= Integer.parseInt(userMainView.getDeliveryDateDay().getSelectedItem().toString());
            int dMonth= Integer.parseInt(userMainView.getDeliveryDateMonth().getSelectedItem().toString());
            int dYear= Integer.parseInt(userMainView.getDeliveryDateYear().getSelectedItem().toString());
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
            LocalDate startDate = LocalDate.of(pYear, pMonth, pDay); // Example start date
            LocalDate returnDate = LocalDate.of(dYear, dMonth, dDay); // Example return date
            if(startDate.isBefore(returnDate)){
                try {
                    System.out.println("--------------------------------");
                    model.showFilteredCars(model.filterCars(brand,category,color,gearType,passenger,pDay,pMonth,pYear,dDay,dMonth,dYear));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else{
                System.out.println("Dates are not valid.");
            }

        }
    }
}
