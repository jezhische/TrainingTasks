package swing._2D;

import com.sun.java.swing.plaf.motif.MotifBorders;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by Ежище on 06.10.2016.
 */

public class FrameCreator extends JFrame {
    FrameCreator() {
        super();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000, 1000));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graph1Rectangle rect = new Graph1Rectangle();
        rect.setPreferredSize(new Dimension(700, 900));
        TitledBorder titledBorder = new TitledBorder("Добавленный компонент Graph1Rectangle");
        CompoundBorder compoundBorder = new CompoundBorder(new LineBorder(Color.BLUE, 3), titledBorder);
        rect.setBorder(compoundBorder);
        add(rect, BorderLayout.SOUTH);
        pack();
        this.setLocationRelativeTo(null);

    }
    public void pulse() {

    }
    private int x, y;
    private JFrame createFrame(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    private class Graph1Rectangle extends JComponent implements Runnable {

        public Graph1Rectangle() {
            super();
            new Thread(this).start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 750; i++) {
                x++;
                y++;
                repaint();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {}
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.clearRect(0, 0, 700, 300);
//            this.setOpaque(true);
            g2d.setBackground(Color.white);
            g2d.drawRect(0, 0, 700, 300);

            g2d.setColor(Color.cyan);
            g2d.fillRect(60, 20, 120, 120);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(60, 20, 120, 120);
            g2d.setColor(Color.ORANGE);
            g2d.fillRect(x/2 + 150, 40, 80, y / 2);
            g2d.setColor(Color.RED);
            g2d.drawRect(x, y, 120, 60);
//            x++;
//            y++;
//            g2d.drawLine(150, 0, x, y);
//            g2d.drawOval(x - 20, y - 20, 40, 40);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrameCreator frameCreator = new FrameCreator();
                frameCreator.createFrame(50, 50);
                frameCreator.setVisible(true);
//                for (int i = 0; i < 1000; i++) {
////                    frameCreator.repaint();
////                    frameCreator.createFrame(0, 0);
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        });
    }
}

