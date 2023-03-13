package br.com.unoesc.academicolegadopub.repositories;

import br.com.unoesc.academicolegadopub.models.CursoNivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoNivelRepository extends JpaRepository<CursoNivel, Long> {
}
