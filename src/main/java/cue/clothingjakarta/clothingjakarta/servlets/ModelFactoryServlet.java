package cue.clothingjakarta.clothingjakarta.servlets;

import cue.clothingjakarta.clothingjakarta.service.impl.SingletonServiceImpl;

import java.sql.SQLException;

public class ModelFactoryServlet {
    SingletonServiceImpl service;

    public SingletonServiceImpl getService() {return service;}
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aquí al ser protected
        private final static ModelFactoryServlet eINSTANCE;

        static {
            try {
                eINSTANCE = new ModelFactoryServlet();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryServlet getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryServlet() throws SQLException, ClassNotFoundException {
        System.out.println("invocación clase singleton");
        service = new SingletonServiceImpl();

    }


}
