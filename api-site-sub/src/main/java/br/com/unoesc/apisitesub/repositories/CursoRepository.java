package br.com.unoesc.apisitesub.repositories;

import br.com.unoesc.apisitesub.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
