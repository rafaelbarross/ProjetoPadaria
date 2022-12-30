package Model;

public class Produto {
    private int cod, quantidadeEmEstoque;
    private double preco;
    private String nome;
    String validade;
    
    public Produto(int cod, String nome, double preco, String validade, int quantidadeEmEstoque) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    } 

    public int length() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}