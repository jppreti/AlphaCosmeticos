package br.com.compdevbooks.alphacosmetics.entity.pagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "docdebito")
public class CartaoDebitoEntity extends DocumentoPagamentoEntity {
    
    private String nome = "Cartão de Débito";
    
    public void setnome(){
        super.setNome(nome);
    }
    public CartaoDebitoEntity(){
        setnome();
    }
    
    @ManyToOne
    private BancoEntity bancoVO;
    
    @ManyToOne
    private OperadoraCartaoEntity operadoraVO;
    
    @Column(nullable = false, length = 10)
    private String agencia;
    
    @Column(nullable = false, length = 10)
    private String conta;

    public BancoEntity getBancoVO() {
        return bancoVO;
    }

    public void setBancoVO(BancoEntity bancoVO) {
        this.bancoVO = bancoVO;
    }

    public OperadoraCartaoEntity getOperadoraVO() {
        return operadoraVO;
    }

    public void setOperadoraVO(OperadoraCartaoEntity operadoraVO) {
        this.operadoraVO = operadoraVO;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public boolean isValido() {
        boolean resp = false;

        return resp;
    }

    @Override
    public String toString() {
        return "Banco: "+this.getBancoVO()+" Agencia: "+this.agencia+" Conta: "+this.conta;
    }
    
    
}
