package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

@RestController
@CrossOrigin
public class DBController {

    PreparedStatement ps;
    Connection con;
    String sql;

    @GetMapping("/dist")
    @CrossOrigin
    public String saylistDistrict() throws SQLException {
        PreparedStatement ps;
        JsonArray districtlist = new JsonArray();

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/mydb?allowPublicKeyRetrieval=true",
                    "admin",
                    "password");
            sql = "SELECT distcode, name FROM district";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                JsonObject jsondistrict = new JsonObject();
                jsondistrict.addProperty("districtcode", res.getString("distcode").toString().trim());
                jsondistrict.addProperty("districtname", res.getString("name").toString().trim());
                districtlist.add(jsondistrict);
            }
            System.out.println("districtlist" + districtlist.size());
            close(con, ps, res);
        } catch (Exception e) {
            System.out.println("getservice Exception==>" + e);
        }
        return districtlist.toString();
    }

    @GetMapping("/taluk")
    @ResponseBody
    @CrossOrigin
    public String listTaluk(@RequestParam String Discode) throws JsonParseException {
        String districtcode = Discode;
        JsonArray taluklist = new JsonArray();

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/mydb?allowPublicKeyRetrieval=true",
                    "admin",
                    "password");
            sql = "select * from taluk where distcode=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, districtcode);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                JsonObject jsontaluk = new JsonObject();
                jsontaluk.addProperty("districtcode", res.getString("distcode").toString().trim());
                jsontaluk.addProperty("talukcode", res.getString("talukcode").toString().trim());
                jsontaluk.addProperty("talukname", res.getString("name").toString().trim());
                taluklist.add(jsontaluk);
            }
            System.out.println("taluklist" + taluklist.size());
        } catch (Exception e) {
            System.out.println("getservice Eception==>" + e);
        }
        return taluklist.toString();
    }

    @GetMapping("/village")
    @ResponseBody
    @CrossOrigin
    public String listVillage(@RequestParam String Discode, @RequestParam String Talukcode) throws JsonParseException {
        String districtcode = Discode;
        String talukcode = Talukcode;
        JsonArray villagelist = new JsonArray();

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/mydb?allowPublicKeyRetrieval=true",
                "admin",
                "password");
            sql = "select * from village where distcode=? and talukcode=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, districtcode);
            ps.setString(2, talukcode);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                JsonObject jsonvillage = new JsonObject();
                jsonvillage.addProperty("districtcode", res.getString("distcode").trim());
                jsonvillage.addProperty("talukcode", res.getString("talukcode").trim());
                jsonvillage.addProperty("villagecode", res.getString("villagecode").toString().trim());
                jsonvillage.addProperty("villagename", res.getString("name").toString().trim());
                villagelist.add(jsonvillage);
            }
            System.out.println("villagelist" + villagelist.size());
            close(con, ps, res);
        } catch (Exception e) {
            System.out.println("getservice Exception==>" + e);
        }
        return villagelist.toString();
    }

    private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myConn != null) {
                myConn.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myRs != null) {
                myRs.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
