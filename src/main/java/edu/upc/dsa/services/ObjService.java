package edu.upc.dsa.services;

import edu.upc.dsa.EmptyUserList;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.User;
import edu.upc.dsa.Obj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Api(value = "/obj", description = "Endpoint to Juego Service")
@Path("/obj")
public class ObjService {
    private GameManagerImpl tm;

    public ObjService() throws EmptyUserList {
        this.tm = GameManagerImpl.getInstance();
       if(this.tm.usersOrdAlf().size()==0){   //PARA NO TENER PROBLEMAS SI HAY SINGLETONE
        this.tm.addUser("1", "Alberto", "Contreras");
        this.tm.addObject("1","1","Espada");
        this.tm.addObject("1","2","Escudo");
        this.tm.addUser("2", "Chema", "Alonso");
        this.tm.addUser("3", "Steve", "Jobs");
          }
    }

    @GET //OKEY Lista Objetos Usuario
    @ApiOperation(value = "Obtener objetos de un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Obj.class, responseContainer = "List"),
    })
    @Path("/{idUser}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjbyID(@PathParam("idUser") String id1) {

        List<Obj> objetos = this.tm.consObj(id1);

        GenericEntity<List<Obj>> entity1 = new GenericEntity<List<Obj>>(objetos) {
        };
        return Response.status(201).entity(entity1).build();

    }

    @POST //OKEY Añadir nuevo Objeto a un usuario
    @ApiOperation(value = "Create a new Object and add to user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Obj.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObj( @QueryParam("idUsuario")  String idUsuario ,Obj c) {

        if (idUsuario==null || c.getIdObj()==null || c.getTipo() == null)  return Response.status(500).entity(c).build();
        this.tm.addObject(idUsuario,c.getIdObj(),c.getTipo());
        return Response.status(201).entity(c).build();
    }



}
