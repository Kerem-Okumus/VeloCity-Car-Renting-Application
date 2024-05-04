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
        if(e.getSource()==view.getsView().getSignUpButton()){
            SignUpView s= view.getsView();
            model.addUser(s.getUserNameTextField().getText(),s.getPasswordTextField().getText(),s.getUserNameTextField().getText(),s.getMailTextField().getText(),22,s.getPhoneNumberTextField().getText(),"male","12341231411");
        }
    }
}
