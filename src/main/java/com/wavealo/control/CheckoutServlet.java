package com.wavealo.control;

import com.wavealo.dao.DettagliOrdineDAO;
import com.wavealo.dao.OrdineDAO;
import com.wavealo.model.CartItem;
import com.wavealo.model.DettagliOrdine;
import com.wavealo.model.Ordine;
import com.wavealo.model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CheckoutServlet", value = "/checkout")
public class CheckoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Utente utente = (Utente) session.getAttribute("utente");
        if(utente == null) {
            response.sendRedirect(request.getContextPath() + "/loginUtente");
        }else{
            request.getRequestDispatcher("/WEB-INF/view/checkout.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Utente utente = (Utente) session.getAttribute("utente");
        String citta = request.getParameter("citta");
        String cap = request.getParameter("CAP");
        String via = request.getParameter("via");
        String numeroCivico = request.getParameter("numeroCivico");
        List<CartItem> carrello = (List<CartItem>) session.getAttribute("carrello");
        try{
            Ordine ordine = new Ordine();
            ordine.setUtenteId(utente.getId());
            ordine.setCitta(citta);
            ordine.setCAP(cap);
            ordine.setVia(via);
            ordine.setNumeroCivico(numeroCivico);
            ordine.setDataOrdine(new Date(System.currentTimeMillis()));

            OrdineDAO ordineDAO = new OrdineDAO();
            int ordineId = ordineDAO.addOrdine(ordine);

            DettagliOrdineDAO dettagliOrdineDAO = new DettagliOrdineDAO();
            for(CartItem item : carrello){
                DettagliOrdine dettaglio = new DettagliOrdine();
                dettaglio.setOrdineId(ordineId);
                dettaglio.setProdottoId(item.getProdotto().getId());
                dettaglio.setQuantita(item.getQuantita());
                dettaglio.setPrezzo(item.getProdotto().getPrezzo());
                dettagliOrdineDAO.addDettagliOrdine(dettaglio);
            }
            session.setAttribute("carrello", null);
            response.sendRedirect(request.getContextPath() + "/ordini");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
