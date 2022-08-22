package br.com.contabancaria.padronizado;

import br.com.contabancaria.padronizado.dao.model.Pessoa;
import br.com.contabancaria.padronizado.service.PessoaService;
import br.com.contabancaria.padronizado.service.impl.PessoaServiceImpl;

import java.sql.Date;
import java.util.List;

public class Main {

    PessoaService pessoaService = new PessoaServiceImpl();

    public static void main(String[] args) {

        Main principal = new Main();

        principal.listagemPessoas();

        principal.filtrarPessoaPorId();

        principal.filtrarPessoaPorNome();

        principal.filtrarPessoaDataNascimento();

//        principal.atualizarPessoa();

        principal.adicionarPessoa();

//        principal.removerPessoa();

    }


    public void filtrarPessoaPorId() {
        Long id = 4L;
        Pessoa pessoa = pessoaService.buscarPessoaPorId(id);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println(pessoa.getId() + "\t" + pessoa.getNome()  + "\t" +  pessoa.getDataNascimento());
        }
    }

    public void filtrarPessoaPorNome() {
        String nome = "";
        Pessoa pessoa = pessoaService.buscarPessoaPorNome(nome);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println(pessoa.getId() + "\t" + pessoa.getNome() + "\t" +  pessoa.getDataNascimento());
        }
    }

    public void filtrarPessoaDataNascimento(){
        Date dataNascimento = Date.valueOf("2009-04-01");
        Pessoa pessoa = pessoaService.buscarPessoaPorDataNascimento(dataNascimento);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println(pessoa.getId() + "\t" + pessoa.getNome() + "\t" +  pessoa.getDataNascimento());
        }
    }

    public void atualizarPessoa() {
        Pessoa pessoa = new Pessoa(2L, "Stephany", Date.valueOf("1998-01-20"));
        pessoa = pessoaService.atualizarPessoa(pessoa);
    }

    public void adicionarPessoa() {
        String nome = "";
        Date dataNascimento = Date.valueOf("");
        Pessoa pessoa = pessoaService.inserirPessoa(nome, dataNascimento);
//        System.out.println(pessoa.toString());
    }

    public void removerPessoa() {
        Long id = 2L;
        Pessoa pessoa = pessoaService.deletarPessoa(id);
    }

    public void listagemPessoas() {
        List<Pessoa> Pessoas = pessoaService.buscarPessoas();
        imprimir(Pessoas);
    }

    public static void imprimir(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getId() + "\t" +  pessoa.getNome() + "\t" +  pessoa.getDataNascimento());
        }
    }

}

