package swing;

import javax.swing.*;

import java.awt.*;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by WORK on 15.09.2016.
 * http://darkraha.com/rus/java/swing/swing01.php
 */
public class MyWin extends JFrame {
    /** это минимальный шаблон оконного приложения */

    // серийный номер класса
    private static final long serialVersionUID = 1L;

    public MyWin() {
        Container c = getContentPane(); // клиентская область окна
        c.setLayout(new BorderLayout()); // выбираем компоновщик

        // добавляем какие-нибудь дочерние элементы - //  Классы MyPanel и MyComponent - пользовательские классы,
        // которые будут реализованы в некоторых следующих примерах для демонстрации возможностей swing.
        // Вам остается просто скопировать со страницы код MyPanel/MyComponent в проект со шаблоном,
        // подправить шаблон и запустить его.
        //MyComponent child = new MyComponent();
        //MyPanel child= new MyPanel();
        //c.add(child);

        // -------------------------------------------
        // настройка окна
        setTitle("Example window"); // заголовок окна
        // желательные размеры окна
        setPreferredSize(new Dimension(640, 480));
        // завершить приложение при закрытии окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // устанавливаем желательные размеры
        setVisible(true); // отображаем окно
    }

    // запуск оконного приложения
    public static void main(String args[]) {
        new MyWin();
    }
}
