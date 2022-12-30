/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_DAO;

import Model.Conexao;
import Model.Usuario;
import View.RedefinirSenha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RedefinirSenhaDAO {
    
    Connection conexao;
    
    public RedefinirSenhaDAO(Connection conexao4){
        conexao = new Conexao().getConexao();
    }
    
    public void redefinir(String rsenha,int codigo){
        
        
        
        try {
            String sql = "UPDATE usuarios SET senha = ?  where Codigo_de_usuario=?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            statement.setString(1, rsenha);
            statement.setInt(2, codigo);
            
            statement.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("\"Erro ao alterar senha.\","+e);
        }
    }
    
    public boolean consutar(int codigo, String nomedeusuario){
        boolean con = false;
        try {
            String sql = "select * from usuarios where Codigo_de_usuario=? and nome_de_usuario=?";
            PreparedStatement ps1 = conexao.prepareStatement(sql);
            ps1.setInt(1, codigo);
            ps1.setString(2, nomedeusuario);
            
            ResultSet rs = ps1.executeQuery();
            
            if(rs.next()){
                con = true;
            }else{
                con = false;
            }
            
        } catch (Exception e) {
            System.out.println(""+e);
        }
        return con;
        
    }


    
}
