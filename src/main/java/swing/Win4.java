package swing;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by WORK on 28.09.2016.
 */
public class Win4 extends JFrame implements ActionListener {

    private JPanel createGUI() {
        JPanel GUI = new JPanel();
        GUI.setLayout(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder("какой-то текст");

        JPanel buttonPanel = new JPanel();
//        buttonPanel.setSize(500, 100);
        buttonPanel.add(new JButton("hu"));
        buttonPanel.add(new JButton("ha"));
        JButton ho = new JButton("ho");
        ho.setMinimumSize(new Dimension(150, 150));
        buttonPanel.add(ho);

        GUI.add(buttonPanel, BorderLayout.SOUTH);

        Box box = Box.createHorizontalBox();
        box.setBorder(border);
        box.add(Box.createHorizontalStrut(20));
        box.add(new JButton("Clear text"));
        box.add(Box.createHorizontalStrut(20));
        box.add(new JButton("Create text"));
        box.add(Box.createGlue());
        box.add(new TextArea("Text will be here"));
        GUI.add(box, BorderLayout.NORTH);


        return GUI;
    }

    public Win4() {
        super("типа несколько панелей одна в другой");
        setDefaultCloseOperation(Win4.EXIT_ON_CLOSE);
        setContentPane(createGUI());
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win4().setVisible(true));
    }
}
