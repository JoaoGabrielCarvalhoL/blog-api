package br.com.carv.blog.config;

import br.com.carv.blog.mapper.UserMapper;
import br.com.carv.blog.mapper.impl.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserMapperConfig {
    @Bean
    UserMapper userMapper(PasswordEncoder passwordEncoder) {
        return new UserMapperImpl(passwordEncoder);
    }
}
