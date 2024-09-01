package ru.kata.spring.boot_security.demo.converter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserConverter(PasswordEncoder passwordEncoder, RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(passwordEncoder.encode(user.getPassword()));
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setRoles(user.getRoles().stream().map(role -> role.getName()).collect(Collectors.toSet()));
        return userDTO;
    }

    public User convertToEntity(UserDTO dto) {
        User user = new User();
        if (dto.getId() != null) {
            user.setId(dto.getId());
        }
        if (dto.getUsername() != null) {
            user.setUsername(dto.getUsername());
        }
        if (dto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }
        if (dto.getPhone() != null) {
            user.setPhone(dto.getPhone());
        }
        if (dto.getRoles() != null) {
            Set<Role> roles = dto.getRoles().stream().map(roleService::findByName).collect(Collectors.toSet());
            user.setRoles(roles);
        }
        return user;
    }
}
