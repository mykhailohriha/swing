import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class IntroGUI extends JFrame {

    public static void main(String[] args) {
        IntroGUI introGUI = new IntroGUI();
        introGUI.setVisible(true);
    }

    public IntroGUI() {
        super("Intro");
        this.setBounds(200,200,400,200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel label = new JLabel("How many number to display?");
        JTextField input = new JTextField();
        JButton button = new JButton("Enter");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        getContentPane().setLayout(new GridLayout(3,6));
        getContentPane().add(label);
        getContentPane().add(input);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> numbers = new ArrayList<>();
                int b = (int) (Math.random() * 30);
                numbers.add(b);

                for (int i = 0; i < Integer.parseInt(input.getText()) - 1; i++) {
                    int n = (int) (Math.random() * 1000);
                    numbers.add(n);
                }

                dispose();

                new NumbersGUI(numbers).setVisible(true);
            }
        });
        getContentPane().add(button);
    }

}
