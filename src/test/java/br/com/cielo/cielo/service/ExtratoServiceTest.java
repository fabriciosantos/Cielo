package br.com.cielo.cielo.service;

import br.com.cielo.cielo.CieloApplication;
import br.com.cielo.cielo.Dto.ExtratoContaLancamentosDto;
import br.com.cielo.cielo.model.*;
import br.com.cielo.cielo.repository.ExtratoContaRepository;
import br.com.cielo.cielo.util.ModelMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CieloApplication.class)
public class ExtratoServiceTest {

	@Autowired
	private ExtratoContaService extratoContaService;
	
	@MockBean
	private ExtratoContaRepository extratoContaRepository;
	
	@Test
	public void recuperarLancamentosSemParametros() {

		given(extratoContaRepository.recuperaLancamentoConta())
		.willReturn(retornaExtratoLancamento());
		
		ExtratoContaLancamentosDto lancamentosExpected = ModelMapper.mapLancamentosContaToExtratoLancamentosResponse(retornaExtratoLancamento());
		ExtratoContaLancamentosDto lancamentos = extratoContaService.buscarLancamentos();
		
		assertEquals(lancamentosExpected.getLancamentos().size(), 2);

		assertEquals(lancamentosExpected.getLancamentos().get(0).getDadosBancarios(), lancamentos.getLancamentos().get(0).getDadosBancarios());
		assertEquals(lancamentosExpected.getLancamentos().get(1).getDadosBancarios(), lancamentos.getLancamentos().get(1).getDadosBancarios());
		
		assertEquals(lancamentosExpected.getLancamentos().get(0).getNumero(), lancamentos.getLancamentos().get(0).getNumero());
		assertEquals(lancamentosExpected.getLancamentos().get(1).getNumero(), lancamentos.getLancamentos().get(1).getNumero());
		
	}

	private Lancamento retornaExtratoLancamento() {

        Calendar data = Calendar.getInstance();
        data.set(2018, 0, 1, 0, 0, 0);

        Lancamento res = new Lancamento();

        res.setIndice(1);
        res.setTamanhoPagina(1);
        res.setTotalElements(1);

        TotalLancamento totalLancamento = new TotalLancamento();
        totalLancamento.setQuantidadeLancamentos(1);
        totalLancamento.setQuantidadeRemessas(1);
        totalLancamento.setValorLancamentos(BigDecimal.valueOf(190.1));
        res.setTotalLancamento(totalLancamento);

        List<ControleLancamento> listaControleLancamento = new ArrayList<>();

        // test 1
        ControleLancamento controleLanc = new ControleLancamento();
        controleLanc.setCodigoIdentificadorUnico("1");
        controleLanc.setDataEfetivaLancamento(data.getTime());
        controleLanc.setDataLancamentoContaCorrenteCliente(data.getTime());
        controleLanc.setDescricaoGrupoPagamento("Teste 1");
        controleLanc.setNomeBanco("Banco");
        controleLanc.setNumeroEvento("1234");
        controleLanc.setNumeroRaizCNPJ("1111");
        controleLanc.setNumeroSufixoCNJP("2222");
        controleLanc.setQuantidadeLancamentoRemessa(1);
        controleLanc.setValorLancamentoRemessa(BigDecimal.valueOf(90.1));

        LancamentoContaCorrenteCliente lccc = new LancamentoContaCorrenteCliente();
        lccc.setNomeSituacaoRemessa("Teste");
        lccc.setNomeTipoOperacao("Op 1");
        lccc.setNumeroRemessaBanco("1234");

        DadosDomicilioBancario ddb = new DadosDomicilioBancario();
        ddb.setCodigoBanco(1);
        ddb.setNumeroAgencia(1);
        ddb.setNumeroContaCorrente("1234");
        lccc.setDadosDomicilioBancario(ddb);

        controleLanc.setLancamentoContaCorrenteCliente(lccc);

        listaControleLancamento.add(controleLanc);

        controleLanc = new ControleLancamento();
        controleLanc.setCodigoIdentificadorUnico("2");
        controleLanc.setDataEfetivaLancamento(data.getTime());
        controleLanc.setDataLancamentoContaCorrenteCliente(data.getTime());
        controleLanc.setDateLancamentoContaCorrenteCliente(data.getTime());
        controleLanc.setDescricaoGrupoPagamento("Teste 2");
        controleLanc.setNomeBanco("Banco B");
        controleLanc.setNumeroEvento("1235");
        controleLanc.setNumeroRaizCNPJ("1112");
        controleLanc.setNumeroSufixoCNJP("2223");
        controleLanc.setQuantidadeLancamentoRemessa(2);
        controleLanc.setValorLancamentoRemessa(BigDecimal.valueOf(190.1));

        lccc = new LancamentoContaCorrenteCliente();
        lccc.setNomeSituacaoRemessa("Situacao Teste");
        lccc.setNomeTipoOperacao("Op 12");
        lccc.setNumeroRemessaBanco("1233");

        ddb = new DadosDomicilioBancario();
        ddb.setCodigoBanco(2);
        ddb.setNumeroAgencia(2);
        ddb.setNumeroContaCorrente("1233");
        lccc.setDadosDomicilioBancario(ddb);

        controleLanc.setLancamentoContaCorrenteCliente(lccc);

        listaControleLancamento.add(controleLanc);

        res.setListaControleLancamento(listaControleLancamento);

        return res;
	}
}
