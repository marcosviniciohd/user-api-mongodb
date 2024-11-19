package com.montanha.user_api.models.dto;

import java.time.LocalDateTime;


import com.montanha.user_api.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    private String telefone;
    private LocalDateTime dataCadastro;

    public static UserDTO convert(User user) {
        return new UserDTO(user.getId(), user.getNome(), user.getCpf(), user.getEndereco(), user.getEmail(), user.getTelefone(), user.getDataCadastro());
    }

}
