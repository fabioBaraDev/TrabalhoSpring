package br.com.fiap.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.trabalho.entity.Credito;

public interface CreditoRepository extends JpaRepository<Credito, Integer> {
	
	@Query(value = "SELECT t.id, t.nome, t.numero_cartao, tc. saldo FROM tb_aluno t INNER JOIN tb_credito tc ON (t.id = tc.id) WHERE t.id = :id", nativeQuery = true)
	public Credito findSaldoById(Integer id);

	@Query(value = "SELECT t.id, t.nome, t.numero_cartao, tc. saldo FROM tb_aluno t INNER JOIN tb_credito tc ON (t.id = tc.id) WHERE t.numero_cartao = :numeroCartao", nativeQuery = true)
	public Credito findSaldoByCartao(Long numeroCartao);

}
