package swing._2Danimation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.util.Timer;

/**
 * Created by Ежище on 07.10.2016.
 */
public class TimerGraph1 extends JComponent {

    private int x = 0;
    private int delay;
    JButton startButton;

    TimerGraph1(int delay) {
        super();
        this.delay = delay;
        MainFrame frame = new MainFrame(delay);
        frame.setVisible(true);
        this.setPreferredSize(new Dimension(700, 900));
        frame.getContentPane().add(this, BorderLayout.NORTH);
        frame.pack();

    }

    private class MainFrame extends JFrame {
        private MainFrame(int delay) {
            super();
            setPreferredSize(new Dimension(1300, 500));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            Box startBox = Box.createHorizontalBox();
            startBox.add(createStartButton());
            startBox.add(createResetButton());
            add(startBox, BorderLayout.SOUTH);

//            this.setLocationRelativeTo(null);
        }

        private JButton createStartButton() {
            startButton = new JButton("Start");
            startButton.setPreferredSize(new Dimension(70, 900));
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equals("Start")) {
                        timer.start();
                        startButton.setText("Pause");
//                    startButton.setActionCommand("Pause");
                    } else {
                        timer.stop();
                        startButton.setText("Start");
                    }
                }
            });

            return startButton;
        }

        private JButton createResetButton() {
            JButton resetButon = new JButton("Reset");
            resetButon.setPreferredSize(new Dimension(70, 900));
            resetButon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    reset();
                    repaint();
                }
            });
            return resetButon;
        }
    }

    private void reset() {
        timer.stop();
        startButton.setText("Start");
        x = 0;
    }

    private Timer timer = new Timer(delay, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveRectangles();
        }
    });
    ArrayList<Integer> listX = new ArrayList<>();

    private void moveRectangles() {
        if (x == 0 || x == 1) {
            listX.add(x);
            x++;
            repaint();
        } else if (1 < x && x < 900 && (listX.get(x - 1) - listX.get(x - 2)) > 0) {
            listX.add(x);
            x++;
            repaint();
        } else if (x == 900) {
//            listX.clear();
            listX.add(x);
            x--;
            repaint();

        } else if (1 < x && x < 900 && (listX.get((900 - x)-1) - listX.get((900 - x) - 2)) < 0) {
            listX.add(x);
            x--;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setBackground(Color.YELLOW);
        Rectangle r = getBounds();
        g2d.clearRect(0, 0, r.width, r.height);

        g2d.setColor(Color.green);
        g2d.scale(1, 1);
        g2d.fillRoundRect(x, 200, 20, 300, 5, 5);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TimerGraph1(100);
            }
        });
    }

}
