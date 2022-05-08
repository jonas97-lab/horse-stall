package novi.horsestall.controller;

import novi.horsestall.model.HorseStall;
import novi.horsestall.model.Horse;
import novi.horsestall.service.HorseStallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class HorseStallController {

    @Autowired
    private HorseStallService horseStallService;

    @GetMapping(value = "/horsestalls")
    public ResponseEntity<Object> getHorseStalls(@RequestParam(name="title", defaultValue="") String title) {
        return ResponseEntity.ok(horseStallService.getHorseStalls(title));   // Jackson  object => json
    }

    @GetMapping(value = "/horsestalls/{id}")
    public ResponseEntity<Object> getHorseStall(@PathVariable int id) {
        return ResponseEntity.ok(horseStallService.getHorseStall(id));
    }

    @DeleteMapping(value = "/horsestalls/{id}")
    public ResponseEntity<Object> deleteHorseStall(@PathVariable("id") int id) {
        horseStallService.deleteHorseStall(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/horsestalls")
    public ResponseEntity<Object> addHorseStall(@RequestBody HorseStall horseStall) {
        int newId = horseStallService.addHorseStall(horseStall);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/horsestalls/{id}/horses")
    public ResponseEntity<Object> getHorseStallHorses(@PathVariable int id) {
        return ResponseEntity.ok(horseStallService.getHorseStallHorses(id));
    }

    @PostMapping(value = "/horsestalls/{id}/horses")
    public ResponseEntity<Object> addHorseStallHorse(@PathVariable int id, @RequestBody Horse horse) {
        horseStallService.addHorseStallHorse(id, horse);
        return ResponseEntity.created(null).build();
    }
}