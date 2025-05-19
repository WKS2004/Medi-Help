package lk.sliit.project.onlinemedicalstore.medihelp.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.prescription.system.model.ConcretePrescription;
import com.prescription.system.model.Prescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {
    private static final Logger logger = LoggerFactory.getLogger(PrescriptionService.class);
    private final String FILE_PATH = "prescription-data/prescriptions.json";
    private final List<Prescription> prescriptions = new ArrayList<>();
    private final ObjectMapper objectMapper;

    public PrescriptionService() {
        // Configure ObjectMapper
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);

        try {
            File dataDir = new File("prescription-data");
            if (!dataDir.exists()) {
                dataDir.mkdirs();
            }
            
            File prescriptionFile = new File(FILE_PATH);
            if (!prescriptionFile.exists()) {
                prescriptionFile.createNewFile();
                // Initialize with empty array
                objectMapper.writeValue(prescriptionFile, new ArrayList<>());
            } else {
                // If file exists but is empty or corrupted, reinitialize it
                if (prescriptionFile.length() == 0) {
                    objectMapper.writeValue(prescriptionFile, new ArrayList<>());
                }
            }
            
            loadPrescriptions();
        } catch (IOException e) {
            logger.error("Error initializing prescription service", e);
        }
    }

    public void loadPrescriptions() {
        prescriptions.clear();
        try {
            File prescriptionFile = new File(FILE_PATH);
            if (prescriptionFile.exists() && prescriptionFile.length() > 0) {
                String jsonContent = new String(java.nio.file.Files.readAllBytes(prescriptionFile.toPath()));
                logger.debug("Loading prescriptions from JSON: {}", jsonContent);
                
                try {
                    // Use TypeReference to properly handle the List<Prescription> type
                    List<Prescription> loadedPrescriptions = objectMapper.readValue(
                        jsonContent,
                        new TypeReference<List<Prescription>>() {}
                    );
                    prescriptions.addAll(loadedPrescriptions);
                    logger.info("Loaded {} prescriptions from file", loadedPrescriptions.size());
                } catch (Exception e) {
                    logger.error("Error parsing prescriptions JSON, reinitializing file", e);
                    // If there's an error parsing the JSON, reinitialize the file
                    objectMapper.writeValue(prescriptionFile, new ArrayList<>());
                }
            }
        } catch (IOException e) {
            logger.error("Error loading prescriptions from file: {}", FILE_PATH, e);
        }
    }

    public void savePrescriptions() {
        try {
            File prescriptionFile = new File(FILE_PATH);
            // Convert prescriptions to a list of ConcretePrescription
            List<ConcretePrescription> concretePrescriptions = prescriptions.stream()
                .filter(p -> p instanceof ConcretePrescription)
                .map(p -> (ConcretePrescription) p)
                .collect(Collectors.toList());
            
            String jsonContent = objectMapper.writeValueAsString(concretePrescriptions);
            logger.debug("Saving prescriptions to JSON: {}", jsonContent);
            
            objectMapper.writeValue(prescriptionFile, concretePrescriptions);
            logger.info("Saved {} prescriptions to file: {}", prescriptions.size(), FILE_PATH);
        } catch (IOException e) {
            logger.error("Error saving prescriptions to file: {}", FILE_PATH, e);
        }
    }

    public void addPrescription(Prescription prescription) {
        try {
            if (prescription instanceof ConcretePrescription) {
                prescription.setId(UUID.randomUUID().toString());
                prescription.setUploadDate(LocalDateTime.now());
                prescription.setStatus("PENDING");
                prescriptions.add(prescription);
                savePrescriptions();
                logger.info("Added new prescription with ID: {}", prescription.getId());
            } else {
                throw new IllegalArgumentException("Invalid prescription type");
            }
        } catch (Exception e) {
            logger.error("Error adding prescription", e);
            throw new RuntimeException("Failed to add prescription", e);
        }
    }

    public void updatePrescriptionStatus(String id, String status, String approvedBy) {
        try {
            prescriptions.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .ifPresent(p -> {
                        p.setStatus(status);
                        p.setApprovalDate(LocalDateTime.now());
                        p.setApprovedBy(approvedBy);
                    });
            savePrescriptions();
            logger.info("Updated prescription status for ID: {} to {}", id, status);
        } catch (Exception e) {
            logger.error("Error updating prescription status", e);
            throw new RuntimeException("Failed to update prescription status", e);
        }
    }

    public void deletePrescription(String id) {
        try {
            prescriptions.removeIf(p -> p.getId().equals(id));
            savePrescriptions();
            logger.info("Deleted prescription with ID: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting prescription", e);
            throw new RuntimeException("Failed to delete prescription", e);
        }
    }

    public List<Prescription> getAllPrescriptions() {
        return new ArrayList<>(prescriptions);
    }

    public List<Prescription> searchPrescriptions(String medicineName) {
        return prescriptions.stream()
                .filter(p -> p.getMedicineName().toLowerCase().contains(medicineName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Prescription> filterPrescriptions(double minPrice, double maxPrice, boolean available, String dosageRange, String ageGroup) {
        return prescriptions.stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .filter(p -> !available || p.isAvailable())
                .filter(p -> dosageRange == null || dosageRange.isEmpty() || p.getDosageRange().equals(dosageRange))
                .filter(p -> {
                    if (ageGroup == null || ageGroup.isEmpty()) {
                        return true;
                    }
                    int age = p.getAge();
                    switch (ageGroup) {
                        case "1-10": return age >= 1 && age <= 10;
                        case "10-40": return age > 10 && age <= 40;
                        case "40-60": return age > 40 && age <= 60;
                        case "60+": return age > 60;
                        default: return true;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Prescription> getPrescriptionsByAgeGroup(String ageGroup) {
        return prescriptions.stream()
                .filter(p -> {
                    int age = p.getAge();
                    switch (ageGroup) {
                        case "1-10": return age >= 1 && age <= 10;
                        case "10-40": return age > 10 && age <= 40;
                        case "40-60": return age > 40 && age <= 60;
                        case "60+": return age > 60;
                        default: return false;
                    }
                })
                .collect(Collectors.toList());
    }
} 