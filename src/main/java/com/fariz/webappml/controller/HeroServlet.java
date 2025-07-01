package com.fariz.webappml.controller;

import com.fariz.webappml.dao.HeroDAO;
import com.fariz.webappml.model.Hero;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HeroServlet extends HttpServlet {
    private HeroDAO dao = new HeroDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Hero hero = dao.getHeroById(id);
            req.setAttribute("hero", hero);
            req.getRequestDispatcher("form.jsp").forward(req, resp);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.deleteHero(id);
            resp.sendRedirect("HeroServlet");
        } else {
            List<Hero> list = dao.getAllHeroes();
            req.setAttribute("listHero", list);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hero hero = new Hero();
        hero.setIdHero(Integer.parseInt(req.getParameter("id_hero")));
        hero.setNamaHero(req.getParameter("nama_hero"));
        hero.setKategori(req.getParameter("kategori"));
        hero.setGender(req.getParameter("gender"));

        if (hero.getIdHero() == 0) {
            dao.insertHero(hero);
        } else {
            dao.updateHero(hero);
        }
        resp.sendRedirect("HeroServlet");
    }
}
