import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Ui implements ActionListener {
    private final JFrame frame;
    private final JPanel panel, panel1, panel2, panel3, panel4, panel5;
    private final JButton[] button;
    private final JButton add;
    private final JButton minus;
    private final JButton multiply;
    private final JButton divide;
    private final JButton equal;
    private final JButton cancel;
    private final JButton squareRoot;
    private final JButton square;
    private final JButton oneDividedBy;

    private final String[] buttonValue =
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private final Font font;
    private final JTextArea text;
    private final Font textFont;
    private final ImageIcon image;
    private final Calculator calculator;

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

        calculator = new Calculator();
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

        panel4.add(button[7]);
        panel4.add(button[8]);
        panel4.add(button[9]);
        panel4.add(Box.createHorizontalStrut(15));
        panel4.add(equal);
        panel4.add(cancel);
        panel.add(panel4);

        panel5.add(Box.createHorizontalStrut(92));
        panel5.add(button[0]);
        panel5.add(Box.createHorizontalStrut(210));
        panel.add(panel5);

        for (int i = 0; i < 10; i++) {
            button[i].addActionListener(this);
        }

        add.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        equal.addActionListener(this);
        cancel.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        Double checkNum = null;

        for (int i = 0; i < 10; i++) {
            if (source == button[i]) {
                text.replaceSelection(buttonValue[i]);
                return;
            }
        }
        try {
            checkNum = Double.parseDouble(text.getText());
        }catch (NumberFormatException ignored) {

        }

        if (checkNum != null || source == cancel) {
            if (source == add) {
                writer(calculator.calculateBi(Calculator.BiOperatorModes.minus, reader()));
                text.replaceSelection(add.getText());
            }
            if (source == minus) {
                writer(calculator.calculateBi(Calculator.BiOperatorModes.minus, reader()));
                text.replaceSelection(minus.getText());
            }
            if (source == multiply) {
                writer(calculator.calculateBi(Calculator.BiOperatorModes.multiply, reader()));
                text.replaceSelection(multiply.getText());
            }
            if (source == divide) {
                writer(calculator.calculateBi(Calculator.BiOperatorModes.divide, reader()));
                text.replaceSelection(divide.getText());
            }
            if (source == square) {
                writer(calculator.calculateMono(Calculator.MonoOperatorModes.square, reader()));
            }
            if (source == squareRoot)
                writer(calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, reader()));

            if (source == oneDividedBy)
                writer(calculator.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, reader()));

            if (source == equal)
                writer(calculator.calculateEqual(reader()));

            if (source == cancel)
                writer(calculator.reset());

        }
        text.selectAll();
    }

    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }

    public Double reader() {
        double num;
        String str;
        str = text.getText();
        num = Double.parseDouble(str);

        return num;
    }
}
