package ojt.management.common.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCreateRequest implements Serializable {
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 2000)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String title;

    @NotNull
    @NotBlank
    private Long semesterId;

    @NotNull
    @NotBlank
    private Long majorId;
}
