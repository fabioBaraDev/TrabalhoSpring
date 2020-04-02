package br.com.fiap.trabalho.service;

import java.util.List;

import br.com.fiap.trabalho.dto.CreditoDTO;

public interface CreditoService {
	public String debitar(CreditoDTO creditoDTO);
	public String adicionar(CreditoDTO creditoDTO);
	public CreditoDTO getSaldoById(Integer id);
	public CreditoDTO getSaldoByCartao(Long numeroCartao);
}
