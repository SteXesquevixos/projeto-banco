package br.com.contabancaria.padronizado;

import br.com.contabancaria.padronizado.dao.PessoaDao;
import br.com.contabancaria.padronizado.dao.impl.PessoaDaoImpl;
import br.com.contabancaria.padronizado.dao.model.Pessoa;

import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Main principal = new Main();

        PessoaDao pessoaDao = new PessoaDaoImpl();

        principal.listagemPessoas(pessoaDao);

        principal.filtrarPessoaPorId(pessoaDao);

        principal.filtrarPessoaPorNome(pessoaDao);

        principal.filtrarPessoaDataNascimento(pessoaDao);

        principal.adicionarPessoa(pessoaDao);

        principal.removerPessoa(pessoaDao);


    }


    public void filtrarPessoaPorId(PessoaDao pessoaDao) {
        Long id = 3L;
        Pessoa pessoa = pessoaDao.buscarPessoaPorId(id);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println( pessoa.getId() + "\t" + pessoa.getNome()  + "\t" +  pessoa.getDataNascimento());
        }
    }

    public void filtrarPessoaPorNome(PessoaDao pessoaDao) {
        String nome = "Alexander";
        Pessoa pessoa = pessoaDao.buscarPessoaPorNome(nome);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println( pessoa.getId() + "\t" + pessoa.getNome() + "\t" +  pessoa.getDataNascimento());
        }
    }

    public void filtrarPessoaDataNascimento(PessoaDao pessoaDao){
        Date dataNascimento = Date.valueOf("2009-04-01");
        Pessoa pessoa = pessoaDao.buscarPessoaPorDataNascimento(dataNascimento);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println( pessoa.getId() + "\t" + pessoa.getNome() + "\t" +  pessoa.getDataNascimento());
        }
    }

    public void adicionarPessoa(PessoaDao pessoaDao) {
        String nome = "Anderson";
        Date dataNascimento = Date.valueOf("1980-07-15");
        Pessoa pessoa = pessoaDao.inserirPessoa(nome, dataNascimento);
    }

    public void removerPessoa(PessoaDao pessoaDao) {
        Long id = 2L;
        Pessoa pessoa = pessoaDao.deletarPessoa(id);
    }

//    public void updatePessoaPorNome(Pessoa pessoaDao) {
//
//    }

    public void listagemPessoas(PessoaDao pessoaDAO) {
        List<Pessoa> Pessoas = pessoaDAO.buscarPessoas();
        imprimir(Pessoas);
    }

    public static void imprimir(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            System.out.println( pessoa.getId() + "\t" +  pessoa.getNome() + "\t" +  pessoa.getDataNascimento());
        }
    }

}

