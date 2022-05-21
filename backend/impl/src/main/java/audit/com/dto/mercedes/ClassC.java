package audit.com.dto.mercedes;


import audit.com.annotations.AuditField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClassC {
    @AuditField(name = "classC",description = "класс мерина")
    private String model;

    @AuditField(name = "year", description = "год")
    private String year;

    @AuditField(name = "price", description = "цена мерина")
    private String price;

    private ModelEnum modelEnum;
}
