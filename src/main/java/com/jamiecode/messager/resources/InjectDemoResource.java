package com.jamiecode.messager.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	//To continue, start the tutorials from webservices 23 The Param annotations
	/*NEXT:
	 * 	24 USING CONTEXT AND BEANPARAM ANNOTATIONS
	 * 25 IMPLEMENTING SUBRESOURCES
	 * 26 SENDING STATUS CODES AND LOCATION HEADERS
	 * 27 HANDLING EXCEPTIONS
	 * 28 USING WEBAPPLICAITONEXCEPTION
	 * 29	 HOTEOAS part 1
	 * 30 HOTEOAS part 2
	 * 31 CONTENT NEGOTIATION*/
	
	@GET
	@Path("annotations")
		//using matrix params, its a way to send parameters and url
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixparam) {
		return "Matrix param: " + matrixparam;
	}

}
