
package com.mycompany.practicasistemadisrtibuidov2.principal;

import com.mycompany.practicasistemadisrtibuidov2.entidades.Producto;
import com.mycompany.practicasistemadisrtibuidov2.session.ProductoJpaController;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TOMA LOS PARAMETROS ESTABLECIDOS DE LA CADENA DE CONEXION
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        //LA CLASE CONTROLADORA RECIBE DE PARAMETRO UNA CADENA DE CONEXION
        ProductoJpaController pjc = new ProductoJpaController(emf);
        //CREAMOS UN NUEVO PRODUCTO
        Producto p = new Producto();
        p.setCodigo(1);
        p.setNombre("Software CMS");
        Double dl = 5000.99;
        BigDecimal bd1 = BigDecimal.valueOf(dl);
        p.setPrecio(bd1);
        p.setDetalle("Gestion de productos");
        
        try{
            pjc.create(p);
        }catch (Exception ex){
            Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
