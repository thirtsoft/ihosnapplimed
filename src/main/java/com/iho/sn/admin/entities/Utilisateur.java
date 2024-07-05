package com.iho.sn.admin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Utilisateur extends AbstractAuditableEntity implements UserDetails {

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
    private String typeUtilisateur;
    private String codeUtilisateur;
    @Column(unique = true)
    private String activation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_uid")
    private Profil profil;

    private String education;

    private String experience;

    private Date dateRecrutement;

    private boolean compteActive;

    private boolean actif;
    @Column(name = "est_valide")
    private int est_valide;

    public boolean isEst_valide() {
        if (est_valide == 1)
            return true;
        else
            return false;
    }

    public void setEst_valide(boolean est_valide) {
        if (est_valide == true)
            this.est_valide = 1;
        else
            this.est_valide = 0;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getProfil()
                .getAction().stream()
                .map(Action::getLibelle)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.motdepasse;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.actif;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.actif;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.actif;
    }

    @Override
    public boolean isEnabled() {
        return this.actif;
    }
}
