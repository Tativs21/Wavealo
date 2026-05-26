package com.wavealo.control;

import com.wavealo.dao.ProdottoDAO;
import com.wavealo.model.CartItem;
import com.wavealo.model.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CarrelloServlet", value = "/carrello")
public class CarrelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/view/carrello.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        List<CartItem> carrello = (List<CartItem>) session.getAttribute("carrello");
         if(action.equals("aggiungi")){
            if(carrello == null) {
                carrello = new ArrayList<>();
            }
            int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
            ProdottoDAO prodottoDAO = new ProdottoDAO();
             Prodotto prodotto = null;
             try {
                 prodotto = prodottoDAO.getProdottoById(idProdotto);
             } catch (Exception e) {
                 e.printStackTrace();
             }
             boolean trovato = false;
            for(CartItem item : carrello){
                if(item.getProdotto().getId() == idProdotto) {
                    item.setQuantita(item.getQuantita() + 1);
                    trovato = true;
                    break;
                }
            }
            if(!trovato) {
                carrello.add(new CartItem(prodotto, 1));
            }
            session.setAttribute("carrello", carrello);
            response.sendRedirect(request.getContextPath() + "/carrello");

         }else if(action.equals("rimuovi")){
             int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
             carrello.removeIf(item -> item.getProdotto().getId() == idProdotto);
             session.setAttribute("carrello", carrello);
             response.sendRedirect(request.getContextPath() + "/carrello");
         }else if(action.equals("svuota")){
             carrello.clear();
             session.setAttribute("carrello", carrello);
             response.sendRedirect(request.getContextPath() + "/carrello");
         }
    }
}
