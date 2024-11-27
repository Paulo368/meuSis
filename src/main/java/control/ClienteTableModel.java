package control;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Cliente;


public class ClienteTableModel extends AbstractTableModel {

    // Lista de OBJETOS
    private List<Cliente> listaItens = new ArrayList();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
        

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Nome", "Bairro", "Dt. Nasc", "Celular", "Foto" };        
        return nomesColunas[column];        
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Cliente item = listaItens.get(rowIndex);
            
            switch (columnIndex) {
                case 0: return item.getNome();
                case 1: return item.getEndereco().getBairro();
                case 2: return item.getDtNascFormatada();
                case 3: return item.getCelular();
                case 4: return item.getFoto();
                default: return null;
            }
        } catch (ParseException ex) {
            Logger.getLogger(ClienteTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void adicionar (Cliente item) {
        listaItens.add(item);
        fireTableRowsInserted( listaItens.size() - 1, listaItens.size() - 1 );        
    }
    
    public void remover (int indice) {        
        listaItens.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }

    public Cliente getCliente(int linha) {
        return listaItens.get(linha);
    }
    
    public void setLista(List<Cliente> novaLista) {
        
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
