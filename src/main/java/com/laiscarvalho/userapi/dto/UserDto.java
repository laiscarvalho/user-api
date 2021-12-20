package com.laiscarvalho.userapi.dto;

import com.laiscarvalho.userapi.repository.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
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

        public UserDto build() {
            return new UserDto(this);
        }
    }

    private UserDto(Builder builder) {
        name = builder.name;
        cpf = builder.cpf;
        address = builder.address;
        phone = builder.phone;
        registerDate = builder.registerDate;
    }

    public static UserDto convertToUserDto(User user) {
        UserDto userDto = new Builder()
                .name(user.getName())
                .cpf(user.getCpf())
                .address(user.getAddress())
                .phone(user.getPhone())
                .registerDate(user.getRegisterDate())
                .build();
        return userDto;
    }

}
