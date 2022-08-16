package br.com.contabancaria.padronizado;

import br.com.contabancaria.padronizado.dao.PessoaDAO;
import br.com.contabancaria.padronizado.dao.impl.PessoaDAOImpl;
import br.com.contabancaria.padronizado.dao.model.Pessoa;

import java.util.List;

public class Principal {

    public static void main(String[] args) {

        Principal principal = new Principal();

        PessoaDAO pessoaDAO = new PessoaDAOImpl();

        principal.listagemPessoas(pessoaDAO);

        principal.filtrarPessoaPorId(pessoaDAO);

    }


    public void filtrarPessoaPorId(PessoaDAO pessoaDAO) {
        Long id = 3L;
        Pessoa pessoa = pessoaDAO.buscarPessoaPorId(id);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println( pessoa.getId() + " -  " + pessoa.getNome()  +  pessoa.getDataNascimento());
        }
    }

    public void listagemPessoas(PessoaDAO pessoaDAO) {
        List<Pessoa> pessoas = pessoaDAO.buscarPessoas();
        imprimir(pessoas);
    }

    public static void imprimir(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            System.out.println( pessoa.getId() + " -  " +  pessoa.getNome()  +  pessoa.getDataNascimento());
        }
    }
}
