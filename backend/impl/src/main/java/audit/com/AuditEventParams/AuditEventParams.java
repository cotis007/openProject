package audit.com.AuditEventParams;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.lang.Nullable;

import java.util.Objects;

@JsonPropertyOrder({"name", "value"})
public class AuditEventParams {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;
    public static final String JSON_PROPERTY_VALUE = "value";
    private String value;

    public AuditEventParams() {
    }

    public AuditEventParams name(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("name")
    @JsonInclude(Include.ALWAYS)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuditEventParams value(String value) {
        this.value = value;
        return this;
    }

    @Nullable
    @JsonProperty("value")
    @JsonInclude(Include.USE_DEFAULTS)
    public String getValue() {
        return this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            AuditEventParams auditEventParams = (AuditEventParams) o;
            return Objects.equals(this.name, auditEventParams.name) && Objects.equals(this.value, auditEventParams.value);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.value});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuditEventParams {\n");
        sb.append("     name: ").append(this.toIndentedString(this.name)).append("\n");
        sb.append("     value: ").append(this.toIndentedString(this.value)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n      ");
    }
}
