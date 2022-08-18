package br.com.contabancaria.padronizado.service;

import br.com.contabancaria.padronizado.dao.model.Pessoa;

import java.util.Date;
import java.util.List;

public interface PessoaService {

    List<Pessoa> buscarPessoas();
    Pessoa buscarPessoaPorId(Long id);
    Pessoa buscarPessoaPorNome(String nome);
    Pessoa buscarPessoaPorDataNascimento(Date data);
    Pessoa inserirPessoa(String nome, Date data);
    Pessoa deletarPessoa(Long id);
    Pessoa atualizarPessoa(Pessoa pessoa);

}
