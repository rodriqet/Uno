package org.uno;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {


    private ArrayList<Carta> cartas;

    public Baraja() {
        this.cartas = new ArrayList<>();
    }

    public void generarBaraja() {

        //VERDE
        for (int i = 0; i < 10; i++) {
            cartas.add(new CartaNumero(Carta.VERDE, String.valueOf(i)));
            cartas.add(new CartaNumero(Carta.VERDE, String.valueOf(i)));
        }

        //ROJO
        for (int i = 0; i < 10; i++) {
            cartas.add(new CartaNumero(Carta.ROJO, String.valueOf(i)));
            cartas.add(new CartaNumero(Carta.ROJO, String.valueOf(i)));
        }

        //AZUL
        for (int i = 0; i < 10; i++) {
            cartas.add(new CartaNumero(Carta.AZUL, String.valueOf(i)));
            cartas.add(new CartaNumero(Carta.AZUL, String.valueOf(i)));
        }

        //AMARILLO
        for (int i = 0; i < 10; i++) {
            cartas.add(new CartaNumero(Carta.AMARILLO, String.valueOf(i)));
            cartas.add(new CartaNumero(Carta.AMARILLO, String.valueOf(i)));
        }

        //CARTAS ESPECIALES
        for (int i = 0; i < 4; i++) {
            if (i < 2) {
                //CHUPATE2
                cartas.add(new CartaEspecial(Carta.VERDE, "chupate2"));
                cartas.add(new CartaEspecial(Carta.ROJO, "chupate2"));
                cartas.add(new CartaEspecial(Carta.AZUL, "chupate2"));
                cartas.add(new CartaEspecial(Carta.AMARILLO, "chupate2"));

                //CAMBIO_SENTIDO
                cartas.add(new CartaEspecial(Carta.VERDE, "cambio_sentido"));
                cartas.add(new CartaEspecial(Carta.ROJO, "cambio_sentido"));
                cartas.add(new CartaEspecial(Carta.AZUL, "cambio_sentido"));
                cartas.add(new CartaEspecial(Carta.AMARILLO, "cambio_sentido"));

                //SALTO_TURNO
                cartas.add(new CartaEspecial(Carta.VERDE, "salto_turno"));
                cartas.add(new CartaEspecial(Carta.ROJO, "salto_turno"));
                cartas.add(new CartaEspecial(Carta.AZUL, "salto_turno"));
                cartas.add(new CartaEspecial(Carta.AMARILLO, "salto_turno"));
            }
            //CHUPATE4
            cartas.add(new CartaComodin(Carta.NEGRO, "chupate4"));
            //CAMBIO_COLOR
            cartas.add(new CartaComodin(Carta.NEGRO, "cambio_color"));
        }

    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta robarCarta() {
        if (cartas.isEmpty()) {
            return null;
        } else {
            Carta carta = cartas.getLast();
            cartas.removeLast();
            return carta;
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        StringBuilder baraja = new StringBuilder();
        for (Carta carta : cartas){
            baraja.append(carta.toString());
        }
        return baraja.toString();
    }

}
