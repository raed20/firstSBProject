package tn.esprit.firstSBProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Universite {
    @Id
    private Long idUniversite;

    private String nomUniversite;
    private String adresse;

    @OneToOne
    private Foyer foyer;
    public long  getIdUniversite() {
        return idUniversite;
    }
    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }

}
