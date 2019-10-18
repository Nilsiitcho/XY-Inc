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

	/**
	 * Encontra os pontos de Interesse proximos ao local do usuario, que possuam uma distancia maxima inferior a informada.
	 * @param localUsuario
	 * @return
	 */
	public List<PontoInteresse> findClosePoints(LocalUsuarioDTO localUsuario) {
		List<PontoInteresse> todosPontos = repository.findAll();
		return todosPontos.stream().filter(ponto -> validaDistancia(ponto, localUsuario)).collect(Collectors.toList());
	}
	
	/**
	 * Realiza o calculo entre o a distancia do usuario e o ponto de interesse analizado
	 * e verifica se a distancia entre os dois eh menor do que o limite informado pelo usuario
	 * 
	 * Formula utilizada: sqrt((x1-x2)^2 + (y1 - y2)^2)
	 * 
	 * @param ponto
	 * @param localUsuario
	 * @return
	 */
	private boolean validaDistancia(PontoInteresse ponto, LocalUsuarioDTO localUsuario) {
		Double xQuadrado = Math.pow((ponto.getX() - localUsuario.getX()), 2);
		Double yQuadrado = Math.pow((ponto.getY() - localUsuario.getY()), 2);
		Double somaQuadrados = xQuadrado + yQuadrado;
		Double raiz = Math.sqrt(somaQuadrados);
		
		return raiz < localUsuario.getDistanciaMaxima();
	}
	
}
