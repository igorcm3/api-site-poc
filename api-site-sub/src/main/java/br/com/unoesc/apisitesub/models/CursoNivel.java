package br.com.unoesc.apisitesub.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * Created by igorcm3 on 12/03/2023 - 20:39
 */
@Entity
@Table(name = "curso_nivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoNivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "nome_curso_nivel", nullable = false)
    private String nomeCursoNivel;

    @Column(name = "pub_web")
    private Boolean publicaWeb;

    @ManyToOne
    @JoinColumn(name="cod_nivel_ensino", nullable=false)
    private NivelEnsino nivelEnsino;

    @OneToMany(mappedBy = "cursoNivel")
    private List<Curso> cursoNivel;

    @Version
    private int version;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final CursoNivel that = (CursoNivel) o;

        return new EqualsBuilder().append(version, that.version).append(codigo, that.codigo).append(nomeCursoNivel, that.nomeCursoNivel).append(publicaWeb, that.publicaWeb).append(nivelEnsino, that.nivelEnsino).append(cursoNivel, that.cursoNivel).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(codigo).append(nomeCursoNivel).append(publicaWeb).append(nivelEnsino).append(cursoNivel).append(version).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("codigo", codigo)
                .append("nomeCursoNivel", nomeCursoNivel)
                .append("publicaWeb", publicaWeb)
                .append("nivelEnsino", nivelEnsino)
                .append("cursoNivel", cursoNivel)
                .append("version", version)
                .toString();
    }
}
