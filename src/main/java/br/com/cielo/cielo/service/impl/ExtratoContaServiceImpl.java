package br.com.cielo.cielo.service.impl;

import br.com.cielo.cielo.Dto.ExtratoContaLancamentosDto;
import br.com.cielo.cielo.repository.ExtratoContaRepository;
import br.com.cielo.cielo.service.ExtratoContaService;
import br.com.cielo.cielo.util.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtratoContaServiceImpl implements ExtratoContaService {
	
	@Autowired
	private ExtratoContaRepository extratoContaLancamentosRepository;

	@Override
	public ExtratoContaLancamentosDto buscarLancamentos() {
		return ModelMapper.mapLancamentosContaToExtratoLancamentosResponse(extratoContaLancamentosRepository.recuperaLancamentoConta());
	}
}
