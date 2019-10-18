package br.com.zup.xyinc.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.xyinc.dto.LocalUsuarioDTO;
import br.com.zup.xyinc.models.PontoInteresse;
import br.com.zup.xyinc.services.PontoInteresseService;

@RestController
@RequestMapping(value = "/pontos-proximos")
public class PontosProximosResource {

	@Autowired
	private PontoInteresseService pontoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<PontoInteresse>> findClosePoints(@Valid @RequestBody LocalUsuarioDTO pontoUsuarioDTO){
		List<PontoInteresse> listaPontosProximos = pontoService.findClosePoints(pontoUsuarioDTO);
		return ResponseEntity.ok().body(listaPontosProximos);
	}

}
