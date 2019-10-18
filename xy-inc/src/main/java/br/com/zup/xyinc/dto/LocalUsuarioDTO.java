package br.com.zup.xyinc.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LocalUsuarioDTO{

	@NotNull(message = "Coordenada X obrigatória")
	@Min(value=0, message = "As coordenadas devem ser um valor positivo")
	private Integer x;
	
	@NotNull(message = "Coordenada Y obrigatória")
	@Min(value=0, message = "As coordenadas devem ser um valor positivo")
	private Integer y;
	
	@NotNull(message = "Distância máxima obrigatória")
	@Min(value=0, message = "A distância deve ser um valor positivo")
	private Integer distanciaMaxima;
	
}
