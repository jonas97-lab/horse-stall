package novi.horsestall.controller;

import novi.horsestall.model.Customer;
import novi.horsestall.model.Membership;
import novi.horsestall.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public ResponseEntity<Object> getCustomers(@RequestParam(name="title", defaultValue="") String title) {
        return ResponseEntity.ok(customerService.getCustomers(title));   // Jackson  object => json
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable int id) {
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        int newId = customerService.addCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/customers/{id}/memberships")
    public ResponseEntity<Object> getCustomerMemberships(@PathVariable int id) {
        return ResponseEntity.ok(customerService.getCustomerMemberships(id));
    }

    @PostMapping(value = "/customers/{id}/memberships")
    public ResponseEntity<Object> addCustomerMembership(@PathVariable int id, @RequestBody Membership membership) {
        customerService.addCustomerMembership(id, membership);
        return ResponseEntity.created(null).build();
    }

}