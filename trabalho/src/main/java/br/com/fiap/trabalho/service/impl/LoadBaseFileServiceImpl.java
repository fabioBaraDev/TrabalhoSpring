package br.com.fiap.trabalho.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.trabalho.entity.Aluno;
import br.com.fiap.trabalho.repository.AlunoRepository;
import br.com.fiap.trabalho.service.LoadBaseFileService;
import br.com.fiap.trabalho.util.FilterFile;

@Service
public class LoadBaseFileServiceImpl implements LoadBaseFileService {

	@Autowired
	private AlunoRepository alunos;

	public void load() throws IOException {
		try {
			
			Stream file = FilterFile.filterFromResource("lista_alunos.txt");

			Stream<String> language = file;

			List<String> result = language.collect(Collectors.toList());

			for (String string : result) {
				setData(string);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void setData(String entry) {

		Long alunoId = Long.parseLong(entry.substring(41, 55).replace("-", "").replace(" ", ""));
		String nome = entry.substring(0, 41);

		Aluno aluno = new Aluno(nome, alunoId);
		
		alunos.save(aluno);

	}
}
