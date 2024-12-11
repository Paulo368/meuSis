/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import control.GerenciadorInterGrafica;
import control.PedidoTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pedido;
import model.PedidoProduto;
import org.hibernate.HibernateException;

/**
 *
 * @author Paulo
 */
public class DlgPesquisaPedido extends javax.swing.JDialog {

    private Pedido pedSelecionado = null;
    
    private PedidoTableModel pedTableModel;
    
    public DlgPesquisaPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        pedSelecionado = null;
        
        // ASSOCIAR o TABLE MODEL ABSTRACT
        pedTableModel = new PedidoTableModel();
        tblPedidos.setModel(pedTableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbTipo = new javax.swing.JComboBox();
        btnExcluir = new javax.swing.JButton();
        btnPedido = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        txtPesq = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID Pedido", "Cliente" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPedido.setText("Pedido");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblPedidos);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/search.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesq)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPesquisar)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(btnPedido)
                        .addGap(32, 32, 32)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar)
                    .addComponent(btnPedido)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        pedSelecionado = pegarLinhaSelecionada();

        if ( pedSelecionado != null) {

            if ( JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Excluir pedido", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION ) {

                //Excluir do BANCO
                try {
                    GerenciadorInterGrafica.getMyInstance().getGerDom().excluir(pedSelecionado);
                } catch (HibernateException ex) {
                    JOptionPane.showMessageDialog(this,"Erro ao excluir cliente. " + ex.getMessage(), "Pesquisar cliente", JOptionPane.ERROR_MESSAGE);
                }

                // Remover da TABELA
                int linha = tblPedidos.getSelectedRow();
                linha = tblPedidos.convertRowIndexToModel(linha);
                pedTableModel.remover(linha);
            }

        } else {
            // Mensagem de erro
            JOptionPane.showMessageDialog(this,"Selecione uma linha da tabela.", "Pesquisar pedido", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        pedSelecionado = pegarLinhaSelecionada();
        if ( pedSelecionado != null ) {
            String msg = "";

            GerenciadorInterGrafica.getMyInstance().getGerDom().getItensPedido(pedSelecionado );

            for (PedidoProduto ip : pedSelecionado.getListaItens()  ) {
                String nome = ip.getProduto().getNome();
                msg = msg.concat(nome).concat("\n");
            }
            JOptionPane.showMessageDialog(this, msg);
        }

    }//GEN-LAST:event_btnPedidoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        List<Pedido> lista;
        try {
            lista = GerenciadorInterGrafica.getMyInstance().getGerDom().pesquisarPedido(cmbTipo.getSelectedIndex(), txtPesq.getText() ) ;
            if ( lista.isEmpty() ) {
                JOptionPane.showMessageDialog(this,"Pedido não encontrado.", "Pesquisar pedido", JOptionPane.INFORMATION_MESSAGE);
            }
            pedTableModel.setLista(lista);

        } catch ( HibernateException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar pedido." + ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        // TODO add your handling code here:

        pedSelecionado = pegarLinhaSelecionada();
        this.setVisible(false);
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        pedSelecionado = null;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

    public Pedido getPedidoSelecionado() {
        return pedSelecionado;
    }
    
    private Pedido pegarLinhaSelecionada() {
        pedSelecionado = null;
        int linha = tblPedidos.getSelectedRow();
        if (linha >= 0) {
            linha = tblPedidos.convertRowIndexToModel(linha);
            pedSelecionado = pedTableModel.getItem(linha);                        
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um PEDIDO.");
        }  
        return pedSelecionado;                     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtPesq;
    // End of variables declaration//GEN-END:variables
}
