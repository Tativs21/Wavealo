package com.wavealo.control;

import com.wavealo.dao.OrdineDAO;
import com.wavealo.model.Ordine;
import com.wavealo.model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrdiniUtenteServlet", value = "/ordiniutente")
public class OrdiniUtenteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        Utente utente = (Utente) session.getAttribute("utente");
        if(utente == null){
            response.sendRedirect(request.getContextPath() + "/loginUtente");
        }else{
            try{
                OrdineDAO ordineDAO = new OrdineDAO();
                List<Ordine> ordini = ordineDAO.getOrdineByUtente(utente.getId());
                request.setAttribute("ordini", ordini);
                request.getRequestDispatcher("/WEB-INF/view/ordiniutente.jsp").forward(request,response);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
