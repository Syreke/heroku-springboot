package kz.kaznitu.footballplayer.repositories;

import kz.kaznitu.footballplayer.models.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player,Long> {
}
