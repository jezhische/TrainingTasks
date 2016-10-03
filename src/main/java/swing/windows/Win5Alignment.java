package swing.windows;

import javax.swing.*;
import java.awt.*;

/**
 * Created by WORK on 29.09.2016.
 */
public class Win5Alignment extends JFrame {
    private JPanel createGUI() {
        JPanel GUI = new JPanel(new BorderLayout());
        Box hBox = Box.createHorizontalBox();
        hBox.setSize(500, 150);
        Box vBox = Box.createVerticalBox();

        JButton a = new JButton("A");
        JButton s = new JButton("S");
        JButton d = new JButton("D");
        JButton f = new JButton("F");
        JButton g = new JButton("G");
        JButton h = new JButton("H");
        JButton j = new JButton("J");

        JButton z = new JButton("Z");
        JButton x = new JButton("X");
        JButton c = new JButton("C");
        JButton v = new JButton("V");
        JButton b = new JButton("B");
        JButton n = new JButton("N");
        JButton m = new JButton("M");

        a.setAlignmentY(JComponent.RIGHT_ALIGNMENT);
        s.setAlignmentY(JComponent.RIGHT_ALIGNMENT);
        d.setAlignmentY(JComponent.LEFT_ALIGNMENT);
        f.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        g.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        h.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        j.setAlignmentY(JComponent.TOP_ALIGNMENT);
        hBox.add(a);
        hBox.add(s);
        hBox.add(d);
        hBox.add(f);
        hBox.add(g);
        hBox.add(h);
        hBox.add(j);
        GUI.add(hBox, BorderLayout.NORTH);

        z.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
        x.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
        c.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        v.setAlignmentY(JComponent.LEFT_ALIGNMENT);
        b.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        n.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        m.setAlignmentX(JComponent.RIGHT_ALIGNMENT);

        vBox.add(z);
        z.add(Box.createVerticalGlue());
//        z.add(Box.createHorizontalStrut(20));
        vBox.add(x);
//        x.add(Box.createHorizontalStrut(50));
        x.add(Box.createVerticalStrut(20));
//        x.add(Box.createVerticalGlue());
//        x.add(Box.createHorizontalGlue());
        vBox.add(c);
        vBox.add(Box.createVerticalGlue());
        vBox.add(v);
        vBox.add(b);
        vBox.add(n);
        vBox.add(Box.createHorizontalGlue());
        vBox.add(m);
        GUI.add(vBox, BorderLayout.WEST);



        return GUI;
    }
    public Win5Alignment() {
        super("выравнивание в боксе...");
        setDefaultCloseOperation(Win5Alignment.EXIT_ON_CLOSE);
        setContentPane(createGUI());
        setSize(500, 350);
//        pack();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win5Alignment().setVisible(true));
    }
}
