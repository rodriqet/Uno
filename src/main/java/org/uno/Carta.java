package org.uno;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class Carta {

    public static final String VERDE = "\033[92m";
    public static final String ROJO = "\033[91m";
    public static final String AZUL = "\033[94m";
    public static final String AMARILLO = "\033[93m";
    public static final String NEGRO = "\033[30m";
    public static final String RESET = "\033[0m";

    private String color;

    private String valor;

    public Carta(String color, String valor) {
        this.color = color;
        this.valor = valor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        File file = new File("src/main/java/org/uno/cartas_ascii/" + valor + ".txt");
        StringBuilder carta = new StringBuilder();
        carta.append(color);
        String linea = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((linea = br.readLine()) != null) {
                carta.append(linea).append("\n");
            }
            carta.append(Carta.RESET);
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return carta.toString();
    }
}
