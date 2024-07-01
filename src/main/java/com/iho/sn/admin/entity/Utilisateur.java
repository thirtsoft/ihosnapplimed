package com.iho.sn.admin.entity;

import com.iho.sn.config.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur extends AbstractAuditableEntity implements UserDetails, Principal {

    @SequenceGenerator(
            name = "MAT_SEG_GEN",
            sequenceName = "matriculeGenerator"
    )
    @GeneratedValue(generator = "matriculeGenerator", strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private String matricule;

    @Column(name = "motdepasse")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@#$%^&+=]).{8,}$")
    private String motdepasse;

    private String nom;

    private String prenom;

    @Column(unique = true)
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Column(unique = true)
    private String telephone;

    private String sexe;

    private String civilite;

    private String fonction;

    private String adresse;

    private String typeCompte;
/*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_uid")
    private Profil profil;*/

    private String education;

    private String experience;

    private Date dateRecrutement;

    private boolean compteActive;

    private boolean actif;
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
