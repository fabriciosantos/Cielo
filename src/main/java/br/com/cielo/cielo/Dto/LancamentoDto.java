package br.com.cielo.cielo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class LancamentoDto {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataLancamento;
	private String descricao;
	private String numero;
	private String situacao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataConfirmacao;

	private DadosBancariosDto dadosBancarios;
	private BigDecimal valorFinal;

	public LancamentoDto() {
		super();
	}

	public LancamentoDto(Date dataLancamento, String descricao, String numero, String situacao, Date dataConfirmacao,
                         DadosBancariosDto dadosBancarios, BigDecimal valorFinal) {
		super();
		this.dataLancamento = dataLancamento;
		this.descricao = descricao;
		this.numero = numero;
		this.situacao = situacao;
		this.dataConfirmacao = dataConfirmacao;
		this.dadosBancarios = dadosBancarios;
		this.valorFinal = valorFinal;
	}
	
	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Date getDataConfirmacao() {
		return dataConfirmacao;
	}
	public void setDataConfirmacao(Date dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}
	public DadosBancariosDto getDadosBancarios() {
		return dadosBancarios;
	}
	public void setDadosBancarios(DadosBancariosDto dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
}
