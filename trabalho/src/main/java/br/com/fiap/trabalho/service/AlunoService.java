package br.com.fiap.trabalho.service;

import java.util.List;
import java.util.Optional;

import br.com.fiap.trabalho.dto.AlunoDTO;
import br.com.fiap.trabalho.entity.Aluno;

public interface AlunoService {

	public AlunoDTO save(AlunoDTO alunoDTO);

	public void delete(Integer id);

	public List<AlunoDTO> getAll();
	
	public Optional<Aluno> getById(Integer id);

}
