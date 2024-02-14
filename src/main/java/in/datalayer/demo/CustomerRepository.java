package in.datalayer.demo;

import java.util.List;

public interface CustomerRepository {
    Customer findById(Long id);
    List<Customer> findAll();
}
