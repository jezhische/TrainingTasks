package swing._2D;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ежище on 06.10.2016.
 */

public class FrameCreator extends JFrame {
    FrameCreator() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new FlowLayout());
        Graph1Rectangle rect = new Graph1Rectangle();
        panel.add(rect);
        add(panel);
        pack();
//        getContentPane().add(new Graph1Rectangle);

    }
    private int x, y;
    public JFrame createFrame(int x, int y) {
        this.x = x;
        this.y = y;
        return new FrameCreator();
    }

    public class Graph1Rectangle extends JComponent {
        public Graph1Rectangle() {
            super();
        }

        //    public Graphics2D setCoordinate(int x, int y) {
//        return new Rectangle()
//    }
        public  int x = 0;
        public  int y = 0;;
//    Graph1Rectangle(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            Rectangle r=getBounds();
            g2d.setBackground(Color.white);
            g2d.clearRect(0, 0, r.width, r.height);

            g.setColor(Color.red);
            g.drawString("Hello, world", 20, 20);
            g.fillRect(60,60, 120, 120);

//            g.drawRect(x, y, 120, 60);
//            g.setColor(Color.ORANGE);
//            g.fillRect(x, y, 80, 40);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameCreator().createFrame(20,50).setVisible(true);
            }
        });
    }
}

