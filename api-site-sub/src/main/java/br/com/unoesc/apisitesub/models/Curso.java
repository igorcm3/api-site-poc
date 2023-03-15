package br.com.unoesc.apisitesub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * Created by igorcm3 on 12/03/2023 - 20:47
 */
@Entity
@Table(name = "curso_nivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "nome_curso", nullable = false)
    private String nomeCurso;

    @ManyToOne
    @JoinColumn(name="cod_area", nullable=false)
    private Area area;

    @ManyToOne
    @JoinColumn(name="cod_cur_nivel", nullable=false)
    private CursoNivel cursoNivel;

    @Version
    private int version;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final Curso curso = (Curso) o;

        return new EqualsBuilder().append(version, curso.version).append(codigo, curso.codigo).append(nomeCurso, curso.nomeCurso).append(area, curso.area).append(cursoNivel, curso.cursoNivel).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(codigo).append(nomeCurso).append(area).append(cursoNivel).append(version).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("codigo", codigo)
                .append("nomeCurso", nomeCurso)
                .append("area", area)
                .append("cursoNivel", cursoNivel)
                .append("version", version)
                .toString();
    }
}
