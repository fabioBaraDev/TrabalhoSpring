package br.com.fiap.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.trabalho.dto.CreditoDTO;
import br.com.fiap.trabalho.service.CreditoService;

@RestController
@RequestMapping("transacoes")
public class TransacoesController {

	@Autowired
	CreditoService credito;
	
	@PostMapping("/credito/debitar")
	public ResponseEntity<String> debitarCredito(@RequestBody CreditoDTO creditoDTO) {
		String res = credito.debitar(creditoDTO);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PostMapping("/credito/adicionar")
	public ResponseEntity<String> adicionarCredito(@RequestBody CreditoDTO creditoDTO) {
		String res = credito.adicionar(creditoDTO);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/credito/saldo/id/{id}")
	public CreditoDTO getSaldoById(@PathVariable Integer id) {
		return credito.getSaldoById(id);	
	}

	
	@GetMapping("/credito/saldo/cartao/{cartao}")
	public CreditoDTO getSaldoById(@PathVariable Long cartao) {
		return credito.getSaldoByCartao(cartao);	
	}
}
