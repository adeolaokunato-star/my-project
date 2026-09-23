package com.fanid.repository;

import com.fanid.model.FanRegistration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class FanRegistrationRepository {

    private List<FanRegistration> registrations;
    private long nextId;
    private Random random;

    public FanRegistrationRepository() {
        this.registrations = new ArrayList<FanRegistration>();
        this.nextId = 1L;
        this.random = new Random();
    }

    public FanRegistration save(FanRegistration registration) {
        registration.set_id(this.nextId);
        registration.set_fan_id(this.generateFanId());
        this.nextId++;
        this.registrations.add(registration);
        return registration;
    }

    public FanRegistration findByEmail(String email) {
        for (FanRegistration registration : this.registrations) {
            if (registration.get_email().equals(email)) {
                return registration;
            }
        }
        return null;
    }

    public FanRegistration findByFanId(String fanId) {
        for (FanRegistration registration : this.registrations) {
            if (registration.get_fan_id().equals(fanId)) {
                return registration;
            }
        }
        return null;
    }

    public List<FanRegistration> findAll() {
        return this.registrations;
    }

    private String generateFanId() {
        int number = 1000 + this.random.nextInt(9000);
        return "CC-2026-" + number;
    }
}
