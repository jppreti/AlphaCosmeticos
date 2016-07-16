package br.com.compdevbooks.alphacosmetics.entity.pessoa;

import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoafisica")
public class PessoaFisicaEntity extends PessoaEntity {

    @Column(length = 14, nullable = false)
    private String CPF;

    @Column(length = 10, nullable = false)
    private String RG;

    public PessoaFisicaEntity() {

    }

    public PessoaFisicaEntity(long id,String nome, String CPF, String RG) {
        this.id=id;
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return this.nome + ", " + this.CPF + ", " + this.RG;
    }

    private boolean isValidoCPF() {
        boolean resp;
        String tempCPF = this.CPF;

        int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        tempCPF = tempCPF.replaceAll(Pattern.quote("."), "");
        tempCPF = tempCPF.replaceAll(Pattern.quote("-"), "");

        if ((tempCPF == null) || (tempCPF.length() != 11)) {
            resp = false;
        } else {
            Integer digito1 = calcularDigito(tempCPF.substring(0, 9), pesoCPF);
            Integer digito2 = calcularDigito(tempCPF.substring(0, 9) + digito1, pesoCPF);
            resp = tempCPF.equals(tempCPF.substring(0, 9) + digito1.toString() + digito2.toString());
        }
        return resp;
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
