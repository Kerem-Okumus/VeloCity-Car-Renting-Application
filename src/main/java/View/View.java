package View;

import javax.swing.*;
import java.util.ArrayList;

public class View extends JFrame {
    LoginView lView=new LoginView();
    SignUpView sView=new SignUpView();
    ArrayList<JButton> buttons=new ArrayList<JButton>();

    public View() {
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtonsToArrayList();
    }

    public void addButtonsToArrayList(){
        buttons.add(sView.getSignUpButton());
        buttons.add(lView.getLogInButton());
    }
    public LoginView getlView() {
        return lView;
    }

    public SignUpView getsView() {
        return sView;
    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }

}
