import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Ui {
    private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9"};


    public Ui() throws IOException {
        JFrame frame = new JFrame("Calculator Application");

        ImageCustom imageReturn = new ImageCustom();
        ImageIcon image = new ImageIcon(imageReturn.imageReturn());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout());
        JPanel panel5 = new JPanel(new FlowLayout());
        JPanel panel6 = new JPanel(new FlowLayout());
        JPanel panel7 = new JPanel(new FlowLayout());
        JPanel panel8 = new JPanel(new FlowLayout());

        Font font = new Font("Consolas", Font.PLAIN, 16);
        JTextArea text = new JTextArea(1, 30);
        Font textFont = new Font("Consolas", Font.BOLD, 18);
        
        JButton[] but = new JButton[10];
        
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
        }
        
        JButton add = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");

        Calculator calc = new Calculator();
    }

    public void init() {

    }
}
