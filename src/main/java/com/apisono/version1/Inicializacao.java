package com.apisono.version1;

import com.apisono.version1.model.Biometric;
import com.apisono.version1.model.SleepStage;
import com.apisono.version1.model.User;
import com.apisono.version1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {


    private final UserRepository userRepository;

    @Autowired
    public Inicializacao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        User user=User.builder()
                .username("user")
                .password("12345")
                .hearts(new ArrayList<>())
                .build();

   /*     Biometric biometric=Biometric.builder()
                .heartRate(80)
                .sleepStage(SleepStage.ASLEEP)
                .timestamp(LocalDateTime.now())
                .user(user)
                .build();

        user.getHearts().add(biometric);*/

        userRepository.save(user);
    }
}
