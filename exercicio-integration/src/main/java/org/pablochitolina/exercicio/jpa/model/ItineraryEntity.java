package org.pablochitolina.exercicio.jpa.model;

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
public class ItineraryEntity {

    @SerializedName("idlinha")
    private String idLinha;
    private String codigo;
    private String nome;
    private List<LocationEntity> locations;

}
