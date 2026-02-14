package org.uno;

import java.util.ArrayList;

public class Jugador implements Jugable{

    private String nombre;

    private ArrayList<Carta> mano;

    private int idJugador;

    private static int idJugadorGenerator = 0;

    public Jugador(String nombre) {
        this.nombre = nombre;
        mano = new ArrayList<>();
        this.idJugador = idJugadorGenerator;
        idJugadorGenerator++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public int getIdJugador() {
        return idJugador;
    }

    @Override
    public void jugarCarta(Carta carta, Partida partida){
        if (mano.remove(carta)) {
            partida.getDescarte().getCartas().addFirst(carta);
            if (carta instanceof CartaEspecial || carta instanceof CartaComodin){
                ((Efecto) carta).aplicarEfecto(partida);
            }
        }
    }

    @Override
    public void robarCarta(Baraja baraja){
        mano.add(baraja.robarCarta());
    }

    @Override
    public void mostrarEstado(){
        for (Carta carta : mano){
            System.out.println(carta.toString());
        }
    }


}
