package br.com.MeloExpress.Fleet.DTO;

import java.util.UUID;

public record FleetCreateDTO(
        UUID fleetCode,
        String fleetPlate,
        String fleetModel,
        String fleetFuelType,
        String fleetLoadCapacity,
        boolean active,
        boolean maintenance
) {
}
