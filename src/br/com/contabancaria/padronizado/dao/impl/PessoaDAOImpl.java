package br.com.contabancaria.padronizado.dao.impl;

import br.com.contabancaria.padronizado.dao.PessoaDAO;
import br.com.contabancaria.padronizado.dao.model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAOImpl implements PessoaDAO {

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
}
