/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Conexao;
import Model.Logins;
import Model_DAO.LoginDAO;
import java.sql.Connection;

/**
 *
 * @author User
 */
public class Login extends javax.swing.JFrame {

    Connection conexao3 = Conexao.getConexao();
    
    /**
     * Creates new form Login
     */
    public Login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sair_login = new javax.swing.JButton();
        esqueci_senha = new javax.swing.JButton();
        nome_login = new javax.swing.JTextField();
        entrar = new javax.swing.JButton();
        senha_login = new javax.swing.JPasswordField();
        login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 200, 37, 16);

        jLabel2.setText("Senha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 270, 37, 16);

        sair_login.setText("Sair");
        sair_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sair_loginActionPerformed(evt);
            }
        });
        getContentPane().add(sair_login);
        sair_login.setBounds(540, 430, 89, 32);

        esqueci_senha.setText("Esqueci a minha senha");
        esqueci_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esqueci_senhaActionPerformed(evt);
            }
        });
        getContentPane().add(esqueci_senha);
        esqueci_senha.setBounds(180, 430, 290, 35);
        getContentPane().add(nome_login);
        nome_login.setBounds(180, 230, 290, 31);

        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        getContentPane().add(entrar);
        entrar.setBounds(180, 360, 290, 33);
        getContentPane().add(senha_login);
        senha_login.setBounds(180, 300, 290, 31);

        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View_imagens/Login.png"))); // NOI18N
        getContentPane().add(login);
        login.setBounds(0, 0, 790, 500);

        setSize(new java.awt.Dimension(788, 534));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        // TODO add your handling code here:
        MenuPrincipal menu_Principal = null;
        String nome = nome_login.getText();
        String senha = senha_login.getText();
        LoginDAO lbanco = new LoginDAO(conexao3);
        lbanco.entrar(nome, senha);
        MenuPrincipal.nome_menu.setText(nome);

    }//GEN-LAST:event_entrarActionPerformed

    private void sair_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sair_loginActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_sair_loginActionPerformed

    private void esqueci_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esqueci_senhaActionPerformed
        // TODO add your handling code here:
        dispose();
        RedefinirSenha redefinirSenha = new RedefinirSenha();
        redefinirSenha.setVisible(true);
    }//GEN-LAST:event_esqueci_senhaActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrar;
    private javax.swing.JButton esqueci_senha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel login;
    private javax.swing.JTextField nome_login;
    private javax.swing.JButton sair_login;
    private javax.swing.JPasswordField senha_login;
    // End of variables declaration//GEN-END:variables
}