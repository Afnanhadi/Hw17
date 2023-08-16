package com.example.hw17.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private String Id;
    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "verchar(20) not null")
    private String name;
    @NotEmpty(message = "should be not null")
    @Size(min = 4)
    @Column(unique = true)
    private String username;
    @NotEmpty(message = "should be not null")
    @Size(min = 4)
    @Column(columnDefinition = "verchar(20) not null")
    private String password;
    @NotEmpty(message = "should be not null")
    @Email
   @Column(unique = true)
    private String email;
    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "verchar(5) check( role='admin' or role = 'user' )")
    private String role;
    @NotNull(message = "should be not null")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
