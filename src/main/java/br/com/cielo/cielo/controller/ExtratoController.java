package br.com.cielo.cielo.controller;

import br.com.cielo.cielo.Dto.ExtratoContaLancamentosDto;
import br.com.cielo.cielo.service.ExtratoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/extratoconta/")
public class ExtratoController {
	
	@Autowired
	private ExtratoContaService extratoLancamentosContaService;

	@GetMapping
	@RequestMapping("lancamentos")
	public ExtratoContaLancamentosDto buscarLancamentos() {
		return extratoLancamentosContaService.buscarLancamentos();
	}
	
}

