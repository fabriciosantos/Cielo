package br.com.cielo.cielo.util;

import br.com.cielo.cielo.Dto.DadosBancariosDto;
import br.com.cielo.cielo.Dto.ExtratoContaLancamentosDto;
import br.com.cielo.cielo.Dto.LancamentoDto;
import br.com.cielo.cielo.model.Lancamento;

import java.util.ArrayList;
import java.util.List;

public class ModelMapper {

	public static ExtratoContaLancamentosDto mapLancamentosContaToExtratoLancamentosResponse(Lancamento lancamentoConta) {
		
		List<LancamentoDto> lancamentos = new ArrayList<LancamentoDto>();
		
		lancamentoConta.getListaControleLancamento().stream()
			.forEach(controleLancamento -> {
				LancamentoDto l = new LancamentoDto();
				l.setDataLancamento(controleLancamento.getDataLancamentoContaCorrenteCliente());
				l.setDescricao(controleLancamento.getLancamentoContaCorrenteCliente().getNomeTipoOperacao());
				l.setNumero(controleLancamento.getLancamentoContaCorrenteCliente().getNumeroRemessaBanco());
				l.setSituacao(controleLancamento.getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa());
				l.setDataConfirmacao(controleLancamento.getDataEfetivaLancamento());
				
				DadosBancariosDto dadosBancariosDto = new DadosBancariosDto();
				dadosBancariosDto.setNomeBanco(controleLancamento.getNomeBanco().trim());
				dadosBancariosDto.setNumeroAgencia(controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia());
				dadosBancariosDto.setNumeroContaCorrente(controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente().trim());

				l.setDadosBancarios(dadosBancariosDto);
				
				l.setValorFinal(controleLancamento.getValorLancamentoRemessa());
				
				lancamentos.add(l);
				
			});
		
		return new ExtratoContaLancamentosDto(lancamentos);
	}
	
}
