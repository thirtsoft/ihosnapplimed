package com.iho.sn.utils;


import com.iho.sn.admin.entities.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilString {

    private UtilString() {
        // hide constructor
    }

    public static String genererMatricule() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
        return "MAT_" + df.format(LocalDateTime.now());
    }

    public static String createNumeroHospitalisation(int poz) {
        DecimalFormat numFormat = new DecimalFormat("00000");
        return "HOST_" + numFormat.format(poz);
    }

    public static String createNumeroConsultation(int poz) {
        DecimalFormat numFormat = new DecimalFormat("00000");
        return "CONS_" + numFormat.format(poz);
    }

    public static String getUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        return url.replace(request.getServletPath(), "");
    }

    public static String applicationUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        return url.replace(request.getServletPath(), "");
    }

    public static String getCurrentUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        Utilisateur userPrincipal = (Utilisateur) authentication.getPrincipal();
        return userPrincipal.getUsername();
    }

    public static String message(String nom, String url, String token) {
        return "Bonjour " + nom + ",\n\nVotre nouveau compte a été crée. Veuillez ci-dessus pour valider votre compte.\n\n"
                + urlDeVerification(url, token) + "";
    }

    private static String urlDeVerification(String url, String token) {
        return url + "" + token;
    }


    public static String generateCommonsLang3Password() {
        String upperCaseLetters = RandomStringUtils.random(1, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(4, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(2);
        String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
        String totalChars = RandomStringUtils.randomAlphanumeric(2);
        return upperCaseLetters.concat(lowerCaseLetters)
                .concat(numbers)
                .concat(specialChar)
                .concat(totalChars);
    }

}
