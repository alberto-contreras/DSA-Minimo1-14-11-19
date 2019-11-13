package edu.upc.dsa.services;
//
//import edu.upc.dsa.GestorProductos;
//import edu.upc.dsa.GestorProductosImpl;
//import edu.upc.dsa.Pedido;
//import edu.upc.dsa.Producto;
//import edu.upc.dsa.Usuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Api(value = "/x", description = "Endpoint to X Service")
@Path("/x")
public class xService {
//    private GestorProductos tm;
//
//    public BarService() {
//        this.tm = GestorProductosImpl.getInstance();
//       if(this.tm.size()==0){   //PARA NO TENER PROBLEMAS SI HAY SINGLETONE
//        this.tm.addProducto("1", "Coca-Cola", 1);
//        this.tm.addProducto("2", "Fanta", 2);
//        this.tm.addProducto("3", "Caña", 4);
//          }
//    }
//
//
//    @GET
//    @ApiOperation(value = "dona m tots els productes", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer = "List"),
//    })
//    @Path("/")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getProductos() {
//
//        List<Producto> productos = this.tm.productosOrdPrecio();
//
//        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(productos) {
//        };
//        return Response.status(201).entity(entity).build();
//
//    }
}
