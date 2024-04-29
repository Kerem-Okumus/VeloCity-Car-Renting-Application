package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame {

    ArrayList<JButton> buttons=new ArrayList<JButton>();

    public View() {
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addActionListener(ActionListener a) {
        for(int i =0;i<buttons.size();i++) {
            buttons.get(i).addActionListener(a);
        }
    }

}
