package br.com.MeloExpress.Fleet.DTO;

import java.util.UUID;

public record FleetDetailsDTO(
        Long fleetNumber,
        UUID fleetCode,
        String fleetPlate,
        String fleetModel,
        String fleetLoadCapacity
) {}
