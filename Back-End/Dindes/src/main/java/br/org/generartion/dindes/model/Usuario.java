package br.org.generartion.dindes.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Campo obrigatório")
	@Size(min = 5, max = 255, message = "O campo deve conter no mínimo 5 e no máximo 255 caracteres")
	private String nome;

	@NotNull
	private String usuario;
	
	@NotNull
	@Size(min = 5, max = 255, message = "O campo deve conter no mínimo 5 e no máximo 255 caracteres")
	private String email;

	@NotNull
	@Size(min = 4, message = "O campo deve conter no mínimo 4 caracteres")
	private String senha;
	
	@NotNull
	private Date dataNascimento;

	@NotNull
	@Size(min = 5, max = 255, message = "O campo deve conter no mínimo 10 e no máximo 255 caracteres")
	private String area;

	@NotNull
	@Size(min = 11, max = 255, message = "O campo deve conter no mínimo 11 e no máximo 255 caracteres")
	private String telefone;

	private String sobre;

	private String foto;

	@NotNull
	private String tipo;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	// Autorelacionamento
	@ManyToOne
	@JoinColumn(name = "dinde")
	@JsonIgnoreProperties(value = { "apadrinhade", "dinde" })
	private Usuario dinde;

	@OneToMany(mappedBy = "dinde", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "apadrinhade", "dinde" })
	private List<Usuario> apadrinhade;

	// Getters e Setters	
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public Usuario getDinde() {
		return dinde;
	}

	public void setDinde(Usuario dinde) {
		this.dinde = dinde;
	}

	public List<Usuario> getApadrinhade() {
		return apadrinhade;
	}

	public void setApadrinhade(List<Usuario> apadrinhade) {
		this.apadrinhade = apadrinhade;
	}

}
