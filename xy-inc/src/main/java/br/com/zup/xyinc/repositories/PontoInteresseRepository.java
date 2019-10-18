package br.com.zup.xyinc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.xyinc.models.PontoInteresse;

@Repository
public interface PontoInteresseRepository extends JpaRepository<PontoInteresse, Integer>{

}
