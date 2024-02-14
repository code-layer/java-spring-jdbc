package in.datalayer.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepositoryImpl crImpl;

    @PostConstruct
    public void test(){
        Customer customer = crImpl.findById(1001L);
        System.out.println("customer 1001: " + customer);

        List<Customer> customers = crImpl.findAll();
        if(customers!=null) {
            for (Customer c : customers) {
                System.out.println("customer: " + c);
            }
        }
    }

}
