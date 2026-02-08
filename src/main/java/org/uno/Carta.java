package org.uno;

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
}
