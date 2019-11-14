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
        this.tm.addUser("2", "Chema", "Alonso");
        this.tm.addUser("3", "Steve", "Jobs");
          }
    }

    @GET //OKEY
    @ApiOperation(value = "Obtener Objetos de un user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Obj.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{idObj}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("idObj") String id) {
        List<Obj> objetos = this.tm.consObj(id);
        if (objetos == null) return Response.status(404).build();
        else  return Response.status(201).entity(objetos).build();
    }

//    @POST  //OKEY
//    @ApiOperation(value = "Create a new User", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response=User.class),
//            @ApiResponse(code = 500, message = "Validation Error")
//
//    })
//
//    @Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response newTrack(User u) {
//
//        if (u.getNombre()==null || u.getIdUser()==null || u.getApellido() == null)  return Response.status(500).entity(u).build();
//        this.tm.addUser(u.getIdUser(),u.getNombre(),u.getApellido());
//        return Response.status(201).entity(u).build();
//    }



















//    @GET
//    @ApiOperation(value = "Obtener Objetos User", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Obj.class),
//            @ApiResponse(code = 404, message = "User not found")
//    })
//    @Path("/{idObj}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getObj(@PathParam("idObj") String id) {
//        List<Obj> objetos = this.tm.consObj(id);
//
//        GenericEntity<List<Obj>> entity1 = new GenericEntity<List<Obj>>(objetos) {
//        };
//        return Response.status(201).entity(entity1).build();
//
//    }
//    @POST
//    @ApiOperation(value = "Insertar un nuevo Objeto", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response=Obj.class),
//            @ApiResponse(code = 500, message = "Validation Error")
//
//    })
//    @Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response newObj(Obj obj,String id1) {
//        this.tm.addObject(id1,obj.getIdObj(),obj.getTipo());
//        return Response.status(201).entity(obj).build();
//    }





}
