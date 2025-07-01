package com.fariz.webappml.dao;

import com.fariz.webappml.model.Hero;
import com.fariz.webappml.util.DBUtil;

import java.sql.*;
import java.util.*;

public class HeroDAO {
    public List<Hero> getAllHeroes() {
        List<Hero> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM tm_hero")) {

            while (rs.next()) {
                Hero h = new Hero();
                h.setIdHero(rs.getInt("id_hero"));
                h.setNamaHero(rs.getString("nama_hero"));
                h.setKategori(rs.getString("kategori"));
                h.setGender(rs.getString("gender"));
                list.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertHero(Hero h) {
        String sql = "INSERT INTO tm_hero (nama_hero, kategori, gender) VALUES (?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, h.getNamaHero());
            ps.setString(2, h.getKategori());
            ps.setString(3, h.getGender());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Hero getHeroById(int id) {
        Hero h = new Hero();
        String sql = "SELECT * FROM tm_hero WHERE id_hero=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                h.setIdHero(rs.getInt("id_hero"));
                h.setNamaHero(rs.getString("nama_hero"));
                h.setKategori(rs.getString("kategori"));
                h.setGender(rs.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return h;
    }

    public void updateHero(Hero h) {
        String sql = "UPDATE tm_hero SET nama_hero=?, kategori=?, gender=? WHERE id_hero=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, h.getNamaHero());
            ps.setString(2, h.getKategori());
            ps.setString(3, h.getGender());
            ps.setInt(4, h.getIdHero());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHero(int id) {
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM tm_hero WHERE id_hero=?")) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}