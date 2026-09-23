package com.fanid.repository;

import com.fanid.model.FanRegistration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FanRegistrationRepositoryTest {

    private FanRegistrationRepository fanRegistrationRepository;

    @BeforeEach
    public void set_up() {
        this.fanRegistrationRepository = new FanRegistrationRepository();
    }

    private FanRegistration buildRegistration(String email) {
        FanRegistration registration = new FanRegistration();
        registration.set_full_name("Yomi Test");
        registration.set_email(email);
        registration.set_country("Nigeria");
        registration.set_city("Lagos");
        registration.set_moment("The 2026 buzzer beater");
        registration.set_fan_years("1–2 years");
        registration.set_game(Arrays.asList("Shooting", "Leadership"));
        registration.set_message("Big fan!");
        registration.set_want("A signed jersey");
        registration.set_nickname("YomiFan");
        registration.set_journey("Been watching since college.");
        return registration;
    }

    @Test
    public void test_save_assigns_an_id_and_a_fan_id() {
        FanRegistration registration = buildRegistration("yomi@fan.com");

        FanRegistration savedRegistration = this.fanRegistrationRepository.save(registration);

        assertNotNull(savedRegistration.get_id());
        assertNotNull(savedRegistration.get_fan_id());
        assertTrue(savedRegistration.get_fan_id().startsWith("CC-2026-"));
    }

    @Test
    public void test_find_by_email_returns_the_correct_registration_when_it_exists() {
        FanRegistration registration = buildRegistration("yomi@fan.com");
        this.fanRegistrationRepository.save(registration);

        FanRegistration foundRegistration = this.fanRegistrationRepository.findByEmail("yomi@fan.com");

        assertNotNull(foundRegistration);
        assertEquals("YomiFan", foundRegistration.get_nickname());
    }

    @Test
    public void test_find_by_email_returns_null_when_the_registration_does_not_exist() {
        FanRegistration foundRegistration = this.fanRegistrationRepository.findByEmail("doesnotexist@fan.com");

        assertNull(foundRegistration);
    }

    @Test
    public void test_find_by_fan_id_returns_the_correct_registration_when_it_exists() {
        FanRegistration registration = buildRegistration("yomi@fan.com");
        FanRegistration savedRegistration = this.fanRegistrationRepository.save(registration);

        FanRegistration foundRegistration =
            this.fanRegistrationRepository.findByFanId(savedRegistration.get_fan_id());

        assertNotNull(foundRegistration);
        assertEquals("yomi@fan.com", foundRegistration.get_email());
    }
}
