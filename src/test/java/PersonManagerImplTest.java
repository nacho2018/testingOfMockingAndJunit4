import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@Log
public class PersonManagerImplTest {

    Person person;
    PersonManager personManager = new PersonManagerImpl();

    @Before
    public void setUp() throws Exception {
        log.info("Setting up person instance....");
        person = new Person(new Integer(1), "Peter", "Smith", 12, "23 Remingthon St.");
    }

    @Test
    public void save() {
        Person savedPerson = personManager.save(person);
        Assert.assertNotNull(savedPerson);
        Assert.assertTrue(savedPerson.getId() == 1 && savedPerson.getId() == person.getId());
    }

    @Test
    public void update() {
        personManager.save(person);
        Person personToUpdate = new Person(new Integer(1), "John", "Williams", 56, "23 Remingthon St.");
        Person updatedPerson = personManager.update(personToUpdate);
        Assert.assertTrue(updatedPerson.getName().equals(personToUpdate.getName()));
    }

    @Test
    public void delete() {
        personManager.save(person);
        personManager.delete(person);
        Assert.assertTrue(personManager.getTotalElements() == 0);
    }


}