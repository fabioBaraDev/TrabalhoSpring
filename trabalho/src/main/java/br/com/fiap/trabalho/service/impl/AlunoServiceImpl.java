package br.com.fiap.trabalho.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.trabalho.dto.AlunoDTO;
import br.com.fiap.trabalho.entity.Aluno;
import br.com.fiap.trabalho.repository.AlunoRepository;
import br.com.fiap.trabalho.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

	public AlunoDTO save(AlunoDTO alunoDTO) {
		Aluno aluno = createAluno(alunoDTO);
		alunoRepository.save(aluno);
		return alunoDTO;
	}

	private Aluno createAluno(AlunoDTO alunoDTO) {
		return new Aluno(alunoDTO.getNome(), alunoDTO.getNumeroCartao());
	}

	public void delete(Integer id) {
		List<Aluno> aluno = getAluno(id);
		//alunoRepository.delete(aluno);
	}
//select nome, numero_cartao from TB_ALUNO
	private List<Aluno> getAluno(Integer id) {
		//return alunoRepository.findAlunos();
		return alunoRepository.findAll();
	}

	public List<AlunoDTO> getAll() {
		
		List<Aluno> alunos = alunoRepository.findAll();
		
		return alunos.stream().map((x) -> {return new AlunoDTO(x.getNome(), x.getNumeroCartao());}).collect(Collectors.toList());
		
	}

	public Optional<Aluno> getById(Integer id) {
		return alunoRepository.findById(id);
	}
}
