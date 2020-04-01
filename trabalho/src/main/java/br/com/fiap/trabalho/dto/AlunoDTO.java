package br.com.fiap.trabalho.dto;

public class AlunoDTO {
	private String nome;
	private Long numeroCartao;
	
	public AlunoDTO(String nome, Long numeroCartao) {
		this.nome = nome;
		this.setNumeroCartao(numeroCartao);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

}
