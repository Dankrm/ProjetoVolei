/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import main.TelaInformacoes;
import main.TelaPrincipal;
import model.Equipe;
import model.Jogo;
import model.SetJogo;
import model.TableModelSet;

/**
 *
 * @author Danton
 */
public class MainController {

    public static Jogo jogo;
    public static TelaInformacoes info;
    public static TelaPrincipal principal;

    public static void main(String[] args) {
        info = new TelaInformacoes();
        info.setVisible(true);
        setActionListenerComecar();
    }

    public static void setActionListenerComecar() {
        info.addBtnComecarEventListener((comecar) -> {
            info.setVisible(false);
            principal = new TelaPrincipal();
            principal.setVisible(true);
            principal.getTableSets().setTableHeader(null);
            principal.getTableSets().setModel(new TableModelSet());
            jogo = criaJogo();
            principal.getLabelEquipeA().setText(jogo.getEquipeA().getNome());
            principal.getLabelEquipeB().setText(jogo.getEquipeB().getNome());

            principal.getLabelSet().setText(String.valueOf(jogo.getNumeroSetAtual()));

            principal.addActionListenerBtnAddPontoA((e) -> {
                adicionarPontoA();
            });
            principal.addActionListenerBtnRemovePontoA((e) -> {
                removerPontoA();
            });
            principal.addActionListenerBtnAddPontoB((e) -> {
                adicionarPontoB();
            });
            principal.addActionListenerBtnRemovePontoB((e) -> {
                removerPontoB();
            });
        });
    }

    public static Jogo criaJogo() {
        return new Jogo(
                new Equipe((info.getTfEquipeA()).getText()),
                new Equipe((info.getTfEquipeB()).getText()),
                (info.getTfHorario()).getText());
    }

    public static void novoSet() {
        JLabel labelA = principal.getLabelPontosEquipeA();
        JLabel labelB = principal.getLabelPontosEquipeB();
        jogo.salvaSet(Integer.parseInt(labelA.getText()), Integer.parseInt(labelB.getText()));
        labelA.setText("0");
        labelB.setText("0");

        principal.getLabelSet().setText(String.valueOf(jogo.getNumeroSetAtual()));
        principal
                .getTableSets()
                .setModel(new TableModelSet(jogo.getSets()));
    }

    public static void adicionarPontoA() {
        JLabel label = principal.getLabelPontosEquipeA();
        int pontoA = (Integer.parseInt(label.getText())) + 1;
        label.setText(String.valueOf(pontoA));
        tentaFinalizarSet();
    }

    public static void removerPontoA() {
        JLabel label = principal.getLabelPontosEquipeA();
        int pontoA = (Integer.parseInt(label.getText())) - 1;
        if (pontoA >= 0) {
            label.setText(String.valueOf(pontoA));
        }
    }

    public static void adicionarPontoB() {
        JLabel label = principal.getLabelPontosEquipeB();
        int pontoB = (Integer.parseInt(label.getText())) + 1;
        label.setText(String.valueOf(pontoB));
        tentaFinalizarSet();
    }

    public static void removerPontoB() {
        JLabel label = principal.getLabelPontosEquipeB();
        int pontoB = (Integer.parseInt(label.getText())) - 1;
        if (pontoB >= 0) {
            label.setText(String.valueOf(pontoB));
        }
    }

    public static void tentaFinalizarSet() {
        int pontoA = Integer.parseInt(principal.getLabelPontosEquipeA().getText());
        int pontoB = Integer.parseInt(principal.getLabelPontosEquipeB().getText());

        if (jogo.getNumeroSetAtual() == 5) {
            if (pontoA >= 15 || pontoB >= 15) {
                if (pontoA >= pontoB + 2) {
                    tentaFinalizarPartida();
                } else if (pontoB >= pontoA + 2) {
                    tentaFinalizarPartida();
                }
            }
        } else {
            if (pontoA >= 25 || pontoB >= 25) {
                if (pontoA >= pontoB + 2) {
                    tentaFinalizarPartida();
                } else if (pontoB >= pontoA + 2) {
                    tentaFinalizarPartida();
                }
            }
        }
    }

    public static void tentaFinalizarPartida() {
        if (JOptionPane.showConfirmDialog(principal, "Você quer finalizar o set?", "Finalizar Set", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            novoSet();

            switch (jogo.alguemGanhou()) {
                case 'A':
                    if (JOptionPane.showConfirmDialog(principal, jogo.getEquipeA().getNome() + " vai ganhar", "Finalizar partida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(principal, "Parabéns " + jogo.getEquipeA().getNome());
                    }
                    break;
                case 'B':
                    if (JOptionPane.showConfirmDialog(principal, jogo.getEquipeB().getNome() + " vai ganhar", "Finalizar partida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(principal, "Parabéns " + jogo.getEquipeB().getNome());
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
