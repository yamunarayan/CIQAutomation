package org.ciq.utils;

import com.github.javafaker.Faker;

import java.util.random.RandomGenerator;

public class DataGenerationUtils {

    Faker faker;
    public DataGenerationUtils(Faker faker){
        this.faker=faker;
    }
    public String randomFirstName(){
        return faker.name().firstName();
    }
    public String randomLastName(){
        return faker.name().firstName();
    }

}
