package com.wavealo.control;

import com.wavealo.dao.UtenteDAO;
import com.wavealo.model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "RegistrazioneServlet", value = "/registrazione")
public class RegistrazioneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/view/registrazione.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        Date dataRegistrazione = new Date(System.currentTimeMillis());

        try{
            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = utenteDAO.getUtenteByEmail(email);
            if(utente == null){
                Utente nuovoUtente = new Utente();
                nuovoUtente.setEmail(email);
                nuovoUtente.setPassword(password);
                nuovoUtente.setNome(nome);
                nuovoUtente.setCognome(cognome);
                nuovoUtente.setDataRegistrazione(dataRegistrazione);
                utenteDAO.signupUser(nuovoUtente);
                response.sendRedirect(request.getContextPath() + "/loginUtente");
            }else{
                request.setAttribute("errore", "Email già registrato");
                request.getRequestDispatcher("/WEB-INF/view/registrazione.jsp").forward(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
