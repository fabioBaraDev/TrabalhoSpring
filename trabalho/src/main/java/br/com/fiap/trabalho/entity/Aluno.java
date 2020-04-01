package br.com.fiap.trabalho.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "TB_ALUNO")
@EntityListeners(AuditingEntityListener.class)
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="nome", nullable = true)
	private String nome;

	@Column(name="numeroCartao", nullable = true)
	private Long numeroCartao;

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Aluno(){}
	
	public Aluno(String nome, Long alunoID){
		this.nome = nome;
		this.numeroCartao = alunoID;
	}
	

	public Integer getIdBaseDeDados() {
		return id;
	}

	public void setIdBaseDeDados(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
