package br.com.contabancaria.padronizado.dao.impl;

import br.com.contabancaria.padronizado.dao.PessoaDao;
import br.com.contabancaria.padronizado.dao.model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDaoImpl implements PessoaDao {

    static final String DB_URL = "jdbc:mysql://localhost/escola";
    static final String USER = "root";
    static final String PASS = "teste123";

    @Override
    public List<Pessoa> buscarPessoas() {

        List<Pessoa> pessoas = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {

            String sql_DB = "select * from pessoa";
            ResultSet rs = stmt.executeQuery(sql_DB);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Date dataNascimento = rs.getDate("data_nascimento");
                Pessoa pessoa = new Pessoa(id, nome, dataNascimento);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    @Override
    public Pessoa buscarPessoaPorId(Long id) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql_DB = "select * from pessoa where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql_DB);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int identificador = rs.getInt("id");
                String nome = rs.getString("nome");
                Date dataNascimento = rs.getDate("data_nascimento");
                Pessoa pessoa = new Pessoa(identificador, nome, dataNascimento);
                return pessoa;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pessoa buscarPessoaPorNome(String nome) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql_DB = "select * from pessoa where nome = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql_DB);
            preparedStatement.setString(1, nome);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int identificador = rs.getInt("id");
                String nome_usuario = rs.getString("nome");
                Date dataNascimento = rs.getDate("data_nascimento");
                Pessoa pessoa = new Pessoa(identificador, nome_usuario, dataNascimento);
                return pessoa;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pessoa buscarPessoaPorDataNascimento(Date data) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql_DB = "select * from pessoa where data_nascimento = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql_DB);
            preparedStatement.setDate(1, data);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int identificador = rs.getInt("id");
                String nome_usuario = rs.getString("nome");
                Date dataNascimento = rs.getDate("data_nascimento");
                Pessoa pessoa = new Pessoa(identificador, nome_usuario, dataNascimento);
                return pessoa;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pessoa inserirPessoa(String nome, Date data) {
        String inserirNovaPessoa = "INSERT INTO pessoa (id, nome, data_nascimento) VALUES (?, ? , ? )";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement st = conn.prepareStatement(inserirNovaPessoa);
        ) {
            int id = getNextId();
            st.setInt(1, id);
            st.setString(2, nome);
            st.setDate(3, data);
            st.executeUpdate();
            return new Pessoa(id, nome, data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pessoa deletarPessoa(Long id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String deletarPessoa = "DELETE FROM pessoa WHERE id = " + id;
            stmt.executeUpdate(deletarPessoa);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Pessoa atualizarPessoa(Pessoa pessoa) {
        String inserirNovaPessoa = "UPDATE pessoa SET nome = ? , data_nascimento = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement st = conn.prepareStatement(inserirNovaPessoa);
        ) {
            st.setString(1, pessoa.getNome());
            st.setDate(2, (Date) pessoa.getDataNascimento());
            st.setLong(3, pessoa.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Integer getNextId() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql_DB = "select max(id) as id from pessoa";
            PreparedStatement preparedStatement = conn.prepareStatement(sql_DB);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt("id") + 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


