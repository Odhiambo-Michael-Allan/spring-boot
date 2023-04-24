package com.example.SpringBootDemoApplication.configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@ConstructorBinding
@ConfigurationProperties( "app.sbip.ct" )
public class AppProperties {

    private final String name;  // Application Name
    private final String ip;  // Application IP
    private final int port;
    private final Security security;  // Application Security Configuration

    public AppProperties(String name, String ip, @DefaultValue( "8080" ) int port, Security security ) {
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.security = security;
    }

    public String getName() {
        return name;
    }

    public int getPort() {
        return port;
    }

    public Security getSecurity() {
        return security;
    }

    @Override
    public String toString() {
        return String.format( "AppProperties{\nname='%s',\nip='%s',\nport='%d',\nsecurity='%s'}\n",
                name, ip, port, security );
    }

    public static class Security {
        private boolean enabled;  // Enable Security. Possible values true/false.
        private final String token;
        private final List<String> roles;

        public Security( boolean enabled, String token, List<String> roles ) {
            this.enabled = enabled;
            this.token = token;
            this.roles = roles;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public String getToken() {
            return token;
        }

        public List<String> getRoles() {
            return roles;
        }

        @Override
        public String toString() {
            return String.format( "Security {\nenabled='%s'\ntoken='%s'\nroles='%s'}",
                    enabled, token, roles );
        }
    }

}
