package br.org.generartion.dindes.model;

//Criando a classe UsuarioLogin
public class UsuarioLogin {

	private String email;

	private String senha;

	// Declarando o token para segurança
	private String token;

	// Aplicando os Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
