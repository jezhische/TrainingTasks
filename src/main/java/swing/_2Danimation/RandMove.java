package swing._2Danimation;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by WORK on 10.10.2016.
 */
public class RandMove extends JFrame implements ActionListener {

    private Timer timer;
    private JButton start;
    private JButton reset;
    private RandRect randRects;
    private int frameWidth;
    private int frameHeight;
    private int yShift;
//    private ArrayList<Integer> randomList;
    private int rX;
    private int count;
//    int delay;

    RandMove(int delay, int count) {
//        this.delay = delay;
        this.count = count;
        frameWidth = 1300;
        frameHeight = 700;
        yShift = 300;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setLayout(new BorderLayout());
        Box visualization = Box.createHorizontalBox();
        visualization.setBorder(new LineBorder(Color.red, 4));

        randRects = new RandRect();
        randRects.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        randRects.setPreferredSize(new Dimension(frameWidth, yShift));
        visualization.add(randRects);

//        RandomRectangles randomRectangles = new RandomRectangles(count, yShift, frameWidth, frameHeight, rX);
//        randomRectangles.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
////        randomRectangles.setPreferredSize(new Dimension(frameWidth, yShift));
//        visualization.add(randomRectangles);

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
//        pack();
    }

    class RandRect extends JComponent {

        private ArrayList<Integer> getRandomList(int count) {
            ArrayList<Integer> randomList = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                randomList.add(i);
            }
            Collections.shuffle(randomList);
            return randomList;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setBackground(Color.RED);
//            Rectangle r = getBounds();
//            g2d.clearRect(0, 0, r.width, r.height);
            g2d.clearRect(0, 0, (frameWidth - 1) + 5, frameHeight);


            int rHeight, rWidth, coefficient;
            rWidth = (int) ((frameWidth - 1) / count);
            coefficient = (int) ((yShift) / count);
//            System.out.println(coefficient);
            ArrayList<Integer> randomList = getRandomList(count);
            for (int i = 0; i < count; i++) {
                rHeight = -(randomList.get(i) * coefficient);
                rX = i * rWidth;
                g2d.setColor(Color.BLUE);
                g2d.drawRect(rX, yShift, rWidth, rHeight - 4);
                g2d.setColor(Color.YELLOW);
                g2d.fillRect(rX + 1, yShift - 1, rWidth - 2, rHeight - 1);

            }
        }
    }

//    private ArrayList<Integer> getRandomList(int count) {
//        this.count = count;
//        ArrayList<Integer> randomList = new ArrayList<>(count);
//        for (int i = 0; i < count; i++) {
//            randomList.add(i);
//        }
//        Collections.shuffle(randomList);
////        for (Integer i: randomList)
////            System.out.print(i + "  ");
//        return randomList;
//    }

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
            rX = 0;
            start.setText("Start");
            randRects.repaint();
        }


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RandMove(10, 150).setVisible(true));
//        getRandomList(20);
    }
}
