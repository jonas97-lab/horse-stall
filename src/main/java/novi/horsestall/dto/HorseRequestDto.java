package novi.horsestall.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class HorseRequestDto {

    // attributen

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    @Size(min = 1, max = 100)
    private String foodType;

    @NotBlank
    @Size(min = 10, max = 100)
    private Boolean copyPassport;

    // getters and setters

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

}