/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Usuario {

   private String username;
    private String password;
    private int puntos;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.puntos = 0;
    }

    public String getUsername() {
        return username;
    }

    public boolean validarPassword(String password) {
        return this.password.equals(password);
    }

    public int getPuntos() {
        return puntos;
    }

    public void incrementarPuntos(int puntos) {
       int puntos1 = this.puntos;
    
    }
}
