package br.com.zup.xyinc.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.xyinc.dto.PontoInteresseDTO;
import br.com.zup.xyinc.models.PontoInteresse;
import br.com.zup.xyinc.services.PontoInteresseService;

@RestController
@RequestMapping("/ponto-interesse")
public class PontoInteresseResource {

	@Autowired
	private PontoInteresseService pontoService;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<PontoInteresse> find(@PathVariable Integer id){
		PontoInteresse ponto = pontoService.find(id);
		return ResponseEntity.ok().body(ponto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PontoInteresse> insert(@Valid @RequestBody PontoInteresseDTO pontoDTO){
		PontoInteresse ponto = pontoService.save(pontoService.fromDTO(pontoDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ponto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PontoInteresseDTO pontoDTO, @PathVariable Integer id){
		PontoInteresse ponto = pontoService.fromDTO(pontoDTO);
		ponto.setId(id);
		pontoService.update(ponto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		pontoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
