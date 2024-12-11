/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Fabricante;

/**
 *
 * @author Paulo
 */
public class FabricanteTableModel extends AbstractTableModel{
    // Lista de OBJETOS
    private List<Fabricante> listaItens = new ArrayList();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
        

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Nome", "Telefone", "Email"};        
        return nomesColunas[column];        
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fabricante item = listaItens.get(rowIndex);
        switch (columnIndex) {
            case 0: return item.getNome();
            case 1: return item.getTelefone();
            case 2: return item.getEmail();
            default: return null;
        }
    }
    
    public void adicionar (Fabricante item) {
        listaItens.add(item);
        fireTableRowsInserted( listaItens.size() - 1, listaItens.size() - 1 );        
    }
    
    public void remover (int indice) {        
        listaItens.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }

    public Fabricante getFabricante(int linha) {
        return listaItens.get(linha);
    }
    
    public void setLista(List<Fabricante> novaLista) {
        
        if ( novaLista == null || novaLista.isEmpty()) {
            if ( !listaItens.isEmpty() ) {
                listaItens.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaItens = novaLista;
            fireTableRowsInserted( 0, listaItens.size() - 1);
        }
                
    }
}
