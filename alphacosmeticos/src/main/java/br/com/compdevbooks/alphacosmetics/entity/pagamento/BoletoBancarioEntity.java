package br.com.compdevbooks.alphacosmetics.entity.pagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "docboleto")
public class BoletoBancarioEntity extends DocumentoPagamentoEntity {
    
    @ManyToOne
    private BancoEntity bancoEmissorVO;
    
    @Column(nullable = false, length = 10)
    private String agencia;
    
    @Column(nullable = false, length = 10)
    private String carteira;
    
    @Column(nullable = false, length = 16)
    private String codigoBarra;

    public BancoEntity getBancoEmissorVO() {
        return bancoEmissorVO;
    }

    public void setBancoEmissorVO(BancoEntity bancoEmissorVO) {
        this.bancoEmissorVO = bancoEmissorVO;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    
    
    
    public boolean isValido() {
        boolean resp = false;

        return resp;
    }

    @Override
    public String toString() {
        return this.codigoBarra;
    }
    
    
}
