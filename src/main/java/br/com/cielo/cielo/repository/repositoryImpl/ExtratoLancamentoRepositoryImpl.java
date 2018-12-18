package br.com.cielo.cielo.repository.repositoryImpl;

import br.com.cielo.cielo.exception.Exception;
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

        ObjectMapper object = new ObjectMapper();
        Lancamento lancamentos = null;

        try {
            InputStream file = this.getClass().getClassLoader().getResourceAsStream(JSON_DATA_FILE);
            lancamentos = object.readValue(new File("json/lancamento-conta-legado.json"), Lancamento.class);
        }catch (IOException io) {
            throw new Exception("Não é possivel recuperar os lançamentos da Conta!");
        }

        return lancamentos;
    }
}
