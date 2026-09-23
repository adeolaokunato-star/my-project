package com.fanid.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE
)
public class FanRegistration {

    private Long id;
    private String fanId;

    private String fullName;
    private String email;
    private String country;
    private String city;
    private String social;
    private String moment;

    private String fanYears;
    private List<String> game;

    private String message;
    private String want;

    private String nickname;
    private String journey;

    public FanRegistration() {
    }

    public FanRegistration(Long id, String fullName, String email, String country, String city,
                            String social, String moment, String fanYears, List<String> game,
                            String message, String want, String nickname, String journey) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.country = country;
        this.city = city;
        this.social = social;
        this.moment = moment;
        this.fanYears = fanYears;
        this.game = game;
        this.message = message;
        this.want = want;
        this.nickname = nickname;
        this.journey = journey;
    }

    public Long get_id() {
        return this.id;
    }

    public void set_id(Long id) {
        this.id = id;
    }

    public String get_fan_id() {
        return this.fanId;
    }

    public void set_fan_id(String fanId) {
        this.fanId = fanId;
    }

    public String get_full_name() {
        return this.fullName;
    }

    public void set_full_name(String fullName) {
        this.fullName = fullName;
    }

    public String get_email() {
        return this.email;
    }

    public void set_email(String email) {
        this.email = email;
    }

    public String get_country() {
        return this.country;
    }

    public void set_country(String country) {
        this.country = country;
    }

    public String get_city() {
        return this.city;
    }

    public void set_city(String city) {
        this.city = city;
    }

    public String get_social() {
        return this.social;
    }

    public void set_social(String social) {
        this.social = social;
    }

    public String get_moment() {
        return this.moment;
    }

    public void set_moment(String moment) {
        this.moment = moment;
    }

    public String get_fan_years() {
        return this.fanYears;
    }

    public void set_fan_years(String fanYears) {
        this.fanYears = fanYears;
    }

    public List<String> get_game() {
        return this.game;
    }

    public void set_game(List<String> game) {
        this.game = game;
    }

    public String get_message() {
        return this.message;
    }

    public void set_message(String message) {
        this.message = message;
    }

    public String get_want() {
        return this.want;
    }

    public void set_want(String want) {
        this.want = want;
    }

    public String get_nickname() {
        return this.nickname;
    }

    public void set_nickname(String nickname) {
        this.nickname = nickname;
    }

    public String get_journey() {
        return this.journey;
    }

    public void set_journey(String journey) {
        this.journey = journey;
    }
}
