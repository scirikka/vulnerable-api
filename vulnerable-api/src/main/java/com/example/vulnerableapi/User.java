package com.example.vulnerableapi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private Long balance;
    private Long cvc;
    private Boolean isAdmin;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", cvc=" + cvc +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
