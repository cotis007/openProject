package com.api.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Common {

    @JsonProperty("UUID")
    @NotBlank(message = "Поле UUID - не может быть null и не должно содержать пробельные символы")
    @Size(max = 60, message = "Поле UUID - не может быть больше 60 символов")
    private String UUID;

    @JsonProperty("id")
    private String id;

    @JsonProperty("data")
    private String data;

}
