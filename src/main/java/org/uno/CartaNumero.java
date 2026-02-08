package org.uno;

import java.io.*;

public class CartaNumero extends Carta{

    public CartaNumero(String color, String valor) {
        super(color, valor);
    }



    @Override
    public String toString() {
        String color = super.getColor();
        File file = new File("/cartas_ascii/" + super.getValor() + ".txt");
        StringBuilder carta = new StringBuilder();
        carta.append(color);
        String linea = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((linea = br.readLine()) != null) {
                carta.append(linea);
            }
            carta.append(Carta.RESET);
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return carta.toString();
    }

}
