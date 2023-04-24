package ma.enset.patient_jpa;

import ma.enset.patient_jpa.entities.*;
import ma.enset.patient_jpa.repositories.ConsultationRepository;
import ma.enset.patient_jpa.repositories.MedecinRepository;
import ma.enset.patient_jpa.repositories.PatientRepository;
import ma.enset.patient_jpa.repositories.RendezVousRepository;
import ma.enset.patient_jpa.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientJpaApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService){
        return args -> {
            Stream.of("Mohamed","Hassan","Karam").forEach(name->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                patient.setScore(14);
                hospitalService.savePatient(patient);
            });

            Stream.of("Aiman","Maryame","Aima").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite(Math.random() > 0.5 ? "Generaliste" : "Cardio");
                medecin.setEmail(name+"@gmail.com");
                hospitalService.saveMedecin(medecin);
            });


            Patient patient1 = hospitalService.findPatientByNom("Karam");
            Medecin medecin = hospitalService.findMedecinByNom("Aiman");


            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatusRDV(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient1);
            RendezVous rendezVous1 =  hospitalService.saveRendezVous(rendezVous);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation");
            hospitalService.saveConsultation(consultation);


        };
    }

}
