package petshop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petshop.config.kafka.KafkaProcessor;
import petshop.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    CustomerRepository customerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @Autowired
    petshop.external.PetService petService;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPetRegistered_DisplayToTheShop(
        @Payload PetRegistered petRegistered
    ) {
        if (!petRegistered.validate()) return;
        PetRegistered event = petRegistered;
        System.out.println(
            "\n\n##### listener DisplayToTheShop : " +
            petRegistered.toJson() +
            "\n\n"
        );

        // REST Request Sample

        // petService.getPet(/** mapping value needed */);

        // Sample Logic //
        Item.displayToTheShop(event);
    }
    // keep

}
