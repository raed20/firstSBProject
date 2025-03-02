package tn.esprit.firstSBProject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstSBProject.entities.Etudiant;
import tn.esprit.firstSBProject.services.IEtudiantServices;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantController {
    IEtudiantServices etudiantService;

    @GetMapping("/getAllEtudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }


    @PostMapping("/addEt")
    public  List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return (etudiantService.addEtudiants(etudiants));
    }

    // Mettre à jour un étudiant
    @PutMapping("/updateEtudiant/{id}")
    public Etudiant updateEtudiant(@PathVariable("id") long idEtudiant, @RequestBody Etudiant etudiant) {

        return etudiantService.updateEtudiant(etudiant);
    }

    // Récupérer un étudiant par ID
    @GetMapping("/getById/{id}")
    public Etudiant retrieveEtudiant(@PathVariable("id") long idEtudiant) {
        return etudiantService.retrieveEtudiant(idEtudiant);
    }

    // Supprimer un étudiant
    @DeleteMapping("/removeEtudiant/{id}")
    public void removeEtudiant(@PathVariable("id") long idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }
}
