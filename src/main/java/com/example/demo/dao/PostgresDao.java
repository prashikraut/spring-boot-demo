package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresDao")
public class PostgresDao implements PersonDao{
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        List<Person> temp = new ArrayList<Person>();
        temp.add(new Person(UUID.randomUUID(),"from postgres"));
        return temp;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }
}
