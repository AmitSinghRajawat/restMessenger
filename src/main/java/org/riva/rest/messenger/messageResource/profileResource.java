package org.riva.rest.messenger.messageResource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.riva.rest.messenger.service.ProfileService;
import org.riva.rest.messenger.model.profile;

@Path("/profiles")
public class profileResource {
	
	ProfileService pService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<profile> getAllProfiles(){
		return pService.getAllProfiles();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public profile getProfile(@PathParam("profileName") String profileName){
		return pService.getProfile(profileName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public profile addProfile(profile profile){
		return pService.addProfile(profile);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public profile updateProfile(@PathParam("profileName") String profileName,profile profile){
		profile.setProfileName(profileName);
		return pService.updateProfile(profile);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public void deleteMessages(@PathParam("profileName") String profileName){
		pService.deleteProfile(profileName);
	}

}
