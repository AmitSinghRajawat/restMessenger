package org.riva.rest.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.riva.rest.messenger.model.message;
import org.riva.rest.messenger.model.profile;

public class Database {
	
	private static Map<Long, message> messages = new HashMap<>();
	private static Map<String, profile> profiles = new HashMap<>();
	
	public static Map<Long, message> getMessages(){
		return messages;
	}
	
	public static Map<String, profile> getProfiles(){
		return profiles;
	}

}
