package petshop.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petshop.domain.*;

@RestController
@RequestMapping(value = "/pets")
@Transactional
public class PetController {

    @Autowired
    PetRepository petRepository;

    @RequestMapping(
        value = "/{id}/feed",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Item feed(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /item/feed  called #####");
        Optional<Item> optionalItem = itemRepository.findById(id);

        optionalItem.orElseThrow(() -> new Exception("No Entity Found"));
        Item item = optionalItem.get();
        item.feed();

        itemRepository.save(item);
        return item;
    }
    // keep
}
