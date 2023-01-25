package keyron.declare.neo4jrepositories;

import keyron.declare.model.bid.BiddingSystemEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

public interface BiddingSystemRepository extends ReactiveNeo4jRepository<BiddingSystemEntity, String> {
    Mono<BiddingSystemEntity> findOneByName(String name);
}
