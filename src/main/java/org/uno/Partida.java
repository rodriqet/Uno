package org.uno;

import java.util.ArrayList;

public class Partida {

    private ArrayList<Jugador> jugadores;

    private Baraja mazo;

    private Baraja descarte;

    private boolean sentido;

    private int turno;

    public Partida(ArrayList<Jugador> jugadores, Baraja baraja) {
        this.jugadores = jugadores;
        this.mazo = baraja;
        descarte = new Baraja();
        sentido = true;
        turno = 0;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Baraja getMazo() {
        return mazo;
    }

    public Baraja getDescarte() {
        return descarte;
    }

    public boolean isSentido() {
        return sentido;
    }

    public void setSentido(boolean sentido) {
        this.sentido = sentido;
    }

    public int getTurno() {
        return turno;
    }

    //TODO
    public void iniciarPartida() {

    }

    //TODO
    private void reponerDescarte() {

    }

    //TODO
    private void cambiarTurno() {

    }

    //TODO
    public void saltarTurno() {

    }

    //TODO
    public Jugador getSiguienteJugador() {

        return Jugador;
    }

    //TODO
    private boolean esCartaValida(Carta carta) {

        return false;
    }

    //TODO
    public void turno() {

    }

    //TODO
    public boolean verificarVictoria() {

        return false;
    }

}

