package org.uno;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        System.out.println("🎮Bienvenido al UNO en terminal🎮");

        int numJugadores = 0;
        boolean leidoCorrectamente = false;

        while (!leidoCorrectamente) {
            System.out.println("¿Cuántos jugadores van a participar? (mínimo 2): ");
            try {
                numJugadores = teclado.nextInt();
                if (numJugadores >= 2) {
                    leidoCorrectamente = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error la entrada no es válida.");
                teclado.next();
            }
        }

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

        System.out.println("Carta en la pila de descarte:");
        System.out.println(partida.getDescarte().getCartas().getFirst().toString());
        System.out.println("¡El jugador: " + partida.getGanador().getNombre() + " ha ganado la partida!");



    }

}