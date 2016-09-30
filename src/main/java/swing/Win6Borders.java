package swing;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;

/**
 * Created by Ежище on 30.09.2016.
 */
public class Win6Borders extends JFrame {
    private JPanel createGUI() {
        JPanel GUI = new JPanel();
        GUI.setLayout(new BorderLayout());
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(2, 3));
        JPanel rightPanel = new JPanel(new GridLayout(2, 3));

        JButton a = new JButton("A");
        a.setBorder(createCompBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLUE, Color.CYAN)));
        a.setMinimumSize(a.getPreferredSize());
        leftPanel.add(a);
        JButton b = new JButton("B");
        b.setBorder(createCompBorder(new EtchedBorder(Color.BLUE, Color.CYAN)));
        b.setMinimumSize(b.getPreferredSize());
        leftPanel.add(b);
        JButton c = new JButton("C");
        c.setBorder(createCompBorder(new LineBorder(Color.ORANGE, 8)));
        c.setMinimumSize(c.getPreferredSize());
        leftPanel.add(c);
        JButton d = new JButton("D");
        d.setBorder(createCompBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.green, Color.pink,
                Color.RED, Color.blue)));
        d.setMinimumSize(d.getPreferredSize());
        leftPanel.add(d);
        JButton e = new JButton("E");
        e.setBorder(createCompBorder(new BasicBorders.ButtonBorder(Color.CYAN, Color.DARK_GRAY, Color.ORANGE,
                Color.LIGHT_GRAY)));
        e.setMinimumSize(e.getPreferredSize());
        leftPanel.add(e);

        GUI.add(leftPanel, BorderLayout.NORTH);

        return GUI;
    }

    private Border createCompBorder(Border border) {
        return new CompoundBorder(new EmptyBorder(20, 20, 20, 20), border);
    }

    Win6Borders() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
        pack();
        setContentPane(createGUI());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win6Borders().setVisible(true));
    }
}
