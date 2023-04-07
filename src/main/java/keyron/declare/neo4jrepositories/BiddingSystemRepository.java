package keyron.declare.neo4jrepositories;

import keyron.declare.model.bid.BiddingSystemEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BiddingSystemRepository extends ReactiveNeo4jRepository<BiddingSystemEntity, Long> {
    Mono<BiddingSystemEntity> findOneByName(String name);
}
