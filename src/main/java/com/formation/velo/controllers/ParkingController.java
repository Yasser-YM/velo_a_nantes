package com.formation.velo.controllers;
import com.formation.velo.model.Parking;
import com.formation.velo.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ParkingController {
    private final ParkingService parkingService;
    
    public ParkingController(ParkingService parkingService){
        this.parkingService=parkingService;
    }
    @GetMapping("parkings")
    public ResponseEntity<List<Parking>> getAll(){
        parkingService.saveRecord();
        List<Parking> parkings = parkingService.findAll();
        return  ResponseEntity.ok(parkings);
        
    }
    @GetMapping("parkings/{id}")
    public ResponseEntity<Optional<Parking>>getParkingbyId(@PathVariable Integer id){
        Optional<Parking> parking = parkingService.findById(id);
        return ResponseEntity.ok(parking);
    }
}
