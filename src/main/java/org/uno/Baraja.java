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
            //CHUPATE2
            cartas.add(new CartaNumero(Carta.VERDE, "chupate2"));
            cartas.add(new CartaNumero(Carta.VERDE, "chupate2"));
            cartas.add(new CartaNumero(Carta.ROJO, "chupate2"));
            cartas.add(new CartaNumero(Carta.ROJO, "chupate2"));
            cartas.add(new CartaNumero(Carta.AZUL, "chupate2"));
            cartas.add(new CartaNumero(Carta.AZUL, "chupate2"));
            cartas.add(new CartaNumero(Carta.AMARILLO, "chupate2"));
            cartas.add(new CartaNumero(Carta.AMARILLO, "chupate2"));

            //CAMBIO_SENTIDO
            cartas.add(new CartaNumero(Carta.VERDE, "cambio_sentido"));
            cartas.add(new CartaNumero(Carta.VERDE, "cambio_sentido"));
            cartas.add(new CartaNumero(Carta.ROJO, "cambio_sentido"));
            cartas.add(new CartaNumero(Carta.ROJO, "cambio_sentido"));
            cartas.add(new CartaNumero(Carta.AZUL, "cambio_sentido"));
            cartas.add(new CartaNumero(Carta.AZUL, "cambio_sentido"));
            cartas.add(new CartaNumero(Carta.AMARILLO, "cambio_sentido"));
            cartas.add(new CartaNumero(Carta.AMARILLO, "cambio_sentido"));

            //SALTO_TURNO
            cartas.add(new CartaNumero(Carta.VERDE, "salto_turno"));
            cartas.add(new CartaNumero(Carta.VERDE, "salto_turno"));
            cartas.add(new CartaNumero(Carta.ROJO, "salto_turno"));
            cartas.add(new CartaNumero(Carta.ROJO, "salto_turno"));
            cartas.add(new CartaNumero(Carta.AZUL, "salto_turno"));
            cartas.add(new CartaNumero(Carta.AZUL, "salto_turno"));
            cartas.add(new CartaNumero(Carta.AMARILLO, "salto_turno"));
            cartas.add(new CartaNumero(Carta.AMARILLO, "salto_turno"));
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

    @Override
    public String toString() {
        StringBuilder baraja = new StringBuilder();
        for (Carta carta : cartas){
            baraja.append(carta.toString());
        }
        return baraja.toString();
    }

}
