package com.mycompany.types;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/myendpoint")
public interface Myendpoint {
  /**
   */
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  PostMyendpointResponse postMyendpoint(MyPostRequest entity);

  class PostMyendpointResponse extends ResponseDelegate {
    private PostMyendpointResponse(Response response, Object entity) {
      super(response, entity);
    }

    private PostMyendpointResponse(Response response) {
      super(response);
    }

    public static PostMyendpointResponse respond200WithApplicationJson(MyPostResponse entity) {
      Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
      responseBuilder.entity(entity);
      return new PostMyendpointResponse(responseBuilder.build(), entity);
    }

    public static PostMyendpointResponse respond400WithApplicationJson(MyPostError entity) {
      Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "application/json");
      responseBuilder.entity(entity);
      return new PostMyendpointResponse(responseBuilder.build(), entity);
    }
  }
}
