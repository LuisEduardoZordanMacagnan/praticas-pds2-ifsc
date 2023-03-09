package ex8;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class CriaBanco {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conexao;
		final String DATABASE = "bd";
		final String USER = "root";
		final String PSW = "aluno";
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER, PSW);
			Statement stm = conexao.createStatement();
			String WSQL = "create database Pessoa";
			stm.executeQuery(WSQL);
			
			WSQL = "use Pessoa";
			stm.executeQuery(WSQL);
			
			WSQL = "create table Pessoa";
			stm.executeQuery(WSQL);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
