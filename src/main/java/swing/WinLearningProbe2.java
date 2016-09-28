package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by WORK on 26.09.2016.
 */
public class WinLearningProbe2 implements ActionListener {
    JFrame window = new JFrame();
    JPanel pan1 = new JPanel();
//    JPanel pan2 = new JPanel();
    public void windowFuture() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(700, 800));
        window.setVisible(true);
//        JButton button = new JButton("E");
        window.setContentPane(pan1);
//        window.setContentPane(pan2);
//        window.getContentPane().add(new JButton("E"), BorderLayout.EAST);
        pan1.setLayout(new BorderLayout());
        pan1.add(new JButton("N"), BorderLayout.NORTH);

        JButton e = new JButton("E");
        pan1.add(e, BorderLayout.EAST);
        e.setMaximumSize(new Dimension(25, 35));
//        e.setPreferredSize(new Dimension(25, 35));
        e.addActionListener(this);

        JButton w = new JButton("W");
        pan1.add(w, BorderLayout.WEST);
        w.addActionListener(this);

//        window.pack();

    }

    JButton k = new JButton("K");
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("W")) {
        window.getContentPane().add(k);
        k.addActionListener(listener1);
        k.setSize(120, 150);
        k.setLocation(120, 70);
        }
        if (e.getActionCommand().equals("E")) {
//            window.toBack();
//            window.remove(k);
            window.getContentPane().setLayout(null);
            JTextArea textArea = new JTextArea();
            textArea.setSize(20, 30);
            textArea.setLocation(100, 200);
//            window.getContentPane().add(textArea, BorderLayout.CENTER);
            window.add(new JScrollPane(textArea));
        }
    }

    private ActionListener listener1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("K"))
                window.toBack();
//                   window.createImage(20,20);
        }
    };

    public static void main(String[] args) {
        WinLearningProbe2 wlp2 = new WinLearningProbe2();
        SwingUtilities.invokeLater(wlp2::windowFuture); // здесь lambda   (() -> wlp2.windowFuture()); вместо
        // (new Runnable(){@Override public void run{wlp2.windowFuture();}}); , которая потом заменена на method reference

    }
}
