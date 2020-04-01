package br.com.fiap.trabalho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.trabalho.dto.AlunoDTO;
import br.com.fiap.trabalho.entity.Aluno;
import br.com.fiap.trabalho.repository.AlunoRepository;
import br.com.fiap.trabalho.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public AlunoDTO save(AlunoDTO alunoDTO) {
		Aluno aluno = createAluno(alunoDTO);
		alunoRepository.save(aluno);
		return alunoDTO;
	}
	
	private Aluno createAluno(AlunoDTO alunoDTO) {
		return new Aluno(alunoDTO.getNome(), alunoDTO.getAlunoID());
	}
}
