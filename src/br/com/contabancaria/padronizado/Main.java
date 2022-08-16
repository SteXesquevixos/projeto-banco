package br.com.contabancaria.padronizado;

import br.com.contabancaria.padronizado.dao.PessoaDao;
import br.com.contabancaria.padronizado.dao.impl.PessoaDaoImpl;
import br.com.contabancaria.padronizado.dao.model.Pessoa;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Main principal = new Main();

        PessoaDao pessoaDao = new PessoaDaoImpl();

        principal.listagemPessoas(pessoaDao);

        principal.filtrarPessoaPorId(pessoaDao);
        principal.filtrarPessoaPorNome(pessoaDao);
        principal.filtrarPessoaPorDataNascimento(pessoaDao);

    }

    public void filtrarPessoaPorId(PessoaDao pessoaDAO) {
        Long id = 3L;
        Pessoa pessoa = pessoaDAO.buscarPessoaPorId(id);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println( pessoa.getId() + "\t" + pessoa.getNome()  + "\t" +  pessoa.getDataNascimento());
        }
    }

    public void filtrarPessoaPorNome(PessoaDao pessoaDao) {
        String nome = "Stephany";
        Pessoa pessoa = pessoaDao.buscarPessoaPorNome(nome);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println( pessoa.getId() + "\t" + pessoa.getNome()  + "\t" +  pessoa.getDataNascimento());
        }
    }

    public void filtrarPessoaPorDataNascimento(PessoaDao pessoaDao) {
//        LocalDate data = LocalDate.now();
//        Date dataSql = java.sql.Date.valueOf(data);
        Date data_nascimento = Date.valueOf("1977-08-02");
        Pessoa pessoa = pessoaDao.buscarPessoaPorDataNascimento(data_nascimento);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println( pessoa.getId() + "\t" + pessoa.getNome()  + "\t" +  pessoa.getDataNascimento());
        }
    }

    public void listagemPessoas(PessoaDao pessoaDAO) {
        List<Pessoa> pessoas = pessoaDAO.buscarPessoas();
        imprimir(pessoas);
    }

    public static void imprimir(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            System.out.println( pessoa.getId() + "\t" +  pessoa.getNome()  + "\t" +  pessoa.getDataNascimento());
        }
    }
}
