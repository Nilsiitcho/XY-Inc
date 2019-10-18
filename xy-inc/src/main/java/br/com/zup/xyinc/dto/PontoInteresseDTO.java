package br.com.zup.xyinc.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;


@Data
public class PontoInteresseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotNull(message = "Coordenada X obrigatória")
	@Min(value=0, message = "As coordenadas devem ser um valor positivo")
	private Integer x;
	
	@NotNull(message = "Coordenada Y obrigatória")
	@Min(value=0, message = "As coordenadas devem ser um valor positivo")
	private Integer y;
	
}
