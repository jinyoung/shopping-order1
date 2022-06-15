package petshop.external;

import lombok.Data;
import java.util.Date;
@Data
public class Item {

    private Long id;
    private String name;
    private String type;
    private Money price;
    private List&lt;Order&gt; order;
    private Pet pet;
    private Pet pet;

    // keep

}
