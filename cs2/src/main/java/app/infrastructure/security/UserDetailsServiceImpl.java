package app.infrastructure.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * Implementation of UserDetailsService that loads user-specific data.
 * Replace the UserRepository with your actual user repository.
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    // Inject your UserRepository here
    // private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace this with your actual user lookup logic:
        //
        // AppUser appUser = userRepository.findByUsername(username)
        //         .orElseThrow(() -> new UsernameNotFoundException(
        //                 "User not found with username: " + username));
        //
        // List<SimpleGrantedAuthority> authorities = appUser.getRoles().stream()
        //         .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
        //         .collect(Collectors.toList());
        //
        // return new User(appUser.getUsername(), appUser.getPassword(), authorities);

        throw new UsernameNotFoundException(
                "UserDetailsServiceImpl: configure your UserRepository and implement loadUserByUsername. " +
                "User not found: " + username
        );
    }

    /**
     * Helper to map your domain user to a Spring Security UserDetails.
     * Adapt field names to match your entity.
     */
    private UserDetails buildUserDetails(
            String username,
            String encodedPassword,
            List<String> roles
    ) {
        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

        return User.builder()
                .username(username)
                .password(encodedPassword)
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
