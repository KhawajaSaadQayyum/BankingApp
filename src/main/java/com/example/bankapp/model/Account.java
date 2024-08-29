package com.example.bankapp.model;

import jakarta.persistence.*;
import jakarta.transaction.Transaction;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private BigDecimal balacne;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transaction;
// @Transient is used if we don't want to create a columns in database

    @Transient
    private Collection<? extends GrantedAuthority> authorities;
}
