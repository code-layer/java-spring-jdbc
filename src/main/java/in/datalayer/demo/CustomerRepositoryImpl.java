package in.datalayer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Customer findById(Long id) {
        try {
            Customer customer = jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Customer.class), id);

            return customer;
        } catch (IncorrectResultSizeDataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * from customer", BeanPropertyRowMapper.newInstance(Customer.class));
    }
}
