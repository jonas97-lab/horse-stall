package novi.horsestall.controller;

import novi.horsestall.model.Horse;
import novi.horsestall.service.HorseService;
import novi.horsestall.dto.HorseRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class HorseController {

    @Autowired
    private HorseService horseService;

    @GetMapping(value = "/horses")
    public ResponseEntity<Object> getHorses(@RequestParam(name = "title", defaultValue = "") String name) {
        return ResponseEntity.ok(horseService.getHorses(name));   // Jackson  object => json
    }

    @GetMapping(value = "/horses/{id}")
    public ResponseEntity<Object> getHorse(@PathVariable int id) {
        return ResponseEntity.ok(horseService.getHorse(id));
    }

    @DeleteMapping(value = "/horses/{id}")
    public ResponseEntity<Object> deleteHorse(@PathVariable("id") int id) {
        horseService.deleteHorse(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/horses")
    public ResponseEntity<Object> addHorse(@Valid @RequestBody HorseRequestDto horseRequestDto) {
        int newId = horseService.addHorse(horseRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/horses/{id}")
    public ResponseEntity<Object> updateHorse(@PathVariable int id, @RequestBody Horse horse) {
        horseService.updateHorse(id, horse);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/horses/{id}")
    public ResponseEntity<Object> partialUpdateHorse(@PathVariable int id, @RequestBody Horse horse) {
        horseService.partialUpdateHorse(id, horse);

        return ResponseEntity.noContent().build();
    }
}
