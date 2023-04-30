package cue.clothingjakarta.clothingjakarta.servlets;


import cue.clothingjakarta.clothingjakarta.model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


@WebServlet(name = "RegisterServlet", urlPatterns = "/register-client")
public class RegisterServlet extends HttpServlet  {
    ArrayList<Client> dBClients = new ArrayList<>();
    ModelFactoryServlet mfs = ModelFactoryServlet.getInstance();
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public RegisterServlet() {
       /* clientList.add( new Client("Monica","mtobon","123","@monica","Barrio lili"));
        clientList.add( new Client("Pepe","pepe23","234","@pepe", "Conjunto baru"));
        clientList.add( new Client("Juan","jrodriguez","345","@juan","Calle 13 carrea 10"));
        clientList.add( new Client("Andres","atorres2","456","@andres","km 10 via tebaida"));
*/
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //list boton
        //lista base de datos

       /* String driver = "com.mysql.cj.jdbc.Driver";
        String url ="jdbc:mysql://localhost:3306/clientes-register";
        String username = "root";
        String password = "0703";*/
        HttpSession session =request.getSession();
        try {
            mfs.service.getRepository().loadList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("dBClients",mfs.getService().getRepository().getProductoList());
        response.sendRedirect("listClient.jsp");


        //Lista anterior a mano
       /* HttpSession session = request.getSession();
        session.setAttribute("clientList",mfs.getService().getClientService().getClientList());
*/

    }

    //profe la verdad no se que estoy haciendo mal, pero cuando en el formulario ya no se presentan errores no se redirige hacia la pagina de productos si no
    //que se queda en el index (o sea en el formulario de registrar) y ya no se como mas hacer para que funcione.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //register boton

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        try {
            mfs.service.getRepository().guardar(new Client(null,name,username,password,confirm_password,email,address));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            mfs.getService().getClientService().messageRegister(name,username,password,confirm_password,email,address);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (mfs.getService().getClientService().getErrores().isEmpty()){

            resp.sendRedirect("/products.jsp");
        }else {

            HttpSession session = req.getSession();
            session.setAttribute("errores",mfs.getService().getClientService().getErrores());
            getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        /*HttpSession session = req.getSession();
        session.setAttribute("errores",errores);
        getServletContext().getRequestDispatcher("/products.jsp").forward(req,resp);
        resp.sendRedirect("products.jsp");*/

    }
}
