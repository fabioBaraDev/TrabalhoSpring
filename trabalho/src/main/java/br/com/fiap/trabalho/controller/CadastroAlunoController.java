package br.com.fiap.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.trabalho.dto.AlunoDTO;
import br.com.fiap.trabalho.service.AlunoService;

@RestController
@RequestMapping("cadastro")
public class CadastroAlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@PutMapping
	public AlunoDTO save (@RequestBody AlunoDTO alunoDTO) {
			return alunoService.save(alunoDTO);
	}
}
