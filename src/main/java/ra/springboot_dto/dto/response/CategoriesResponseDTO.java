package ra.springboot_dto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriesResponseDTO {
    private long id;
    private String name;
    private boolean status;
}
