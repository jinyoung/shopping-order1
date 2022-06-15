package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.StoreApplication;

@Entity
@Table(name = "Customer_table")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static CustomerRepository repository() {
        CustomerRepository customerRepository = StoreApplication.applicationContext.getBean(
            CustomerRepository.class
        );
        return customerRepository;
    }
}
