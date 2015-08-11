package org.riva.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.riva.rest.messenger.database.Database;
import org.riva.rest.messenger.model.profile;

public class ProfileService {
	
private Map<String,profile> profiles = Database.getProfiles();

	public ProfileService(){
		profiles.put("asr",new profile(1L,"amit","singh","rajawat"));
		profiles.put("lrs",new profile(2L, "love","roze","sandhu"));
	}
	
	public List<profile> getAllProfiles(){
		return new ArrayList<profile>(profiles.values());
	}
	
	public profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	public profile addProfile(profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}
	public profile updateProfile(profile profile){
		if(profile.getId() <= 0){
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
			
	}
	public profile deleteProfile(String profileName){
		return profiles.remove(profileName);
	}

}
