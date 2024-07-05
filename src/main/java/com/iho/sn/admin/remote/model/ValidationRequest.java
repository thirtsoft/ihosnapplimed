package com.iho.sn.admin.remote.model;

import lombok.Builder;

@Builder
public record ValidationRequest(String code) {
}