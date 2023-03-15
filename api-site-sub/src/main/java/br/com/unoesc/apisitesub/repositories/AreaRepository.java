package br.com.unoesc.apisitesub.repositories;

import br.com.unoesc.apisitesub.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
}
