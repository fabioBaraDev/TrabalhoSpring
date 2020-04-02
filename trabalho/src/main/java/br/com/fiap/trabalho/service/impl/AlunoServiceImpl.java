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
		aluno = alunoRepository.save(aluno);

		return createAlunoDTO(aluno);
	}

	private Aluno createAluno(AlunoDTO alunoDTO) {
		return new Aluno(alunoDTO.getNome(), alunoDTO.getNumeroCartao());
	}
	
	private AlunoDTO createAlunoDTO(Aluno aluno) {
		return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getNumeroCartao());
	}

	public void delete(Integer id) {
		Optional<Aluno> aluno = getAluno(id);
		alunoRepository.delete(aluno.get());
	}

	private Optional<Aluno> getAluno(Integer id) {
		return alunoRepository.findById(id);
	}

	public List<AlunoDTO> getAll() {

		List<Aluno> alunos = alunoRepository.findAll();

		return alunos.stream().map((x) -> {
			return new AlunoDTO(x.getId(), x.getNome(), x.getNumeroCartao());
		}).collect(Collectors.toList());

	}

	public Optional<AlunoDTO> getById(Integer id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		Optional<AlunoDTO> alunoDTO = Optional
				.of(new AlunoDTO(aluno.get().getId(), aluno.get().getNome(), aluno.get().getNumeroCartao()));
		return alunoDTO;
	}

	public List<AlunoDTO> getByName(String nome) {

		List<AlunoDTO> alunoDTO = alunoRepository.findByName(nome.toUpperCase()).stream().map((x) -> {
			return new AlunoDTO(x.getId(), x.getNome(), x.getNumeroCartao());
		}).collect(Collectors.toList());

		return alunoDTO;
	}

}
