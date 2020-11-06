import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddGUI extends JFrame {

    public AddGUI(List<Integer> list) {
        super("Intro");
        this.setBounds(200, 200, 400, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel label = new JLabel("How many numbers do you want to add?");
        JTextField input = new JTextField();
        JButton button = new JButton("Add");

        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,1));
        container.add(label);
        container.add(input);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int b = (int) (Math.random() * 30);
                list.add(b);

                for (int i = 0; i < Integer.parseInt(input.getText()) - 1; i++) {
                    int n = (int) (Math.random() * 1000);
                    list.add(n);
                }

                dispose();

                new NumbersGUI(list).setVisible(true);
            }
        });
        container.add(button);
    }
}
