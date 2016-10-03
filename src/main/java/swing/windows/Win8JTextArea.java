package swing.windows;

import javax.swing.*;
import java.awt.*;

/**
 * Created by WORK on 30.09.2016.
 * http://math.sgu.ru/sites/chairs/prinf/materials/java/lesson9.htm
 */
public class Win8JTextArea extends JFrame {
    Win8JTextArea() {
        super("Пример текстовых компонентов");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextField textField = new JTextField("Текстовое поле", 20);
        textField.setCaretColor(Color.RED);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        passwordField.setText("пароль");
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        for (int i = 0; i <= 20; i++)
            textArea.append("Область для ввода текстового содержимого ");
        getContentPane().add(textField, BorderLayout.NORTH);
//        getContentPane().add(textArea);
        getContentPane().add(new JScrollPane(textArea));
        getContentPane().add(passwordField, BorderLayout.SOUTH);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Win8JTextArea().setVisible(true);
            }
        });
    }

}
