package br.com.cielo.cielo.repository.repositoryImpl;

import br.com.cielo.cielo.model.Lancamento;
import br.com.cielo.cielo.repository.ExtratoContaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Repository
public class ExtratoLancamentoRepositoryImpl implements ExtratoContaRepository {

    @Value("json/lancamento-conta-legado.json")
    private String JSON_DATA_FILE;

    @Override
    public Lancamento recuperaLancamentoConta() {
        return null;
    }

    @Override
    public Lancamento recuperaLancamentoContaEntreData() {
        return null;
    }


    private Lancamento transformaJsonObject() {

        ObjectMapper object = new ObjectMapper();
        Lancamento lancamentos = null;

        try {
            InputStream file = this.getClass().getClassLoader().getResourceAsStream(JSON_DATA_FILE);
            lancamentos = object.readValue(new File("json/lancamento-conta-legado.json"), Lancamento.class);
        }catch (IOException io) {

        }


        return lancamentos;
    }
}
