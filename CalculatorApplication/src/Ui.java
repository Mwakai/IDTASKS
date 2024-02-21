import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.ImageIcon;
import java.io.*;

public class Ui implements ActionListener {

    private final JFrame frame;

    private final JPanel panel;
    private final JPanel panel1;
    private final JPanel panel2;
    private final JPanel panel3;
    private final JPanel panel4;
    private final JPanel panel5;
    private final JPanel panel6;
    private final JPanel panel7;
    private final JPanel panel8;

    private final JTextArea text;

    private final JButton[] but;
    private final JButton add;
    private final JButton minus;
    private final JButton multiply;
    private final JButton divide;
    private final JButton equal;
    private final JButton cancel;
    private final JButton squareRoot;
    private final JButton square;
    private final JButton oneDivideBy;
    private final JButton cos;
    private final JButton sin;
    private final JButton tan;
    private final JButton powerOfY;
    private final JButton log;
    private final JButton trate;
    private final JButton tabs;
    private final JButton binary;
    private final JButton ln;
    private final Calculator calc;

    private final String[] value = {"0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9"};


    private final Font font;
    private final Font textFont;
    private final ImageIcon image;

    public Ui() throws IOException {
        frame = new JFrame("Calculator PH");

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

        but = new JButton[10];
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
        }
        add = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        equal = new JButton("=");
        squareRoot = new JButton("sqrt");
        square = new JButton("x*x");
        oneDivideBy = new JButton("1/x");
        cos = new JButton("Cos");
        sin = new JButton("Sin");
        tan = new JButton("Tan");
        ln = new JButton("ln");
        powerOfY = new JButton("x^y");
        log = new JButton("log10(x)");
        trate = new JButton("x%");
        tabs = new JButton("abs(x)");
        cancel = new JButton("C");
        binary = new JButton("Bin");

        calc = new Calculator();

    }


    public void init() {
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(image.getImage());

        text.setFont(textFont);
        text.setEditable(false);

        for (int i = 0; i < 10; i++) {
            but[i].setFont(font);
        }
        add.setFont(font);
        minus.setFont(font);
        multiply.setFont(font);
        divide.setFont(font);
        equal.setFont(font);
        squareRoot.setFont(font);
        square.setFont(font);
        oneDivideBy.setFont(font);
        cos.setFont(font);
        sin.setFont(font);
        tan.setFont(font);
        ln.setFont(font);
        powerOfY.setFont(font);
        log.setFont(font);
        trate.setFont(font);
        tabs.setFont(font);
        cancel.setFont(font);
        binary.setFont(font);

        panel.add(Box.createHorizontalStrut(100));
        panel1.add(text);
        panel.add(panel1);

        panel2.add(but[1]);
        panel2.add(but[2]);
        panel2.add(but[3]);
        panel2.add(Box.createHorizontalStrut(15));
        panel2.add(add);
        panel2.add(minus);
        panel.add(panel2);

        panel3.add(but[4]);
        panel3.add(but[5]);
        panel3.add(but[6]);
        panel3.add(Box.createHorizontalStrut(15));
        panel3.add(multiply);
        panel3.add(divide);
        panel.add(panel3);

        panel4.add(but[7]);
        panel4.add(but[8]);
        panel4.add(but[9]);
        panel4.add(Box.createHorizontalStrut(15));
        panel4.add(equal);
        panel4.add(cancel);
        panel.add(panel4);

        panel5.add(Box.createHorizontalStrut(92));
        panel5.add(but[0]);
        panel5.add(ln);
        panel5.add(Box.createHorizontalStrut(210));
        panel.add(panel5);

        panel6.add(square);
        panel6.add(squareRoot);
        panel6.add(oneDivideBy);
        panel6.add(powerOfY);
        panel.add(panel6);

        panel7.add(cos);
        panel7.add(sin);
        panel7.add(tan);
        panel.add(panel7);

        panel8.add(log);
        panel8.add(trate);
        panel8.add(tabs);
        panel8.add(binary);
        panel.add(panel8);

        for (int i = 0; i < 10; i++) {
            but[i].addActionListener(this);
        }
        add.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        square.addActionListener(this);
        squareRoot.addActionListener(this);
        oneDivideBy.addActionListener(this);
        cos.addActionListener(this);
        sin.addActionListener(this);
        tan.addActionListener(this);
        ln.addActionListener(this);
        powerOfY.addActionListener(this);
        log.addActionListener(this);
        trate.addActionListener(this);
        tabs.addActionListener(this);
        binary.addActionListener(this);

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
            if (source == but[i]) {
                text.replaceSelection(value[i]);
                return;
            }
        }


        try {
            checkNum = Double.parseDouble(text.getText());
        } catch(NumberFormatException ignored) {

        }

        if (checkNum != null || source == cancel) {
            if (source == add) {
                writer(calc.calculateBi(Calculator.BiOperatorModes.add, reader()));
                text.replaceSelection(add.getText());
            }

            if (source == minus) {
                writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()));
                text.replaceSelection(minus.getText());
            }

            if (source == multiply) {
                writer(calc.calculateBi(Calculator.BiOperatorModes.multiply, reader()));
                text.replaceSelection(multiply.getText());
            }

            if (source == divide) {
                writer(calc.calculateBi(Calculator.BiOperatorModes.divide, reader()));
                text.replaceSelection(divide.getText());
            }

            if (source == powerOfY) {
                writer(calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, reader()));
            }

            if (source == square) {
                writer(calc.calculateMono(Calculator.MonoOperatorModes.square, reader()));
            }

            if (source == squareRoot)
                writer(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, reader()));

            if (source == oneDivideBy)
                writer(calc.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, reader()));

            if (source == cos)
                writer(calc.calculateMono(Calculator.MonoOperatorModes.cos, reader()));

            if (source == sin)
                writer(calc.calculateMono(Calculator.MonoOperatorModes.sin, reader()));

            if (source == tan)
                writer(calc.calculateMono(Calculator.MonoOperatorModes.tan, reader()));

            if (source == log)
                writer(calc.calculateMono(Calculator.MonoOperatorModes.log, reader()));

            if (source == ln)
                writer(calc.calculateMono(Calculator.MonoOperatorModes.ln, reader()));

            if (source == trate)
                writer(calc.calculateMono(Calculator.MonoOperatorModes.rate, reader()));

            if (source == tabs)
                writer(calc.calculateMono(Calculator.MonoOperatorModes.abs, reader()));

            if (source == equal)
                writer(calc.calculateEqual(reader()));

            if (source == cancel)
                writer(calc.reset());

            if (source == binary)
                parsetoBinary();
        }

        text.selectAll();
    }

    private void parsetoBinary() {
        try {
            text.setText(Long.toBinaryString(Long.parseLong(text.getText())));
        } catch (NumberFormatException ex) {
            System.err.println("Error while parse to binary." + ex);
        }
    }

    public Double reader() {
        double num;
        String str;
        str = text.getText();
        num = Double.parseDouble(str);

        return num;
    }

    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }
}