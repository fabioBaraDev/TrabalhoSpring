package br.com.fiap.trabalho.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tb_credito")
@EntityListeners(AuditingEntityListener.class)
public class Credito {
	
	@Id
	private Integer id;
	
	@Column(name="saldo", nullable = false)
	private Double saldo;
	
	@Column(name="numeroCartao", nullable = false)
	private Long numeroCartao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Long getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
}
