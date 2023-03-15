package br.com.unoesc.apisitesub.repositories;

import br.com.unoesc.apisitesub.models.CursoNivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoNivelRepository extends JpaRepository<CursoNivel, Long> {
}
