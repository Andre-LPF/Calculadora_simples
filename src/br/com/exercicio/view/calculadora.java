package br.com.exercicio.view;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;


public class calculadora {
    private JTextField jLabelResultado;
    private JLabel jLabelValorA;
    private JLabel jLabelValorB;

    private JTextField jTextFieldValorA;
    private JTextField jTextFieldValorB;

    private JButton jButtonAdd;
    private JButton jButtonSub;
    private JButton jButtonMul;
    private JButton jButtonDiv;
    private JButton jButtonClear;

    public calculadora() {
        JFrame jFrameTelaPrincipal = new JFrame("Calculadora Simples");
        jFrameTelaPrincipal.setLayout(null);
        jFrameTelaPrincipal.setSize(300, 400);

        jLabelResultado = new JTextField("Resultado");
        jLabelResultado.setEditable(false);
        jLabelValorA = new JLabel("Valor A:");
        jLabelValorB = new JLabel("Valor B:");

        jTextFieldValorA = new JTextField();
        jTextFieldValorA.setDocument(new onlyNumber());
        jTextFieldValorB = new JTextField();
        jTextFieldValorB.setDocument(new onlyNumber());

        jButtonAdd = new JButton("+");
        jButtonSub = new JButton("-");
        jButtonMul = new JButton("*");
        jButtonDiv = new JButton("/");
        jButtonClear = new JButton("Limpar");

        jLabelResultado.setBounds(10,10,280,20);
        jLabelResultado.setBackground(new Color(255,0 ,0));

        jLabelValorA.setBounds(10,30,50,20);
        jTextFieldValorA.setBounds(65,30, 220,20);

        jLabelValorB.setBounds(10,55,50,20);
        jTextFieldValorB.setBounds(65,55, 220,20);

        jButtonAdd.setBounds(60, 80, 50, 50);
        jButtonSub.setBounds(110, 80, 50, 50);
        jButtonMul.setBounds(160, 80, 50, 50);
        jButtonDiv.setBounds(210, 80, 50, 50);

        jButtonClear.setBounds(60,135, 200, 50);

        jButtonClear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        acaoBotaoLimpar();
                    }
                }
        );

        jButtonAdd.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        executarOperacao(actionEvent.getActionCommand());
                    }
                }
        );

        jButtonSub.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        executarOperacao(actionEvent.getActionCommand());
                    }
                }
        );

        jButtonMul.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        executarOperacao(actionEvent.getActionCommand());
                    }
                }
        );

        jButtonDiv.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        executarOperacao(actionEvent.getActionCommand());
                    }
                }
        );

        jFrameTelaPrincipal.add(jLabelResultado);
        jFrameTelaPrincipal.add(jLabelValorA);
        jFrameTelaPrincipal.add(jTextFieldValorA);
        jFrameTelaPrincipal.add(jLabelValorB);
        jFrameTelaPrincipal.add(jTextFieldValorB);
        jFrameTelaPrincipal.add(jButtonAdd);
        jFrameTelaPrincipal.add(jButtonSub);
        jFrameTelaPrincipal.add(jButtonMul);
        jFrameTelaPrincipal.add(jButtonDiv);
        jFrameTelaPrincipal.add(jButtonClear);
        jFrameTelaPrincipal.setResizable(false);
        jFrameTelaPrincipal.setVisible(true);
        jFrameTelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void executarOperacao(String actionCommand) {
        BigDecimal valorA = new BigDecimal(jTextFieldValorA.getText());
        BigDecimal valorB = new BigDecimal(jTextFieldValorB.getText());
        BigDecimal resultado;
        switch (actionCommand) {
            case "+":
                resultado = valorA.add(valorB);
                jLabelResultado.setText("" + resultado);
                break;
            case "-":
                resultado = valorA.subtract(valorB);
                jLabelResultado.setText("" + resultado);
                break;
            case "*":
                resultado = valorA.multiply(valorB);
                jLabelResultado.setText("" + resultado);
                break;
            case "/":
                try{
                    resultado = valorA.divide(valorB);
                    jLabelResultado.setText("" + resultado);
                } catch(ArithmeticException ex){
                    jLabelResultado.setText("não e possível realizar divisão por zero");
                }
                break;
        }
    }

    public class onlyNumber extends PlainDocument{
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

            super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
        }
    }

    private void acaoBotaoLimpar() {
        jLabelResultado.setText("Informe os valores para realizar a operação");
        jTextFieldValorA.setText("");
        jTextFieldValorB.setText("");
    }
}