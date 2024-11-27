/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import control.FuncoesUteis;
import control.GerenciadorInterGrafica;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Cliente;
import model.Endereco;

/**
 *
 * @author Paulo
 */
public class DlgCadCliente extends javax.swing.JDialog {

    private Cliente cliSelecionado;

    public DlgCadCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpSexo = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        txtNome = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        lblCpf = new javax.swing.JLabel();
        lblDtNasc = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        lblFoto = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        txtCEP = new javax.swing.JFormattedTextField();
        btnAlterar = new javax.swing.JButton();
        lblComplem = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdbFemin = new javax.swing.JRadioButton();
        rdbMasc = new javax.swing.JRadioButton();
        txtEnder = new javax.swing.JTextField();
        lblEnder7 = new javax.swing.JLabel();
        lblEnder5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        lblEnder6 = new javax.swing.JLabel();
        dtNasc = new com.toedter.calendar.JDateChooser();
        txtCidade = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        lblNum = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        lblEnder = new javax.swing.JLabel();
        lblTelFixo = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        lblEnder1 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnNovo.setMnemonic('N');
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remove.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/search.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblCpf.setText("CPF");

        lblDtNasc.setText("Dt. Nasc.");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

        lblCEP.setText("CEP");

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCEPFocusLost(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/repeat.png"))); // NOI18N
        btnAlterar.setMnemonic('A');
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarbtnNovoActionPerformed(evt);
            }
        });

        lblComplem.setText("Complemento");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        grpSexo.add(rdbFemin);
        rdbFemin.setMnemonic('F');
        rdbFemin.setText("Feminino");
        rdbFemin.setActionCommand("Feminino");
        rdbFemin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rb.gif"))); // NOI18N
        rdbFemin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rbr.gif"))); // NOI18N
        rdbFemin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rbrs.gif"))); // NOI18N
        jPanel2.add(rdbFemin, java.awt.BorderLayout.CENTER);

        grpSexo.add(rdbMasc);
        rdbMasc.setMnemonic('M');
        rdbMasc.setText("Masculino");
        rdbMasc.setActionCommand("Masculino");
        rdbMasc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rb.gif"))); // NOI18N
        rdbMasc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rbp.gif"))); // NOI18N
        rdbMasc.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rbs.gif"))); // NOI18N
        rdbMasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMascActionPerformed(evt);
            }
        });
        jPanel2.add(rdbMasc, java.awt.BorderLayout.PAGE_START);

        lblEnder7.setText("E-mail");

        lblEnder5.setText("Tel. Cel.");

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/rss.png"))); // NOI18N
        jToggleButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/rss_remove.png"))); // NOI18N

        lblEnder6.setText("Cidade");

        dtNasc.setDateFormatString("dd/MM/yyyy");

        lblNum.setText("Nº");

        lblNome.setText("Nome");

        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        lblEnder.setText("Endereço");

        lblTelFixo.setText("Tel. Fixo");

        lblEnder1.setText("Bairro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEnder7)
                        .addGap(27, 27, 27)
                        .addComponent(txtEmail))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTelFixo)
                        .addGap(18, 18, 18)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(lblEnder5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEnder1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNum)
                                    .addGap(48, 48, 48)
                                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblComplem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtComplemento))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblEnder6)
                                    .addGap(23, 23, 23)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(lblDtNasc)
                                    .addComponent(lblCEP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCpf)
                                            .addComponent(dtNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCEP))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblEnder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEnder, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCEP)
                                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNome)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCpf)
                                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDtNasc)
                                            .addComponent(dtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComplem)
                    .addComponent(lblNum))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnder1)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnder6)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelFixo)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnder5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnder7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAlterar)
                        .addComponent(btnNovo)
                        .addComponent(btnCancelar))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        char sexo = (char) grpSexo.getSelection().getMnemonic();
        String cep = txtCEP.getText();
        String ender = txtEnder.getText();
        String txtNumero = txtNum.getText();
        String complemento = txtComplemento.getText();
        String bairro = txtBairro.getText();
        String referencia = txtCidade.getText();
        String telFixo = txtTel.getText();
        String celular = txtCelular.getText();
        String email = txtEmail.getText();

        if (validarCampos()) {
            // INSERIR NO BANCO
            try {
                int num = Integer.parseInt(txtNumero);

                if (cliSelecionado == null) {
                    // INSERIR
                    int id = GerenciadorInterGrafica.getMyInstance().getGerDom().inserirCliente(nome, cpf, dtNasc.getDate(), sexo,
                            cep, ender, num, complemento, bairro, referencia, telFixo, celular, email, lblFoto.getIcon());

                    JOptionPane.showMessageDialog(this, "Cliente " + id + " inserido com sucesso.");
                    limparCampos();
                } else {
                    // ALTERAR
                    GerenciadorInterGrafica.getMyInstance().getGerDom().alterarCliente(cliSelecionado.getIdCliente(), nome, cpf, dtNasc.getDate(), sexo,
                            cep, ender, num, complemento, bairro, referencia, telFixo, celular, email, lblFoto.getIcon());

                    JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso.");

                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO Cliente", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        habilitarBotoes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        cliSelecionado = GerenciadorInterGrafica.getMyInstance().abrirPesqCliente();

        if (cliSelecionado != null) {
            try {
                preencherCampos(cliSelecionado);
                habilitarBotoes();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao preencher os dados do cliente: " + ex.getMessage(),
                        "Preencher dados do cliente", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum cliente foi selecionado.",
                    "Selecionar Cliente", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked

        JFileChooser janArq = new JFileChooser();
        janArq.setAcceptAllFileFilterUsed(false);
        janArq.setFileFilter(new FileNameExtensionFilter("Arquivos de imagem", "jpg", "png", "gif", "bmp"));
        janArq.addChoosableFileFilter(new FileNameExtensionFilter("Arquivos de texto", "txt", "doc", "docx"));

        if (janArq.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File arquivo = janArq.getSelectedFile();

            // Transformar esse arquivo em Imagem
            ImageIcon imagem = new ImageIcon(arquivo.getAbsolutePath());
            mostrarFoto(imagem);

        }

    }//GEN-LAST:event_lblFotoMouseClicked

    private void txtCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCEPFocusLost
        try {
            String cep = txtCEP.getText();

            Endereco ender = FuncoesUteis.consultarCEP(cep);
            if (ender != null) {
                txtEnder.setText(ender.getLogradouro());
                txtBairro.setText(ender.getBairro());
                txtCidade.setText(ender.getCidade() + "/" + ender.getUf());
            } else {
                JOptionPane.showMessageDialog(this, "CEP não encontrado.", "Cadastro de Cliente", JOptionPane.ERROR_MESSAGE);
                txtEnder.setText("");
                txtBairro.setText("");
                txtCidade.setText("");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex, "Cadastro de Cliente", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_txtCEPFocusLost

    private void btnAlterarbtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarbtnNovoActionPerformed
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        char sexo = (char) grpSexo.getSelection().getMnemonic();
        String cep = txtCEP.getText();
        String ender = txtEnder.getText();
        String txtNumero = txtNum.getText();
        String complemento = txtComplemento.getText();
        String bairro = txtBairro.getText();
        String referencia = txtCidade.getText();
        String telFixo = txtTel.getText();
        String celular = txtCelular.getText();
        String email = txtEmail.getText();

        if (validarCampos()) {
            // INSERIR NO BANCO
            try {
                int num = Integer.parseInt(txtNumero);

                if (cliSelecionado == null) {
                    // INSERIR
                    int id = GerenciadorInterGrafica.getMyInstance().getGerDom().inserirCliente(nome, cpf, dtNasc.getDate(), sexo,
                            cep, ender, num, complemento, bairro, referencia, telFixo, celular, email, lblFoto.getIcon());

                    JOptionPane.showMessageDialog(this, "Cliente " + id + " inserido com sucesso.");
                    limparCampos();
                } else {
                    // ALTERAR
                    GerenciadorInterGrafica.getMyInstance().getGerDom().alterarCliente(cliSelecionado.getIdCliente(), nome, cpf, dtNasc.getDate(), sexo,
                            cep, ender, num, complemento, bairro, referencia, telFixo, celular, email, lblFoto.getIcon());

                    JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso.");

                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO Cliente", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnAlterarbtnNovoActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void rdbMascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbMascActionPerformed

    private boolean validarCampos() {

        String msgErro = "";

        lblNome.setForeground(Color.black);
        lblCEP.setForeground(Color.black);
        lblCpf.setForeground(Color.black);
        lblNum.setForeground(Color.black);
        lblDtNasc.setForeground(Color.black);

        if (txtNome.getText().trim().isEmpty()) {
            msgErro = msgErro + "Digite seu nome.\n";
            lblNome.setForeground(Color.red);
        }

        if (txtCEP.getText().replace("-", "").trim().isEmpty()) {
            msgErro = msgErro + "Digite seu CEP.\n";
            lblCEP.setForeground(Color.red);
        }

        if (FuncoesUteis.isCPF(txtCpf.getText()) == false) {
            msgErro = msgErro + "CPF inválido.\n";
            lblCpf.setForeground(Color.red);
        }
        try {
            int num = Integer.parseInt(txtNum.getText());
        } catch (NumberFormatException erro) {
            msgErro = msgErro + "Número inválido.\n";
            lblNum.setForeground(Color.red);
        } catch (Exception erro) {
            msgErro = msgErro + erro.getMessage() + "\n";
            lblNum.setForeground(Color.red);
        }

        if (dtNasc.getDate() == null) {
            msgErro = msgErro + "Data inválida.\n";
            lblDtNasc.setForeground(Color.red);
        } else {

            try {
                dtNasc.getDate().toString();
            } catch (Exception erro) {
                msgErro = msgErro + erro.getMessage() + "\n";
                lblNum.setForeground(Color.red);
            }
        }

        // COLOCAR VALIDAÇÃO DOS OUTROS CAMPOS
        if (msgErro.isEmpty()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, msgErro, "Cadastro de Cliente", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    private void mostrarFoto(Icon ic) {

        // Redimensionar
        ImageIcon imagem = (ImageIcon) ic;
        imagem.setImage(imagem.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));

        lblFoto.setText("");
        lblFoto.setIcon(imagem);
    }

    private void habilitarBotoes() {
        if (cliSelecionado == null) {
            btnNovo.setVisible(true);
            btnAlterar.setVisible(false);
        } else {
            btnNovo.setVisible(false);
            btnAlterar.setVisible(true);
        }
    }

    private void preencherCampos(Cliente cli) throws ParseException {
        if (cli != null) {
            txtNome.setText(cli.getNome());
            txtCpf.setText(cli.getCpf());
            dtNasc.setDate(cli.getDtNasc());
            txtCEP.setText(cli.getEndereco().getCep());
            txtEnder.setText(cli.getEndereco().getLogradouro());
            txtNum.setText(String.valueOf(cli.getEndereco().getNumero()));
            txtComplemento.setText(cli.getEndereco().getComplemento());
            txtBairro.setText(cli.getEndereco().getBairro());
            txtCidade.setText(cli.getEndereco().getReferencia());
            txtTel.setText(cli.getTelFixo());
            txtCelular.setText(cli.getCelular());
            txtEmail.setText(cli.getEmail());

            if (cli.getSexo() == 'M') {
                rdbMasc.setSelected(true);
            } else {
                rdbFemin.setSelected(true);
            }

            if (cli.getFoto() != null) {
                ImageIcon imagem = new ImageIcon(cli.getFoto());
                mostrarFoto(imagem);
            } else {
                lblFoto.setText("Foto");
                lblFoto.setIcon(null);
            }
        }
        // habilitarBotoes();
    }

    private void limparCampos() {
        cliSelecionado = null;
        txtNome.setText("");
        txtCpf.setText("");
        dtNasc.setDate(null);
        txtCEP.setText("");
        txtEnder.setText("");
        txtNum.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtTel.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        lblFoto.setText("Foto");
        lblFoto.setIcon(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private com.toedter.calendar.JDateChooser dtNasc;
    private javax.swing.ButtonGroup grpSexo;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblComplem;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDtNasc;
    private javax.swing.JLabel lblEnder;
    private javax.swing.JLabel lblEnder1;
    private javax.swing.JLabel lblEnder5;
    private javax.swing.JLabel lblEnder6;
    private javax.swing.JLabel lblEnder7;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblTelFixo;
    private javax.swing.JRadioButton rdbFemin;
    private javax.swing.JRadioButton rdbMasc;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnder;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}