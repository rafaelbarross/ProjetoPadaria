/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_DAO;

import Model.Conexao;
import Model.Venda;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class VendaDAO {

    Connection conexao;

    public VendaDAO(Connection conexao1) {
        conexao = new Conexao().getConexao();
    }

    // Variável para armazenar o próximo id_venda a ser utilizado
    private static int idVenda = 1;

    // idiicona clientes na tabela "clientes"
    public void inserirVenda(Venda venda) {
        try {
            // Código para inserir a venda na tabela "vendas" do banco de dados
            // Prepara a instrução SQL para inserir a venda na tabela "vendas"
            String sql = "INSERT INTO vendas (nome_cliente, cpf_cliente, nome_produto, codigo_produto, quantidade, preco_unitario, preco_total, valor_bruto, desconto, forma_pagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conexao.prepareStatement(sql);

            // Define os valores dos parâmetros
            pstmt.setString(1, venda.getNomeCliente());
            pstmt.setString(2, venda.getCpfCliente());
            pstmt.setString(3, venda.getNomeProduto());
            pstmt.setInt(4, venda.getCodigoProduto());
            pstmt.setInt(5, venda.getQuantidade());
            pstmt.setDouble(6, venda.getPrecoUnitario());
            pstmt.setDouble(7, venda.getPrecoTotal());
            pstmt.setDouble(8, venda.getValorBruto());
            pstmt.setDouble(9, venda.getDesconto());
            pstmt.setString(10, venda.getFormaPagamento());

            // Executa a instrução SQL
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!");

            // Fecha a conexão com o banco de dados
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public ArrayList<Venda> consultarTodasVendas() {
        ArrayList<Venda> vendas = new ArrayList<>();
        try {
            // Prepara a instrução SQL para consultar as vendas na tabela "vendas"
            String sql = "SELECT id_venda, data, nome_cliente, cpf_cliente, nome_produto, codigo_produto, quantidade, preco_unitario, preco_total, valor_bruto, desconto, forma_pagamento FROM vendas";
            PreparedStatement sttmt = conexao.prepareStatement(sql);
            ResultSet rs = sttmt.executeQuery();

            // Percorre o ResultSet, adicionando cada venda encontrada à lista de vendas
            while (rs.next()) {
                // Obtém os valores das colunas da tabela "vendas"
                String Id = rs.getString("id_venda");
                String DATA = rs.getString("data");
                String NomeCliente = rs.getString("nome_cliente");
                String CpfCliente = rs.getString("cpf_cliente");
                String NomeProduto = rs.getString("nome_produto");
                int CodigoProduto = rs.getInt("codigo_produto");
                int Quantidade = rs.getInt("quantidade");
                double PrecoUnitario = rs.getDouble("preco_unitario");
                double PrecoTotal = rs.getDouble("preco_total");
                double ValorBruto = rs.getDouble("valor_bruto");
                double Desconto = rs.getDouble("desconto");              
                String FormaPagamento = rs.getString("forma_pagamento");

                // Cria um objeto Venda com os valores obtidos
                Venda venda = new Venda( Id, DATA, NomeCliente, CpfCliente, NomeProduto, CodigoProduto, Quantidade, PrecoUnitario, PrecoTotal, ValorBruto,Desconto, FormaPagamento );
                // Adiciona a venda à lista de vendas
                vendas.add(venda);
            }

            // Fecha a conexão com o banco de dados
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        // Retorna a lista de vendas
        return vendas;
    }

}
