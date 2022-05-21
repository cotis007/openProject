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
public class Mercedes {
    @AuditField()
    private MercedesGT mercedesGT;
    @AuditField()
    private Maybach maybach;
    @AuditField()
    private ClassC classC;
    @AuditField()
    private ClassS classS;
}
