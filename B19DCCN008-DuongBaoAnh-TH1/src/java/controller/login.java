/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet{
    private boolean exist(String inf) {
        try {
            FileReader f = new FileReader("C:\\Users\\DELL\\Documents\\NetBeansProjects\\B19DCCN008-DuongBaoAnh-TH1\\web\\WEB-INF\\login.txt");
            BufferedReader b = new BufferedReader(f);
            String s = "";
            while (true) {
                s = b.readLine();
                if (s == null || s.equals("")) {
                    break;
                }
                if (s.equals(inf)) {
                    return false;
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
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        PrintWriter pw = resp.getWriter();
        String inf = username + "/" + password;
        if (!exist(inf)) {
            pw.write("<h1 style ='color: red;margin-left: 40px'>Welcome</h1>\n"
                    + "            <p style = 'color:  blue'>Username: " + username + "</p>"
                    + "            <p style = 'color:  blue'>Current Date: " + ft.format(date) + "</p>"
                    + "            <p style = 'color:  blue'>IP Address: " + InetAddress.getLocalHost().getHostAddress() + "</p>"
                    + "          "
                    + "");

        } else {
            pw.write("<h1 style ='color: red'>Invalid!!!</h1>");
        }
    }
}
