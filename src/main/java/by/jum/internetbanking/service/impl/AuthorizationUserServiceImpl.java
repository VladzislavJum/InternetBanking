package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.Role;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("authUserService")
public class AuthorizationUserServiceImpl implements UserDetailsService {

    private static Logger logger = Logger.getLogger(AuthorizationUserServiceImpl.class);

    @Autowired
    private UserDAO userDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        by.jum.internetbanking.entity.User user = userDao.getByUserName(login);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleUser()));
        return buildUserForAuthentication(user, authorities);
    }


    private User buildUserForAuthentication(by.jum.internetbanking.entity.User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }



}