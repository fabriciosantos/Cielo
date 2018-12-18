package br.com.cielo.cielo.Dto;

public class DadosBancariosDto {

	private String nomeBanco;
	private Integer numeroAgencia;
	private String numeroContaCorrente;

	public DadosBancariosDto() {
		super();
	}

	public DadosBancariosDto(String nomeBanco, Integer numeroAgencia, String numeroContaCorrente) {
		super();
		this.nomeBanco = nomeBanco;
		this.numeroAgencia = numeroAgencia;
		this.numeroContaCorrente = numeroContaCorrente;
	}
	
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getNumeroContaCorrente() {
		return numeroContaCorrente;
	}
	public void setNumeroContaCorrente(String numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}


}
