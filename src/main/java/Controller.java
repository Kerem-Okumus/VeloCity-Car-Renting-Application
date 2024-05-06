import Objects.User;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        addActionListenerToButtons();
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

        if(e.getSource()==signUpView.getSignUpButton()){
            User newUser = new User(
                    signUpView.getUserNameTextField().getText(),signUpView.getPasswordTextField().getText(),
                    signUpView.getUserNameTextField().getText(),signUpView.getMailTextField().getText(),22,
                    signUpView.getPhoneNumberTextField().getText(),"male","12341231411"
            );
            model.addUser(newUser);
        }
    }
}
