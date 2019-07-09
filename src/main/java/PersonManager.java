public interface PersonManager {

    Person save(Person person);
    Integer delete(Person person);
    Person update(Person person);
    int getTotalElements();

}
