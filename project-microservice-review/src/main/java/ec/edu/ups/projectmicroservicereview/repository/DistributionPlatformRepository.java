package ec.edu.ups.projectmicroservicereview.repository;

import ec.edu.ups.projectmicroservicereview.entity.DistributionPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionPlatformRepository extends JpaRepository<DistributionPlatform,Long> {
}
