package com.fanid.controller;

import com.fanid.model.FanRegistration;
import com.fanid.repository.FanRegistrationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fan-id")
public class FanRegistrationController {

    private final FanRegistrationRepository fanRegistrationRepository;

    public FanRegistrationController(FanRegistrationRepository fanRegistrationRepository) {
        this.fanRegistrationRepository = fanRegistrationRepository;
    }

    @PostMapping("/register")
    public FanRegistration register(@RequestBody FanRegistration registration) {
        return this.fanRegistrationRepository.save(registration);
    }

    @GetMapping("/{fanId}")
    public FanRegistration getByFanId(@PathVariable String fanId) {
        return this.fanRegistrationRepository.findByFanId(fanId);
    }
}
