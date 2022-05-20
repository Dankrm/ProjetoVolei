/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import junit.framework.TestCase;

/**
 *
 * @author Danton
 */
public class TestJogo extends TestCase {

    private Jogo jogo;

    @Override
    public void setUp() {
        jogo = new Jogo(new Equipe("A"), new Equipe("B"), "12:00");
        jogo.salvaSet(25, 20);
        jogo.salvaSet(25, 20);
        jogo.salvaSet(25, 20);
    }
    
    public void testAlguemGanhou(){
        assertNotSame("Verificando ganhador", 'B', jogo.alguemGanhou());
    }

}
