package novi.horsestall.service;

import novi.horsestall.dto.HorseRequestDto;
import novi.horsestall.exception.RecordNotFoundException;
import novi.horsestall.model.Horse;
import novi.horsestall.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HorseService {
    @Autowired
    private HorseRepository horseRepository;

    public Iterable<Horse> getHorses(String name) {
        if (name.isEmpty()) {
            return horseRepository.findAll();
        } else {
            return horseRepository.findAllByNameContainingIgnoreCase(name);
        }
    }

    public Horse getHorse(int id) {
        Optional<Horse> optionalHorse = horseRepository.findById(id);

        if (optionalHorse.isPresent()) {
            return optionalHorse.get();
        } else {
            // exception
            throw new RecordNotFoundException("ID does not exist");
        }
    }

    public void deleteHorse(int id) {
        if (horseRepository.existsById(id)) {
            horseRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }

    public int addHorse(HorseRequestDto horseRequestDto) {


        Horse horse = new Horse();
        horse.setName(horseRequestDto.getName());
        horse.setFoodType(horseRequestDto.getFoodType());
        horse.setCopyPassport(horseRequestDto.getCopyPassport());

        Horse newHorse = horseRepository.save(horse);
        return newHorse.getId();
    }

    public void updateHorse(int id, Horse horse) {
        Optional<Horse> optionalHorse = horseRepository.findById(id);

        if (optionalHorse.isPresent()) {
            Horse storedHorse = optionalHorse.get();

            horse.setId(storedHorse.getId());
            horseRepository.save(horse);
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }

    public void partialUpdateHorse(int id, Horse horse) {
        Optional<Horse> optionalHorse = horseRepository.findById(id);

        if (optionalHorse.isPresent()) {
            Horse storedHorse = horseRepository.findById(id).orElse(null);

            if (horse.getName() != null && !horse.getName().isEmpty()) {
                storedHorse.setName(horse.getName());
            }
            if (horse.getFoodType() != null && !horse.getFoodType().isEmpty()) {
                storedHorse.setFoodType(horse.getFoodType());
            }
            horseRepository.save(storedHorse);

        } else {
            throw new RecordNotFoundException("ID does not exist");
        }
    }

}