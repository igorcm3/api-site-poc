package br.com.unoesc.apisitesub.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by igorcm3 on 12/03/2023 - 20:37
 */
@Entity
@Table(name = "nivel_ensino")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NivelEnsino {

    @Id
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "nomeNivelEnsino", nullable = false)
    private String nomeNivelEnsino;

    @OneToMany(mappedBy = "nivelEnsino")
    private List<CursoNivel> cursoNivelList;

    @Version
    private int version;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final NivelEnsino that = (NivelEnsino) o;

        return new EqualsBuilder().append(version, that.version).append(codigo, that.codigo).append(nomeNivelEnsino, that.nomeNivelEnsino).append(cursoNivelList, that.cursoNivelList).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(codigo).append(nomeNivelEnsino).append(cursoNivelList).append(version).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("codigo", codigo)
                .append("nomeNivelEnsino", nomeNivelEnsino)
                .append("cursoNivelList", cursoNivelList)
                .append("version", version)
                .toString();
    }
}
