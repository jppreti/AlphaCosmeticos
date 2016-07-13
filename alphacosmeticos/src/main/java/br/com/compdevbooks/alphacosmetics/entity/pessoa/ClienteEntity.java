package br.com.compdevbooks.alphacosmetics.entity.pessoa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity extends PessoaJuridicaEntity {
    
    @OneToOne(fetch = FetchType.EAGER)
    private VendedorEntity vendedorVO;
    
    public ClienteEntity() {
        super();
    }

    public ClienteEntity(Long id,String razao, String fantasia, String CNPJ, String inscricao) {
        super(id,razao, fantasia, CNPJ, inscricao);
    }

    public VendedorEntity getVendedorVO() {
        return vendedorVO;
    }

    public void setVendedorVO(VendedorEntity vendedorVO) {
        this.vendedorVO = vendedorVO;
    }

}
