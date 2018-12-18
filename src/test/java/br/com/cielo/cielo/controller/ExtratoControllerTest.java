package br.com.cielo.cielo.controller;

import br.com.cielo.cielo.CieloApplication;
import br.com.cielo.cielo.Dto.DadosBancariosDto;
import br.com.cielo.cielo.Dto.ExtratoContaLancamentosDto;
import br.com.cielo.cielo.Dto.LancamentoDto;
import br.com.cielo.cielo.service.ExtratoContaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ExtratoController.class, secure = false)
@ContextConfiguration(classes = CieloApplication.class)
public class ExtratoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ExtratoContaService extratoContaService;
	
	@Test
	public void recuperarLancamentos() throws Exception {

		given(extratoContaService.buscarLancamentos())
			.willReturn(retornaExtratoLancamento());
		
		MvcResult result = mockMvc.perform(get("/api/extratoconta/lancamentos")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.lancamentos", hasSize(2)))
				.andReturn();
		
		String jsonExpected = "{\"lancamentos\":[{\"dataLancamento\":\"01/01/2018\",\"descricao\":\"Dezembro 2018\",\"numero\":\"12345\",\"situacao\":\"Situação OK\",\"dataConfirmacao\":\"01/01/2018\",\"dadosBancarios\":{\"nomeBanco\":\"Banco\",\"numeroAgencia\":1,\"numeroContaCorrente\":\"1234\"},\"valorFinal\":342.9},{\"dataLancamento\":\"05/01/2018\",\"descricao\":\"Dezembro 2018\",\"numero\":\"54321\",\"situacao\":\"Situação OK\",\"dataConfirmacao\":\"05/01/2018\",\"dadosBancarios\":{\"nomeBanco\":\"Banco Teste\",\"numeroAgencia\":1,\"numeroContaCorrente\":\"1234\"},\"valorFinal\":342.9}]}";

		JSONAssert.assertEquals(jsonExpected, result.getResponse().getContentAsString(), false);
	}

	private ExtratoContaLancamentosDto retornaExtratoLancamento() {

		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2018, 0, 1);

		Calendar dataConfirmacao = Calendar.getInstance();
		dataConfirmacao.set(2018, 0, 1);

		DadosBancariosDto dadosBancarios = new DadosBancariosDto("Teste", 1, "1234");

		List<LancamentoDto> lancamentos = new ArrayList<>();
		LancamentoDto l = new LancamentoDto();
		l.setDataLancamento(dataLancamento.getTime());
		l.setDescricao("Dezembro 2018");
		l.setNumero("12345");
		l.setSituacao("Situação OK");
		l.setDataConfirmacao(dataConfirmacao.getTime());
		l.setDadosBancarios(dadosBancarios);
		l.setValorFinal(BigDecimal.valueOf(342.9));

		lancamentos.add(l);

		dataLancamento.set(2018, 0, 5);

		dataConfirmacao.set(2018, 0, 5);

		l = new LancamentoDto();
		l.setDataLancamento(dataLancamento.getTime());
		l.setDescricao("Dezembro 2018");
		l.setNumero("54321");
		l.setSituacao("Situação OK");
		l.setDataConfirmacao(dataConfirmacao.getTime());
		l.setDadosBancarios(dadosBancarios);
		l.setValorFinal(BigDecimal.valueOf(342.9));

		lancamentos.add(l);

		return new ExtratoContaLancamentosDto(lancamentos);
	}
	
}
