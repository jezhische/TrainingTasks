package swing.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by WORK on 23.09.2016.
 */
public class WinConstructorProbe extends JFrame implements ActionListener {
    public JTextArea textArea = new JTextArea();
    WinConstructorProbe() {
        super();
        textArea.add(new JScrollBar());
        textArea.setLineWrap(true);
        textArea.setToolTipText("something like text editor");

//        Container c = getContentPane();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BorderLayout());
        add(new JScrollPane(textArea));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton button = new JButton("Clear pane");
        button.addActionListener(this);
        panel.add(button);
        panel.add(new JButton("Anonimous"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Anonimous"))
                textArea.setText("anonymous turns into a lambda");
            }
        });
        panel.add(new JButton("something very long"));

        add(panel, BorderLayout.SOUTH);
        setSize(new Dimension(300, 400));
//        setContentPane(panel);
        getContentPane().add(new JButton("what?"), BorderLayout.WEST);
        getContentPane().add(new JButton("that!"), BorderLayout.NORTH);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("Clear"))
            textArea.setText("");
    }

    public static void main(String[] args) {
//        new WinConstructorProbe().setVisible(true);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WinConstructorProbe().setVisible(true);
            }
        });
    }
}
