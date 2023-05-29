
package controlador;


import controlador.EjecutaSQL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IvanL
 */
@WebServlet("/Conector")
public class Conector extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String usuario=request.getParameter("usu");
        String password=request.getParameter("pas");
        
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<body>");

        out.println("</br>");
        

       ResultSet rs=EjecutaSQL.devuelveRS("Select * from seguridad "
               + "where usuario='"+usuario+"' and password='"+password+"';","root", "1234", 
                "jdbc:mysql://localhost:3306/bd_exa_mf0490");
       
        try {
            rs.next();
            if (rs.getRow()==1)
            
               out.println("Bienvenid@ "+usuario +". Gracias por utilizar nuestros servicios");
            
            else
                out.println("Usuario o Password incorrecto");
            
           
             out.println("</body>");
             out.println("</html>");
            
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
