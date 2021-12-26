package com.laiscarvalho.userapi.repository;

import com.laiscarvalho.userapi.dto.UserDto;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String cpf;

    private String address;

    private String phone;

    private LocalDateTime registerDate;

    public static class Builder {

        private String name = "";

        private String cpf = "";

        private String address = "";

        private String phone = "";

        private LocalDateTime registerDate = LocalDateTime.now();

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder registerDate(LocalDateTime registerDate) {
            this.registerDate = registerDate;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        name = builder.name;
        cpf = builder.cpf;
        address = builder.address;
        phone = builder.phone;
        registerDate = builder.registerDate;
    }


    public static User convertToUser(UserDto userDto) {
        User user = new Builder()
                .name(userDto.getName())
                .cpf(userDto.getCpf())
                .address(userDto.getAddress())
                .phone(userDto.getPhone())
                .registerDate(userDto.getRegisterDate())
                .build();

        return user;
    }
}
