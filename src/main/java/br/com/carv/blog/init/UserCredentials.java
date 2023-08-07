package br.com.carv.blog.init;

import br.com.carv.blog.entity.Role;
import br.com.carv.blog.entity.User;
import br.com.carv.blog.repository.UserRepository;
import br.com.carv.blog.security.SecurityConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class UserCredentials implements CommandLineRunner {
    private final UserRepository userRepository;
    private final SecurityConfig securityConfig;
    private final Logger logger = Logger.getLogger(UserCredentials.class.getName());
    public UserCredentials(UserRepository userRepository, SecurityConfig securityConfig) {
        this.userRepository = userRepository;
        this.securityConfig = securityConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Insert Batman into database.");
        Set<Role> authorizations = new HashSet<>();
        authorizations.add(new Role("ADMIN"));
        User user = new User("Bruce", "Batman", "batman@batemail.com",
                securityConfig.passwordEncoder().encode("BruceWayne"),
                authorizations, true);
        this.userRepository.save(user);

    }
}
