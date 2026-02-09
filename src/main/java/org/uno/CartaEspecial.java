package org.uno;

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


}
