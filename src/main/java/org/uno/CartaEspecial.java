package org.uno;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class CartaEspecial extends Carta implements Efecto{

    public CartaEspecial(String color, String valor) {
        super(color, valor);
    }



    @Override
    public void aplicarEfecto(Partida partida){
        if (Objects.equals(super.getValor(), "salto_turno")) {
            partida.saltarTurno();
        } else if (Objects.equals(super.getValor(), "chupate2")) {
            partida.getJugadores().get(partida.getTurno() + 1).robarCarta(partida.getMazo());
            partida.getJugadores().get(partida.getTurno() + 1).robarCarta(partida.getMazo());
        } else {
            partida.setSentido(!partida.isSentido());
        }
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
