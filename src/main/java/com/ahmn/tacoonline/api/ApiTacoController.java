package com.ahmn.tacoonline.api;

import com.ahmn.tacoonline.data.TacoRepository;
import com.ahmn.tacoonline.exceptions.TacoNotFoundException;
import com.ahmn.tacoonline.model.Taco;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api/taco")
public class ApiTacoController {

    // http://localhost:8080/swagger-ui/index.html#

    private final TacoRepository tacoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Taco> getTacoById(@PathVariable("id") long id){
        Optional<Taco> optTaco = tacoRepository.findById(id);
        if(optTaco.isPresent()){
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Taco> postTaco(@RequestBody Taco taco){
        Taco saved = tacoRepository.save(taco);
        if(saved != null) {
            return new ResponseEntity<>(taco, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/recents/{page}")
    public ResponseEntity<Iterable<Taco>> getAllTacos(@PathVariable("page") int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("createAt").descending());
        Iterable<Taco> tacos = tacoRepository.findAll(pageable);
        return new ResponseEntity<>(tacos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaco(@PathVariable("id") long id) {

        Optional<Taco> optTaco = tacoRepository.findById(id);

        if (optTaco.isPresent()) {
            tacoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Taco> updateTaco(@RequestBody Taco taco) {

        Taco savedTaco = tacoRepository.findById(taco.getId()).orElseThrow(() -> new TacoNotFoundException());
        Taco tacoUpdated = tacoRepository.save(taco);
        return new ResponseEntity<>(tacoUpdated, HttpStatus.OK);
        }

}
