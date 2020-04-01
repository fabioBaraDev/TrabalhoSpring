package br.com.fiap.trabalho.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.trabalho.dto.AlunoDTO;
import br.com.fiap.trabalho.entity.Aluno;
import br.com.fiap.trabalho.service.AlunoService;

@RestController
@RequestMapping("alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping("/todos")
	public List<AlunoDTO> getAll() {
		return alunoService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Aluno> getById(@PathVariable Integer id) {
		return alunoService.getById(id);
	}
}
