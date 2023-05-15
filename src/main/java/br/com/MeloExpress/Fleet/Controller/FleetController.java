package br.com.MeloExpress.Fleet.Controller;

import br.com.MeloExpress.Fleet.DTO.FleetCreateDTO;
import br.com.MeloExpress.Fleet.DTO.FleetDetailsDTO;
import br.com.MeloExpress.Fleet.Domain.Fleet;
import br.com.MeloExpress.Fleet.Exception.FleetNotFoundException;
import br.com.MeloExpress.Fleet.Service.FleetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/fleet")
public class FleetController {

    private FleetService fleetService;

    public FleetController(FleetService fleetService){
        this.fleetService = fleetService;
    }

    @PostMapping
    public ResponseEntity<Fleet> createFleet (@RequestBody FleetCreateDTO fleetCreateDTO) {
        Fleet newFleet = fleetService.createFleet(fleetCreateDTO);
        return ResponseEntity.created(URI.create("/fleet/" + newFleet.getFleetNumber())).body(newFleet);
    }

    @GetMapping("/code/{fleetCode}")
    public ResponseEntity<FleetDetailsDTO> getFleetByCode(@PathVariable UUID fleetCode) {
        try{
            FleetDetailsDTO fleetDetailsDTO = fleetService.getFleetByCode(fleetCode);
            return ResponseEntity.ok(fleetDetailsDTO);
        } catch (FleetNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
