package br.com.fiap.trabalho.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.trabalho.dto.AlunoDTO;
import br.com.fiap.trabalho.dto.CreditoDTO;
import br.com.fiap.trabalho.entity.Credito;
import br.com.fiap.trabalho.repository.CreditoRepository;
import br.com.fiap.trabalho.service.AlunoService;
import br.com.fiap.trabalho.service.CreditoService;

@Service
public class CreditoServiceImpl implements CreditoService {

	@Autowired
	CreditoRepository creditoRepository;

	@Autowired
	AlunoService alunoService;

	public String debitar(CreditoDTO creditoDTO) {
		return "Debitado com sucesso!";

	}

	public String adicionar(CreditoDTO creditoDTO) {
		return "Credito adiocinado com sucesso!";
	}

	public CreditoDTO getSaldoById(Integer id) {
		Credito saldo = creditoRepository.findSaldoById(id);
		Optional<AlunoDTO> aluno = alunoService.getById(saldo.getId());

		CreditoDTO credito = new CreditoDTO(aluno.get(), saldo.getSaldo());
		return credito;
	}

	public CreditoDTO getSaldoByCartao(Long numeroCartao) {

		Credito saldo = creditoRepository.findSaldoByCartao(numeroCartao);
		Optional<AlunoDTO> aluno = alunoService.getById(saldo.getId());

		CreditoDTO credito = new CreditoDTO(aluno.get(), saldo.getSaldo());
		return credito;
	}
}
