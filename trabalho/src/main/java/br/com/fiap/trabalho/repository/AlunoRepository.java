package br.com.fiap.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.trabalho.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
