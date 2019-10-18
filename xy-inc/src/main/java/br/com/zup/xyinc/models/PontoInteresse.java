package br.com.zup.xyinc.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PontoInteresse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Integer x;
	private Integer y;
	
	public PontoInteresse() {
	}

	public PontoInteresse(Integer id, String nome, Integer x, Integer y) {
		this.id = id;
		this.nome = nome;
		this.x = x;
		this.y = y;
	}
	
}
