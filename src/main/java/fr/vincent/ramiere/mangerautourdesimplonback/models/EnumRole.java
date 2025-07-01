package fr.vincent.ramiere.mangerautourdesimplonback.models;

import org.springframework.security.core.GrantedAuthority;

public enum EnumRole implements GrantedAuthority {
    ROLE_READER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

}
