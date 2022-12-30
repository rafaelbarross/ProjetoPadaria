/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_DAO;

import Model.Conexao;
import Model.Usuario;
import View.MenuPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class LoginDAO {
    
    Connection conexao;
    
    public LoginDAO(Connection conexao3){
        conexao = new Conexao().getConexao();
    }
    
    public void entrar(String nome, String senha){
        
        
        try {
            String sql = "select * from usuarios where nome_de_usuario=? and senha=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next()) {
                MenuPrincipal menu_Principal = new MenuPrincipal();
                menu_Principal.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "Senha ou usuario invalidos");
            }
            
        } catch (Exception e) {
            System.out.println(""+e);
        }
        
        
    }
    
}
