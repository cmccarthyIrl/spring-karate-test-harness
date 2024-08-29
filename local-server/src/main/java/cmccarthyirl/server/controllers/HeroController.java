package cmccarthyirl.server.controllers;

import cmccarthyirl.server.models.Hero;
import cmccarthyirl.server.storage.HeroList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroController {

    private final HeroList heroList;

    @Autowired
    public HeroController(HeroList heroList) {
        this.heroList = heroList;
    }

    @GetMapping
    public ResponseEntity<List<Hero>> getHeroList() {
        List<Hero> heroes = heroList.getListOfHeros();
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHero(@PathVariable int id) {
        Hero hero = heroList.getHero(id);
        if (hero == null) {
            return new ResponseEntity<>("Hero not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHero(@PathVariable int id) {
        boolean isDeleted = heroList.deleteHero(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Hero not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Hero> createUpdateHero(@RequestBody Hero newHero) {
        Hero updatedHero = heroList.createUpdateHero(newHero);
        return new ResponseEntity<>(updatedHero, HttpStatus.OK);
    }
}
