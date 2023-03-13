package br.com.unoesc.academicolegadopub.repositories;

import br.com.unoesc.academicolegadopub.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
