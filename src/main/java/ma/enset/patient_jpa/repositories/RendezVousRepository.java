package ma.enset.patient_jpa.repositories;

import ma.enset.patient_jpa.entities.Medecin;
import ma.enset.patient_jpa.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
