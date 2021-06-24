package edu.citytech.cst.s23253396.cst4713project.security.services;

import edu.citytech.cst.s23253396.cst4713project.security.models.JsonUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JsonUserDetailService implements UserDetailsService {

    @Override
    public JsonUserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return new JsonUserDetails(userId);
    }
}
