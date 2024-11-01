/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Conexao;
import java.sql.*;
import Model.Produto;
import Model.Venda;
import Model_DAO.ProdutoDAO;
import Model_DAO.VendaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class Vendas extends javax.swing.JFrame {

    // Cria uma conexão com o banco de dados
    Connection conexao = Conexao.getConexao();

    public Vendas() {

        initComponents();
        valorBruto.setEnabled(false);
        valorTotal.setEnabled(false);

        this.codigoProduto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                nomeProduto.setEnabled(false);
                valorProduto.setEnabled(false);
                String textoCodigo = codigoProduto.getText();
                if (textoCodigo.length() == 3) {
                    try {
                        int codigo = Integer.parseInt(textoCodigo);

                        // Lógica para consultar os dados na tabela
                        ProdutoDAO p = new ProdutoDAO(conexao);
                        Produto produto = p.consultarProduto(codigo);
                        if (produto != null) {
                            nomeProduto.setText(produto.getNome());
                            valorProduto.setText(Double.toString(produto.getPreco()));
                            quantidadeDeProduto.removeAllItems();
                            for (int i = 1; i <= produto.getQuantidadeEmEstoque(); i++) {
                                ((DefaultComboBoxModel) quantidadeDeProduto.getModel()).addElement(i);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "O código do produto não existe.");
                        }
                    } catch (NumberFormatException exception) {
                        // O código digitado não é um número inteiro válido, então não fazemos nada
                    }
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nomeProduto = new javax.swing.JTextField();
        codigoProduto = new javax.swing.JTextField();
        valorProduto = new javax.swing.JTextField();
        quantidadeDeProduto = new javax.swing.JComboBox<>();
        inserir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        formaDePagamento = new javax.swing.JComboBox<>();
        finalizarCompra = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        valorBruto = new javax.swing.JTextField();
        desconto = new javax.swing.JTextField();
        valorTotal = new javax.swing.JTextField();
        remover = new javax.swing.JButton();
        cpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendas");

        jLabel1.setText("Nome do cliente:");

        jLabel2.setText("CPF:");

        nomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeClienteActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Código:");

        jLabel4.setText("Valor:");

        jLabel5.setText("Nome:");

        jLabel6.setText("Quantidade:");

        nomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeProdutoActionPerformed(evt);
            }
        });

        codigoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoProdutoActionPerformed(evt);
            }
        });

        valorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorProdutoActionPerformed(evt);
            }
        });

        quantidadeDeProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insira o código do item" }));
        quantidadeDeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeDeProdutoActionPerformed(evt);
            }
        });

        inserir.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        inserir.setText("Inserir");
        inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Valor Unitário", "Total do item"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Forma de pagamento:");

        formaDePagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Dinheiro", "Debíto", "Crédito", "Fiado" }));
        formaDePagamento.setToolTipText("");

        finalizarCompra.setFont(new java.awt.Font("Segoe UI", 0, 29)); // NOI18N
        finalizarCompra.setText("Finalizar compra");
        finalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarCompraActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Valor bruto:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Desconto:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Valor total:");

        valorBruto.setText("R$ 0,00");
        valorBruto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorBrutoActionPerformed(evt);
            }
        });

        desconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descontoActionPerformed(evt);
            }
        });

        valorTotal.setText("R$ 0,00");
        valorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTotalActionPerformed(evt);
            }
        });

        remover.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        remover.setText("Remover");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(valorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(codigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantidadeDeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 354, Short.MAX_VALUE)
                                        .addComponent(remover)
                                        .addGap(26, 26, 26)))
                                .addComponent(inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(valorBruto)
                                            .addComponent(desconto, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(37, 37, 37)
                                        .addComponent(formaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(finalizarCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(cpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelar)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(valorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantidadeDeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inserir)
                    .addComponent(remover))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(formaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(valorBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(finalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeClienteActionPerformed

    private void nomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeProdutoActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_nomeProdutoActionPerformed

    private void finalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarCompraActionPerformed
        // TODO add your handling code here:

        String NomeCliente = this.nomeCliente.getText();
        String CpfCliente = this.cpf.getText();
        String formaPagamento = (String) formaDePagamento.getSelectedItem();
        String NomeProduto = this.nomeProduto.getText();
        int CodigoProduto = Integer.parseInt(this.codigoProduto.getText());
        int quantidadeProduto = (int) quantidadeDeProduto.getSelectedItem();
        double PrecoUnitario = Double.parseDouble(this.valorProduto.getText());
        double PrecoTotal = Double.parseDouble(this.valorTotal.getText());       
        double ValorBruto = Double.parseDouble(this.valorBruto.getText());
        
        int Desconto;
        if (desconto.getText().isEmpty()) {
            Desconto = 0;
        } else {
            Desconto = Integer.parseInt(desconto.getText());
        }

        Venda v = new Venda(null,null, NomeCliente, CpfCliente, NomeProduto, CodigoProduto, quantidadeProduto, PrecoUnitario, PrecoTotal, ValorBruto, Desconto, formaPagamento);
        VendaDAO pbanco = new VendaDAO(conexao);
        pbanco.inserirVenda(v);
    }//GEN-LAST:event_finalizarCompraActionPerformed

    private void valorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTotalActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_valorTotalActionPerformed

    private void quantidadeDeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeDeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeDeProdutoActionPerformed

    private void valorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorProdutoActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_valorProdutoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        // fecha a janela
        dispose();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);

    }//GEN-LAST:event_cancelarActionPerformed

    private void tabelaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaAncestorAdded

    private void inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirActionPerformed
        // TODO add your handling code here:

        // Obtém os dados do formulário
        int codigo = Integer.parseInt(codigoProduto.getText());
        String nome = nomeProduto.getText();
        int quantidade = (int) quantidadeDeProduto.getSelectedItem();
        double valorUnitario = Double.parseDouble(valorProduto.getText());
        double total = quantidade * valorUnitario;

        // Adiciona os dados à tabela
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.addRow(new Object[]{codigo, nome, quantidade, valorUnitario, total});

        double ValorBruto = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            ValorBruto += (double) model.getValueAt(i, 4); // Soma o valor do item da linha atual
        }

        valorBruto.setText(String.valueOf(ValorBruto));
        valorTotal.setText(String.valueOf(ValorBruto));

        desconto.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Cancela a operação
                }
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                // Obtém o valor bruto e o desconto informados
                double ValorBruto = Double.parseDouble(valorBruto.getText());
                double Desconto = 0.0;
                if (desconto.getText().isEmpty()) {
                    Desconto = 0;
                } else {

                    Desconto = Double.parseDouble(desconto.getText());
                }
                // Verifica se o desconto é MENOR OU IGUAL  ao valor bruto
                if (Desconto > ValorBruto) {
                    // Mostra o valor bruto no valorTotal
                    valorTotal.setText(String.valueOf(ValorBruto));

                    //valorTotal.setText(Double.toString(ValorBruto));
                    // Limpa o campo de texto "desconto"
                    desconto.setText("");
                    // Exibe uma mensagem de erro                  
                    JOptionPane.showMessageDialog(null, "O desconto não pode ser maior que o valor bruto!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Atualiza o valor total
                    double ValorTotal = ValorBruto - Desconto;
                    valorTotal.setText(String.valueOf(ValorTotal));
                }

            }
        });


    }//GEN-LAST:event_inserirActionPerformed

    private void valorBrutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorBrutoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_valorBrutoActionPerformed

    private void descontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descontoActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_descontoActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        // TODO add your handling code here:
        // Obtém o modelo da tabela
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        // Verifica se há linhas selecionadas
        if (tabela.getSelectedRow() != -1) {
            // Remove a linha selecionada
            model.removeRow(tabela.getSelectedRow());
        }

        // Verifica se a tabela está vazia
        if (model.getRowCount() == 0) {
            // Limpa os campos valorBruto e valorTotal
            valorBruto.setText("");
            valorTotal.setText("");
            // Limpa o campo desconto
            desconto.setText("");
        } else {
            // Atualiza os campos valorBruto e valorTotal
            double ValorBruto = 0.0;
            for (int i = 0; i < model.getRowCount(); i++) {
                ValorBruto += (double) model.getValueAt(i, 4); // Soma o valor do item da linha atual
            }
            valorBruto.setText(String.valueOf(ValorBruto));
            valorTotal.setText(String.valueOf(ValorBruto));
        }

    }//GEN-LAST:event_removerActionPerformed

    private void codigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField codigoProduto;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JTextField desconto;
    private javax.swing.JButton finalizarCompra;
    private javax.swing.JComboBox<String> formaDePagamento;
    private javax.swing.JButton inserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JComboBox<String> quantidadeDeProduto;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField valorBruto;
    private javax.swing.JTextField valorProduto;
    private javax.swing.JTextField valorTotal;
    // End of variables declaration//GEN-END:variables
}
