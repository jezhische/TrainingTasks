package swing.listeners;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.Arrays;

/**
 * Created by Ежище on 30.09.2016.
 * http://math.sgu.ru/sites/chairs/prinf/materials/java/lesson10.htm
 */
public class Win14LogWind_MOUSE_Listener extends JFrame {
    /* Для того, чтобы впоследствии обращаться к содержимому текстовых полей, рекомендуется сделать их членами класса окна */
    JTextField loginField;
    JPasswordField passwordField;

    Win14LogWind_MOUSE_Listener() {
        super("Вход в систему");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
// Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Логин:");
        loginField = new JTextField(15);
        loginField.setToolTipText("Логин");
        loginField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if((int)e.getKeyChar() == 27)
                    loginField.setText("");
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);
// Настраиваем вторую горизонтальную панель (для ввода пароля)
        Box box2 = Box.createHorizontalBox();
        JButton ok = new JButton("OK");
        JLabel passwordLabel = new JLabel("Пароль:");
        passwordField = new JPasswordField(15);
        passwordField.setToolTipText("Пароль");
        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
                if((int)e.getKeyChar() == 27) // 27 - это ESC
                    passwordField.setText("");
                if((int)e.getKeyChar() == 10) // 10 - это Enter
                    ok.doClick(500);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        box2.add(passwordLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(passwordField);
// Настраиваем третью горизонтальную панель (с кнопками)
        Box box3 = Box.createHorizontalBox();
//        JButton ok = new JButton("OK");

        class MouseL implements MouseListener {

            public void mouseClicked(MouseEvent event) {
                System.out.println(String.valueOf(passwordField.getPassword()));
                if (loginField.getText().equals("Иван") & Arrays.equals(passwordField.getPassword(), "ivan".toCharArray()))
                {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Вход выполнен");
                }
                else if (!(loginField.getText().equals("Иван")))
                JOptionPane.showMessageDialog(null, "Неверный логин");
                else if (loginField.getText().equals("Иван") & !String.valueOf(passwordField.getPassword())
                        .equals("ivan"))
                    JOptionPane.showMessageDialog(null, "Неверный пароль");
            }

            public void mouseEntered(MouseEvent event) {}

            public void mouseExited(MouseEvent event) {}

            public void mousePressed(MouseEvent event) {}

            public void mouseReleased(MouseEvent event) {
            }

        }
        ok.addMouseListener(new MouseL());
        ok.setToolTipText("Подтвердить");
        ok.addActionListener(e -> System.out.println(loginField.getText()));

        JButton cancel = new JButton("Отмена");
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                dispose();
                System.exit(1);
            }
        });
        cancel.setToolTipText("Закрыть окно");

        box3.add(Box.createHorizontalGlue());
        box3.add(ok);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(cancel);
// Уточняем размеры компонентов
        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
// Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);
        pack();
        setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win14LogWind_MOUSE_Listener().setVisible(true));
    }
}
