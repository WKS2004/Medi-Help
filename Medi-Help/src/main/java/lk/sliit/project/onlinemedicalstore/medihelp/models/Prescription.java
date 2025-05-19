package lk.sliit.project.onlinemedicalstore.medihelp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ConcretePrescription.class, name = "concrete")
})
public abstract class Prescription {
    private String id;
    private String patientName;
    private int age;
    private String medicineName;
    private String medicineType; // Tablets, Tonic, Medical hits
    private double price;
    private boolean isAvailable;
    private String dosageRange;
    private boolean doctorApproved;
    private String status; // PENDING, APPROVED, REJECTED
    private String type = "concrete"; // Default type for all prescriptions
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime uploadDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime approvalDate;
    
    private String approvedBy;

    public abstract boolean validate();
} 