package ex9;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

	private Connection conexao;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	
	private final String DATABASE = "Pessoa";
	private final String USER = "root";
	private final String PSW = "aluno";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 8, 358, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(66, 33, 358, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(66, 58, 358, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER, PSW);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					String query = "INSERT INTO pessoa (cpf, nome, senha) VALUES (?, ?, ?);";
					PreparedStatement stm = conexao.prepareStatement(query);

					stm.setLong(1, Long.valueOf(txtCpf.getText()));
					stm.setString(2, txtNome.getText());
					stm.setString(3, txtSenha.getText());
					stm.executeUpdate();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					conexao.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(151, 149, 132, 49);
		contentPane.add(btnSalvar);
	}
}
