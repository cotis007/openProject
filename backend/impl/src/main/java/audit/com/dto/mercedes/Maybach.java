package audit.com.dto.mercedes;

import audit.com.annotations.AuditField;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Maybach {
    @AuditField(name = "price", description = "дорого цена")
    private String price;

    @AuditField(name = "type", description = "моделька")
    private String type;
}
