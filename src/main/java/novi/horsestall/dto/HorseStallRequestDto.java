package novi.horsestall.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class HorseStallRequestDto {

    // attributen

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    @Size(min = 1, max = 100)
    private String size;

    @NotBlank
    @Size(min = 10, max = 100)
    private String type;

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}