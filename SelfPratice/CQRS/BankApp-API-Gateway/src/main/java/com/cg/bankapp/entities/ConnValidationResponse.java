package com.cg.bankapp.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class ConnValidationResponse {
    private String status;
    private boolean authenticated;
    private String methodType;
    private String username;
    private String token;
    private List<Authorities> authorities;
}