package br.com.MeloExpress.Fleet.Domain;

import br.com.MeloExpress.Fleet.DTO.FleetCreateDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "fleetNumber")
@Entity(name = "fleet")
@Table(name = "fleet")
public class Fleet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long fleetNumber;

    UUID fleetCode;

    String fleetPlate;

    String fleetModel;

    String fleetFuelType;

    String fleetLoadCapacity;

    boolean active;

    boolean maintenance;

    public Fleet (FleetCreateDTO fleetCreateDTO){
        this.fleetCode = fleetCreateDTO.fleetCode();
        this.fleetPlate = fleetCreateDTO.fleetPlate();
        this.fleetModel = fleetCreateDTO.fleetModel();
        this.fleetFuelType = fleetCreateDTO.fleetFuelType();
        this.fleetLoadCapacity = fleetCreateDTO.fleetLoadCapacity();
        this.active = fleetCreateDTO.active();
        this.maintenance = fleetCreateDTO.maintenance();
    }
}
