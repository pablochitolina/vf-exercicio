package org.pablochitolina.exercicio.integration.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ItineraryIntegrantionEntity {

    @SerializedName("idlinha")
    private String idLinha;
    private String codigo;
    private String nome;
    private List<LocationIntegrantionEntity> locations;

}
