package keyron.declare.neo4jrepositories;

import keyron.declare.model.bid.BiddingSystemEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.core.Neo4jClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BiddingSystemRepositoryTest {

    @Autowired
    private BiddingSystemRepository biddingSystemRepository;

    @Test
    public void insertNode(@Autowired Neo4jClient client) {
        BiddingSystemEntity biddingSystemEntity = new BiddingSystemEntity();
        biddingSystemEntity.setName("Fiori Torino");
        Mono<BiddingSystemEntity> monoBiddingSystemEntity = biddingSystemRepository.save(biddingSystemEntity);

        assertThat(monoBiddingSystemEntity).isNotNull();
    }


    @Test
    public void findNode(@Autowired Neo4jClient client) {
        String biddingSystemNameToFind = "Fiori Torino";
        Mono<BiddingSystemEntity> monoBiddingSystemEntity = biddingSystemRepository.findOneByName(biddingSystemNameToFind);
        assertThat(monoBiddingSystemEntity).isNotNull();
    }

}