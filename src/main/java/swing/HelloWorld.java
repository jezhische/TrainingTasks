package swing;

import javax.swing.*;

/**
 * Created by WORK on 15.09.2016.
 */
public class HelloWorld implements Runnable {
    public static void main(String[] args) {

        // Swing имеет собственный управляющий поток (т.н. dispatching thread),
        // который работает параллельно с основным (стартовым, в котором выполняется main())
        // потоком. Это означает что если основной поток закончит работу (метод main завершится),
        // поток отвечающий за работу Swing-интерфейса может продолжать свою работу.
        // И даже если пользователь закрыл все окна, программа продолжит свою работу
        // (до тех пор, пока жив данный поток). Начиная с Java 6, когда все компоненты уничтожены,
        // управляющим интерфейсом поток останавливается автоматически.
        //
        // Запускаем весь код, работающий с интерфейсом, в управляющем потоке, даже инициализацию:


        // из java-документации по методу invokeLater:
        Runnable doHelloWorld = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello World on " + Thread.currentThread());
            }
        };

        SwingUtilities.invokeLater(doHelloWorld);
        System.out.println("This might well be displayed before the other message.");

        SwingUtilities.invokeLater(new HelloWorld());
    }

    @Override
    public void run() {
        // вначале event dispatching thread поспит 5 сек, потом появится окно, и только еще через 5 сек выполнится
        // SwingUtilities.invokeLater(doHelloWorld); - поскольку invokeLater выполняется после завершения других задач в потоке
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Создаем окно с заголовком "Hello, World!"

        JFrame f = new JFrame("Hello, World!");

        // Ранее практиковалось следующее: создавался listener и регистрировался
        // на экземпляре главного окна, который реагировал на windowClosing()
        // принудительной остановкой виртуальной машины вызовом System.exit()
        // Теперь же есть более "правильный" способ задать реакцию на закрытие окна.
        // Данный способ уничтожает текущее окно, но не останавливает приложение. Тем
        // самым приложение будет работать пока не будут закрыты все окна.

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // однако можно задать и так:
        //            f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        // Добавляем на панель окна нередактируемый компонент с текстом.

//        f.getContentPane().add (new JLabel("Hello, World!")); // - старый стиль
        f.add(new JLabel("Hello World"));

        // pack() "упаковывает" окно до оптимального размера, рассчитанного на основании размеров
        // всех расположенных в нем компонентов.

        f.pack();

        // Показать окно

        f.setVisible(true);

        JFrame e = new JFrame("kkk");
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        e.add(new JLabel("ddddddddddddddddddddddddddddddddddd \n iiiiiiiiiiii"));
        e.setVisible(true);
        e.pack();
    }
}
