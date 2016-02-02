package certification.chapter1.nested_classes.anonymousinnerclass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Serhii K. on 2/1/2016.
 */
public class Listener {

    public static void main(String[] args) {
        JButton button = new JButton("red");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //	handle	the	button	click
            }
        });
    }
}
