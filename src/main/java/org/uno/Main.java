package org.uno;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        System.out.println("🎮Bienvenido al UNO en terminal🎮");
        System.out.println("¿Cuántos jugadores van a participar? (mínimo 2): ");
        int numJugadores = teclado.nextInt();
        for (int i = 0; i < numJugadores; i++) {
            System.out.println("Nombre del jugador " + (i+1) +": ");
            String nombreJugador = teclado.next();
            jugadores.add(new Jugador(nombreJugador));
        }

        Baraja mazo = new Baraja();
        mazo.generarBaraja();
        mazo.barajar();
        //Simula el reparto de las 7 cartas a cada jugador
        for (int i = 1; i <= 7; i++){
            for (int j = 0; j < numJugadores; j++) {
                jugadores.get(j).robarCarta(mazo);
            }
        }

        Partida partida = new Partida(jugadores, mazo);
        partida.iniciarPartida();

        do {
            partida.turno();
        } while (!partida.verificarVictoria());


    }

}