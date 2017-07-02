package rmiCal.client;

import rmiCal.server.CalculateService;

import javax.swing.*;
import java.awt.*;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Calculator Client
 * Created by Charley on 2017/7/2.
 */

public class Calculator {

    double a, b;
    char op;

    String url = "rmi://localhost:6789/calculate";
    CalculateService cal ;
    JButton[] button = { new JButton("1"), new JButton("2"), new JButton("3"),
            new JButton("+"), new JButton("!"), new JButton("4"), new JButton("5"),
            new JButton("6"), new JButton("-"), new JButton("^"),new JButton("7"),
            new JButton("8"), new JButton("9"), new JButton("*"),new JButton("fib"),
            new JButton("0"), new JButton("."), new JButton("="),
            new JButton("/"),new JButton("cls")
    };

    JFrame calFrame = new JFrame("计算器--RMI");
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JTextField tf = new JTextField(20);
    protected String result = "";

    public Calculator() throws Exception {
        cal = (CalculateService) Naming.lookup(url);
        calFrame.setSize(300, 300);

        jp1.setLayout(new FlowLayout());
        jp1.setSize(200, 50);
        jp1.add(new JLabel("结果:"));
        jp1.add(tf);

        GridLayout gridLayout = new GridLayout(4, 5);

        jp2.setLayout(gridLayout);

        for (int i = 0; i < 20; i++) {
            jp2.add(button[i]);
            button[i].addActionListener(e -> {

                JButton btn = (JButton) e.getSource();
                if (btn.getText().matches("[0-9]")
                        || btn.getText().equals(".")) {
                    tf.setText(tf.getText() + btn.getText());
                } else if (btn.getText().matches("[+\\-*/]")) {
                    a = Double.parseDouble(tf.getText());
                    op = btn.getText().charAt(0);
                    tf.setText("");
                }
                else if(btn.getText().matches("!")){
                    a = Double.parseDouble(tf.getText());
                    op = btn.getText().charAt(0);
                    tf.setText("");
                }
                else if(btn.getText().equalsIgnoreCase("^")){
                    a = Double.parseDouble(tf.getText());
                    op = 'm';
                    tf.setText("");
                }
                else if(btn.getText().matches("fib")){
                    a = Double.parseDouble(tf.getText());
                    op = 'f';
                    tf.setText("");
                }
                else if(btn.getText().equalsIgnoreCase("cls")){
                    tf.setText("");
                    op = ' ';
                }
                else if(btn.getText().matches("=")){
                    switch (op) {
                        case '+':
                            try {
                                b = Double.parseDouble(tf.getText());
                                tf.setText(Double.toString(cal.add(a, b)));
                            } catch (RemoteException e1) {
                                e1.printStackTrace();
                            }
                            break;
                        case '-':
                            try {
                                b = Double.parseDouble(tf.getText());

                                tf.setText(Double.toString(cal.sub(a, b)));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            break;
                        case '*':
                            try {
                                b = Double.parseDouble(tf.getText());

                                tf.setText(Double.toString(cal.mul(a, b)));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            break;
                        case '/':
                            try {
                                b = Double.parseDouble(tf.getText());

                                tf.setText(Double.toString(cal.div(a, b)));

                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            break;
                        case '!':
                            try {
                                tf.setText(Double.toString(cal.fac(a)));
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            break;
                        case 'm':
                            try {
                                //System.out.println("nihao");
                                b = Double.parseDouble(tf.getText());
                                tf.setText(Double.toString(cal.pow(a,b)));
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                            break;
                        case 'f':
                            try {
                                for(int i1 = 1; i1 <= a; i1++){
//										result = result + Double.toString(cal.fibonacci(i))+" ";
                                }
                                tf.setText(result);

                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                    }
                }
            });
        }

        calFrame.setLayout(new BorderLayout());
        calFrame.add(jp1, BorderLayout.NORTH);
        calFrame.add(jp2, BorderLayout.CENTER);
        calFrame.setVisible(true);
    }

    public static void main(String[] args) throws RemoteException {
        try {
            new Calculator();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
