package swing._2Danimation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ежище on 11.10.2016.
 */
public class RandomRectangles extends JComponent {
    private int count, yShift, frameWidth, frameHeight, rX;
//    private ArrayList<Integer> randomList;
    RandomRectangles(int count, int yShift, int frameWidth, int frameHeight, int rX) {
        this.count = count;
        this.yShift = yShift;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.rX = rX;
//        this.randomList = randomList;
    }

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
        g2d.clearRect(0, 300, (frameWidth - 1) + 5, frameHeight);


        int rHeight, rWidth, coefficient;
        rWidth = (int)((frameWidth - 1) / (count / 2));
        coefficient = (int)((yShift) / (count / 2));
//            System.out.println(coefficient);
        ArrayList<Integer> randomList = getRandomList(count / 2);
        for (int i = 0; i < (count / 2); i++) {
            rHeight = -(randomList.get(i) * coefficient) ;
            rX = i * rWidth;
            g2d.setColor(Color.BLUE);
            g2d.drawRect(rX, yShift + 310, rWidth, rHeight - 4);
            g2d.setColor(Color.YELLOW);
            g2d.fillRect(rX + 1, yShift + 309, rWidth - 2, rHeight - 1);

        }
    }
}
