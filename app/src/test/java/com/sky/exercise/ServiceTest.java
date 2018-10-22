package com.sky.exercise;

import com.sky.exercise.rest.domain.FilmesSO;
import com.sky.exercise.rest.service.FilmeWService;
import com.sky.exercise.rest.service.FilmeWService_;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class ServiceTest {

    @Test
    public void checkService(){
        List<FilmesSO> listaFilmes;

        FilmeWService filmeWService = FilmeWService_.getInstance_(null);

        listaFilmes = filmeWService.obterFilmes();

        assertNotEquals(listaFilmes, null);
    }
}
