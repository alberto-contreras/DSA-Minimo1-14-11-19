//import edu.upc.dsa.GestorProductos;
//import edu.upc.dsa.GestorProductosImpl;
//import edu.upc.dsa.Pedido;
//import edu.upc.dsa.Usuario;
import edu.upc.dsa.EmptyUserList;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class GameManagerTest {

   GameManagerImpl gestor ;

    @Before
    public void setUp() {
        this.gestor = GameManagerImpl.getInstance();
    }
    @After
    public void tearDown(){
        gestor.liberar();
    }
    @Test
    public void verifUser(){
        gestor.addUser("1","Alberto","Contreras");
        gestor.modifUser("1","Alb","Con");
        Assert.assertEquals("Num users en el sistema",1, gestor.numUsers());
        User u = gestor.consUser("1");
        Assert.assertEquals("User consultado correctamente","Alb", u.getNombre());
        gestor.addUser("2","Marcos","Perez");
        Assert.assertEquals("Users",2, gestor.usersOrdAlf().size());
    }
    @Test
    public void verifUserObj() {
        gestor.addUser("1","Alberto","Contreras");
        Assert.assertEquals("Num users en el sistema",1, gestor.numUsers());
        User u = gestor.consUser("1");
        gestor.addObject("1","1","Espada");
        gestor.addObject("1","2","Corona");
        Assert.assertEquals("User obj size",2, gestor.consObj("1").size());
    }
}
