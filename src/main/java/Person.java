import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class Person {

    final String CITY = "London";

    @NonNull private Integer id;
    @NonNull private String name;
    @NonNull private String surname;
    @NonNull private int age;
    @NonNull private String address;

    public String showInfo(){
        return "Info of the person: " + this.toString();
    }

    public String completeName(){
        return "name: " + this.name + ", surname: " + this.surname;
    }

    public String addressWithDefaultCity(){
        return "City: " + CITY + ", " + this.address;
    }
}
