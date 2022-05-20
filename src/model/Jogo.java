/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static controller.MainController.jogo;
import static controller.MainController.principal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;

/**
 *
 * @author Danton
 */
public class Jogo {

    private Equipe equipeA;
    private Equipe equipeB;
    private String horario;
    private List<SetJogo> sets;

    private AtomicInteger ai = new AtomicInteger();

    public Jogo(Equipe equipeA, Equipe equipeB, String horario) {
        this.equipeA = equipeA;
        this.equipeB = equipeB;
        this.horario = horario;
        this.sets = new ArrayList<>();
    }

    public void salvaSet(int pontoA, int pontoB) {
        this.sets.add(new SetJogo(ai.incrementAndGet(), pontoA, pontoB));
    }

    public int getNumeroSetAtual() {
        return ai.get() + 1;
    }

    public Equipe getEquipeA() {
        return equipeA;
    }

    public Equipe getEquipeB() {
        return equipeB;
    }

    public String getHorario() {
        return horario;
    }

    public List<SetJogo> getSets() {
        return sets;
    }

    public Character alguemGanhou() {
        int jogoA = 0;
        int jogoB = 0;

        for (SetJogo sj : sets) {
            if (sj.isAGanhador()) {
                jogoA++;
            } else {
                jogoB++;
            }
        }
        
        if (jogoA == 3 || jogoB == 3) {
            if (jogoA > jogoB) {
                return 'A';
            } else {
                return 'B';
            }
        }else{
            return 'N';
        }
    }
}
