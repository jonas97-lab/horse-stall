package novi.horsestall.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class HorseStallRequestDto {

    // attributen
    @NotBlank
    @Size(min = 1, max = 100)
    private String type;

    @NotBlank
    @Size(min = 1, max = 100)
    private String size;

    // getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}