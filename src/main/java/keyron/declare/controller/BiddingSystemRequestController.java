package keyron.declare.controller;


import keyron.declare.model.bid.BiddingSystemEntity;
import keyron.declare.neo4jrepositories.BiddingSystemRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/biddingsystems")
public class BiddingSystemRequestController {

    private BiddingSystemRepository biddingSystemRepository;

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public List<BiddingSystemEntity> getBiddingSystems() {
        BiddingSystemEntity biddingSystemEntity1 = new BiddingSystemEntity();
        biddingSystemEntity1.setName("Naturale");
        biddingSystemEntity1.setId(1L);
        BiddingSystemEntity biddingSystemEntity2 = new BiddingSystemEntity();
        biddingSystemEntity2.setName("Quinta Nobile");
        biddingSystemEntity2.setId(2L);
        return Arrays.asList(biddingSystemEntity1, biddingSystemEntity2);
    }

    @GetMapping("/by-title")
    Mono<BiddingSystemEntity> byTitle(@RequestParam String title) {
        return  biddingSystemRepository.findOneByName(title);
    }


}
