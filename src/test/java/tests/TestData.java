package tests;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestData {

    Faker faker = new Faker();
    Random rand = new Random();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.number().digits(10);

    String[] genderItems = new String[] {"Male", "Female", "Other"};
    String gender = genderItems[rand.nextInt(genderItems.length)];

    String birthDayDay =  "" + faker.number().numberBetween(4, 28);
    String[] monthItems = new String[] {"October", "January", "December", "June", "September", "May", "July", "April", "August", "November", "March", "February"};
    String birthDayMonth = monthItems[rand.nextInt(monthItems.length)];
    String birthDayYear = "" + faker.number().numberBetween(1990, 2022);

    String[] subjectItems = new String[] {"Math", "Arts"};
    String subject = subjectItems[rand.nextInt(subjectItems.length)];

    String[] hobbyItems = new String[] {"Sports", "Reading", "Music"};
    String hobby = hobbyItems[rand.nextInt(hobbyItems.length)];

    String file = "img/pic.png";
    String currentAddress = faker.address().fullAddress();

    String state = "NCR";
    String[] cityItems = new String[] {"Delhi", "Noida"};
    String city = cityItems[rand.nextInt(cityItems.length)];

}
