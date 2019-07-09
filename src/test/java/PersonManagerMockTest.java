import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;


public class PersonManagerMockTest {

    @Mock
    PersonManager mockedPersonManager;

    @Mock
    Person person;

    Person savedPerson = new Person(new Integer(9), "Peter", "Marques", 67, "23 Salisbury Rd.");

    int totalElements = 1;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
        Mockito.when(mockedPersonManager.save(person)).thenReturn(savedPerson);
        Person personFromSave = mockedPersonManager.save(person);

        Assert.assertNotNull(personFromSave);
        Assert.assertTrue(personFromSave.getId().intValue() == 9);
    }

    @Test
    public void delete() {

        Mockito.when(mockedPersonManager.delete(person)).thenReturn(new Integer(3));

        Integer deletedId = mockedPersonManager.delete(person);

        Assert.assertNotNull(deletedId);
        Assert.assertTrue(deletedId.intValue() == 3);
    }

    @Test
    public void update() {
        Person updatedPerson = new Person(new Integer(9), "Peter", "Marques", 88, "55 Roses Av.");
        Mockito.when(mockedPersonManager.update(person)).thenReturn(updatedPerson);

        Person personFromUpdate = mockedPersonManager.update(person);

        Assert.assertNotNull(personFromUpdate);
        Assert.assertTrue(personFromUpdate.getAddress().equals("55 Roses Av.") && personFromUpdate.getAge() == 88);




    }

    @Test
    public void getTotalElements() {

        Mockito.when(mockedPersonManager.getTotalElements()).thenReturn(totalElements);

        Assert.assertTrue(mockedPersonManager.getTotalElements() == totalElements);
    }
}