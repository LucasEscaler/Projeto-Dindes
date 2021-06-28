package br.org.generartion.dindes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Atributo obrigatório")
	@Size(min = 2, max = 255)
	private String nomeTema;

	@NotNull(message = "Atributo obrigatório")
	@Size(min = 2, max = 255)
	private String area;

	@Size(min = 5, max = 500)
	private String descricao;

	@Transient
	private int qtdTema;

	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeTema() {
		return nomeTema;
	}

	public void setNomeTema(String nomeTema) {
		this.nomeTema = nomeTema;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public int getQtdTema() {
		return qtdTema;
	}

	public void setQtdTema(int qtdTema) {
		this.qtdTema = qtdTema;
	}
}
