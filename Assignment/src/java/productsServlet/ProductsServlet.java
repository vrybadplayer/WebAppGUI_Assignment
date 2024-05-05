package productsServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import domain.CartOrders;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ProductsServlet", urlPatterns = {"/ProductsServlet"})
public class ProductsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductsServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //@PersistenceContext
    private EntityManager entityManager;

    //@Resource
    private UserTransaction utx;

    //This is to put data into table once user clicked add to cart button
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Begin a new transaction
            utx.begin();

            int CustID = Integer.parseInt(request.getParameter("custId"));
            int ProdID = Integer.parseInt(request.getParameter("prodId"));

            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Define the date formatter for the desired format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Format the current date using the formatter
            String date = currentDate.format(formatter);

            // Perform the database operation
            CartOrders cartOrder = new CartOrders();
            cartOrder.setProdId(CartOrders.NextHKPK());
            cartOrder.setCustId(CustID);
            cartOrder.setProdId(ProdID);
            cartOrder.setDate(date);
            entityManager.persist(cartOrder);

            // Commit the transaction
            utx.commit();

            // Redirect back to JSP
            response.sendRedirect("Products2.jsp?picNo="+Integer.parseInt(request.getParameter("picNo"))+"&category="+request.getParameter("category")+"&prodId="+ProdID);
            
        } catch (Exception e) {
            // Handle any exceptions
            try {
                // Rollback the transaction if an error occurs
                utx.rollback();
            } catch (Exception rollbackEx) {
                // Log or handle the rollback exception
            }

            // Forward to an error page or display an error message
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error occurred while processing the request.");
        }

//        //param get to get custid and prodid from jsp, then pass into fucntion
//
//        int CustID = Integer.parseInt(request.getParameter("custId"));
//        int ProdID = Integer.parseInt(request.getParameter("prodId"));
//        
//        // Get the current date
//        LocalDate currentDate = LocalDate.now();
//        
//        // Define the date formatter for the desired format
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        
//        // Format the current date using the formatter
//        String date = currentDate.format(formatter);
//        
//        CartOrders.AddToCart(CartOrders.NextHKPK(), CustID, ProdID, date);
//        
//        //redirect back to jsp
//        //Also think of a way to pop-up display that customer added to cart
//        response.sendRedirect("Products2.jsp?picNo="+Integer.parseInt(request.getParameter("picNo"))+"&category="+request.getParameter("category")+"&prodId="+ProdID);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
