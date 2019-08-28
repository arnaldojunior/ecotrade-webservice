package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Arnaldo Junior
 */
@Embeddable
@XmlType
public class Endereco implements Serializable {
    @Column(nullable = false)
    private String logradouro;
    
    @Column(nullable = false)
    private String bairro;
    
    @Column(nullable = false, length = 8)
    private String cep;
    
    private int numero;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
