package novi.horsestall.controller;

import novi.horsestall.model.Membership;
import novi.horsestall.service.MembershipService;
import novi.horsestall.dto.MembershipRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class MembershipController {

    @Autowired
    private MembershipService membershipService;
    @GetMapping(value = "/memberships")
    public ResponseEntity<Object> getMemberships(@RequestParam(name="title", defaultValue="") String name) {
        return ResponseEntity.ok(membershipService.getMemberships(name));   // Jackson  object => json
         }

    @GetMapping(value = "/memberships/{id}")
    public ResponseEntity<Object> getMembership(@PathVariable int id) {
        return ResponseEntity.ok(membershipService.getMembership(id));
    }

    @DeleteMapping(value = "/memberships/{id}")
    public ResponseEntity<Object> deleteMembership(@PathVariable("id") int id) {
        membershipService.deleteMembership(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/memberships")
    public ResponseEntity<Object> addMembership(@Valid @RequestBody MembershipRequestDto membershipRequestDto) {
        int newId = membershipService.addMembership(membershipRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/memberships/{id}")
    public ResponseEntity<Object> updateMembership(@PathVariable int id, @RequestBody Membership membership) {
        membershipService.updateMembership(id, membership);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/memberships/{id}")
    public ResponseEntity<Object> partialUpdateMembership(@PathVariable int id, @RequestBody Membership membership) {
        membershipService.partialUpdateMembership(id, membership);

        return ResponseEntity.noContent().build();
    }

}
