package br.com.unoesc.apisitesub.repositories;

import br.com.unoesc.apisitesub.models.NivelEnsino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by igorcm3 on 12/03/2023 - 21:10
 */

@Repository
public interface NivelEnsinoRepository extends JpaRepository<NivelEnsino, Long> {
}
