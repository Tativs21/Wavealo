package com.wavealo.control;

import com.wavealo.dao.ProdottoDAO;
import com.wavealo.model.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CatalogoServlet", value = "/catalogo")
public class CatalogoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            List<Prodotto> prodotti = prodottoDAO.getAllProdotti();

            request.setAttribute("prodotti", prodotti);
            request.getRequestDispatcher("/WEB-INF/view/catalogo.jsp").forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
