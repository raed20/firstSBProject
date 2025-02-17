package tn.esprit.firstSBProject.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Foyer {
    @Id
    private Long idFoyer;

    private String nomFoyer;
    private Long capaciteFoyer;


}
