package edu.upc.dsa.services;
import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.Obj;
import edu.upc.dsa.User;
import edu.upc.dsa.EmptyUserList;
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


@Api(value = "/juego", description = "Endpoint to Juego Service")
@Path("/juego")
public class JuegoService {
    private GameManagerImpl tm;

    public JuegoService() throws EmptyUserList {
        this.tm = GameManagerImpl.getInstance();
       if(this.tm.usersOrdAlf().size()==0){   //PARA NO TENER PROBLEMAS SI HAY SINGLETONE
        this.tm.addUser("1", "Alberto", "Contreras");
        this.tm.addUser("2", "Chema", "Alonso");
        this.tm.addUser("3", "Steve", "Jobs");
        this.tm.addObject("1","1","Espada");
        this.tm.addObject("1","2","Escudo");
          }
    }


    @GET //OKEY Obten todos users sistemas
    @ApiOperation(value = "Obtener usuarios del sistema ordenados alfabeticamente", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<User> usuarios = this.tm.usersOrdAlf();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(usuarios) {
        };
        return Response.status(201).entity(entity).build();

    }

    @GET //OKEY Obtiene datos User
    @ApiOperation(value = "Obtener User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("idUser") String id) {
        User t = this.tm.consUser(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @POST  //OKEY Crea nuevo User
    @ApiOperation(value = "Create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(User u) {

        if (u.getNombre()==null || u.getIdUser()==null || u.getApellido() == null)  return Response.status(500).entity(u).build();
        this.tm.addUser(u.getIdUser(),u.getNombre(),u.getApellido());
        return Response.status(201).entity(u).build();
    }
    @PUT //OKEY Modifica un user
    @ApiOperation(value = "Update a User (WARNING don't modifie the id)", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateUser(@QueryParam("idUse")  String idUse ,User u) {

        User t = this.tm.modifUser(idUse,u.getNombre(),u.getApellido());

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }





}
