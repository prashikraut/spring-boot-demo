package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// component can be used here also in place of repository
@Repository("fakePersonDao")
public class FakePersonDao implements PersonDao {
    List<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return db;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if(person.isPresent()){
            db.remove(person.get());
            return(1);
        }
        return(0);
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p-> {
            int indexToUpdate = db.indexOf(p);
            if(indexToUpdate>=0){
                db.set(indexToUpdate, new Person(id, person.getName()));
                return(1);
            } else {
                return(0);
            }
        }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return db.stream().filter(person -> person.getId().equals(id)).findFirst();
    }
}
