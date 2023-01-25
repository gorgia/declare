package keyron.declare.model.bid;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("BiddingSystem")
public class BiddingSystemEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public BiddingSystemEntity(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
