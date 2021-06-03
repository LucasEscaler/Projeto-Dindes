package br.org.generartion.dindes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Campo obrigatório")
	@Size(min = 5, max = 255, message = "O campo deve conter no mínimo 5 e no máximo 255 caracteres")
	private String nome;
	
	@NotNull
	private Date dataNascimento;
	
	@NotNull
	@Size(min = 5, max = 255, message = "O campo deve conter no mínimo 5 e no máximo 255 caracteres")
	private String email;
	
	@NotNull
	@Size(min = 6, max = 255, message = "O campo deve conter no mínimo 6 e no máximo 255 caracteres")
	private String senha;
	
	@NotNull
	@Size(min = 5, max = 255, message = "O campo deve conter no mínimo 10 e no máximo 255 caracteres")
	private String area;
	
	@NotNull
	@Size(min = 11, max = 255, message = "O campo deve conter no mínimo 11 e no máximo 255 caracteres")
	private String telefone;
	
	@Size(min = 0, max = 255, message = "O campo deve conter no máximo 255 caracteres")
	private String sobre;
	
	@Size(min = 0, max = 255, message = "O campo deve conter no máximo 255 caracteres")
	private String fotoString;
	
	@NotNull
	private boolean dinde;
	
	//Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public String getFotoString() {
		return fotoString;
	}

	public void setFotoString(String fotoString) {
		this.fotoString = fotoString;
	}

	public boolean isDinde() {
		return dinde;
	}

	public void setDinde(boolean dinde) {
		this.dinde = dinde;
	}

}
