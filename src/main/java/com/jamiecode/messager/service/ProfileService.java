package com.jamiecode.messager.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import com.jamiecode.messager.database.DatabaseClass;
import com.jamiecode.messager.model.Profile;

public class ProfileService {

	private Map<String , Profile>   profiles = DatabaseClass.getAllProfiles();
	
	public ProfileService() {
		profiles.put("Jamiecode", new Profile(1L,"Jamiecode", "James","Mutura"));
		//profiles.put("Qween", new Profile(2L,"Qween","Millicent", "Kiruri"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProifile(String profileName) {
		return profiles.remove(profileName);
	}
	
}
