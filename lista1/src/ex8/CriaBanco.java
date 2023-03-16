package ex8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriaBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conexao;
		final String USER = "root";
		final String PSW = "aluno";

		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/", USER, PSW);

			Statement stm = conexao.createStatement();

			String WSQL = "create database Pessoa;";
			stm.executeUpdate(WSQL);

			WSQL = "use pessoa;";
			stm.executeUpdate(WSQL);

			WSQL = "create table Pessoa (cpf BIGINT(12) NOT NULL, nome VARCHAR(45) NOT NULL, senha VARCHAR(45) NOT NULL, PRIMARY KEY (cpf));";
			stm.executeUpdate(WSQL);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
