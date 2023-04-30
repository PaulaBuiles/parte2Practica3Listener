package cue.clothingjakarta.clothingjakarta.servlets;

import cue.clothingjakarta.clothingjakarta.model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "EditarServlet", urlPatterns = "/editar-BD")
public class EditarServlet extends HttpServlet {

    ModelFactoryServlet mfc = ModelFactoryServlet.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String accion = req.getParameter("operation");

        if (accion.equals("buscar")) {
            try {
                if (mfc.service.getRepository().byId(id) != null){
                    System.out.println(mfc.service.getRepository().byId(id).getName());
                    resp.setContentType("text/html");
                    try(PrintWriter out = resp.getWriter()){
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Resultado</title>");
                        out.println("<style>");
                        out.println(".rectangulo {\n" +
                                "  background-color: #f7f7f7;\n" +
                                "  color: #333;\n" +
                                "  width: 80%;\n" +
                                "  max-width: 600px;\n" +
                                "  margin: 50px auto;\n" +
                                "  border: 1px solid #ddd;\n" +
                                "  padding: 20px;\n" +
                                "  font-size: 18px;\n" +
                                "  font-family: Arial, sans-serif;\n" +
                                "  text-align: center;\n" +
                                "}");
                        out.println("</style>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<div class=\"rectangulo\">");
                        out.println(" Se encontró con éxito según el ID el Cliente " + mfc.service.getRepository().byId(id).getName());
                        out.println("</div>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }else {
                    PrintWriter out = resp.getWriter();
                    System.out.println("No se encontro el cliente con este ID");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Resultado</title>");
                    out.println("<style>");
                    out.println(".rectangulo {\n" +
                            "  background-color: #f7f7f7;\n" +
                            "  color: #333;\n" +
                            "  width: 80%;\n" +
                            "  max-width: 600px;\n" +
                            "  margin: 50px auto;\n" +
                            "  border: 1px solid #ddd;\n" +
                            "  padding: 20px;\n" +
                            "  font-size: 18px;\n" +
                            "  font-family: Arial, sans-serif;\n" +
                            "  text-align: center;\n" +
                            "}");
                    out.println("</style>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div class=\"rectangulo\">");
                    out.println("No se encontro a ningun cliente con ese id");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (accion.equals("eliminar")) {
            try {
                if (mfc.service.getRepository().byId(id)!= null){
                    Client client = mfc.service.getRepository().byId(id);
                    System.out.println(client.getName());
                    mfc.service.getRepository().eliminar(id);
                    resp.setContentType("text/html");
                    try(PrintWriter out = resp.getWriter()){
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Resultado</title>");
                        out.println("<style>");
                        out.println(".rectangulo {\n" +
                                "  background-color: #f7f7f7;\n" +
                                "  color: #333;\n" +
                                "  width: 80%;\n" +
                                "  max-width: 600px;\n" +
                                "  margin: 50px auto;\n" +
                                "  border: 1px solid #ddd;\n" +
                                "  padding: 20px;\n" +
                                "  font-size: 18px;\n" +
                                "  font-family: Arial, sans-serif;\n" +
                                "  text-align: center;\n" +
                                "}");
                        out.println("</style>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<div class=\"rectangulo\">");
                        out.println("  Se encontró y se elimino el cliente"+ client.getName() +" según su id ");
                        out.println("</div>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }else {
                    System.out.println("No se pudo eliminar dado que no se encontro el cliente con ese ID");
                    PrintWriter out = resp.getWriter();
                    System.out.println("No se encontro el cliente con este ID");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Resultado</title>");
                    out.println("<style>");
                    out.println(".rectangulo {\n" +
                            "  background-color: #f7f7f7;\n" +
                            "  color: #333;\n" +
                            "  width: 80%;\n" +
                            "  max-width: 600px;\n" +
                            "  margin: 50px auto;\n" +
                            "  border: 1px solid #ddd;\n" +
                            "  padding: 20px;\n" +
                            "  font-size: 18px;\n" +
                            "  font-family: Arial, sans-serif;\n" +
                            "  text-align: center;\n" +
                            "}");
                    out.println("</style>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div class=\"rectangulo\">");
                    out.println("No se pudo eliminar dado que no se encontro el cliente con ese ID");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
