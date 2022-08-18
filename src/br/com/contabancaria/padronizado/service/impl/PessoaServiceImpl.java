package br.com.contabancaria.padronizado.service.impl;

import br.com.contabancaria.padronizado.dao.PessoaDao;
import br.com.contabancaria.padronizado.dao.impl.PessoaDaoImpl;
import br.com.contabancaria.padronizado.dao.model.Pessoa;
import br.com.contabancaria.padronizado.service.PessoaService;

import java.util.Date;
import java.util.List;

public class PessoaServiceImpl implements PessoaService {

    PessoaDao pessoaDao = new PessoaDaoImpl();

    @Override
    public List<Pessoa> buscarPessoas() {
        return pessoaDao.buscarPessoas();
    }

    @Override
    public Pessoa buscarPessoaPorId(Long id) {
        // verificar se o nome não está null
        return pessoaDao.buscarPessoaPorId(id);
    }

    @Override
    public Pessoa buscarPessoaPorNome(String nome) {
        // verificar se o nome não está nulo ou vazio
        return pessoaDao.buscarPessoaPorNome(nome);
    }

    @Override
    public Pessoa buscarPessoaPorDataNascimento(Date data) {
        //Validar se a data não é maior que o dia atual
        return pessoaDao.buscarPessoaPorDataNascimento((java.sql.Date) data);
    }

    @Override
    public Pessoa inserirPessoa(String nome, Date data) {
        // Garantir que o nome e a data estejam preenchidas
        // depois de inserir , fazer o select para pega o objeto
        //
        return pessoaDao.inserirPessoa(nome, (java.sql.Date) data);
    }

    @Override
    public Pessoa deletarPessoa(Long id) {
        return pessoaDao.deletarPessoa(id);
    }

    @Override
    public Pessoa atualizarPessoa(Pessoa pessoa) {

        // 1 - Verificar se o usuário passou o id
        // 2 - Verificar se o id existe na base
        // 3 - Se não existe retornar null
        // 4 - Se existir atualizar com os dados do objeto pessoa e retornar o objeto Pessoa

        return pessoaDao.atualizarPessoa(pessoa);
    }
}
