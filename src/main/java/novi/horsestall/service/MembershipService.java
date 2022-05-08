package novi.horsestall.service;

import novi.horsestall.dto.MembershipRequestDto;
import novi.horsestall.exception.BadRequestException;
import novi.horsestall.exception.RecordNotFoundException;
import novi.horsestall.model.Membership;
import novi.horsestall.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipService {
    @Autowired
    private MembershipRepository membershipRepository;

    public Iterable<Membership> getMemberships(String name) {
        if (name.isEmpty()) {
            return membershipRepository.findAll();
        }
        else {
            return membershipRepository.findAllByNameContainingIgnoreCase(name);
        }
    }

    public Membership getMembership(int id) {
        Optional<Membership> optionalMembership = membershipRepository.findById(id);

        if (optionalMembership.isPresent()) {
            return optionalMembership.get();
        }
        else {
            // exception
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void deleteMembership(int id) {
        if (membershipRepository.existsById(id)) {
            membershipRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public int addMembership(MembershipRequestDto membershipRequestDto) {

        String price = membershipRequestDto.getPrice();
        List<Membership> memberships = (List<Membership>)membershipRepository.findAllByPrice(price);
        if (memberships.size() > 0) {
            throw new BadRequestException("Isbn already exists!!!");
        }


        Membership membership = new Membership();
        membership.setName(membershipRequestDto.getName());
        membership.setPrice(membershipRequestDto.getPrice());
        membership.setTypeOfHorseStall(membershipRequestDto.getTypeOfHorseStall());

        Membership newMembership = membershipRepository.save(membership);
        return newMembership.getId();
    }

    public void updateMembership(int id, Membership membership) {
        Optional<Membership> optionalMembership = membershipRepository.findById(id);

        if (optionalMembership.isPresent()) {
            Membership storedMembership = optionalMembership.get();

            membership.setId(storedMembership.getId());
            membershipRepository.save(membership);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void partialUpdateMembership(int id, Membership membership) {
        Optional<Membership> optionalMembership = membershipRepository.findById(id);

        if (optionalMembership.isPresent()) {
            Membership storedMembership = membershipRepository.findById(id).orElse(null);

            if (membership.getName()!=null && !membership.getName().isEmpty()) {
                storedMembership.setName(membership.getName());
            }
            if (membership.getPrice()!=null && !membership.getPrice().isEmpty()) {
                storedMembership.setPrice(membership.getPrice());
            }
            if (membership.getTypeOfHorseStall()!=null && !membership.getTypeOfHorseStall().isEmpty()) {
                storedMembership.setTypeOfHorseStall(membership.getTypeOfHorseStall());
            }
            membershipRepository.save(storedMembership);

        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

}