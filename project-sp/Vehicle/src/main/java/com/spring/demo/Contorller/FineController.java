package com.spring.demo.Contorller;

import com.spring.demo.Service.FineService;
import com.spring.demo.dto.FineCreateDto;
import com.spring.demo.dto.FineDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/fines")
public class FineController {
    private FineService fineService;
    @Autowired
    public FineController(FineService fineService) {
        this.fineService = fineService;
    }
    @GetMapping("/ids")
    public ResponseEntity<List<FineDto>>getFinesByIds(@RequestParam("ids") List<Long>ids){
        return ResponseEntity.ok(fineService.getFinesByIds(ids));
    }
    @PostMapping("/pay/{vehicleId}")
    public ResponseEntity<FineDto>createFine(@PathVariable Long vehicleId, @RequestBody @Valid FineCreateDto fineCreateDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/fines/pay/{vehicleId}"))
                .body(fineService.createFine(vehicleId,fineCreateDto));
    }
}
