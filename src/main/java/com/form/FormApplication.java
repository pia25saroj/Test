package com.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.form.model.User;
import com.form.repository.UserRepository;

@ComponentScan
@SpringBootApplication
public class FormApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FormApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String...args) throws Exception {
        this.userRepository.save(new User("Priya", "Saroj", "priya@gmail.com"));
        this.userRepository.save(new User("Tanaya", "Jadhav", "tanaya@gmail.com"));
        this.userRepository.save(new User("Ajay", "Jha", "ajay@gmail.com"));
    }
}