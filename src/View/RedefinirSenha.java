/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Conexao;
import Model.Usuario;
import Model_DAO.RedefinirSenhaDAO;
import Model_DAO.Usuarios_DAO;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RedefinirSenha extends javax.swing.JFrame {

    /**
     * Creates new form RedefinirSenha
     */
    Connection conexao4 = Conexao.getConexao();
    
    public RedefinirSenha() {
        initComponents();
        senha_nova.setEnabled(false);
        verificacao.setEnabled(false);
        redefinir.setEnabled(false);
        
    }
    
    public void exibir(){
        this.codigo_redefinir.setEditable(false);
         this.nome_redefinir.setEditable(false);
         senha_nova.setEnabled(true);
         verificacao.setEnabled(true);   
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigo_redefinir = new javax.swing.JTextField();
        nome_redefinir = new javax.swing.JTextField();
        redefinir = new javax.swing.JButton();
        voltar_R = new javax.swing.JButton();
        senha_nova = new javax.swing.JPasswordField();
        verificacao = new javax.swing.JPasswordField();
        consultar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Redefinir Senha");
        getContentPane().setLayout(null);

        jLabel1.setText("Codigo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 60, 42, 16);

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 110, 37, 16);

        jLabel3.setText("Senha nova:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 270, 64, 16);

        jLabel4.setText("Repita sua senha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 330, 91, 16);
        getContentPane().add(codigo_redefinir);
        codigo_redefinir.setBounds(130, 60, 337, 22);
        getContentPane().add(nome_redefinir);
        nome_redefinir.setBounds(130, 120, 337, 22);

        redefinir.setText("Redefinir");
        redefinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redefinirActionPerformed(evt);
            }
        });
        getContentPane().add(redefinir);
        redefinir.setBounds(230, 380, 88, 38);

        voltar_R.setText("Voltar");
        voltar_R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar_RActionPerformed(evt);
            }
        });
        getContentPane().add(voltar_R);
        voltar_R.setBounds(370, 380, 105, 38);

        senha_nova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senha_novaActionPerformed(evt);
            }
        });
        getContentPane().add(senha_nova);
        senha_nova.setBounds(130, 270, 337, 22);
        getContentPane().add(verificacao);
        verificacao.setBounds(130, 330, 337, 22);

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        getContentPane().add(consultar);
        consultar.setBounds(390, 160, 81, 22);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View_imagens/redefininr senha.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 550, 460);

        setSize(new java.awt.Dimension(566, 495));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void redefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redefinirActionPerformed
        // TODO add your handling code here:
        if (!senha_nova.getText().isEmpty() && !verificacao.getText().isEmpty()) {

        String senha_nova = this.senha_nova.getText();
        String verificao = this.verificacao.getText();
        int Codigo = Integer.parseInt(this.codigo_redefinir.getText());
        
        
        RedefinirSenhaDAO redefinirSenhaDAO = new RedefinirSenhaDAO(conexao4);
       
       
        if(senha_nova.equals(verificao)){
             redefinirSenhaDAO.redefinir(senha_nova,Codigo);
            JOptionPane.showMessageDialog(null, "Senha alterar com sucesso");
        }else{
            JOptionPane.showMessageDialog(null, "Senhas não estão igual escrevar novamente!!!");
            this.verificacao.setText("");
            this.verificacao.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(null, "Campo senha ou Repita sua senha esta vazio");
        }
        
    }//GEN-LAST:event_redefinirActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed

        // TODO add your handling code here:
        
                
 if (!codigo_redefinir.getText().isEmpty() && !nome_redefinir.getText().isEmpty()) {
        // Realizar a consulta no banco de dados para verificar se o usuário existe
// Verificar se os campos "matricula" e "nome de usuário" estão preenchidos
    if (!codigo_redefinir.getText().isEmpty() && !nome_redefinir.getText().isEmpty()) {
        // Realizar a consulta no banco de dados para verificar se o usuário existe
        int codigo_redefinir = Integer.parseInt(this.codigo_redefinir.getText());
        String nome_redefinir = this.nome_redefinir.getText();
        RedefinirSenhaDAO redefinirSenhaDAO = new RedefinirSenhaDAO(conexao4);
        redefinirSenhaDAO.consutar(codigo_redefinir, nome_redefinir);
        if (redefinirSenhaDAO.consutar(codigo_redefinir, nome_redefinir) == true) {
            // Se o usuário existir, desabilitar os campos "matricula" e "nome de usuário" e habilitar os campos "senha" e repita "a senha"
            this.codigo_redefinir.setEnabled(false);
            this.nome_redefinir.setEnabled(false);
               
            senha_nova.setEnabled(true);
            verificacao.setEnabled(true);
            redefinir.setEnabled(true);

         } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Preencha os campos de os campos 'matricula' e 'nome de usuário'!");
    }
}
 
    }//GEN-LAST:event_consultarActionPerformed

    private void voltar_RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar_RActionPerformed
        // TODO add your handling code here:
        dispose();
        Login l = new Login();
        l.setVisible(true);
        
    }//GEN-LAST:event_voltar_RActionPerformed

    private void senha_novaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senha_novaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senha_novaActionPerformed

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
            java.util.logging.Logger.getLogger(RedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RedefinirSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo_redefinir;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nome_redefinir;
    private javax.swing.JButton redefinir;
    private javax.swing.JPasswordField senha_nova;
    private javax.swing.JPasswordField verificacao;
    private javax.swing.JButton voltar_R;
    // End of variables declaration//GEN-END:variables
}
