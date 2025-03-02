package tn.esprit.firstSBProject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstSBProject.entities.Foyer;
import tn.esprit.firstSBProject.services.IFoyerServices;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerController {
    IFoyerServices foyerService;

    @PostMapping("/saveFoyer")
    public Foyer saveFoyer(@RequestBody Foyer foyer) {
        return foyerService.save(foyer);
    }

    @GetMapping("/getById/{id}")
    public Foyer getFoyer(@PathVariable("id") Long id) {
        return foyerService.findById(id);
    }
    @GetMapping("/getByNomCapacite/{nom}/{capacite}")
    public Foyer getFoyer(@PathVariable("nom") String nom, @PathVariable("capacite") Long capacite) {
        return foyerService.getNomCapacite(nom, capacite);
    }
}
