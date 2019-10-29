package com.example.oauth2authorizationserver.configuration;

import com.example.oauth2authorizationserver.domain.UserEntity;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UserEntity user = (UserEntity) authentication.getPrincipal();

        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("userId", user.getId());
        additionalInfo.put("userEmail", user.getEmail());
        additionalInfo.put("userCity", user.getCity());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
