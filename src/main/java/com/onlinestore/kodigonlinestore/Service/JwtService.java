package com.onlinestore.kodigonlinestore.Service;

import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Model.JwtRequest;
import com.onlinestore.kodigonlinestore.Model.JwtResponse;
import com.onlinestore.kodigonlinestore.Repository.CustomerRepository;
import com.onlinestore.kodigonlinestore.Util.JwtUtil;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private JwtUtil util;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private CustomerService service;

    public JwtResponse createJwtToken(JwtRequest request) throws Exception {
        String user = request.getUserName();
        String pass = request.getPassword();

        Authenticate(user,pass);

        final UserDetails details = loadUserByUsername(user);

        String token = util.generateToken(details);

        Customer cus = service.findWithEmail(user).get();

        return new JwtResponse(cus,token);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user = service.findWithEmail(username).get();

        if(!Objects.isNull(user)){
            return new User(user.getEmail(),
                    user.getPassword(),
                    getAuthorities(user)
                    );
        }else {
            throw new UsernameNotFoundException("Not valid");
        }

    }

    private Set getAuthorities(Customer user){
        Set Auth = new HashSet();

        user.getRole().forEach((n)->{
            Auth.add(new SimpleGrantedAuthority("ROLE_"+n.getRoleName()));
        });

        return Auth;

    }

    private void Authenticate(String userName,String password) throws Exception {

        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));

        }catch (DisabledException e){
            throw new Exception("User is disable");
        }catch (BadCredentialsException e){
            throw new Exception("Bad Credentials from user");
        }
    }
}
