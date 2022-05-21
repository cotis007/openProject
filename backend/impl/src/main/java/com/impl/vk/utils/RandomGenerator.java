package com.impl.vk.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

@Slf4j
@Component
public class RandomGenerator {

    @Value("${uuid.algorithm}")
    private String algorithm = null;

    public Integer getRandomUID() {
        SecureRandom secureRandom = null;

        try {
            secureRandom = SecureRandom.getInstance(algorithm);
        }  catch (NullPointerException | NoSuchAlgorithmException e) {
            log.error("Algorithm search error for generating UID. Check properties file: " + e);
        }
        return secureRandom != null ? secureRandom.nextInt(Integer.MAX_VALUE) : new SecureRandom().nextInt(Integer.MAX_VALUE);
    }

    public String getNewUUID() {
        return UUID.randomUUID().toString();
    }
}
