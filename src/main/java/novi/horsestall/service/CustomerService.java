package novi.horsestall.service;

import novi.horsestall.exception.RecordNotFoundException;
import novi.horsestall.model.Membership;
import novi.horsestall.model.Customer;
import novi.horsestall.repository.CustomerRepository;
import novi.horsestall.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MembershipRepository membershipRepository;

    public Iterable<Customer> getCustomers(String title) {
        return customerRepository.findAll();
    }

    public Customer getCustomer(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }

    public void deleteCustomer(int id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }

    public int addCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    public List<Membership> getCustomerMemberships(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            return customer.getMemberships();
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }

    public void addCustomerMembership(int id, Membership membership) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            List<Membership> memberships = customer.getMemberships();

            membership.setOwner(customer);
            membershipRepository.save(membership);

            memberships.add(membership);
            customer.setMemberships(memberships);
            customerRepository.save(customer);
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }
}