package com.iho.sn.admin.service.auth;


import com.iho.sn.admin.entities.Profil;
import com.iho.sn.admin.entities.Token;
import com.iho.sn.admin.entities.TokenType;
import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.remote.model.ActionListResponse;
import com.iho.sn.admin.remote.model.AuthenticationResponse;
import com.iho.sn.admin.remote.model.ProfilReponse;
import com.iho.sn.admin.repository.TokenRepository;
import com.iho.sn.admin.repository.UtilisateurRepository;
import com.iho.sn.config.security.auth.AuthenticationRequest;
import com.iho.sn.config.security.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UtilisateurRepository repository;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        if (!authenticate.isAuthenticated()) {
            return null;
        }
        Utilisateur user = repository.findByEmail(request.email())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .id(user.getId())
                .matricule(user.getMatricule())
                .email(user.getEmail())
                .typeUtilisateur(user.getTypeUtilisateur())
                .profilReponse(getProfile(user.getProfil()))
                .build();
    }

    private ProfilReponse getProfile(Profil profil) {
        return new ProfilReponse(profil.getCode(), getActionReponse(profil));
    }

    private List<ActionListResponse> getActionReponse(Profil profil) {
        return profil.getAction().stream()
                .map(action -> new ActionListResponse(action.getCode(), action.getLibelle()))
                .toList();
    }

    private void saveUserToken(Utilisateur user, String jwtToken) {
        var token = Token.builder()
                .utilisateur(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(Utilisateur user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
}