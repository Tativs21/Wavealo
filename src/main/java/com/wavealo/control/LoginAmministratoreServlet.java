package com.wavealo.control;

import com.wavealo.dao.AmministratoreDAO;
import com.wavealo.model.Amministratore;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginAmministratoreServlet", value = "/loginAmministratore")
public class LoginAmministratoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/loginAmministratore.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try{
            AmministratoreDAO amministratoreDAO = new AmministratoreDAO();
            Amministratore amministratore = amministratoreDAO.loginAdmin(email, password);
            if(amministratore != null){
                HttpSession session = request.getSession();
                session.setAttribute("amministratore", amministratore);
                response.sendRedirect(request.getContextPath() + "/catalogo");
            }else{
                request.setAttribute("errore", "Email o password errati");
                request.getRequestDispatcher("/WEB-INF/view/loginAmministratore.jsp").forward(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
