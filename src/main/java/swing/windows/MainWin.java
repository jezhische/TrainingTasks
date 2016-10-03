package swing.windows;

// пример оконного приложения
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by WORK on 22.09.2016.
 */
public class MainWin extends JFrame implements ActionListener {
    // версия класса
    private static final long serialVersionUID = 1L;

    // некоторые элементы окна
    private JTextArea jta = new JTextArea(
            "Scroll bar will appear, when much text");

    public MainWin() {
        // ------------------------------------------
        // добавление и настройка компонент
        Container c = getContentPane(); // клиентская область окна
        c.setLayout(new BorderLayout()); // выбираем компоновщик

        // метку наверх
        c.add(new JLabel("my first label :)"), BorderLayout.BEFORE_FIRST_LINE);
        // две кнопки в дополнительную панель
        JPanel jp = new JPanel();
        JButton jbt = new JButton("Add text");
        jbt.addActionListener(this); // назначаем в обработчики события образец класса - то есть то, что получается при
        // имплементации интерфейса, см. внизу
        jbt.addActionListener(e -> System.out.println("text!")); // создаем другой обработчик события, не образец класса.
        // e - потому что в супер-методе интерфейса в аргументах (ActionEvent e).
        // И назначаем этот обработчик события дополнительно на ту же кнопку
        jp.add(jbt);
        jbt = new JButton("Clear text");
        jbt.addActionListener(this); // назначаем обработчик события
        jp.add(jbt);
        // добавляем панель вниз
        c.add(jp, BorderLayout.SOUTH);
        // помещаем текст. поле в область прокрутки
        // а область прокрутки в центр окна,
        // BorderLayout.CENTER значение по умолчанию
        c.add(new JScrollPane(jta));
        jta.setLineWrap(true); // автоматический перенос строк
        // всплывающая подсказка
        jta.setToolTipText("this is simple text editor");

        // -------------------------------------------
        // настройка окна
//   ...
        setTitle("Example window"); // заголовок окна
        setPreferredSize(new Dimension(240, 200));
        pack(); // устанавливаем желательные размеры
        setVisible(true); // отображаем окно
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // обработчик события, метод интерфейса ActionListener
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getActionCommand().equals("Add text"))
            jta.append(" Add text\\n");

        if (arg0.getActionCommand().equals("Clear text"))
            jta.setText("");

        // если ссылки на объекты сохранены можно сравнивать
        // по объектам, например для JButton jbOK= new JBUtton("Ok");
        // то сравнение будет таким
        //    if(arg0.getSource().equals(jbOK))
    }

    // запуск оконного приложения
    public static void main(String args[]) {
        new MainWin();
    }

}
