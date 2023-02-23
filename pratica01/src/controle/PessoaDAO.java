package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {
	private Conexao con;

	public boolean inserir(Pessoa p) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO pessoa (cpf, nome, senha) VALUES (?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, 123);
			stm.setString(2, "Luis");
			stm.setString(3, "senha");
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return false;
	}

	public boolean alterar(Pessoa p) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE pessoa SET nome = ?, senha = ? WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setString(3, p.getSenha());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}

	public boolean deletar(Pessoa p) {
		return false;
	}

	public ArrayList<Pessoa> listarPessoas() {
		ArrayList<Pessoa> pessoas = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM Pessoa";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");
				Pessoa p = new Pessoa();
				p.setCpf(cpf);
				p.setNome(nome);
				p.setSenha(senha);
				pessoas.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return null;
	}
}
