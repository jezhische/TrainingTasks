package swing;

import javax.swing.*;

/**
 * Created by WORK on 30.09.2016.
 * http://math.sgu.ru/sites/chairs/prinf/materials/java/lesson9.htm
 */
public class Win10JComboBox extends JFrame {
    Win10JComboBox() {
        super("Пример использования JComboBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String[] elements = new String[] {"Вася", "Петя",
                "<html><font size = +1 color = yellow>Иван</font>"};
        JComboBox combo = new JComboBox(elements);
        combo.setSelectedIndex(1);
        JPanel panel = new JPanel();
        panel.add(combo);
        setContentPane(panel);
        setSize(200,200);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win10JComboBox().setVisible(true));
    }
}
