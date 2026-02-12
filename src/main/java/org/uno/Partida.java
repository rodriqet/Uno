package org.uno;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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

    public void iniciarPartida() {
        Carta cartaMazo = mazo.robarCarta();
        while (cartaMazo instanceof CartaComodin) {
            mazo.getCartas().add(cartaMazo);
            mazo.barajar();
            cartaMazo = mazo.robarCarta();
        }
        descarte.getCartas().add(cartaMazo);
    }

    private void reponerDescarte() {
        if (mazo.getCartas().isEmpty()) {
            mazo.setCartas(descarte.getCartas());
            mazo.barajar();
        }
    }

    private void cambiarTurno() {
        if (sentido) {
            turno++;
        } else {
            turno--;
        }
        turno = Math.floorMod(jugadores.size(), turno);
    }

    public void saltarTurno() {
        cambiarTurno();
        cambiarTurno();
    }

    public Jugador getSiguienteJugador() {
        if (sentido) {
            return jugadores.get(turno + 1);
        } else {
            return jugadores.get(turno - 1);
        }
    }

    private boolean esCartaValida(Carta carta) {
        boolean esValida = false;
        if (descarte.getCartas().isEmpty() || carta instanceof CartaComodin ||
                Objects.equals(carta.getColor(), descarte.getCartas().getFirst().getColor()) ||
                Objects.equals(carta.getValor(), descarte.getCartas().getFirst().getValor())) {
            esValida = true;
        }
        return esValida;
    }

    public void turno() {
        Scanner teclado = new Scanner(System.in);
        Jugador jugadorTurno = jugadores.get(turno);
        String opcion = "";
        int opcionCartaElegida = 0;

        System.out.println("Turno de: " + jugadorTurno.getNombre() + ", con ID: " + jugadorTurno.getIdJugador());
        System.out.println(descarte.getCartas().getFirst().toString());
        jugadorTurno.mostrarEstado();
        do {
            System.out.println("¿Quieres jugar o robar carta? (jugar/robar)");
            opcion = teclado.next().toLowerCase();
            if (!opcion.equals("jugar") && !opcion.equals("robar")) {
                System.out.println("Respuesta no válida, por favor intentelo de nuevo.");
            }
        } while (!opcion.equals("jugar") && !opcion.equals("robar"));

        if (opcion.equals("robar")) {
            if (mazo.getCartas().isEmpty()) {
                mazo.getCartas().addAll(
                        descarte.getCartas().subList(1, descarte.getCartas().size())
                );
                mazo.barajar();
                descarte.getCartas().subList(1, descarte.getCartas().size()).clear();
            }
            jugadorTurno.robarCarta(mazo);
            cambiarTurno();
        } else {
            do {
                System.out.println("¿Qué carta quieres jugar? (1, 2, 3, ...)");
                opcionCartaElegida = teclado.nextInt();
                if (opcionCartaElegida < 1 || opcionCartaElegida > jugadorTurno.getMano().size()) {
                    System.out.println("Respuesta no válida, por favor intentelo de nuevo.");
                }
            } while (opcionCartaElegida < 1 || opcionCartaElegida > jugadorTurno.getMano().size());
            Carta cartaElegida = jugadorTurno.getMano().get(opcionCartaElegida);

            if (esCartaValida(cartaElegida)) {
                jugadorTurno.jugarCarta(cartaElegida, this);
                cambiarTurno();
            } else {
                System.out.println("La carta elegida no es válida.");
            }
        }
    }

    public boolean verificarVictoria() {
        boolean victoria = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getMano().isEmpty()) {
                victoria = true;
            }
        }
        return victoria;
    }

}

