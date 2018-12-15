package br.com.cielo.cielo.model;

import java.util.List;

public class Lancamento {

    private TotalLancamento totalLancamento;
    private List<ControleLancamento> listaControleLancamento;
    private Integer indice;
    private Integer tamanhoPagina;
    private Integer totalElements;

    public TotalLancamento getTotalLancamento() {
        return totalLancamento;
    }

    public void setTotalLancamento(TotalLancamento totalLancamento) {
        this.totalLancamento = totalLancamento;
    }

    public List<ControleLancamento> getListaControleLancamento() {
        return listaControleLancamento;
    }

    public void setListaControleLancamento(List<ControleLancamento> listaControleLancamento) {
        this.listaControleLancamento = listaControleLancamento;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public Integer getTamanhoPagina() {
        return tamanhoPagina;
    }

    public void setTamanhoPagina(Integer tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }
}
