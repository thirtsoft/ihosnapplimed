package com.iho.sn.admin.remote.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class ActivationRequest {
    @NotBlank
    private String email;
    @NotNull
    private String password;
}
