package br.com.zup.xyinc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.xyinc.dto.PontoInteresseDTO;
import br.com.zup.xyinc.dto.LocalUsuarioDTO;
import br.com.zup.xyinc.exceptions.ObjectNotFoundException;
import br.com.zup.xyinc.models.PontoInteresse;
import br.com.zup.xyinc.repositories.PontoInteresseRepository;

@Service
public class PontoInteresseService {

	@Autowired
	private PontoInteresseRepository repository;
	
	public PontoInteresse find(Integer id) {
		Optional<PontoInteresse> ponto = repository.findById(id);
		if(!ponto.isPresent()) {
			throw new ObjectNotFoundException("Ponto de Interesse não encontrado! Id: " +id);
		}
		
		return ponto.orElse(null);
	}
	
	public PontoInteresse save(PontoInteresse ponto) {
		return repository.save(ponto);
	}
	
	public void update(PontoInteresse ponto) {
		PontoInteresse oldPonto = find(ponto.getId());
		updateData(oldPonto, ponto);
		repository.save(oldPonto);
	}

	public void delete(Integer id) {
		find(id);
		repository.deleteById(id);
	}
	
	public List<PontoInteresse> findAll(){
		return repository.findAll();
	}
	
	public PontoInteresse fromDTO(PontoInteresseDTO dto) {
		return new PontoInteresse(dto.getId(), dto.getNome(), dto.getX(), dto.getY());
	}
	
	private void updateData(PontoInteresse oldObj, PontoInteresse newObj) {
		oldObj.setNome(newObj.getNome());
		oldObj.setX(newObj.getX());
		oldObj.setY(newObj.getY());
	}

	public List<PontoInteresse> findClosePoints(LocalUsuarioDTO localUsuario) {
		List<PontoInteresse> todosPontos = repository.findAll();
		return todosPontos.stream().filter(ponto -> filtaPontos(ponto, localUsuario)).collect(Collectors.toList());
	}
	
	private boolean filtaPontos(PontoInteresse ponto, LocalUsuarioDTO localUsuario) {
		Double xQuadrado = Math.pow((ponto.getX() - localUsuario.getX()), 2);
		Double yQuadrado = Math.pow((ponto.getY() - localUsuario.getY()), 2);
		Double somaQuadrados = xQuadrado + yQuadrado;
		Double raiz = Math.sqrt(somaQuadrados);
		
		return raiz < localUsuario.getDistanciaMaxima();
	}
	
}
