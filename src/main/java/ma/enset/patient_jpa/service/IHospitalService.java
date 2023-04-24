package ma.enset.patient_jpa.service;

import ma.enset.patient_jpa.entities.Consultation;
import ma.enset.patient_jpa.entities.Medecin;
import ma.enset.patient_jpa.entities.Patient;
import ma.enset.patient_jpa.entities.RendezVous;

import java.util.List;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Patient findPatientByNom(String name);
    Medecin saveMedecin(Medecin medecin);
    Medecin findMedecinByNom(String name);
    RendezVous saveRendezVous(RendezVous rendezVous);
//    RendezVous findRendezVousById(String id);
    List<RendezVous> findAllRendezVous();

    Consultation saveConsultation(Consultation consultation);

}
