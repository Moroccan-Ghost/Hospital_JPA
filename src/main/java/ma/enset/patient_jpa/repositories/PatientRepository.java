package ma.enset.patient_jpa.repositories;

import ma.enset.patient_jpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findPatientByNom(String s);
}
