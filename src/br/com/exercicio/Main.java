package br.com.exercicio;

import br.com.exercicio.view.calculadora;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new calculadora();
            }
        });
    }
}