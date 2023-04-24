package ma.enset.patient_jpa.repositories;

import ma.enset.patient_jpa.entities.Medecin;
import ma.enset.patient_jpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findMedecinByNom(String s);
}
