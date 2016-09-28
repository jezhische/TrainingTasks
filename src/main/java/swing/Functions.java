package swing;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Created by WORK on 27.09.2016.
 * http://www.cyberforum.ru/java-gui-javafx/thread885786.html
 */
public class Functions {
    double k, maxX, y, s;

    public JPanel CreateTab()
    {
        JPanel GUI = new JPanel();
        JPanel panel = new JPanel();
        JPanel panelIn = new JPanel(); // имеется ввиду Input , входящие данные
        TitledBorder border = BorderFactory.createTitledBorder("Исходные данные");
        JTextField textX = new JTextField(5);
        JTextField textY = new JTextField(5);
        JTextField textS = new JTextField(5);
        JTextArea textArea = new JTextArea();
        JLabel labelF = new JLabel("Функция: k = (arcsin X) + |X + cos(Y)|");
        JLabel labelX = new JLabel("Значение X от 0 до :");
        JLabel labelY = new JLabel("Значение Y :");
        JLabel labelS = new JLabel("Шаг : ");
        JScrollPane scrollPane = new JScrollPane(textArea);

        panelIn.setBorder(border);

        panel.setLayout(null);
        panelIn.setLayout(null);
        panel.setSize(600, 50);
        panelIn.setSize(600, 100);
        panel.setBounds(0, 20, 590, 50);
        panelIn.setBounds(0, 100, 590, 150);
        scrollPane.setBounds(2, 260, 587, 205);
        textX.setBounds(320, 30, 50, 25);
        textY.setBounds(170, 100, 50, 25);
        textS.setBounds(400, 100, 50, 25);
        labelF.setBounds(180, 15, 250, 30);
        labelX.setBounds(195, 30, 250, 20);
        labelY.setBounds(90, 100, 150, 20);
        labelS.setBounds(365, 100, 150, 20);
        textArea.setBounds(2, 200, 585, 250);

        panelIn.setBorder(border);

        panelIn.add(textX);
        panelIn.add(textY);
        panelIn.add(textS);
        panelIn.add(labelX);
        panelIn.add(labelY);
        panelIn.add(labelS);

        panel.add(labelF);
        GUI.add(panel);
        GUI.add(panelIn);
        GUI.add(scrollPane);
        GUI.setBounds(500, 300, 600, 500);

        GUI.setOpaque(true);
        return GUI;
    }

    public static void CreateGUI()
    {
        JFrame frame = new JFrame("Таблица значений функции");

        Functions tab = new Functions();
        frame.setContentPane(tab.CreateTab());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(500, 300, 600, 500);
        frame.setVisible(true);
    }

    public void Function()
    {
        for (float x = 0; x > maxX ; x -= 0.01)
        {
            k = (Math.pow((Math.asin(x)), 2) + Math.abs(x + Math.cos(Math.toRadians(y))));
            System.out.print("k = " + k + " при x = ");
            System.out.printf("%.2f\n", x);
        }
    }



    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                CreateGUI();
            }
        });
    }
}
