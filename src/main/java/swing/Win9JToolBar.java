package swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by WORK on 30.09.2016.
 * http://math.sgu.ru/sites/chairs/prinf/materials/java/lesson9.htm
 */
public class Win9JToolBar extends JFrame {
    Win9JToolBar() {
        super("Пример использования JToolBar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea(5, 20);
        setLayout(new BorderLayout());
        getContentPane().add(textArea, BorderLayout.SOUTH);
        JToolBar toolBar = new JToolBar("Инструментальная панель");
        toolBar.add(new JButton("Кнопка 1"));
        toolBar.add(new JButton("Кнопка 2"));
        toolBar.addSeparator();
        toolBar.add(new JButton("Кнопка 3"));
        getContentPane().add(toolBar, BorderLayout.NORTH);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win9JToolBar().setVisible(true));
    }
}
