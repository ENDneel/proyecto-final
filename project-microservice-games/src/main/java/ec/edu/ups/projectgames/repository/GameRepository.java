package ec.edu.ups.projectgames.repository;

import ec.edu.ups.projectgames.entitty.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository  extends JpaRepository<Game,Long> {
}
