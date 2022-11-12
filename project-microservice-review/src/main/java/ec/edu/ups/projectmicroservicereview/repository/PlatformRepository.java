package ec.edu.ups.projectmicroservicereview.repository;

import ec.edu.ups.projectmicroservicereview.entity.Platform;
import ec.edu.ups.projectmicroservicereview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform,Long> {




}
