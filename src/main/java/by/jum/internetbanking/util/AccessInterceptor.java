package by.jum.internetbanking.util;

import by.jum.internetbanking.facade.RoleFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = Logger.getLogger(AccessInterceptor.class);

    @Autowired
    private RoleFacade roleFacade;

    @Autowired
    private ApplicationContext appContext;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        String role = roleFacade.getRoleCurrentUser();
        String context = appContext.getApplicationName();
        LOGGER.info("User with role " + role + " authorized");
        if (Roles.ROLE_ADMIN.getRole().equals(role)) {
            httpServletResponse.sendRedirect(context + "/admin/users");
            return false;
        } else if (Roles.ROLE_USER.getRole().equals(role)) {
            httpServletResponse.sendRedirect(context + "/user/accounts");
            return false;
        } else if (Roles.ROLE_ANONYMOUS.getRole().equals(role)) {
            LOGGER.error("LOL");
            httpServletResponse.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
