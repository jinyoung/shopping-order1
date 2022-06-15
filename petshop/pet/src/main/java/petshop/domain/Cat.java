package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@DiscriminatorValue("cat")
public class Cat extends Pet {

    private String name;
}
