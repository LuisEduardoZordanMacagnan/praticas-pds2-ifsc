package ex10;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Consultas;
import modelo.Endereco;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Lista extends JFrame {

	private JPanel contentPane;
	private JTable tablePessoa;
	private Connection conexao;
	private final String DATABASE = "Pessoa";
	private final String USER = "root";
	private final String PSW = "aluno";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista frame = new Lista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Lista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);
		
		tablePessoa = new JTable();
		scrollPane.setViewportView(tablePessoa);
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+ DATABASE + "?serverTimeZone=UTC",USER,PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM endereco";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long cep = rs.getLong("cep");
				Endereco en = new Endereco();
				en.setCep(cep);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
