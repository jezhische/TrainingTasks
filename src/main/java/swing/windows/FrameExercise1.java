package swing.windows;

import javax.swing.*;
import java.awt.*;

/**
 * Created by WORK on 27.09.2016.
 */
public class FrameExercise1 extends JFrame {

    FrameExercise1() {
        super("окошечко");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        setLayout(null);
        setSize(400, 800);

        JPanel flowPanel = new JPanel();
        flowPanel.setLayout(new FlowLayout());
        flowPanel.add(new JButton("Yes"));
        flowPanel.add(new JButton("No"));
        flowPanel.add(new JButton("Ambiguity"));
        setContentPane(flowPanel);
        flowPanel.setSize(25, 400);
        flowPanel.setLocation(100, 200);
//        pack();

        Box boxPanel = Box.createHorizontalBox();
        boxPanel.add(new JButton("Why?"));
        boxPanel.add(new JButton("Because!"));
//        setContentPane(boxPanel);
        boxPanel.setSize(100, 50);
//        boxPanel.setLocation(100, 200);

//        flowPanel.setBounds(0, 100, 500, 100);
//        boxPanel.setBounds(0, 200, 500, 100);

//        pack();


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameExercise1().setVisible(true);
            }
        });

    }
}
