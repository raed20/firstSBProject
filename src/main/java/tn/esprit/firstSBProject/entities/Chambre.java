package tn.esprit.firstSBProject.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre;
    private TypeC typeChambre;
    @ManyToOne
    private Bloc bloc;
    @OneToMany
    private List<Reservation> reservations;

    public long getIdChambre() {
        return idChambre;
    }



}
