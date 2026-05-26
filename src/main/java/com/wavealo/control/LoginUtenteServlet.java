package com.wavealo.control;

import com.wavealo.dao.UtenteDAO;
import com.wavealo.model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginUtenteServlet", value = "/loginUtente")
public class LoginUtenteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/loginUtente.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try{
            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = utenteDAO.loginUser(email, password);
            if(utente != null) {
                HttpSession session = request.getSession();
                session.setAttribute("utente", utente);
                response.sendRedirect(request.getContextPath() + "/catalogo");
            }else{
                request.setAttribute("errore", "Email o password errati");
                request.getRequestDispatcher("/WEB-INF/view/loginUtente.jsp").forward(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
