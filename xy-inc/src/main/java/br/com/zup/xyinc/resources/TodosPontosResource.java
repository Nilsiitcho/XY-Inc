package br.com.zup.xyinc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.xyinc.models.PontoInteresse;
import br.com.zup.xyinc.services.PontoInteresseService;


@RestController
@RequestMapping(value = "/todos-pontos")
public class TodosPontosResource {
	
	@Autowired
	private PontoInteresseService pontoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PontoInteresse>> findAll(){
		List<PontoInteresse> listaPontosInteresse = pontoService.findAll();
		return ResponseEntity.ok().body(listaPontosInteresse);
	}
	
}
