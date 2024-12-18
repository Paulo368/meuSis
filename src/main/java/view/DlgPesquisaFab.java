/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import control.FabricanteTableModel;
import control.GerenciadorInterGrafica;
import java.util.List;
import javax.swing.JOptionPane;
import model.Fabricante;
import org.hibernate.HibernateException;

/**
 *
 * @author Paulo
 */
public class DlgPesquisaFab extends javax.swing.JDialog {

    private Fabricante fabSelecionado;
    private FabricanteTableModel tableFabricanteModel;
    public DlgPesquisaFab(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        fabSelecionado = null;

        tableFabricanteModel = new FabricanteTableModel(); // Inicializa o modelo
        tblFabricante.setModel(tableFabricanteModel); // Associa o modelo à tabela
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFabricante = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        txtPesq = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblFabricante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "Email"
            }
        ));
        jScrollPane1.setViewportView(tblFabricante);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/remove.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/accept.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/search.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("Fabricante");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnPesquisar)
                    .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public Fabricante getFabSelecionado() {
        return fabSelecionado;
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        fabSelecionado = null;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblFabricante.getSelectedRow(); // Obtém a linha selecionada na tabela

        if (linha >= 0) {
            try {
                Fabricante cli = tableFabricanteModel.getFabricante(linha);  // Obtém o cliente da linha selecionada
                GerenciadorInterGrafica.getMyInstance().getGerDom().excluir(cli);  // Exclui o cliente

                // Atualiza o JTable após a exclusão
                tableFabricanteModel.remover(linha);
                JOptionPane.showMessageDialog(this, "Fabricante excluído com sucesso.", "Exclusão de Cliente", JOptionPane.INFORMATION_MESSAGE);
            } catch (HibernateException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o fabricante: " + ex.getMessage(), "Erro ao Excluir", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para excluir.", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed

        int linha = tblFabricante.getSelectedRow();

        if (linha >= 0) {
            fabSelecionado = tableFabricanteModel.getFabricante(linha);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Fabricante", "Pesquisar Fabricante", JOptionPane.ERROR_MESSAGE);
        }

        this.setVisible(false);
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String pesquisa = txtPesq.getText().trim(); // Obter o texto da pesquisa e remover espaços extras

        if (pesquisa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe um termo para pesquisa.", "Erro de Pesquisa", JOptionPane.WARNING_MESSAGE);
            return; // Não faz nada se a pesquisa estiver vazia
        }

        try {
            // Realiza a pesquisa no banco de dados
            List<Fabricante> lista = GerenciadorInterGrafica.getMyInstance().getGerDom().pesquisarFabricante(pesquisa);

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum fabricante encontrado para o termo informado.", "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
            }

            // Atualiza o JTable com os resultados da pesquisa
            tableFabricanteModel.setLista(lista);

        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar fabricantes: " + ex.getMessage(), "Erro de Pesquisa", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFabricante;
    private javax.swing.JTextField txtPesq;
    // End of variables declaration//GEN-END:variables
}
