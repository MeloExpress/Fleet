package br.com.MeloExpress.Fleet.Service;

import br.com.MeloExpress.Fleet.DTO.FleetCreateDTO;
import br.com.MeloExpress.Fleet.DTO.FleetDetailsDTO;
import br.com.MeloExpress.Fleet.Domain.Fleet;
import br.com.MeloExpress.Fleet.Exception.FleetNotFoundException;
import br.com.MeloExpress.Fleet.Repository.FleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FleetService {
    private final FleetRepository fleetRepository;

    @Autowired
    public FleetService(FleetRepository fleetRepository) {
        this.fleetRepository = fleetRepository;
    }

    public Fleet createFleet(FleetCreateDTO fleetCreateDTO) {
        Fleet fleet = new Fleet(fleetCreateDTO);
        fleet.setFleetCode(UUID.randomUUID());
        fleet.setActive(true);
        fleet.setMaintenance(false);
        Fleet savedFleet = fleetRepository.save(fleet);
        return savedFleet;
    }

    public FleetDetailsDTO getFleetByCode (UUID fleetCode) throws FleetNotFoundException {
        Optional<Fleet> fleetOptional = fleetRepository.findByFleetCode(fleetCode);
        if (fleetOptional.isEmpty()) {
            throw new FleetNotFoundException();
        }
        Fleet fleet = fleetOptional.get();

        FleetDetailsDTO fleetDetailsDTO = new FleetDetailsDTO(
                fleet.getFleetNumber(),
                fleet.getFleetCode(),
                fleet.getFleetPlate(),
                fleet.getFleetModel(),
                fleet.getFleetLoadCapacity()
        );

        return fleetDetailsDTO;

    }
}
