package ma.enset.patient_jpa.service;

import jakarta.transaction.Transactional;
import ma.enset.patient_jpa.entities.Consultation;
import ma.enset.patient_jpa.entities.Medecin;
import ma.enset.patient_jpa.entities.Patient;
import ma.enset.patient_jpa.entities.RendezVous;
import ma.enset.patient_jpa.repositories.ConsultationRepository;
import ma.enset.patient_jpa.repositories.MedecinRepository;
import ma.enset.patient_jpa.repositories.PatientRepository;
import ma.enset.patient_jpa.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient findPatientByNom(String name) {
        return patientRepository.findPatientByNom(name);
    }

    @Override
    public Medecin findMedecinByNom(String name) {
        return medecinRepository.findMedecinByNom(name);
    }

//    @Override
//    public RendezVous findRendezVousById(String id) {
//        return rendezVousRepository.findById(id);
//    }

    @Override
    public List<RendezVous> findAllRendezVous() {
        return rendezVousRepository.findAll();
    }
}
