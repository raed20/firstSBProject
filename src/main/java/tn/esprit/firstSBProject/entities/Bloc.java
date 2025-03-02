package tn.esprit.firstSBProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.firstSBProject.entities.Chambre;
import tn.esprit.firstSBProject.entities.Foyer;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;
    @ManyToOne
    private Foyer foyer;
    @OneToMany (mappedBy = "bloc")
    private List<Chambre> chambres;

    public long getIdBloc() {
        return idBloc;
    }

}
