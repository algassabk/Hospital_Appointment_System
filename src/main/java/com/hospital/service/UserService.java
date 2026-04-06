package com.hospital.service;

import com.hospital.dto.UserDTO;
import com.hospital.model.User;
import com.hospital.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setEmailVerified(userDTO.getEmailVerified());

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setEmailVerified(userDTO.getEmailVerified());

        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}