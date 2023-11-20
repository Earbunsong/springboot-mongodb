package co.dev.kh.springbootmongodb.repository;

import co.dev.kh.springbootmongodb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person,String>{
      List<Person> findByFirstNameStartingWith(String name);

//      List<Person> findByAgeBetween(Integer min, Integer max);

      List<Person> findPersonByAgeBetween(Integer min, Integer max);
}
