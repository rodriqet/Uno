package org.uno;

import java.util.Objects;
import java.util.Scanner;

public class CartaComodin extends Carta implements Colorable, Efecto{

    public CartaComodin(String color, String valor) {
        super(color, valor);
    }



    @Override
    public void aplicarEfecto(Partida partida){
        Scanner teclado = new Scanner(System.in);

        if (Objects.equals(super.getValor(), "cambio_color")) {
            String nuevoColor;

            while (true) {
                System.out.println("¿A qué color quieres cambiar? (verde, rojo, azul o amarillo): ");
                nuevoColor = teclado.next().toLowerCase();

                if (nuevoColor.equals("verde") ||
                        nuevoColor.equals("rojo") ||
                        nuevoColor.equals("azul") ||
                        nuevoColor.equals("amarillo")) {
                    break;
                } else {
                    System.out.println("Color no válido. Debes introducir: verde, rojo, azul o amarillo.");
                }
            }
            cambiarColor(nuevoColor);

        } else {
            for (int i = 0; i < 4; i++){
                partida.getJugadores().get(partida.getTurno() + 1).robarCarta(partida.getMazo());
            }
            partida.saltarTurno();
            System.out.println("El jugador: " + partida.getSiguienteJugador() + ", con ID: " + partida.getSiguienteJugador().getIdJugador() + ", roba 4 cartas.");
        }
    }



    @Override
    public void cambiarColor(String color){
        super.setColor(color);
    }


}
