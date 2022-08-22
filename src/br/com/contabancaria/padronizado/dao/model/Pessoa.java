package br.com.contabancaria.padronizado.dao.model;

import java.sql.Date;

public class Pessoa {
    private Long id;
    private String nome;
    private Date dataNascimento;

        public Pessoa() {
        }

        public Pessoa(Long id, String nome, Date dataNascimento) {
            this.id = id;
            this.nome = nome;
            this.dataNascimento = dataNascimento;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Date getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
        }


    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}

