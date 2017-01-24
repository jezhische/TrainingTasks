package classClass.lesson22Multithreading;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Random;

/**
 * Created by Ежище on 24.01.2017.
 */
public class ThreadExample4a extends JFrame {

    JTextField txt1 = new JTextField(10);
    JTextField txt2 = new JTextField(10);
    JTextField txtTime = new JTextField(18);
    int randValue = 0;
    long numbOfRand = 0;
    SimpleThread sth = null;
    JButton sbtn;

    ThreadExample4a() {
        super("Знакомство с нитями (часы)");

        try  {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
        }

        setSize(400, 300);
        Container c = getContentPane();
        JPanel pnm = new JPanel(new GridLayout(2, 1, 5, 5));
        c.add(pnm, BorderLayout.CENTER);
        JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnm.add(pn1);
        pnm.add(pn2);
        pn1.add(new JLabel("Номер числа        "));
        pn1.add(txt1);
        txt1.setEnabled(false);
        pn2.add(new JLabel("Случайное число"));
        pn2.add(txt2);
        txt2.setEnabled(false);
        JPanel pnb = new JPanel();
        JButton btn = new JButton("Показать число");
        pnb.add(btn);
        c.add(pnb, BorderLayout.SOUTH);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txt1.setText(String.valueOf(numbOfRand));
                txt2.setText(String.valueOf(randValue));
            }
        });
        JPanel pntop = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        sbtn = new JButton("Показать время");
        pntop.add(sbtn);
        pntop.add(txtTime);
        txtTime.setEnabled(false);
        txtTime.setEditable(false);
        c.add(pntop, BorderLayout.NORTH);
        sbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( sth == null ) {
                    sth = new SimpleThread();
                    sth.start();
                }
                sth.switchOnOff();
                sbtn.setText( sth.isOn() ? "Остановить часы" : "Показать время" );
            }
        });

        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);

        Random rnd = new Random();
        for(;;numbOfRand++) {
            randValue = rnd.nextInt();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
            }
        }
    }

    class SimpleThread extends Thread {

        private boolean runFlag = false;

        public void run() {
            while ( true ) {
                if ( runFlag ) {
                    Date dt = new Date();
                    txtTime.setText(dt.toString());
                } else {
                    txtTime.setText("");
                }
                try {
                    Thread.sleep(200);
                } catch(InterruptedException e) {
                }
            }
        }

        public boolean isOn() {
            return runFlag;
        }

        public void switchOnOff() {
            runFlag = !runFlag;
        }

    }

    public static void main(String[] args) {
        new ThreadExample4a();
    }
}
