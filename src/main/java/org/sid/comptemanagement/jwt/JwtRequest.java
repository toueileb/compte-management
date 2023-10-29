package org.sid.comptemanagement.jwt;

import lombok.Data;

/**
 * The type Jwt request.
 */
@Data
public class JwtRequest {

    private String email;
    private String password;

}