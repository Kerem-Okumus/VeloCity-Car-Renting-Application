package View;

import javax.swing.*;
import java.util.ArrayList;

public class View extends JFrame {
    LoginView lView=new LoginView();
    SignUpView sView = new SignUpView();
    UserMainView uView = new UserMainView();
    PaymentInformationView pView = new PaymentInformationView();
    ArrayList<JButton> buttons=new ArrayList<JButton>();

    public View() {
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtonsToArrayList();
    }

    public void addButtonsToArrayList(){
        buttons.add(sView.getSignUpButton());
        buttons.add(lView.getLogInButton());
        buttons.add(pView.getConfirmButton());
        buttons.add(lView.getSignUpButton());
    }
    public LoginView getlView() {
        return lView;
    }

    public SignUpView getsView() {
        return sView;
    }

    public PaymentInformationView getpView() {
        return pView;
    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }

}
