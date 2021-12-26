package com.laiscarvalho.userapi.service;

import com.laiscarvalho.userapi.UserRepository;
import com.laiscarvalho.userapi.dto.UserDto;
import com.laiscarvalho.userapi.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();

        return users
                .stream()
                .map(UserDto::convertToUserDto)
                .collect(Collectors.toList());
    }

    public Optional<User> findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public UserDto save(UserDto userDto){
        User user = userRepository.save(User.convertToUser(userDto));
        return UserDto.convertToUserDto(user);
    }

    public UserDto delete(long userId){
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            userRepository.delete(user.get());
        }
        return null;
    }

    public UserDto findByCpf(String cpf){
        User user = userRepository.findByCpf(cpf);
        if(user != null){
            return UserDto.convertToUserDto(user);
        }
        return null;
    }

    public List<UserDto> findByName(String name){
        List<User> users = userRepository.findByNameLike(name);
        return users.stream().map(UserDto::convertToUserDto).collect(Collectors.toList());
    }

}
