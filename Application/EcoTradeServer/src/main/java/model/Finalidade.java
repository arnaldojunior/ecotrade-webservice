package model;

/**
 *
 * @author Arnaldo Junior
 */
public enum Finalidade {

    DOACAO("Doação"),
    VENDA("Venda");
    
    private String descricao;
    
    Finalidade (String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}