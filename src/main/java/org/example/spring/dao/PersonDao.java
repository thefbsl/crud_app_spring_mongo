package org.example.spring.dao;
import org.example.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PersonDao {
    @Autowired
    MongoTemplate mongoTemplate;
    public static final String COLLECTION = "users";

    public List<Person> index(){
        return mongoTemplate.findAll(Person.class, COLLECTION);
    }

    public Person show(String id){
        return mongoTemplate.findById(id, Person.class, COLLECTION);
    }

    public void save(Person person){
        if(!mongoTemplate.collectionExists(Person.class)){
            mongoTemplate.createCollection(Person.class);
        }
        person.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(person, COLLECTION);
    }

    public void update(Person person, String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("name", person.getName());
        update.set("surname", person.getLastName());
        update.set("email", person.getEmail());
        update.set("phoneNumber", person.getPhoneNumber());
        update.set("password", person.getPassword());
        mongoTemplate.upsert(query, update, Person.class, COLLECTION);
    }

    public void delete(Person person){
        mongoTemplate.remove(person, COLLECTION);
    }
}
