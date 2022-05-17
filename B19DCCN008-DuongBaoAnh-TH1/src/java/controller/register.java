/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    private boolean exist(String username, String password) {
        try {
            FileReader f = new FileReader("C:\\Users\\DELL\\Documents\\NetBeansProjects\\B19DCCN008_DuongBaoAnh_TH1\\web\\WEB-INF\\login.txt");
            BufferedReader b = new BufferedReader(f);
            String s = "";
            while (true) {
                s = b.readLine();
                if (s == null || s.equals("")) {
                    break;
                }
                if (s.contains(username)) {
                    String inf = username + "/" + password;
                    if (s.equals(inf)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            f.close();
            b.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter pw = resp.getWriter();
        String inf = username + "/" + password;
        if (exist(username, password)) {
            pw.write("<h1 style ='color: red'>Already exist!!!!<h1>");
        } else {
            try {
                FileWriter f = new FileWriter("C:\\Users\\DELL\\Documents\\NetBeansProjects\\B19DCCN008-DuongBaoAnh-TH1\\web\\WEB-INF\\login.txt", true);
                BufferedWriter b = new BufferedWriter(f);
                String s = username + "/" + password;
                b.write(s);
                b.newLine();
                b.flush();
                f.close();
                b.close();
                System.out.println(s);
            } catch (IOException e) {
                System.out.println(e);
            }
            pw.write("<h1 style ='color: red'>Success!!!!</h1>");
        }
    }
}