/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_DAO;

import Model.Conexao;
import java.sql.Connection;

/**
 *
 * @author Rafael
 */
public class RelatorioDAO {
    
    Connection conexao;

    public RelatorioDAO(Connection conexao1) {
        conexao = new Conexao().getConexao();
    }
    
    
    
    
}
