/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Rank {
    private NodoJugador head; 
    private int contarJugadores;

public Rank() {
        this.head = null;
        this.contarJugadores = 0;
    }

   
    public void agregarJugador(Usuario usuario) {
        NodoJugador nuevo = new NodoJugador(usuario);
        if (head == null) {
            head = nuevo;
        } else {
            NodoJugador actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        contarJugadores++;
    }
    public String mostrarRanking() {
        if (head == null) {
            return "En el ranking no hay jugadores.";
        }

        
        Rank listaOrdenada = ordenarPorPuntos();

      
        StringBuilder ranking = new StringBuilder("RANKING DE JUGADORES:\n");
        NodoJugador actual = listaOrdenada.head;
        int posicion = 1;
        while (actual != null) {
            ranking.append(posicion).append(". ").append(actual.jugador.getUsername())
                    .append(" - ").append(actual.jugador.getPuntos()).append(" puntos\n");
            actual = actual.siguiente;
            posicion++;
        }
        return ranking.toString();
    }

    
    public Usuario buscarJugador(String username) {
        NodoJugador actual = head;
        while (actual != null) {
            if (actual.jugador.getUsername().equals(username)) {
                return actual.jugador;
            }
            actual = actual.siguiente;
        }
        return null; 
    }

    
    private Rank ordenarPorPuntos() {
        Rank listaOrdenada = new Rank();
        NodoJugador actual = head;

        while (actual != null) {
            Usuario jugador = actual.jugador;
            NodoJugador nodoOrdenado = new NodoJugador(jugador);

            if (listaOrdenada.head == null || jugador.getPuntos() > listaOrdenada.head.jugador.getPuntos()) {
                nodoOrdenado.siguiente = listaOrdenada.head;
                listaOrdenada.head = nodoOrdenado;
            } else {
                NodoJugador temp = listaOrdenada.head;
                while (temp.siguiente != null && temp.siguiente.jugador.getPuntos() >= jugador.getPuntos()) {
                    temp = temp.siguiente;
                }
                nodoOrdenado.siguiente = temp.siguiente;
                temp.siguiente = nodoOrdenado;
            }

            actual = actual.siguiente;
        }

        return listaOrdenada;
    }

    
    private static class NodoJugador {
        Usuario jugador;
        NodoJugador siguiente;

        public NodoJugador(Usuario jugador) {
            this.jugador = jugador;
            this.siguiente = null;
        }
    }
}


