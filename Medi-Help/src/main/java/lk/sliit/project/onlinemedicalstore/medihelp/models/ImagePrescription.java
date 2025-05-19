package lk.sliit.project.onlinemedicalstore.medihelp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ImagePrescription extends Prescription {
    private String imageUrl;
    private String imageFormat;
    private long fileSize;

    @Override
    public boolean validate() {
        // Validate image-specific requirements
        if (imageUrl == null || imageUrl.isEmpty()) {
            return false;
        }
        if (fileSize > 5 * 1024 * 1024) { // 5MB limit
            return false;
        }
        if (!imageFormat.matches("(?i)(jpg|jpeg|png|pdf)")) {
            return false;
        }
        return true;
    }
} 