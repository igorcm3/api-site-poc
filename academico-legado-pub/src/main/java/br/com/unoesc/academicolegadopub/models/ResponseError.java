package br.com.unoesc.academicolegadopub.models;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by igorcm3 on 12/03/2023 - 21:28
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {
    private List<String> error = new ArrayList<>();
}
