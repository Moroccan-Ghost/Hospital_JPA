package ma.enset.patient_jpa.repositories;

import ma.enset.patient_jpa.entities.Consultation;
import ma.enset.patient_jpa.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
