package novi.horsestall.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MembershipRequestDto {

    // attributen

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    @Size(min = 1, max = 100)
    private String price;

    @NotBlank
    @Size(min = 10, max = 100)
    private String typeOfHorseStall;

    // getters and setters

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

}