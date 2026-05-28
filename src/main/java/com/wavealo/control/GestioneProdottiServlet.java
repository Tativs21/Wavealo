package com.wavealo.control;

import com.wavealo.dao.ProdottoDAO;
import com.wavealo.model.Amministratore;
import com.wavealo.model.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GestioneProdottiServlet", value = "/gestioneprodotti")
public class GestioneProdottiServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Amministratore amministratore = (Amministratore) session.getAttribute("amministratore");
        if(amministratore == null){
            response.sendRedirect(request.getContextPath() + "/loginAmministratore");
        }else{
            try{
                ProdottoDAO prodottoDAO = new ProdottoDAO();
                List<Prodotto> prodotti = prodottoDAO.getAllProdotti();
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher("/WEB-INF/view/gestioneprodotti.jsp").forward(request, response);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");

        try{
            ProdottoDAO prodottoDAO = new ProdottoDAO();

            if(action.equals("aggiungi")) {
                Prodotto p = new Prodotto();
                p.setNome(request.getParameter("nome"));
                p.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
                p.setQuantita(Integer.parseInt(request.getParameter("quantita")));
                p.setDescrizione(request.getParameter("descrizione"));
                p.setMarca(request.getParameter("marca"));
                p.setImmagine(request.getParameter("immagine"));
                p.setCategoriaId(Integer.parseInt(request.getParameter("categoriaId")));
                p.setDataInserimento(new java.sql.Date((System.currentTimeMillis())));
                p.setAttivo(true);
                prodottoDAO.addProdotto(p);
            }else if(action.equals("modifica")){
                Prodotto p = new Prodotto();
                p.setId(Integer.parseInt(request.getParameter("id")));
                p.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
                p.setQuantita(Integer.parseInt(request.getParameter("quantita")));
                p.setDescrizione(request.getParameter("descrizione"));
                p.setMarca(request.getParameter("marca"));
                p.setImmagine(request.getParameter("immagine"));
                p.setCategoriaId(Integer.parseInt(request.getParameter("categoriaId")));
                p.setDataInserimento(new java.sql.Date((System.currentTimeMillis())));
                p.setAttivo(true);
                prodottoDAO.updateProdotto(p);
            }else if(action.equals("cancella")){
                int id = Integer.parseInt(request.getParameter("id"));
                prodottoDAO.deleteProdotto(id);
            }

            response.sendRedirect(request.getContextPath() + "/gestioneprodotti");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
