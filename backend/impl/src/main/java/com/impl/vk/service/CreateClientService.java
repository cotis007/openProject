package com.impl.vk.service;

import com.api.dto.requestDto.Id;
import com.api.dto.responseDto.Common;
import com.impl.vk.utils.RandomGenerator;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class CreateClientService {
    public final RandomGenerator randomGenerator;

    public CreateClientService(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Common initNewClient(Id id) {
        return new Common(id.getUUID(), "id", "data");
    }
}
