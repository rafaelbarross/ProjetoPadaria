package View;

import Model.Conexao;
import Model_DAO.ProdutoDAO;
import Model.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Produtos extends javax.swing.JFrame {

    // Cria uma conexão com o banco de dados
    Connection conexao = Conexao.getConexao();

    /**
     * Creates new form Cadastrar
     */
    public Produtos() {
        initComponents();
        excluir.setEnabled(false);
        confirmar.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        Preço = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        codigo = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        preco = new javax.swing.JTextField();
        quantEstoque = new javax.swing.JTextField();
        validade = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        consultarRadio = new javax.swing.JRadioButton();
        editarRadio = new javax.swing.JRadioButton();
        novoRadio = new javax.swing.JRadioButton();
        excluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Codigo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 240, 77, 32);

        Preço.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Preço.setText("Preço");
        getContentPane().add(Preço);
        Preço.setBounds(70, 330, 59, 32);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Quantidade em estoque");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 400, 259, 32);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Nome");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(350, 240, 74, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Validade");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 330, 92, 32);

        cancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancelar.setText("Fechar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(70, 530, 81, 31);

        confirmar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(360, 530, 109, 31);

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        getContentPane().add(codigo);
        codigo.setBounds(70, 280, 128, 22);
        getContentPane().add(nome);
        nome.setBounds(350, 280, 128, 22);
        getContentPane().add(preco);
        preco.setBounds(70, 360, 128, 22);
        getContentPane().add(quantEstoque);
        quantEstoque.setBounds(70, 440, 127, 22);

        try {
            validade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        validade.setText("");
        validade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validadeActionPerformed(evt);
            }
        });
        getContentPane().add(validade);
        validade.setBounds(350, 360, 92, 22);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Produtos");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(194, 26, 143, 48);

        buttonGroup1.add(consultarRadio);
        consultarRadio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        consultarRadio.setText("Consultar");
        consultarRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarRadioActionPerformed(evt);
            }
        });
        getContentPane().add(consultarRadio);
        consultarRadio.setBounds(113, 123, 98, 29);

        buttonGroup1.add(editarRadio);
        editarRadio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editarRadio.setText("Editar");
        editarRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarRadioActionPerformed(evt);
            }
        });
        getContentPane().add(editarRadio);
        editarRadio.setBounds(241, 123, 68, 29);

        buttonGroup1.add(novoRadio);
        novoRadio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        novoRadio.setText("Novo");
        novoRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoRadioActionPerformed(evt);
            }
        });
        getContentPane().add(novoRadio);
        novoRadio.setBounds(347, 123, 67, 29);

        excluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        getContentPane().add(excluir);
        excluir.setBounds(230, 530, 79, 31);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Selecione uma opção:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(181, 80, 173, 25);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View_imagens/produtos.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 550, 602);

        setSize(new java.awt.Dimension(550, 619));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        // TODO add your handling code here:
        if (novoRadio.isSelected()) {
           
            int Codigo = Integer.parseInt(this.codigo.getText());
            String Nome = this.nome.getText();
            double Preco = Double.parseDouble(this.preco.getText());
            String Validade = this.validade.getText();
            int Estoque = Integer.parseInt(this.quantEstoque.getText());

            Produto p = new Produto(Codigo, Nome, Preco, Validade, Estoque);
            ProdutoDAO pbanco = new ProdutoDAO(conexao);
            pbanco.cadastrarProduto(p);

        } else if (consultarRadio.isSelected()) {
            // Lógica para consultar os dados na tabela
            int Codigo = Integer.parseInt(this.codigo.getText());
            // Verifica se o tamanho do código é igual a 3
            if (String.valueOf(Codigo).length() <= 3) {
                ProdutoDAO p = new ProdutoDAO(conexao);
                Produto produto = p.consultarProduto(Codigo);
                if (produto != null) {
                    this.nome.setText(produto.getNome());
                    this.preco.setText(Double.toString(produto.getPreco()));
                    this.validade.setText(produto.getValidade());
                    this.quantEstoque.setText(Integer.toString(produto.getQuantidadeEmEstoque()));
                } else {
                    JOptionPane.showMessageDialog(null, "O código do produto não existe!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "O código do produto deve ter 3 dígitos!");
            }

        } else if (editarRadio.isSelected()) {
            // Lógica para editar os dados na tabela
            int Codigo = Integer.parseInt(this.codigo.getText());
            String Nome = this.nome.getText();
            double Preco = Double.parseDouble(this.preco.getText());
            String Validade = this.validade.getText();
            int Estoque = Integer.parseInt(this.quantEstoque.getText());

            Produto p = new Produto(Codigo, Nome, Preco, Validade, Estoque);
            ProdutoDAO pbanco = new ProdutoDAO(conexao);
            if (pbanco.alterarProduto(p)) {
                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar o produto!");
            }
        }
    }//GEN-LAST:event_confirmarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        // fecha a janela
        dispose();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
    }//GEN-LAST:event_cancelarActionPerformed


    private void novoRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoRadioActionPerformed
        // habilita todos os campos de texto para edição
        confirmar.setEnabled(true);
        codigo.setEnabled(true);
        nome.setEnabled(true);
        preco.setEnabled(true);
        validade.setEnabled(true);
        quantEstoque.setEnabled(true);
        excluir.setEnabled(false);
        // Limpar todas as caixas de texto
        this.codigo.setText("");
        this.nome.setText("");
        this.preco.setText("");
        this.validade.setText("");
        this.quantEstoque.setText("");
    }//GEN-LAST:event_novoRadioActionPerformed

    private void consultarRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarRadioActionPerformed

        // habilita todos os campos de texto para edição
        confirmar.setEnabled(true);
        codigo.setEnabled(true);
        nome.setEnabled(false);
        preco.setEnabled(false);
        validade.setEnabled(false);
        quantEstoque.setEnabled(false);
        excluir.setEnabled(false);


    }//GEN-LAST:event_consultarRadioActionPerformed

    private void editarRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarRadioActionPerformed

        // habilita todos os campos de texto para edição
        confirmar.setEnabled(true);
        codigo.setEnabled(true);
        nome.setEnabled(true);
        preco.setEnabled(true);
        validade.setEnabled(false);
        quantEstoque.setEnabled(true);
        excluir.setEnabled(true);


    }//GEN-LAST:event_editarRadioActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed

        // Executar a lógica de exclusão do produto aqui
        if (!codigo.getText().isEmpty()) {
            // verifica se o código do produto existe na tabela
            int Codigo = Integer.parseInt(codigo.getText());
            ProdutoDAO p = new ProdutoDAO(conexao);
            if (p.consultarProduto(Codigo) != null) {
                // o código do produto existe, então você pode excluir o produto da tabela
                p.removerProduto(Codigo);
            } else {
                // o código do produto não existe, então você pode exibir uma mensagem de erro para o usuário
                JOptionPane.showMessageDialog(null, "O código do produto não existe.");
            }
        } else {
            // o campo de código está vazio, então você pode exibir uma mensagem de erro para o usuário
            JOptionPane.showMessageDialog(null, "O campo de código está vazio.");
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void validadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_validadeActionPerformed

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
            java.util.logging.Logger.getLogger(Produtos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produtos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produtos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produtos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produtos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Preço;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField codigo;
    private javax.swing.JButton confirmar;
    private javax.swing.JRadioButton consultarRadio;
    private javax.swing.JRadioButton editarRadio;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nome;
    private javax.swing.JRadioButton novoRadio;
    private javax.swing.JTextField preco;
    private javax.swing.JTextField quantEstoque;
    private javax.swing.JFormattedTextField validade;
    // End of variables declaration//GEN-END:variables
}