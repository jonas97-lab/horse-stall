package novi.horsestall.model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "horses")
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String foodType;
    private Boolean copyPassport;

    @JsonIgnoreProperties("horses")
    @ManyToOne
    @JoinColumn(name = "horseStall_id", referencedColumnName = "id")
    private HorseStall owner;
    // voor Spring Boot (JPA) is een constructor niet nodig

    // default constructor
    public Horse() {}

    public Horse(String name, String foodType, Boolean copyPassport) {
        this.name = name;
        this.foodType = foodType;
        this.copyPassport = copyPassport;
    }

    // full constructor
    public Horse(int id, String name, String foodType, Boolean copyPassport) {
        this.id = id;
        this.name = name;
        this.foodType = foodType;
        this.copyPassport = copyPassport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Boolean getCopyPassport() {
        return copyPassport;
    }

    public void setCopyPassport(Boolean copyPassport) {
        this.copyPassport = copyPassport;
    }

    public HorseStall getOwner() {
        return owner;
    }

    public void setOwner(HorseStall owner) {
        this.owner = owner;
    }
}
