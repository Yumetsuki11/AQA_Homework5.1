package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker faker;

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        faker = new Faker(new Locale(locale));
        return faker.address().city();
    }

    public static String generateName(String locale) {
        faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        faker = new Faker(new Locale(locale));
        return "+" + faker.number().numberBetween(7_900_000_00_00L, 8_000_000_00_00L);
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
