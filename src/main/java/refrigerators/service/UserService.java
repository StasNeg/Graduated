package refrigerators.service;


import refrigerators.AuthorizedUser;
import refrigerators.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import refrigerators.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        if(AuthorizedUser.safeGet()!=null && AuthorizedUser.get().getUserTo().getEmail().equals(email.toLowerCase()))
            return AuthorizedUser.get();
        User user = repository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
