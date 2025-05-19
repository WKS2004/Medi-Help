package lk.sliit.project.onlinemedicalstore.medihelp.controller;

import com.prescription.system.model.ConcretePrescription;
import com.prescription.system.service.PrescriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PrescriptionController {
    private static final Logger logger = LoggerFactory.getLogger(PrescriptionController.class);

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("prescriptions", prescriptionService.getAllPrescriptions());
        return "index";
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("prescription", new ConcretePrescription());
        return "upload";
    }

    @PostMapping("/prescriptions/add")
    public String addPrescription(
            @ModelAttribute ConcretePrescription prescription,
            @RequestParam(required = false) MultipartFile prescriptionFile,
            Model model) {
        try {
            logger.debug("Received prescription upload request: {}", prescription);
            
            if (prescriptionFile != null && !prescriptionFile.isEmpty()) {
                // Handle file upload
                String fileName = prescriptionFile.getOriginalFilename();
                logger.debug("Received file: {}", fileName);
                // TODO: Save file to storage
            }

            if (!prescription.validate()) {
                model.addAttribute("error", "Invalid prescription data");
                return "upload";
            }

            prescriptionService.addPrescription(prescription);
            return "redirect:/";
        } catch (Exception e) {
            logger.error("Error processing prescription upload", e);
            model.addAttribute("error", "Error processing prescription: " + e.getMessage());
            return "upload";
        }
    }

    @GetMapping("/prescriptions/view/{id}")
    public String viewPrescription(@PathVariable String id, Model model) {
        prescriptionService.getAllPrescriptions().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .ifPresent(p -> model.addAttribute("prescription", p));
        return "view";
    }

    @PostMapping("/prescriptions/approve/{id}")
    public String approvePrescription(@PathVariable String id, @RequestParam String approvedBy) {
        prescriptionService.updatePrescriptionStatus(id, "APPROVED", approvedBy);
        return "redirect:/";
    }

    @PostMapping("/prescriptions/reject/{id}")
    public String rejectPrescription(@PathVariable String id, @RequestParam String approvedBy) {
        prescriptionService.updatePrescriptionStatus(id, "REJECTED", approvedBy);
        return "redirect:/";
    }

    @GetMapping("/prescriptions/delete/{id}")
    public String deletePrescription(@PathVariable String id) {
        prescriptionService.deletePrescription(id);
        return "redirect:/";
    }

    @GetMapping("/prescriptions/search")
    public String searchPrescriptions(@RequestParam String medicineName, Model model) {
        model.addAttribute("prescriptions", prescriptionService.searchPrescriptions(medicineName));
        return "index";
    }

    @GetMapping("/prescriptions/filter")
    public String filterPrescriptions(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Boolean available,
            @RequestParam(required = false) String dosageRange,
            @RequestParam(required = false) String ageGroup,
            Model model) {
        model.addAttribute("prescriptions", 
            prescriptionService.filterPrescriptions(
                minPrice != null ? minPrice : 0.0,
                maxPrice != null ? maxPrice : Double.MAX_VALUE,
                available != null ? available : false,
                dosageRange,
                ageGroup));
        return "index";
    }

    @GetMapping("/prescriptions/age-group/{group}")
    public String getPrescriptionsByAgeGroup(@PathVariable String group, Model model) {
        model.addAttribute("prescriptions", prescriptionService.getPrescriptionsByAgeGroup(group));
        return "index";
    }
} 