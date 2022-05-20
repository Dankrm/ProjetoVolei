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

public class TestSetJogo extends TestCase{
    
    public SetJogo setJogo;
    
    @Override
    public void setUp(){
        setJogo = new SetJogo(1, 30, 28);
    }
    
    public void testRetornaVencedor(){
        assertEquals("Cálculo de vencedor de Set", true, setJogo.isAGanhador());
    }
}
