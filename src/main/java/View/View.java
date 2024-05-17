package View;

import javax.swing.*;
import java.util.ArrayList;

public class View extends JFrame {
    LoginView lView=new LoginView();
    SignUpView sView = new SignUpView();
    UserMainView uView = new UserMainView();
    PaymentInformationView pView = new PaymentInformationView();
    ArrayList<JButton> buttons=new ArrayList<JButton>();
    ArrayList<JComboBox> cBoxes=new ArrayList<JComboBox>();

    public View() {
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtonsToArrayList();
        addComboBoxesToArrayList();
    }

    public void addButtonsToArrayList(){
        buttons.add(sView.getSignUpButton());
        buttons.add(lView.getLogInButton());
        buttons.add(pView.getConfirmButton());
        buttons.add(pView.getBackButton());
        buttons.add(lView.getSignUpButton());
        buttons.add(uView.getSearchButton());
        buttons.add(uView.getConfirmButton());
        buttons.add(uView.getClearButton());
        buttons.add(pView.applyDiscountButton);
    }
    public void addComboBoxesToArrayList(){
        cBoxes.add(uView.getBrandComboBox());
        cBoxes.add(uView.getColorComboBox());
        cBoxes.add(uView.getFuelTypeComboBox());
        cBoxes.add(uView.getCarTypeComboBox());
        cBoxes.add(uView.getPickUpDateDay());
        cBoxes.add(uView.getPickUpDateMonth());
        cBoxes.add(uView.getPickUpDateYear());
        cBoxes.add(uView.getDeliveryDateDay());
        cBoxes.add(uView.getDeliveryDateMonth());
        cBoxes.add(uView.getDeliveryDateYear());
        cBoxes.add(uView.getPickUpPlace());
        cBoxes.add(uView.getDeliveryPlace());
        cBoxes.add(uView.getPassengerAmountComboBox());
        cBoxes.add(uView. getGearTypeComboBox());
    }
    public LoginView getlView() {
        return lView;
    }

    public SignUpView getsView() {
        return sView;
    }

    public UserMainView getuView() {
        return uView;
    }

    public PaymentInformationView getpView() {
        return pView;
    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }

    public ArrayList<JComboBox> getcBoxes() {
        return cBoxes;
    }
}
