package com.spring.demo.Contorller;

import com.spring.demo.Service.InspectionService;
import com.spring.demo.dto.InspectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/inspections")
public class InspectionController {
    private InspectionService inspectionService;
    @Autowired
    public InspectionController(InspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }
    @PostMapping("/{vehicleId}")
    public ResponseEntity<InspectionDto>createInspection(@PathVariable Long vehicleId) throws URISyntaxException {
        return ResponseEntity.created(new URI("/inspections/{vehicleId}"))
                .body(inspectionService.createInspection(vehicleId));
    }
    @GetMapping("/upcoming")
    public ResponseEntity<List<InspectionDto>>getInspections(){
        return ResponseEntity.ok(inspectionService.getInspections());
    }
}
