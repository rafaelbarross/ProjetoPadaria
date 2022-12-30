
package Model;


public class Usuario {
    
    private int codigo_de_usuario;
    private String nome,nome_de_usuario,senha;

    public Usuario(int codigo_de_usuario, String nome, String nome_de_usuario, String senha) {
        this.codigo_de_usuario = codigo_de_usuario;
        this.nome = nome;
        this.nome_de_usuario = nome_de_usuario;
        this.senha = senha;
    }



    
    /**
     * @return the codigo_de_usuario
     */
    public int getCodigo_de_usuario() {
        return codigo_de_usuario;
    }

    /**
     * @param codigo_de_usuario the codigo_de_usuario to set
     */
    public void setCodigo_de_usuario(int codigo_de_usuario) {
        this.codigo_de_usuario = codigo_de_usuario;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nome_de_usuario
     */
    public String getNome_de_usuario() {
        return nome_de_usuario;
    }

    /**
     * @param nome_de_usuario the nome_de_usuario to set
     */
    public void setNome_de_usuario(String nome_de_usuario) {
        this.nome_de_usuario = nome_de_usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
