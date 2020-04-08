package br.com.fiap.trabalho.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.fiap.trabalho.entity.Aluno;
import br.com.fiap.trabalho.entity.Credito;
import br.com.fiap.trabalho.repository.AlunoRepository;
import br.com.fiap.trabalho.repository.CreditoRepository;
import br.com.fiap.trabalho.service.impl.LoadBaseFileServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class LoadBaseFileServiceTest {

	@InjectMocks
	private LoadBaseFileServiceImpl service;

	@Mock
	private AlunoRepository alunos;

	@Mock
	private CreditoRepository credito;

	@Test
	public void load() throws IOException {

		List<String> items = new ArrayList<String>();

		items.add("AARON FELIPE GRASSMANN                   3095564 100-11");
		items.add("AARON PAPA DE MORAIS                     8610833 160-26");
		items.add("ABNER GALLILEI MOREIRA BORGES            1494778 500-35");

		Stream<String> stream = items.stream();

		Aluno aluno = new Aluno();
		aluno.setId(1);
		aluno.setNome("Joao");
		aluno.setNumeroCartao(11111L);

		//PowerMockito.mockStatic(FilterFile.class);
		//PowerMockito.when(FilterFile.filterFromResource("lista_alunos.txt")).thenReturn(stream);
		
		Mockito.when(alunos.save(Mockito.any(Aluno.class))).thenReturn(aluno);
		Mockito.when(credito.save(Mockito.any(Credito.class))).thenReturn(new Credito());
		
		service.load();

	}
}
