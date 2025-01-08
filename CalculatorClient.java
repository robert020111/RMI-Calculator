package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorClient extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private CalculatorInterface calculator;
    private JTextField xField, yField, resultField;
    private JLabel operationLabel;

    public CalculatorClient() {
        super("Calculator RMI Robert");

        // creeare componente
        xField = new JTextField(10);
        yField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        operationLabel = new JLabel("Alege o operatiune:");

        JButton addButton = new JButton("Suma (x+y)");
        addButton.addActionListener(this);
        JButton subButton = new JButton("Diferenta (x-y)");
        subButton.addActionListener(this);
        JButton mulButton = new JButton("Inmultire (x*y)");
        mulButton.addActionListener(this);
        JButton divButton = new JButton("Impartire (x/y)");
        divButton.addActionListener(this);
        JButton squareButton = new JButton("X la puterea 2 (x^2)");
        squareButton.addActionListener(this);
        JButton sqrtButton = new JButton("Radical din x (√x)");
        sqrtButton.addActionListener(this);
        JButton factButton = new JButton("Factorial de X (X!)");
        factButton.addActionListener(this);
        JButton comb1Button = new JButton("Comb de x luate cate y (metoda 1)");
        comb1Button.addActionListener(this);
        JButton comb2Button = new JButton("Comb de x luate cate y (metoda 2)");
        comb2Button.addActionListener(this);

        // Creeare Layout
        JPanel inputPanel = new JPanel(new GridLayout(4, 4));
        inputPanel.add(new JLabel("X:"));
        inputPanel.add(xField);
        inputPanel.add(new JLabel("Y:"));
        inputPanel.add(yField);
        inputPanel.add(new JLabel("Rezultat:"));
        inputPanel.add(resultField);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(sqrtButton);
        buttonPanel.add(factButton);
        buttonPanel.add(comb1Button);
        buttonPanel.add(comb2Button);

        // Adaugam componentele
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(operationLabel, BorderLayout.SOUTH);
        
        // Intitializam conexiunean
        try {
      // Porniți serverul manual
      CalculatorServer.main(new String[] {});
        calculator = (CalculatorInterface) Naming.lookup("//localhost:1090/Calculator");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
        System.out.println(e);
        }

        // Setam proprietatiile chenarului
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(600, 400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double x = Double.parseDouble(xField.getText());
        double y = Double.parseDouble(yField.getText());

        try {
            switch (e.getActionCommand()) {
                case "Suma (x+y)":
                    {
                        double result = calculator.adunare(x, y);
                        resultField.setText(String.valueOf(result));
                        operationLabel.setText(x + " + " + y + " = " + result);
                        break;
                    }
                case "Diferenta (x-y)":
                    {
                        double result = calculator.scadere(x, y);
                        resultField.setText(String.valueOf(result));
                        operationLabel.setText(x + " - " + y + " = " + result);
                        break;
                    }
                case "Inmultire (x*y)":
                    {
                        double result = calculator.inmultire(x, y);
                        resultField.setText(String.valueOf(result));
                        operationLabel.setText(x + " * " + y + " = " + result);
                        break;
                    }
                case "Impartire (x/y)":
                    {    
                    if (y == 0) 
                        {
                        resultField.setText("");
                        operationLabel.setText("Nu se poate împărți la 0.");
                        break;
                        }
                double result = calculator.impartire(x, y);
                resultField.setText(String.valueOf(result));
                operationLabel.setText(x + " / " + y + " = " + result);
                break;
                    }
                case "X la puterea 2 (x^2)":
                    {
                        double result = calculator.patrat(x);
                        resultField.setText(String.valueOf(result));
                        operationLabel.setText(x + "^2 = " + result);
                        break;
                    }
                case "Radical din x (√x)":
                    {
                        if (x < 0) 
                        {
                        resultField.setText("");
                        operationLabel.setText("Nu se poate afla radical din numar negativ.");
                        break;
                        }
                        double result = calculator.radical(x);
                        resultField.setText(String.valueOf(result));
                        operationLabel.setText("√(" + x + ") = " + result);
                        break;
                    }
                case "Factorial de X (X!)":
                    {
                        if (x < 0) 
                        {
                        resultField.setText("");
                        operationLabel.setText("Nu se poate afla factorial din numar negativ.");
                        break;
                        }
                        double result = calculator.factorial((int) x);
                        resultField.setText(String.valueOf(result));
                        operationLabel.setText(x + "! = " + result);
                        break;
                    }
                case "Comb de x luate cate y (metoda 1)":
                    {
                      if (x < y || y<=0) 
                        {
                        resultField.setText("");
                        operationLabel.setText("X nu poate sa fie mai mic decat Y si Y nu poate sa fie < 0");
                        break;
                        }
                        double result = calculator.combinatii1((int) x,(int) y);
                        resultField.setText(String.valueOf(result));
                        operationLabel.setText("Combinari de "+x + " luate cate "+y +"="+ result+"-metoda1");
                        break;
                    }
                case "Comb de x luate cate y (metoda 2)":
                    {
                      if (x < y || y<=0) 
                        {
                        resultField.setText("");
                        operationLabel.setText("X nu poate sa fie mai mic decat Y si Y nu poate sa fie < 0");
                        break;
                        }
                        double result = calculator.combinatii2((int) x,(int) y);
                        resultField.setText(String.valueOf(result));
                        operationLabel.setText("Combinari de "+x + " luate cate "+y +"="+ result+"-metoda2");
                        break;
                    }
                default:
                    break;
            }
} catch (RemoteException ex) {
System.out.println(ex);
}
}
    public static void main(String[] args) {
    new CalculatorClient();
}

}