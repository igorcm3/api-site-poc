package br.com.unoesc.apisitesub.models.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by igorcm3 on 12/03/2023 - 21:26
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreaDTO implements Serializable {
    private Long codigo;

    private String nomeArea;
}
