package all.servlet;

import all.model.User;
import all.service.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/admin/update")
public class AdminUpdateServlet extends HttpServlet {
    private UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("newName");
        String mail = req.getParameter("newMail");
        String role = req.getParameter("newRole");
        Long password = Long.parseLong(req.getParameter("newPassword"));
        Long id = Long.parseLong(req.getParameter("testId"));
        if (userService.isUserExist(id)) {
            userService.updateUser(new User(id, name, mail, role, password));
        }

        resp.sendRedirect("/admin");
    }
}
