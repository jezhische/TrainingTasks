package oracle.myAttempts;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ежище on 23.09.2016.
 */
public class HelloWorldSwing {
    public void createSimpleWindow() {
        JFrame simpleWindow = new JFrame("in myAttempts");
        simpleWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        simpleWindow.setLayout(new BorderLayout(25, 5));
        JLabel label = new JLabel("there should be some text here");
        simpleWindow.getContentPane().add(label);
        simpleWindow.pack();
        simpleWindow.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HelloWorldSwing().createSimpleWindow();
            }
        });
    }
}
