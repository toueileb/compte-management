package org.sid.comptemanagement.jwt;

import lombok.Data;

@Data
public class JwtRequest {

    private String email;
    private String password;

}