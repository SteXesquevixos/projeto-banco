package br.com.contabancaria.padronizado.service.impl;

import br.com.contabancaria.padronizado.dao.PessoaDao;
import br.com.contabancaria.padronizado.dao.impl.PessoaDaoImpl;
import br.com.contabancaria.padronizado.dao.model.Pessoa;
import br.com.contabancaria.padronizado.service.PessoaService;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PessoaServiceImpl implements PessoaService {

    PessoaDao pessoaDao = new PessoaDaoImpl();

    @Override
    public List<Pessoa> buscarPessoas() {
        return pessoaDao.buscarPessoas();
    }

    @Override
    public Pessoa buscarPessoaPorId(Long id) {
        // Verificar se o nome não está null

        return pessoaDao.buscarPessoaPorId(id);
    }

    @Override
    public Pessoa buscarPessoaPorNome(String nome) {
        // Verificar se o nome não está nulo ou vazio
        if (!(Objects.equals(nome, ""))) {
            return pessoaDao.buscarPessoaPorNome(nome);
        } else {
            return null;
        }
    }

    @Override
    public Pessoa buscarPessoaPorDataNascimento(Date data) {
        // Validar se a data não é maior que o dia atual
        LocalDateTime dtm = LocalDateTime.now();
        LocalDate dataAtual = dtm.toLocalDate();

        if (data.toLocalDate().isBefore(dataAtual)) {
            return pessoaDao.buscarPessoaPorDataNascimento(data);
        } else {
//            System.out.println("Data invalida");
            return null;
        }
    }

    @Override
    public Pessoa inserirPessoa(String nome, Date data) {
        // 1 - Garantir que o nome e a data estejam preenchidas

        try {
            if (!(Objects.equals(nome, "")) && !(Objects.equals(data, null))) {
                pessoaDao.inserirPessoa(nome, data);
                // 2 - Depois de inserir , fazer o select para pega o objeto
                return pessoaDao.buscarPessoaPorNome(nome);

            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro");
        }
        return null;
    }

    @Override
    public Pessoa deletarPessoa(Long id) {
        return pessoaDao.deletarPessoa(id);
    }

    @Override
    public Pessoa atualizarPessoa(Pessoa pessoa) {
        // 1 - Verificar se o usuário passou o id
        if (!(pessoa == null)) {

            // 2 - Verificar se o id existe na base
            if (!(pessoaDao.buscarPessoaPorId(pessoa.getId()) == null)) {
                // 4 - Se existir atualizar com os dados do objeto pessoa e retornar o objeto Pessoa
                return pessoaDao.atualizarPessoa(pessoa);
            } else {
                // 3 - Se não existe retornar null
                return null;
            }
        }
        return pessoa;
    }
}
