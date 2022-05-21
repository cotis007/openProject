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
public class MercedesGT {
    @AuditField(name = "model", description = "model")
    private Integer model;

    @Setter
    @AuditField(name = "mashinka")
    private Maybach maybach;

    @Getter
    @AuditField(description = "годик")
    private String year;

    @AuditField(name = "price", description = "цена")
    private String price;
}
