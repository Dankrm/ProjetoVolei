/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Danton
 */
public class SetJogo {
    private int numero;
    private int pontosA;
    private int pontosB;
    

    public SetJogo(int numero, int pontosA, int pontosB) {
        this.numero = numero;
        this.pontosA = pontosA;
        this.pontosB = pontosB;
    }

    public int getPontosA() {
        return pontosA;
    }

    public int getPontosB() {
        return pontosB;
    }

    public boolean isAGanhador() {
        return pontosA > pontosB;
    }

    public int getNumero() {
        return numero;
    }
    
    
    
}
