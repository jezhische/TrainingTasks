package swing.windows;

import javax.swing.*;

/**
 * Created by WORK on 30.09.2016.
 * http://math.sgu.ru/sites/chairs/prinf/materials/java/lesson9.htm
 */
public class Win11JSlider extends JFrame {
    Win11JSlider() {
        super("Пример использования JSlider");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 50, 150, 70);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        JPanel panel = new JPanel();
        panel.add(slider);
        setContentPane(panel);
        pack();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win11JSlider().setVisible(true));
    }
}
