package co.dev.kh.springbootmongodb.controller;

import co.dev.kh.springbootmongodb.collection.Person;
import co.dev.kh.springbootmongodb.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
//@RequiredArgsConstructor
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public String save(@RequestBody Person person){
        return personService.save(person);
    }
    @GetMapping
    public List<Person> getPersonStartWith(@PathVariable("name")String name){
        return personService.getPersonStartWith(name);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
         personService.delete(id);
    }
    @GetMapping("/age")
    public List<Person> getByPersonAge(@RequestParam Integer minAge,
                                       @RequestParam Integer maxAge){
        return personService.getByPersonAge(minAge, maxAge);
    }
    @GetMapping("/search")
    public Page<Person> searchPerson(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ) {
        Pageable pageable
                = PageRequest.of(page,size);
        return personService.search(name,minAge,maxAge,city,pageable);
    }

    @GetMapping("/oldestPerson")
    public List<Document> getOldestPerson() {
        return personService.getOldestPersonByCity();
    }

    @GetMapping("/populationByCity")
    public List<Document> getPopulationByCity() {
        return personService.getPopulationByCity();
    }
}
