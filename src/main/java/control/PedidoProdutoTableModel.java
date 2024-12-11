/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.PedidoProduto;

/**
 *
 * @author Paulo
 */
public class PedidoProdutoTableModel extends AbstractTableModel {

    private List<PedidoProduto> listaItens = new ArrayList();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Codigo", "Preco", "Qtde", "Fabricante"};

        return nomesColunas[column];

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PedidoProduto item = listaItens.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return item.getProduto().getCodigo(); // Código do Produto
            case 1:
                return item.getProduto().getPreco();     // Preço
            case 2:
                return item.getQtde();                  // Quantidade
            case 3:
                return item.getProduto().getFabricante().getNome(); // Nome do Fabricante
            default:
                return null;
        }
    }

    public PedidoProduto getItem(int rowIndex) {
        return listaItens.get(rowIndex);
    }

    public void adicionar(PedidoProduto item) {
        listaItens.add(item);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);

    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);

    }

    public void setLista(List<PedidoProduto> novaLista) {
        if (novaLista == null || novaLista.isEmpty()) {
            if (!listaItens.isEmpty()) {
                listaItens.clear();
                fireTableRowsDeleted(0, 0);
            }
        } else {
            listaItens = novaLista;
            fireTableRowsInserted(0, listaItens.size() - 1);
        }

    }

    public List<PedidoProduto> getLista() {
        return listaItens;
    }
    
    // Método para limpar a lista de itens
    public void limpar() {
        listaItens.clear(); // Remove todos os elementos da lista
        fireTableDataChanged(); // Notifica que os dados da tabela foram alterados
    }

}
