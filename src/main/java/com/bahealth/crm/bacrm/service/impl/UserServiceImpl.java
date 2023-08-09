package com.bahealth.crm.bacrm.service.impl;

import com.bahealth.crm.bacrm.converter.user.UserConverter;
import com.bahealth.crm.bacrm.data.dto.user.UserDto;
import com.bahealth.crm.bacrm.data.entity.user.User;
import com.bahealth.crm.bacrm.data.exception.ResourceNotFoundException;
import com.bahealth.crm.bacrm.repository.UserRepository;
import com.bahealth.crm.bacrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto find(Long id) throws ResourceNotFoundException {
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isPresent()) {
            return UserConverter.toDto(optUser.get());
        } else {
            throw new ResourceNotFoundException("User", "User is not found!");
        }
    }

    @Override
    public UserDto save(UserDto user) {
        User entity = UserConverter.toEntity(user);
        entity.setPassword(encoder.encode(user.getPassword()));
        return UserConverter.toDto(userRepository.save(entity));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            //authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }


}