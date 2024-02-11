import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Ui {
    private final JFrame frame;
    private final JPanel panel, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8;

    private final String[] buttonValue =
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private final JButton button[], add, minus, multiply, divide,
            equal, cancel, squareRoot, square, oneDividedBy;
    private final Font font;
    private final JTextArea text;
    private final Font textFont;
    private ImageIcon image;
    private ImageCustom imageReturn;

    public Ui() throws IOException {
        frame = new JFrame("Calculator Application");

        ImageCustom imageReturn = new ImageCustom();
        image = new ImageIcon(imageReturn.imageReturn());

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel1 = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());
        panel3 = new JPanel(new FlowLayout());
        panel4 = new JPanel(new FlowLayout());
        panel5 = new JPanel(new FlowLayout());
        panel6 = new JPanel(new FlowLayout());
        panel7 = new JPanel(new FlowLayout());
        panel8 = new JPanel(new FlowLayout());

        font = new Font("Consolas",Font.PLAIN, 18);
        text = new JTextArea(1, 30);
        textFont = new Font("Consolas",Font.BOLD, 24);

        button = new JButton[10];

        for (int i = 0; i < 10; i++) {
            button[i] = new JButton(String.valueOf(i));
        }

        add = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        equal = new JButton("=");
        squareRoot = new JButton("sqrt");
        square = new JButton("x*x");
        oneDividedBy = new JButton("1/x");
        cancel = new JButton("C");

        Calculator calc = new Calculator();
    }

    public void init() {
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(image.getImage());

        text.setFont(textFont);
        text.setEditable(false);
        for (int i =0; i < 10; i++) {
            button[i].setFont(font);
        }

        add.setFont(font);
        minus.setFont(font);
        multiply.setFont(font);
        divide.setFont(font);
        equal.setFont(font);
        square.setFont(font);
        squareRoot.setFont(font);
        oneDividedBy.setFont(font);
        cancel.setFont(font);

        panel.add(Box.createHorizontalStrut(100));
        panel1.add(text);
        panel.add(panel1);
        panel2.add(button[1]);
        panel2.add(button[2]);
        panel2.add(button[3]);
        panel2.add(Box.createHorizontalStrut(15));
        panel2.add(add);
        panel2.add(minus);
        panel.add(panel2);

        panel3.add(button[4]);
        panel3.add(button[5]);
        panel3.add(button[6]);
        panel3.add(Box.createHorizontalStrut(15));
        panel3.add(multiply);
        panel3.add(divide);
        panel.add(panel3);

    }
}
