import lombok.Getter;
import lombok.extern.java.Log;
import java.util.HashMap;
import java.util.Map;

@Log
public class PersonManagerImpl implements PersonManager {

    private Map<Integer, Person> map = new HashMap<Integer, Person>();


   public Person save(Person person){

        Person personSaved;

        if (person != null && !map.containsKey(person.getId())){
            map.put(person.getId(), person);
            personSaved = map.get(person.getId());
            log.info("person saved with id: " + personSaved.getId());

        }else{
            personSaved = null;
            log.info("No person saved.");
        }
        return personSaved;
    }

    public Integer delete(Person person){

       int deletedId = 0;

       if (person != null && map.get(person.getId()).getId().intValue() == person.getId().intValue()){
            Person personToRemove = map.get(person.getId());
            if (personToRemove != null){
                this.map.remove(personToRemove.getId());
                log.info("person successfully removed!");
                deletedId = personToRemove.getId();
            }

       }else{
           log.info("person does not exist id ");
       }
       return new Integer(deletedId);
    }

    public Person update(Person person){

       Person personUpdated = null;

        if (person != null){
            Person personFromMap = map.get(person.getId());
            if (personFromMap!= null && personFromMap.getId().intValue() == person.getId().intValue()) {
                map.put(person.getId(), person);
                log.info("person updated!");
                personUpdated = map.get(person.getId());
            }
        }
        return personUpdated;
    }

    public int getTotalElements(){
       return this.map.size();

    }


}
