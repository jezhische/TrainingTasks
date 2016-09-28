package swing;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ежище on 28.09.2016.
 */
public class Win3 extends JFrame implements ActionListener {

    private JPanel createGUI() {
        JPanel GUI = new JPanel();
        JPanel fields = new JPanel();
        JTextField field1 = new JTextField();
        JLabel label1 = new JLabel("something1");
        Box box = Box.createHorizontalBox();
        TitledBorder border = BorderFactory.createTitledBorder("Исходные данные");
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
//        JTextArea textArea = new JTextArea();

//        BorderLayout bord = new BorderLayout();
        GUI.setLayout(new BorderLayout());

//        fields.setSize(200, 50);
        fields.add(label1);
        fields.add(field1);
        GUI.add(fields, BorderLayout.NORTH);

//        box.setSize(500, 200);
        box.setBorder(border);
        scrollPane.setSize(400, 150);
        textArea.setSize(380, 120);
        box.add(scrollPane);
        box.add(new JButton("H"));
        scrollPane.add(textArea);
        scrollPane.setLayout(null);
        scrollPane.setBounds(2, 260, 587, 205);
        textArea.setBounds(2, 20, 585, 250);
        GUI.add(box, BorderLayout.SOUTH);

        GUI.setOpaque(true);
        return GUI;
    }

    Win3() {
        super("псевдо-3 панели");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
        setContentPane(createGUI());
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win3().setVisible(true));
    }
}
