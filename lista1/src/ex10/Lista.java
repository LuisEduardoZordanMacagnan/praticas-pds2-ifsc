package ex10;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Lista extends JFrame {

	private Connection conexao;
	private JPanel contentPane;
	private JTable listaPessoas;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	
	private final String DATABASE = "Pessoa";;
	private final String USER = "root";
	private final String PSW = "aluno";
	
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
		scrollPane.setBounds(10, 21, 414, 229);
		contentPane.add(scrollPane);
		
		listaPessoas = new JTable();
		scrollPane.setViewportView(listaPessoas);
		
		listaPessoas.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CPF", "Nome"
				}
			));
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER, PSW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String query = "SELECT nome FROM pessoa;";
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				modelo.addRow(new Object[] { rs.getLong("cpf"), rs.getString("nome")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listaPessoas.setModel(modelo);
	}
}
