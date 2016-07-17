package br.com.compdevbooks.alphacosmetics.entity.endereco;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.compdevbooks.alphacosmetics.entity.IEntity;

@Embeddable
public class TelefoneEntity implements IEntity {
    
    @Enumerated(EnumType.ORDINAL)
    private TipoUsoTelefoneEnum tipoUsoFone;
    
    @Enumerated(EnumType.ORDINAL)
    private TipoTelefoneEnum tipoFone;

    @Column(length = 3, nullable = false)
    private String ddi;
    
    @Column(length = 3, nullable = false)
    private String ddd;
    
    @Column(length = 9, nullable = false)
    private String numero;

    public TelefoneEntity() {
    }

    public TelefoneEntity(TipoUsoTelefoneEnum tipoUsoFone, TipoTelefoneEnum tipoFone, String ddi, String ddd, String numero) {
        this.tipoUsoFone = tipoUsoFone;
        this.tipoFone = tipoFone;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    public TipoUsoTelefoneEnum getTipoUsoFone() {
        return tipoUsoFone;
    }

    public void setTipoUsoFone(TipoUsoTelefoneEnum tipoUsoFone) {
        this.tipoUsoFone = tipoUsoFone;
    }

    public TipoTelefoneEnum getTipoFone() {
        return tipoFone;
    }

    public void setTipoFone(TipoTelefoneEnum tipoFone) {
        this.tipoFone = tipoFone;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    @Override
    public String toString() {
        return this.ddi+" ("+this.ddd+") "+this.numero;
    }

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object validar() {
		return null;
	}
}

