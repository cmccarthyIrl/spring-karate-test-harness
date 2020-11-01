package cmccarthyirl.controllers;

import cmccarthyirl.models.Hero;
import cmccarthyirl.storage.HeroList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeroController {

    @GetMapping(value = "/hero", consumes = "application/json", produces = "application/json")
    public static ResponseEntity<?> getHeroList() {
        return new ResponseEntity<>(HeroList.getListOfHeros(), HttpStatus.OK);
    }

    @GetMapping(value = "/hero/{id}", consumes = "application/json", produces = "application/json")
    public static ResponseEntity<?> getHero(@PathVariable int id) {
        return new ResponseEntity<>(HeroList.getHero(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/hero/{id}")
    public static ResponseEntity<?> deleteHero(@PathVariable int id) {
        HeroList.deleteHero(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/hero", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createUpdateHero(@RequestBody Hero newHero) {
        HeroList.createUpdateHero(newHero);
        return new ResponseEntity<>(HeroList.getHero(newHero.getId()), HttpStatus.OK);
    }
}