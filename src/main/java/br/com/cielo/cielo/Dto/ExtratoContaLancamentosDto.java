package br.com.cielo.cielo.Dto;

import java.util.List;

public class ExtratoContaLancamentosDto {

	private List<LancamentoDto> lancamentos;

	public ExtratoContaLancamentosDto() {

	}

	public ExtratoContaLancamentosDto(List<LancamentoDto> lancamentos) {
		super();
		this.lancamentos = lancamentos;
	}

	public List<LancamentoDto> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<LancamentoDto> lancamentos) {
		this.lancamentos = lancamentos;
	}
}
