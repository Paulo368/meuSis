/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import control.GerenciadorInterGrafica;
import control.PedidoProdutoTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Fabricante;
import model.Pedido;
import model.PedidoProduto;
import model.Produto;
import org.hibernate.HibernateException;

/**
 *
 * @author Paulo
 */
public class DlgCadPedido extends javax.swing.JDialog {

    private Produto produtoSelecionado;
    private Fabricante fabSelecionado;
    private Cliente cliSelecionado;

    private PedidoProdutoTableModel pedidoProdutoModel;

    public DlgCadPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurePopupMenu();

        pedidoProdutoModel = new PedidoProdutoTableModel(); // Inicializa o modelo
        tabela.setModel(pedidoProdutoModel); // Associa o modelo à tabela
    }

    public Produto produtoSelecionado() {
        // Obtem o item selecionado no ComboBox
        Object itemSelecionado = cmbProduto.getSelectedItem();
        // Verifica se o item é uma instância de Produto e retorna
        if (itemSelecionado instanceof Produto) {
            return (Produto) itemSelecionado;
        }
        // Retorna null caso nenhum Produto válido esteja selecionado
        return null;
    }

    public Fabricante fabricanteSelecionado() {
        // Obtem o item selecionado no ComboBox
        Object itemSelecionado = cmbFab.getSelectedItem();
        // Verifica se o item é uma instância de Produto e retorna
        if (itemSelecionado instanceof Fabricante) {
            return (Fabricante) itemSelecionado;
        }
        // Retorna null caso nenhum Produto válido esteja selecionado
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popCadPecas = new javax.swing.JPopupMenu();
        mnuCadastar = new javax.swing.JMenuItem();
        mnuExcluir = new javax.swing.JMenuItem();
        cmbFab1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        lblCodigo1 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        dtPedido = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtQtde = new javax.swing.JTextField();
        lblFabricante = new javax.swing.JLabel();
        cmbFab = new javax.swing.JComboBox();
        lblNome = new javax.swing.JLabel();
        cmbProduto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNomeCli = new javax.swing.JTextField();
        btnPesqCli = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        txtValorTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        mnuCadastar.setText("jMenuItem1");
        popCadPecas.add(mnuCadastar);

        mnuExcluir.setText("jMenuItem1");
        popCadPecas.add(mnuExcluir);

        cmbFab1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fiat", "Volkswagen", "Toyota", "Chevrolet", " " }));
        cmbFab1.setSelectedIndex(1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

        lblData.setText("Data Pedido");

        dtPedido.setDateFormatString("dd/MM/yyyy");

        jLabel1.setText("Qtde");

        lblFabricante.setText("Fabricante");

        cmbFab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFabActionPerformed(evt);
            }
        });

        lblNome.setText("Produto");

        cmbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdutoActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome");

        btnPesqCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/search.png"))); // NOI18N
        btnPesqCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblData, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblNome))
                    .addComponent(lblFabricante)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQtde)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(287, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbFab, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesqCli)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodigo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNome)
                            .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblData)
                            .addComponent(dtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFabricante)
                            .addComponent(cmbFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/add.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/remove.png"))); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.setToolTipText("");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Pedidos"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Produto", "Qtde", "Fabricante", "Valor Total"
            }
        ));
        tabela.setShowHorizontalLines(true);
        tabela.setShowVerticalLines(true);
        jScrollPane3.setViewportView(tabela);

        jPanel5.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        txtValorTotal.setEnabled(false);
        txtValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorTotalActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(btnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApagar)
                    .addComponent(btnCadastrar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (pedidoProdutoModel == null) {
            pedidoProdutoModel = new PedidoProdutoTableModel(); // Inicializa o modelo se necessário
            tabela.setModel(pedidoProdutoModel); // Associa o modelo à tabela
        }
        // Validação do produto selecionado
        Produto produto = produtoSelecionado(); // Obtenha o produto selecionado
        if (produto == null) {
            JOptionPane.showMessageDialog(this, "Nenhum produto foi selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validação da quantidade
        String qtdeTexto = txtQtde.getText();
        if (qtdeTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A quantidade é obrigatória.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int quantidade = Integer.parseInt(qtdeTexto);
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Criando um novo Pedido
            Pedido pedido = new Pedido();
            pedido.setCliente(cliSelecionado); // Cliente selecionado
            pedido.setDtPedido(dtPedido.getDate()); // Data do pedido
            pedido.setValorTotal(0.0); // Valor inicial do pedido

            // Atualizando o valor total do pedido
            double valorProduto = produto.getPreco() * quantidade;
            pedido.setValorTotal(pedido.getValorTotal() + valorProduto);

            // Atualizando o valor total na interface
            double valorTotal = pedido.getValorTotal();
            String valorFormatado = String.format("%.2f", valorTotal);
            txtValorTotal.setText(valorFormatado);

            try {
                // Inserindo o pedido no banco de dados
                int idPedido = GerenciadorInterGrafica.getMyInstance().getGerDom().inserirPedido(pedido.getDtPedido(), quantidade, pedido.getValorTotal(), cliSelecionado);

                // Agora que o pedido foi inserido, podemos associar os itens
                pedido.setIdPedido(idPedido);  // Defina o ID do pedido, agora gerado no banco

                // Criando o item do pedido
                PedidoProduto item = new PedidoProduto();
                item.setPedido(pedido);  // Associa o pedido já persistido
                item.setProduto(produto);  // Associa o produto selecionado
                item.setQtde(quantidade);  // Define a quantidade
                
                pedidoProdutoModel.adicionar(item);

                // Mostrar mensagem de sucesso
                JOptionPane.showMessageDialog(this, "Pedido cadastrado com sucesso. ID do Pedido: " + idPedido, "Cadastro de Pedido", JOptionPane.INFORMATION_MESSAGE);

            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar o pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma quantidade válida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja apagar todos os dados?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            PedidoProdutoTableModel modelo = (PedidoProdutoTableModel) tabela.getModel();
            modelo.limpar();  // Apaga todas as linhas da tabela
            limparCamposProduto();
            JOptionPane.showMessageDialog(this, "Todos os dados foram apagados.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ação cancelada. Nenhum dado foi apagado.", "Cancelamento", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        GerenciadorInterGrafica.getMyInstance().carregarCombo(cmbFab, Fabricante.class);
        GerenciadorInterGrafica.getMyInstance().carregarCombo(cmbProduto, Produto.class);
    }//GEN-LAST:event_formComponentShown

    private void cmbFabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFabActionPerformed

    private void txtValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorTotalActionPerformed

    private void cmbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProdutoActionPerformed

    private void btnPesqCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqCliActionPerformed
        cliSelecionado = GerenciadorInterGrafica.getMyInstance().abrirPesqCliente();

        if (cliSelecionado != null) {
            txtNomeCli.setText(cliSelecionado.getNome());
        }
    }//GEN-LAST:event_btnPesqCliActionPerformed

    private void excluirLinhaSelecionada() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        int selectedRow = tabela.getSelectedRow(); // Obtém a linha selecionada

        if (selectedRow != -1) { // Verifica se alguma linha está selecionada
            modelo.removeRow(selectedRow); // Remove a linha selecionada
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para excluir.", "Cadastro de Peças", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void cadastrarDados() {
        // Coletando dados do usuário
        String nome = JOptionPane.showInputDialog(this, "Digite o nome da peça:");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O nome da peça não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String entrada = JOptionPane.showInputDialog(this, "Digite o código da peça:");
        if (entrada == null || entrada.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O número da peça não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int codigo;
        try {
            codigo = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            // Se a conversão falhar, informa ao usuário e sai do método
            JOptionPane.showMessageDialog(this, "Por favor, insira um número inteiro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verifica se o código já existe na tabela
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            int codigoExistente = (int) model.getValueAt(i, 1); // Supondo que o código está na coluna 1
            if (codigoExistente == codigo) {
                JOptionPane.showMessageDialog(this, "O código " + codigo + " já está cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String entrada1 = JOptionPane.showInputDialog(this, "Digite o preço da peça :");
        if (entrada1 == null || entrada.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O número da peça não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        float preco;
        try {
            preco = Float.parseFloat(entrada1);
        } catch (NumberFormatException e) {
            // Se a conversão falhar, informa ao usuário e sai do método
            JOptionPane.showMessageDialog(this, "Por favor, insira um preço válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fabricante = (String) cmbFab.getSelectedItem();
        if (fabricante == null || fabricante.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um fabricante.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Adicionando a peça à tabela
        model.addRow(new Object[]{nome, codigo, preco, fabricante});
        JOptionPane.showMessageDialog(this, "Peça cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void configurePopupMenu() {
        popCadPecas = new JPopupMenu();

        JMenuItem cadastrarItem = new JMenuItem("Cadastrar");
        cadastrarItem.addActionListener(e -> cadastrarDados());
        popCadPecas.add(cadastrarItem);

        JMenuItem apagarItem = new JMenuItem("Excluir");
        apagarItem.addActionListener(e -> excluirLinhaSelecionada());
        popCadPecas.add(apagarItem);

        tabela.setComponentPopupMenu(popCadPecas);
    }

    private void limparCamposProduto() {
        // Limpar os campos de texto
        txtNomeCli.setText("");  // Nome do produto
        txtValorTotal.setText("");  // Preço do produto
        txtQtde.setText("");  // Quantidade do produto no pedido

        cmbFab.setSelectedIndex(0);
        cmbProduto.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnPesqCli;
    private javax.swing.JComboBox cmbFab;
    private javax.swing.JComboBox cmbFab1;
    private javax.swing.JComboBox<String> cmbProduto;
    private com.toedter.calendar.JDateChooser dtPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblFabricante;
    private javax.swing.JLabel lblNome;
    private javax.swing.JMenuItem mnuCadastar;
    private javax.swing.JMenuItem mnuExcluir;
    private javax.swing.JPopupMenu popCadPecas;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtNomeCli;
    private javax.swing.JTextField txtQtde;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
