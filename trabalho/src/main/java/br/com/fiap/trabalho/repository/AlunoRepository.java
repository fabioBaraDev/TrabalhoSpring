package br.com.fiap.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.trabalho.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	//@Query("select nome, numero_cartao from TB_ALUNO")
	//List<Aluno> findAll();
}
