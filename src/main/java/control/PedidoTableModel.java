package control;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Pedido;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 1547816
 */
public class PedidoTableModel extends AbstractTableModel {

    private List<Pedido> listaPedidos = new ArrayList();

    @Override
    public int getRowCount() {
        return listaPedidos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
        

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"ID", "Cliente", "Data"};
        
        return nomesColunas[column];
        
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido item = listaPedidos.get(rowIndex);
        switch (columnIndex) {
            case 0: return item.getIdPedido();
            case 1: return item.getCliente();
            case 2: return item.getDtPedido();
            default: return null;
        }
    }
    
    public Pedido getItem (int rowIndex) {
        return listaPedidos.get(rowIndex);        
    }
    
    public void adicionar (Pedido item) {
        listaPedidos.add(item);
        fireTableRowsInserted( listaPedidos.size() - 1, listaPedidos.size() - 1 );
        
    }
    
    public void remover (int indice) {
        listaPedidos.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }
    
    public void setLista(List<Pedido> novaLista) {
        if ( novaLista == null || novaLista.isEmpty()) {
            if ( !listaPedidos.isEmpty() ) {
                listaPedidos.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaPedidos = novaLista;
            fireTableRowsInserted( 0, listaPedidos.size() - 1);
        }
           
    }
    
    public List<Pedido> getLista() {
        return listaPedidos;
    }
        
}
