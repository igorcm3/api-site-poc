package br.com.unoesc.academicolegadopub.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by igorcm3 on 12/03/2023 - 21:53
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NivelEnsinoDTO {

    private Long codigo;

    private String nomeNivelEnsino;
}
