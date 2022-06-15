package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@DiscriminatorValue("tiger")
public class Tiger extends Cat {}
