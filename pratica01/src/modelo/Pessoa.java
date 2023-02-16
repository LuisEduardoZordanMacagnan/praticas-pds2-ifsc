package modelo;

public class Pessoa {
	private Long cpf;
	private String nome;
	private String senha;
	
	public void setCpf(Long cpf) {
		this.cpf=cpf;
	}
	
	public Long getCpf() {
		return cpf;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setSenha(String senha) {
		this.senha=senha;
	}
	
	public String getSenha() {
		return senha;
	}
}
