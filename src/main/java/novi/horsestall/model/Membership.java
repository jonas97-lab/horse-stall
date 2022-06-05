package novi.horsestall.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String price;
    private String typeOfHorseStall;

    @JsonIgnoreProperties("memberships")
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer owner;
    // voor Spring Boot (JPA) is een constructor niet nodig

    // default constructor
    public Membership() {
    }

    public Membership(String type, String price, String typeOfHorseStall) {
        this.type = type;
        this.price = price;
        this.typeOfHorseStall = typeOfHorseStall;
    }

    // full constructor
    public Membership(int id, String type, String price, String typeOfHorseStall) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.typeOfHorseStall = typeOfHorseStall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTypeOfHorseStall() {
        return typeOfHorseStall;
    }

    public void setTypeOfHorseStall(String typeOfHorseStall) {
        this.typeOfHorseStall = typeOfHorseStall;
    }
}
