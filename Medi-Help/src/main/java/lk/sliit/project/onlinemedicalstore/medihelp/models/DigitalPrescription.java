package lk.sliit.project.onlinemedicalstore.medihelp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DigitalPrescription extends Prescription {
    private String digitalSignature;
    private String doctorId;
    private String hospitalName;
    private String prescriptionCode;

    @Override
    public boolean validate() {
        // Validate digital prescription requirements
        if (digitalSignature == null || digitalSignature.isEmpty()) {
            return false;
        }
        if (doctorId == null || doctorId.isEmpty()) {
            return false;
        }
        if (prescriptionCode == null || prescriptionCode.isEmpty()) {
            return false;
        }
        return true;
    }
} 