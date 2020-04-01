package br.com.fiap.trabalho.dto;

public class AlunoDTO {
	private String nome;
	private Long alunoID;
	
	public AlunoDTO(String nome, Long alunoID) {
		this.nome = nome;
		this.alunoID = alunoID;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getAlunoID() {
		return alunoID;
	}
	public void setAlunoID(Long alunoID) {
		this.alunoID = alunoID;
	}
}
