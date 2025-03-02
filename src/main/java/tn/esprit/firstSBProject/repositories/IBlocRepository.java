package tn.esprit.firstSBProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstSBProject.entities.Bloc;

@Repository
public interface IBlocRepository extends JpaRepository<Bloc, Long> {
}
