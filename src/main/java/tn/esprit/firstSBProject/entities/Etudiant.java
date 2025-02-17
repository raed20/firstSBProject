package tn.esprit.firstSBProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etudiant {
    @Id
    private Long idEtudiant;

    private String nomEt;
    private String prenomEt;
    private Long cIn;
    private String ecole;
    private Date dateNaissance;

}
