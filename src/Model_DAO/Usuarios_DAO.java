/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_DAO;
import Model.Conexao;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class Usuarios_DAO {
    
    Connection conexao;
    
    public Usuarios_DAO(Connection conexao1){
        conexao = new Conexao().getConexao();
    }
    
    public void cadastrar(Usuario u){
        try {
            PreparedStatement ps1 = conexao.prepareStatement("SELECT * FROM usuarios WHERE codigo_de_usuario = ?");
            
            ps1.setInt(1, u.getCodigo_de_usuario());
            ResultSet resul = ps1.executeQuery();
            
            if (resul.next()) {
                // Exibe mensagem de erro informando que o código do produto já está em uso
                JOptionPane.showMessageDialog(null, "Erro: o código do produto já está em uso.");
                return;
            }else {
                PreparedStatement pst1 = conexao.prepareStatement("insert into usuarios(codigo_de_usuario, nome, nome_de_usuario, senha) values (?, ?, ?, ?);");
                pst1.setInt(1, u.getCodigo_de_usuario());
                pst1.setString(2, u.getNome());
                pst1.setString(3, u.getNome_de_usuario());
                pst1.setString(4, u.getSenha());
                pst1.executeUpdate();
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            } 
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    
    public Usuario Consultar(int codigo_de_usuario){
        Connection conexao = Conexao.getConexao();
        Usuario usuario = null;
        try {
            String sql = "SELECT * FROM usuarios WHERE codigo_de_usuario = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1,codigo_de_usuario);
            
            ResultSet rs = ps.executeQuery();
            
            
                if (rs.next()) {
                String nome = rs.getString("nome");
                String nome_de_usuario = rs.getString("nome_de_usuario");
                String senha = rs.getString("senha");

                usuario = new Usuario(codigo_de_usuario, nome,nome_de_usuario,senha);
            }
            
        } catch (Exception erro) {
            System.out.println("Erro ao consultar usuario: " + erro.getMessage());
        }
        return usuario;
    }
    
    public void excluir(int codigo){
        try {
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM usuarios WHERE codigo_de_usuario = ?");
            ps.setInt(1, codigo);
            ps.executeUpdate();
            
             JOptionPane.showMessageDialog(null, "\n Usuario removido com sucesso!");
            
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    
}
