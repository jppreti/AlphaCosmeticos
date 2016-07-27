package br.com.compdevbooks.alphacosmetics.entity.pagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doccredito")
public class CartaoCreditoEntity extends DocumentoPagamentoEntity {
    
      private String nome = "Cartão_Crédito";
    
    public void setnome(){
        super.setNome(nome);
    }
    public CartaoCreditoEntity(){
        setnome();
    }
    
    
    @ManyToOne
    private OperadoraCartaoEntity operadora;
    
    @Column(nullable = false, length = 16)
    private String numero;
    
    @Column(nullable = false, length = 5)
    private String validade;

    public OperadoraCartaoEntity getOperadora() {
        return operadora;
    }

    public void setOperadora(OperadoraCartaoEntity operadora) {
        this.operadora = operadora;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public boolean isValido() {
        boolean resp = false;

        return resp;
    }

    @Override
    public String toString() {
        return "Bandeira: "+this.operadora.getNome()+" Numero: "+this.numero+" Validade: "+this.validade;
    }
    
    
}
