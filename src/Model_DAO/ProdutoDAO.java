package Model_DAO;

import Model.Conexao;
import Model.Produto;
import Model.Venda;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    Connection conexao;

    public ProdutoDAO(Connection conexao1) {
        conexao = new Conexao().getConexao();
    }

    public void cadastrarProduto(Produto p) {
        try {
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produtos WHERE cod = ?");
            ps.setInt(1, p.getCod());
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                // Exibe mensagem de erro informando que o código do produto já está em uso
                JOptionPane.showMessageDialog(null, "Erro: o código do produto já está em uso.");
                return; // Encerra a execução do método
            } else {
                PreparedStatement pst = conexao.prepareStatement("insert into produtos (cod, nome, preco, validade, quantidadeEmEstoque) values ( ?, ?, ?, ?, ?)");
                pst.setInt(1, p.getCod());
                pst.setString(2, p.getNome());
                pst.setDouble(3, p.getPreco());
                pst.setString(4, p.getValidade());
                pst.setInt(5, p.getQuantidadeEmEstoque());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    /*
    public ArrayList<Produto> consultarTudo() {
        ArrayList<Produto> produtos = new ArrayList();
        String sql = "select * from produtos;";
        try {
            PreparedStatement sttmt = conexao.prepareStatement(sql);
            ResultSet rst = sttmt.executeQuery();
            while (rst.next()) {
                int c = rst.getInt("cod");
                String n = rst.getString("nome");
                double pr = rst.getDouble("preco");
                String v = rst.getString("validade");
                int q = rst.getInt("Quantidade_em_estoque");

                Produto p = new Produto(c, n, pr, v, q);
                produtos.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta de produtos: " + ex);
        }
        return produtos;
    }*/

    public void removerProduto(int codigo) {
        try {
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM produtos WHERE cod = ?");
            ps.setInt(1, codigo);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "\n Produto removido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    public Produto consultarProduto(int codigo) {
        Connection conexao = Conexao.getConexao();
        Produto produto = null;

        try {
            String sql = "SELECT * FROM produtos WHERE cod = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                String validade = rs.getString("validade");
                int quantidadeEmEstoque = rs.getInt("quantidadeEmEstoque");

                produto = new Produto(codigo, nome, preco, validade, quantidadeEmEstoque);
            }
        } catch (SQLException ex) {
            // exibe uma mensagem de erro se houver algum problema ao consultar o produto
            System.out.println("Erro ao consultar produto: " + ex.getMessage());
        }

        return produto;
    }

    public boolean alterarProduto(Produto p) {
        String sql = "UPDATE produtos SET cod = ?, nome = ?, preco = ?, quantidadeEmEstoque = ? WHERE cod = ?";
        try ( PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, p.getCod());
            statement.setString(2, p.getNome());
            statement.setDouble(3, p.getPreco());
            statement.setInt(4, p.getQuantidadeEmEstoque());
            statement.setInt(5, p.getCod());

            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao alterar produto.", exception);
        }
        // Se a alteração foi realizada com sucesso, retornar true
        return true;
    }

    /*
    public List<Produto> consultarTodosProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            // Código para consultar todos os produtos na tabela "produtos" do banco de dados
            // Prepara a instrução SQL para consultar os produtos na tabela "produtos"
            String sql = "SELECT * FROM produtos";
            Statement stmt = conexao.createStatement();

            // Executa a instrução SQL e armazena os dados retornados em um ResultSet
            ResultSet rs = stmt.execute Query(sql);

            // Percorre o ResultSet, adicionando cada produto encontrado à lista de produtos
            while (rs.next()) {
                // Obtém os valores das colunas da tabela "produtos"
                int Cod = rs.getInt("cod");
                String Nome = rs.getString("nome");
                double Preco = rs.getDouble("preco");
                String Validade = rs.getString("validade");
                int quantidade = rs.getInt("quantidade");

                // Cria um objeto Produto com os valores obtidos
                Produto produto = new Produto(Cod, Nome, Preco, Validade, quantidade);
                // Adiciona o produto à lista de produtos
                produtos.add(produto);
            }

            // Fecha a conexão com o banco de dados
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        // Retorna a lista de produtos
        return produtos;
    }
     */
    public ArrayList<Produto> consultarTudo() {
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            // Código para consultar todos os produtos na tabela "produtos" do banco de dados
            // Prepara a instrução SQL para consultar todos os produtos na tabela "produtos"
            String sql = "SELECT * FROM produtos";
            PreparedStatement sttmt = conexao.prepareStatement(sql);
            ResultSet rs = sttmt.executeQuery();

            // Percorre o ResultSet, adicionando cada produto encontrado à lista de produtos
            while (rs.next()) {
                // Obtém os valores das colunas da tabela "produtos"
                int Cod = rs.getInt("cod");
                String Nome = rs.getString("nome");
                double Preco = rs.getDouble("preco");
                String Validade = rs.getString("validade");
                int quantidade = rs.getInt("quantidadeEmEstoque");

                // Cria um objeto Produto com os valores obtidos
                Produto produto = new Produto(Cod, Nome, Preco, Validade, quantidade);
                // Adiciona o produto à lista de produtos
                produtos.add(produto);
            }

            // Fecha a conexão com o banco de dados
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        // Retorna a lista de produtos
        return produtos;
    }

}