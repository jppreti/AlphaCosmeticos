package br.com.compdevbooks.alphacosmetics.entity.pagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doccheque")
public class ChequeEntity extends DocumentoPagamentoEntity {
    
    @ManyToOne
    private BancoEntity bancoVO;
    
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
