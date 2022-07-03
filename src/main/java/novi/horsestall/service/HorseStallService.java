package novi.horsestall.service;

import novi.horsestall.exception.RecordNotFoundException;
import novi.horsestall.model.Horse;
import novi.horsestall.model.HorseStall;
import novi.horsestall.repository.HorseStallRepository;
import novi.horsestall.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorseStallService {

    @Autowired
    private HorseStallRepository horseStallRepository;

    @Autowired
    private HorseRepository horseRepository;

    public Iterable<HorseStall> getHorseStalls(String title) {
        return horseStallRepository.findAll();
    }

    public HorseStall getHorseStall(int id) {
        Optional<HorseStall> optionalHorseStall = horseStallRepository.findById(id);

        if (optionalHorseStall.isPresent()) {
            return optionalHorseStall.get();
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }

    public void deleteHorseStall(int id) {
        if (horseStallRepository.existsById(id)) {
            horseStallRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }

    public int addHorseStall(HorseStall horseStall) {
        HorseStall newHorseStall = horseStallRepository.save(horseStall);
        return newHorseStall.getId();
    }

    public List<Horse> getHorseStallHorses(int id) {
        Optional<HorseStall> optionalHorseStall = horseStallRepository.findById(id);

        if (optionalHorseStall.isPresent()) {
            HorseStall horseStall = optionalHorseStall.get();
            return horseStall.getHorses();
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }

    public void addHorseStallHorse(int id, Horse horse) {
        Optional<HorseStall> optionalHorseStall = horseStallRepository.findById(id);

        if (optionalHorseStall.isPresent()) {
            HorseStall horseStall = optionalHorseStall.get();
            List<Horse> horses = horseStall.getHorses();

            horse.setOwner(horseStall);
            horseRepository.save(horse);

            horses.add(horse);
            horseStall.setHorses(horses);
            horseStallRepository.save(horseStall);
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }
}