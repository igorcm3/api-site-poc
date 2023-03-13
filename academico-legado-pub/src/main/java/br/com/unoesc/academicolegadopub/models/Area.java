package br.com.unoesc.academicolegadopub.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * Created by igorcm3 on 12/03/2023 - 19:59
 */
@Entity
@Table(name = "area")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "nomeArea", nullable = false)
    private String nomeArea;

    @OneToMany(mappedBy = "area")
    private List<Curso> cursoList;

    @Version
    private int version;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final Area area = (Area) o;

        return new EqualsBuilder().append(version, area.version).append(codigo, area.codigo).append(nomeArea, area.nomeArea).append(cursoList, area.cursoList).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(codigo).append(nomeArea).append(cursoList).append(version).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("codigo", codigo)
                .append("nomeArea", nomeArea)
                .append("cursoList", cursoList)
                .append("version", version)
                .toString();
    }
}
