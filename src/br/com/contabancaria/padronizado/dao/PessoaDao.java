package br.com.contabancaria.padronizado.dao;

import br.com.contabancaria.padronizado.dao.model.Pessoa;

import java.util.List;

public interface PessoaDAO {

    List<Pessoa> buscarPessoas();

    Pessoa buscarPessoaPorId(Long id);

}
