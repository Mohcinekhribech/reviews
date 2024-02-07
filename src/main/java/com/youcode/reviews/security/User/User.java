package com.youcode.reviews.security.User;


import com.youcode.reviews.app.entities.Review;
import com.youcode.reviews.security.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
//public class User {
public class User  implements UserDetails {
    @Id
    @GeneratedValue
    protected UUID id;
    protected String fullName;
    protected LocalDate dateOfBirth;
    @Column(unique = true)
    protected String email;
    protected String password;
    @Enumerated(EnumType.STRING)
    protected Role role;
    @OneToMany(mappedBy = "user")
    protected List<Token> tokens;

    @OneToMany(mappedBy = "user")
    protected List<Review> reviews;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
