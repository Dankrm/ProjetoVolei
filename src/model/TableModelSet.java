/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danton
 */
public class TableModelSet extends AbstractTableModel{
    public List<SetJogo> setsEmTela = new ArrayList<>();

    public TableModelSet() {
    }

    public TableModelSet(List<SetJogo> setsEmTela) {
        this.setsEmTela = setsEmTela;
    }

    public void setSetsEmTela(List<SetJogo> setsEmTela) {
        this.setsEmTela = setsEmTela;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public int getColumnCount() {
        return setsEmTela.size();
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SetJogo set = setsEmTela.get(columnIndex);
        Object value;
        switch(rowIndex){
            case 0:{
                value = "Set: " + set.getNumero();
                break;
            }
            case 1:{
                value = set.getPontosA();
                break;
            }
            case 2:{
                value = set.getPontosB();
                break;
            }
            default:{
                value = "X";
            }
        }
        return value;
    }
    
}
