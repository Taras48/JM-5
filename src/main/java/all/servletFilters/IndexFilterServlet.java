package all.servletFilters;

import all.model.User;
import all.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/index")
public class IndexFilterServlet implements Filter {

    private UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getParameter("password") == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String name = servletRequest.getParameter("name");
            Long password = Long.parseLong(servletRequest.getParameter("password"));
            User user = userService.getUser(name, password);
            if (user != null) {
                if (user.getRole().equals("admin")) {

                    HttpServletRequest request = (HttpServletRequest) servletRequest;
                    request.getSession().setAttribute("Role", "admin");
                    HttpServletResponse response = (HttpServletResponse) servletResponse;
                    response.sendRedirect("/admin");

                } else {
                    HttpServletRequest request = (HttpServletRequest) servletRequest;
                    request.getSession().setAttribute("Role", "user");
                    HttpServletResponse response = (HttpServletResponse) servletResponse;
                    response.sendRedirect("/user");
                }
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }

        }

    }

    @Override
    public void destroy() {

    }
}

