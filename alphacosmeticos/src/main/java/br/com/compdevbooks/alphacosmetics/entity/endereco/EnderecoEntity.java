package br.com.compdevbooks.alphacosmetics.entity.endereco;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import br.com.compdevbooks.alphacosmetics.entity.IEntity;

@Embeddable
public class EnderecoEntity implements IEntity {

    @Column(length = 100, nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private int numero;

    @Column(length = 10, nullable = false)
    private String CEP;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    private BairroEntity bairroVO;

    public EnderecoEntity() {
        this.logradouro = "";
        this.CEP = "";
    }

    public EnderecoEntity(String logradouro, int numero, String CEP, BairroEntity bairro) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.CEP = CEP;
        this.bairroVO = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public BairroEntity getBairroVO() {
        return bairroVO;
    }

    public void setBairroVO(BairroEntity bairroVO) {
        this.bairroVO = bairroVO;
    }

    @Override
    public String toString() {
        return this.logradouro.trim() + ", " + this.numero + ", " + this.bairroVO + ", " + this.CEP;
    }

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object validar() {
		// TODO Auto-generated method stub
		return null;
	}
}
