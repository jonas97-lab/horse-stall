package novi.horsestall.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
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

    public Membership(String name, String price, String typeOfHorseStall) {
        this.name = name;
        this.price = price;
        this.typeOfHorseStall = typeOfHorseStall;
    }

    // full constructor
    public Membership(int id, String name, String price, String typeOfHorseStall) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.typeOfHorseStall = typeOfHorseStall;
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

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
