package objectMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Ежище on 18.01.2017.
 */
public class NewInstanceDemo extends JFrame {

    private JTextField fld = new JTextField(30);
    private JTextArea msg = new JTextArea(8, 40);

    NewInstanceDemo() {
        super("Демонстрация работы метода Class.newInstance");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        setSize(500, 250);
        Container c = getContentPane();
        JPanel pn = new JPanel();
        c.add(pn, BorderLayout.NORTH);
        pn.add(new Label("Имя класса"));
        pn.add(fld);
        fld.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                createObject();
            }
        });
        JScrollPane pane = new JScrollPane(msg);
        c.add(pane, BorderLayout.CENTER);
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);
    }

    void createObject() {
        String className = fld.getText();
        try {
            Class cls = Class.forName(className);
            Object obj = cls.newInstance();
//            String s = (String) obj;
//            s = "zaboday";
            msg.append("Создан объект класса " + className + ": " + obj.getClass() + "\n");
            msg.append(obj.toString() + "\n");
        } catch (Exception ex) {
            msg.append("Ошибка при создании объекта класса "
                    + className + ":\n");
            msg.append(ex.toString() + "\n");
        }
    }

    public static void main(String args[]) {
        new NewInstanceDemo();

    }
}
