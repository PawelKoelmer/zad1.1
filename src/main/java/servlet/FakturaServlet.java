package servlet;

import capitals.Lowering;
import capitals.Static;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;


@WebServlet("/credit")
public class FakturaServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        float kwotaKredytu = Float.parseFloat(request.getParameter("loanAmountRequested"));
        int iloscRat = Integer.parseInt(request.getParameter("numberOfInstallments"));
        float odsetki = Float.parseFloat(request.getParameter("interest"));
        float oplataStala = Float.parseFloat(request.getParameter("fixedFee"));
        String type = request.getParameter("typeofInstallments");
        String tabelaOutput = null;
        String tabela=null;
        java.text.DecimalFormat df = new java.text.DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        if ((Float.toString(kwotaKredytu) == null || kwotaKredytu == 0)
                || (Integer.toString(iloscRat) == null || iloscRat == 0)
                || (Float.toString(odsetki) == null)
                || (Float.toString(oplataStala) == null)
                || type == null) {
            try {
                response.sendRedirect("localhost:8080");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            tabela="<table border=\"2\">" +
                    "<tr>" +
                    "<td>nr raty</td>" +
                    "<td>kwota kapitalu</td>" +
                    "<td>kwota odsetek</td>" +
                    "<td>Oplaty Stale</td>" +
                    "<td>Calkowita rata</td>" +
                    "</tr>";

            if (type.equals("lowering")) {
                Lowering lowering = new Lowering(kwotaKredytu, oplataStala, odsetki, iloscRat);
                for (int i = 1; i <= iloscRat * 12; i++) {
                    tabelaOutput=tabelaOutput + "<tr>" +
                            "<td>" + i + "</td>" +
                            "<td>" + df.format(lowering.getCapitalAmount()) + "</td>" +
                            "<td>" + df.format(lowering.getInterestAmount(i)) + "</td>" +
                            "<td>" + df.format(lowering.oplataStala) + "</td>" +
                            "<td>" + df.format(lowering.getKwotaRaty()) + "</td>" +
                            "</tr>";
                }
            } else if (type.equals("static")) {

                Static staticCapital = new Static(kwotaKredytu, oplataStala, odsetki, iloscRat);
                staticCapital.getStalaOdsetkowa();
                staticCapital.getWysokoscRaty();
                for (int i = 1; i <= iloscRat * 12; i++) {
                    staticCapital.setNrRaty(i);
                    staticCapital.obliczenia();
                    tabelaOutput= tabelaOutput +"<tr>" +
                            "<td>" + i + "</td>" +
                            "<td>" + df.format(staticCapital.getKwotaKapitalu()) + "</td>" +
                            "<td>" + df.format(staticCapital.getKwotaOdsetek()) + "</td>" +
                            "<td>" + df.format(staticCapital.oplataStala) + "</td>" +
                            "<td>" + df.format(staticCapital.getKwotaRaty()) + "</td>" +
                            "</tr>";

                }
                response.getWriter().print(tabela+tabelaOutput+"</table>");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            String k = tabela + tabelaOutput + "</table>";
//
//            Document document = new Document();
//            PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
//            document.open();
//            InputStream is = new ByteArrayInputStream(k.getBytes());
//            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
//            document.close();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

    }
}




