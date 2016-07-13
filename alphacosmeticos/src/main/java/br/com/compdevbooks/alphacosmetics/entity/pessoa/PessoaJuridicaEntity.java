package br.com.compdevbooks.alphacosmetics.entity.pessoa;

import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoajuridica")
public class PessoaJuridicaEntity extends PessoaEntity {

    @Column(length = 18, nullable = false)
    private String CNPJ;
    
    @Column(length = 20, nullable = false)
    private String inscricao;

    @Column(length = 50, nullable = false)
    private String fantasia;

    public PessoaJuridicaEntity() {
        super();
    }

    public PessoaJuridicaEntity(Long id,String razao, String fantasia, String CNPJ, String inscricao) {
        super(id, razao);
        this.CNPJ = CNPJ;
        this.inscricao = inscricao;
        this.fantasia = fantasia;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    
    /**
     * @return
     */
    @Override
    public String toString() {
        return this.nome+", "+this.fantasia+", "+this.CNPJ+", "+this.inscricao;
    }

    private boolean isValidoCNPJ() {
        boolean resp;
        String tempCNPJ;
        int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        tempCNPJ = this.CNPJ;
        tempCNPJ = tempCNPJ.replaceAll(Pattern.quote ("."), "");
        tempCNPJ = tempCNPJ.replaceAll(Pattern.quote ("-"), "");
        tempCNPJ = tempCNPJ.replaceAll(Pattern.quote ("/"), "");
        
        if ((tempCNPJ == null) || (tempCNPJ.length() != 14)) {
            resp = false;
        }

        Integer digito1 = calcularDigito(tempCNPJ.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(tempCNPJ.substring(0, 12) + digito1, pesoCNPJ);
        return tempCNPJ.equals(tempCNPJ.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    private int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

	@Override
	public Object validar() {
		// TODO Auto-generated method stub
		return null;
	}
}
