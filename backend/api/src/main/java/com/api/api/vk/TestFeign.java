package com.api.api.vk;

import com.api.dto.requestDto.Id;
import com.api.dto.responseDto.Common;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface TestFeign {

    @PostMapping(value = "/vk/api")
    Common data(@RequestBody Id id);

}
