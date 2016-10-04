package swing.listeners;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by WORK on 03.10.2016.
 */
public class Win16Probe extends JFrame implements ActionListener {
JButton button2;
    Win16Probe() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
////        Box horiz = Box.createHorizontalBox();
//        setLayout(new FlowLayout());
//        JPanel panel1 = new JPanel();
//        panel1.setBorder(new LineBorder(Color.orange, 5));
//        getContentPane().add(panel1, BorderLayout.SOUTH);
////        panel1.setLayout(new FlowLayout());
////        setContentPane(panel1);
//        JButton button1 = new JButton("Положить быстро, ровно и рядами");
//        button1.setSize(250, 30);
//        button1.setLocation(50, 30);
//        add(button1);
//        JButton button2 = new JButton("Пакласть");
//        button2.setSize(100, 30);
//        button2.setLocation(350, 50);
//        add(button2);
////        pack();
////        setContentPane();

        JButton button1;

        JPanel panel1;
        JPanel panel2;
        JPanel panel3;

        setLayout(new BorderLayout());

        panel1 = new JPanel(new BorderLayout());

        button1 = new JButton("1");
        button1.setBorder(new CompoundBorder(new EmptyBorder(12, 20, 12, 20), new LineBorder(Color.BLUE, 3)));
        button1.addActionListener(this);
        panel1.add(button1, BorderLayout.NORTH);

        button1 = new JButton("2");
        button1.setBorder(new CompoundBorder(new EmptyBorder(12, 20, 12, 20), new LineBorder(Color.BLUE, 3)));
        button1.addActionListener(this);
        panel1.add(button1, BorderLayout.WEST);

        button2 = new JButton("3");
        button2.setBorder(new CompoundBorder(new EmptyBorder(12, 20, 12, 20), new LineBorder(Color.BLUE, 3)));
        button2.addActionListener(this);
        button2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println((int)e.getKeyChar());
                if ((int)e.getKeyChar() == 27) {
                    if(JOptionPane.showConfirmDialog(button2, "Щас ты все закроешь! Точно уверен?") == JOptionPane.YES_OPTION)
                        System.exit(0);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        panel1.add(button2);

        panel1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.green, Color.CYAN));

        JTextArea text = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(text);
        add(scrollPane);

        add(panel1, BorderLayout.WEST);


//        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Есть контакт");

        if (e.getActionCommand().equals("1"))
            dispose();
        else if (e.getActionCommand().equals("2"))
            System.out.println("игого");
    }


//    static boolean isOK = false;
    public static void main(String[] args) {
//        Win16Probe w;
//        w.setSize(200, 100);
//        w.setVisible(true);

        SwingUtilities.invokeLater(() -> new Win16Probe().setVisible(true));

//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                boolean isOK = true;
//                Win16Probe www = new Win16Probe();
//                www.setVisible(isOK);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                isOK = false;
//                www.setVisible(isOK);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                isOK = true;
//                www.setVisible(isOK);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                isOK = false;
//                www.setVisible(isOK);
//            }
//        };
//        new Thread(r).start();
    }

}
