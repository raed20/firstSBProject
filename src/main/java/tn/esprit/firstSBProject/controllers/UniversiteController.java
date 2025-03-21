package tn.esprit.firstSBProject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstSBProject.entities.Universite;
import tn.esprit.firstSBProject.services.IUniversiteServices;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteController {
    @Autowired
    IUniversiteServices universiteService;


    @GetMapping("/getAllUniversities")
    public List<Universite> retrieveAllUniversities() {
        return universiteService.retrieveAllUniversities();
    }


    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }


    @PutMapping("/updateUniversite/{id}")
    public Universite updateUniversite(@PathVariable("id") long idUniversite, @RequestBody Universite universite) {

        return universiteService.updateUniversite(universite);
    }


    @GetMapping("/getById/{id}")
    public Universite retrieveUniversite(@PathVariable("id") long idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }
    @PutMapping("/affecter/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(
            @PathVariable long idFoyer,
            @PathVariable String nomUniversite) {

        Universite universite = universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
        return universite;
    }

    @PutMapping("/desaffecterFoyer/{idUniversite}")
    public ResponseEntity<Universite> desaffecterFoyer(@PathVariable long idUniversite) {
        Universite universite = universiteService.desaffecterFoyerAUniversite(idUniversite);
        return ResponseEntity.ok(universite);
    }
}
