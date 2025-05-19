package lk.sliit.project.onlinemedicalstore.medihelp.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonTypeName("concrete")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class ConcretePrescription extends Prescription {
    @Override
    public boolean validate() {
        // Basic validation rules
        if (getPatientName() == null || getPatientName().trim().isEmpty()) {
            return false;
        }
        if (getAge() <= 0) {
            return false;
        }
        if (getMedicineName() == null || getMedicineName().trim().isEmpty()) {
            return false;
        }
        if (getPrice() < 0) {
            return false;
        }
        if (getDosageRange() == null || getDosageRange().trim().isEmpty()) {
            return false;
        }
        return true;
    }
} 