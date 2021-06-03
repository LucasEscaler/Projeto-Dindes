package br.org.generartion.dindes.model;

import javax.persistence.Entity;
import java.util.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Atributo obrigatório")
	@Size(min = 2)
	private String texto;
	
	private int curtida;
	
	@Size(min = 5)
	private String midia;
	
	@NotNull(message = "Indique se é a postagem é referente a uma vaga.")
	private boolean vaga;
	
	private String tituloVaga;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCurtida() {
		return curtida;
	}

	public void setCurtida(int curtida) {
		this.curtida = curtida;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public boolean isVaga() {
		return vaga;
	}

	public void setVaga(boolean vaga) {
		this.vaga = vaga;
	}

	public String getTituloVaga() {
		return tituloVaga;
	}

	public void setTituloVaga(String tituloVaga) {
		this.tituloVaga = tituloVaga;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
