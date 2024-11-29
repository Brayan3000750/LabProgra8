
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */public class juego_Brayan extends JFrame {

private char[][] tablero;
    private Usuario jugador1;
    private Usuario jugador2;
    private Rank ranking;
    private char turno;

    public juego_Brayan(Usuario jugador1, Usuario jugador2, Rank ranking) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ranking = ranking;
        this.tablero = new char[3][3];
        this.turno = 'X';
        inicializarTablero();
        initComponents();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    private void initComponents() {
        JButton[][] botones = new JButton[3][3];
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new JButton("-");
                int fila = i, columna = j;
                botones[i][j].addActionListener(e -> realizarMovimiento(fila, columna, botones[fila][columna]));
                panel.add(botones[i][j]);
            }
        }

        setTitle("Juego X-O");
        add(panel);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void realizarMovimiento(int fila, int columna, JButton boton) {
        if (tablero[fila][columna] != '-') {
            JOptionPane.showMessageDialog(this, "Celda ocupada, elige otra.");
            return;
        }

        tablero[fila][columna] = turno;
        boton.setText(String.valueOf(turno));

        if (verificarGanador(turno)) {
            JOptionPane.showMessageDialog(this, "¡" + (turno == 'X' ? jugador1.getUsername() : jugador2.getUsername()) + " ha ganado!");
            if (turno == 'X') jugador1.incrementarPuntos(1);
            else jugador2.incrementarPuntos(1);
            volverAlMenu();
            return;
        }

        if (tableroLleno()) {
            JOptionPane.showMessageDialog(this, "¡Empate!");
            volverAlMenu();
            return;
        }

        turno = (turno == 'X') ? 'O' : 'X';
    }

    private boolean verificarGanador(char ficha) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) return true;
            if (tablero[0][i] == ficha && tablero[1][i] == ficha && tablero[2][i] == ficha) return true;
        }
        if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) return true;
        if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha) return true;
        return false;
    }

    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') return false;
            }
        }
        return true;
    }

    private void volverAlMenu() {
        new MenuPrincipal(jugador1, ranking).setVisible(true); 
        dispose(); // Cierra la ventana actual.
    }
}

    
    

