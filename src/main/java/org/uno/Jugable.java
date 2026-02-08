package org.uno;

public interface Jugable {

    void jugarCarta(Carta carta, Partida partida);

    void robarCarta(Baraja baraja);

    void mostrarEstado();
}
