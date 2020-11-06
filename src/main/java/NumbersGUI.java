import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersGUI extends JFrame {

    public NumbersGUI(List<Integer> numbers) {
        super("Sort");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel gridNumbers = new JPanel();
        gridNumbers.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        int counter = 0;

        for (int x = 0; x < (int) Math.ceil(numbers.size() / 10.0); x++) {
            constraints.gridx = x;
            for (int y = 0; y < 10; y++) {
                if (counter == numbers.size()) {
                    break;
                }
                constraints.gridy = y;
                JButton jButton = new JButton(String.valueOf(numbers.get(counter)));
                jButton.setSize(20,20);
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (Integer.parseInt(jButton.getText()) > 30) {
                            JOptionPane.showMessageDialog(null, "Please select a value smaller or equal to 30");
                        } else {
                            dispose();
                            new AddGUI(numbers).setVisible(true);
                        }
                    }
                });
                gridNumbers.add(jButton, constraints);
                counter++;
            }
        }


        JPanel actions = new JPanel();
        GridLayout layout2 = new GridLayout(2, 1, 5, 12);
        actions.setLayout(layout2);
        JButton sort = new JButton("Sort");
        JButton reset = new JButton("Reset");

        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if (numbers.get(1) > numbers.get(2)) {
                    new NumbersGUI(numbers.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList())).setVisible(true);
                } else {
                    new NumbersGUI(numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())).setVisible(true);
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new IntroGUI().setVisible(true);
            }
        });

        actions.add(sort);
        actions.add(reset);

        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(gridNumbers);
        this.getContentPane().add(actions);
        this.pack();
    }

}
