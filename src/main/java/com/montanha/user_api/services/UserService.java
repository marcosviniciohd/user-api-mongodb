package com.montanha.user_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.montanha.user_api.models.dto.UserDTO;
import com.montanha.user_api.models.User;
import com.montanha.user_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(String id) {
        return userRepository.findById(id)
                .map(UserDTO::convert)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public UserDTO save(UserDTO userDTO) {
        User user = User.convert(userDTO);
        return UserDTO.convert(userRepository.save(user));
    }

    public UserDTO update(String id, UserDTO userDTO) {
        User user = User.convert(userDTO);
        user.setId(id);
        return UserDTO.convert(userRepository.save(user));
    }

    public UserDTO delete(String id) {
        UserDTO userDTO = findById(id);
        userRepository.deleteById(id);
        return userDTO;
    }

    public List<UserDTO> findByName(String nome) {
        List<User> usuarios = userRepository.queryByNomeLike(nome);
        return usuarios.stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO editById(String id, UserDTO userDTO) {
        User user = User.convert(userDTO);
        user.setId(id);
        return UserDTO.convert(userRepository.save(user));
    }

    public Page<UserDTO> getAll(Pageable page) {
        Page<User> usuarios = userRepository.findAll(page);
        return usuarios.map(UserDTO::convert);
    }

}
