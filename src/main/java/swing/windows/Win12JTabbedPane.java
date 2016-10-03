package swing.windows;

import javax.swing.*;

/**
 * Created by WORK on 30.09.2016.
 */
public class Win12JTabbedPane extends JFrame {
    Win12JTabbedPane() {
        super("Пример использования JTabbedPane");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        for (int i = 1; i <= 10; i++) {
            JPanel panel = new JPanel();
            panel.add(new JButton("Кнопка № " + i));
            tabbedPane.add("Панель " + i, panel);
        }
        getContentPane().add(tabbedPane);
        setSize(300,200);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win12JTabbedPane().setVisible(true));
    }
}
