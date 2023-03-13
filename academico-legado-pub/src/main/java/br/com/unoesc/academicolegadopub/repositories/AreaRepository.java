package br.com.unoesc.academicolegadopub.repositories;

import br.com.unoesc.academicolegadopub.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
}
