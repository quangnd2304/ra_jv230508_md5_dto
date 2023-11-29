package ra.springboot_dto.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriesRequestDTO {
    private long id;
    private String name;
    private boolean status;
}
