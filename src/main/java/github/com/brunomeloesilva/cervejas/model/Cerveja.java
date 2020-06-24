package github.com.brunomeloesilva.cervejas.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Cerveja {

	@NotBlank(message = "sku não pode estar em branco.")
	private String sku;
	
	@NotBlank(message = "nome não pode estar em branco.")
	private String nome;
	
	@Size(min = 1, max = 50, message = "descricao deve ter entre 1 e 50 chars.")
	private String descricao;
	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}