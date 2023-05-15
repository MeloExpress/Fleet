package br.com.MeloExpress.Fleet.Repository;

import br.com.MeloExpress.Fleet.Domain.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FleetRepository extends JpaRepository <Fleet, Long> {
    Optional<Fleet> findByFleetCode(UUID fleetCode);

}
