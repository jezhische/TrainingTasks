package swing._2Danimation;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by WORK on 10.10.2016.
 */
public class RandMove extends JFrame implements ActionListener {

    private Timer timer;
    private JButton start;
    private JButton reset;
    private RandRect randRects;
//    ArrayList<Integer> randomList;
    private int x = 0;
//    private int count;
//    int delay;

    RandMove(int delay) {
//        this.delay = delay;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Box visualization = Box.createHorizontalBox();
//        visualization.setLayout(new BorderLayout(300, 500));
        visualization.setBorder(new EtchedBorder(Color.red, Color.red));

        randRects = new RandRect();
//        randomRects.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        visualization.add(randRects);

        Box buttons = Box.createHorizontalBox();
        buttons.setBorder(new EtchedBorder(Color.BLUE, Color.BLUE));

        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randRects.repaint();
            }
        });


        start = new JButton("Start");
        start.addActionListener(this);
        reset = new JButton("Reset");
        reset.addActionListener(this);
        buttons.add(start);
        buttons.add(reset);

        add(visualization, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setSize(900, 300);
//        pack();
        setVisible(true);
    }

    class RandRect extends JComponent {

        private void paintRandomRect(int count) {
            ArrayList<Integer> randomList = getRandomList(count);

        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.drawRect(x, 200, 50, -70);
            x++;
            g2d.drawRect(70, 200, 50, -100);
            g2d.drawRect(140, 200, 50, -130);

        }
    }

    private ArrayList<Integer> getRandomList(int count) {
//        this.count = count;
        ArrayList<Integer> randomList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            randomList.add(new Random(count).nextInt());
//            System.out.print(new Random().nextInt(count) + " ");
        }
        return randomList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start")) {
            timer.start();
            start.setText("Pause");
        } else if (e.getActionCommand().equals("Pause")) {
            timer.stop();
            start.setText("Start");
        } else if (e.getActionCommand().equals("Reset")) {
            timer.stop();
            x = 0;
            start.setText("Start");
            randRects.repaint();
        }


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RandMove(10));
//        getRandomList(20);
    }
}
