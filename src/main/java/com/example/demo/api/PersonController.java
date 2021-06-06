package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// defines to URL where request would be send
@RequestMapping("api/v1/person")
/* this annotation makes the class rest controller allows applications
 to interact to backend usi REST APIs */
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // this make the method a POST API
    @PostMapping
    // RequestBody tells that we would receive a person JSON body in request
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllpeople(){
        return personService.getAllPeople();
    }

/*     path is added after the URL used at the top in mapping
     to get value from the path use path variable annotation before that define path in mapping */
    @GetMapping(path = "{id}")
    // returns the person if any person of that id is present else returns null
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public int updatePerosnById(@PathVariable("id") UUID id,@RequestBody Person person){
        return personService.updatePerson(id, person);
    }
}
