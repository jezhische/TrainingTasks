package swing.windows;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;

/**
 * Created by Ежище on 30.09.2016.
 */
public class Win6BordersAndHTML extends JFrame {
    private JPanel createGUI() {
        JPanel GUI = new JPanel();
        GUI.setLayout(new BorderLayout());
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 2));
        JPanel rightPanel = new JPanel(new GridLayout(2, 3));

        JButton a = new JButton("FileWriterSimply");
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
        JLabel f = new JLabel("<html>применение HTML-форматирования: <ul><li> <i>курсив</i>, <li><b>полужирный</b>, " +
                "<li><font size = +2> увеличение размера, </font></ul> выше это был маркированный список ul " +
                "<li> и переносы строки li", new ImageIcon("src\\main\\resources\\B202tp2_.gif"), SwingConstants.CENTER);
        leftPanel.add(f);

        d.setBackground(Color.DARK_GRAY);
        b.setVisible(false);

//        c.setBounds(new Rectangle(50, 20));
//        c.setOpaque(false);

//        GUI.setOpaque(true);
        GUI.add(leftPanel, BorderLayout.NORTH);

        return GUI;
    }

    private Border createCompBorder(Border border) {
        return new CompoundBorder(new EmptyBorder(20, 20, 20, 20), border);
    }

    Win6BordersAndHTML() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
        setSize(800, 600);
//        pack();
        setContentPane(createGUI());
//        JLabel f = new JLabel("dfsd", new ImageIcon("src\\main\\resources\\B202tp2_.gif"), SwingConstants.RIGHT);
//        getContentPane().add(f);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win6BordersAndHTML().setVisible(true));
    }
}
