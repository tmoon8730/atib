package com.atib.twitter;

import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

public class AtibTwitter {
	
	private Twitter twitter;
	private User user;
	
	public AtibTwitter(){
		// Get Twitter instance with credentials stored in twitter4j.properties
		// The factory instance is both re-usable and thread safe
		twitter = new TwitterFactory().getInstance();
		try {
			// Instantiate a default user. Can throw errors if the credentials are not valid
			user = twitter.verifyCredentials();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	public String getTimeline(){
		List<Status> tweets = new ArrayList<Status>();
		try{
			// Get a list of the current timeline tweets
			tweets = twitter.getHomeTimeline();
			System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
			
		} catch (TwitterException te){
			te.printStackTrace();
		    System.out.println("Failed to get timeline: " + te.getMessage());
		}
		
		return stringFromList(tweets);
	}
	
	public String searchTweets(String searchTerm){
		Query query = new Query(searchTerm);
		List <Status> tweets = new ArrayList<Status>();
		try{
			QueryResult result;
			do {
				result = twitter.search(query);
				tweets = result.getTweets();
			}while ((query = result.nextQuery()) != null);
		}catch(TwitterException te){
			te.printStackTrace();
		}
		return stringFromList(tweets);
	}
	
	public String searchUser(String userName){
		int page = 1;
		ResponseList<User> users = null;
		try{
			do{
				users = twitter.searchUsers(userName, page);
				page++;
			}while (users.size() != 0 && page < 50);
			System.out.println("done");
		}catch(TwitterException te){
			te.printStackTrace();
			System.out.println("Failed to search users: " + te.getMessage());
		}
		return stringFromListUsers(users);
	}
	
	private String stringFromList(List<Status> statuses){
		// Collect data into a string to return
		StringBuilder strBldr = new StringBuilder();
		for(Status status: statuses){
			strBldr.append(status.getUser().getScreenName());     // Screen name of the user who posted the tweet
			strBldr.append(" - "); 								  // Delimiter
			strBldr.append(status.getText());                     // Contents of the tweet
			strBldr.append("\n");								  // Newline
		}
		// Return the String from the StringBuilder strBldr
		return strBldr.toString();
	}
	private String stringFromListUsers(List<User> users){
		// Collect data into a string to return
		StringBuilder strBldr = new StringBuilder();
		for(User status: users){
			strBldr.append(status.getScreenName());     // Screen name of the user who posted the tweet
			if(status.getStatus() != null){
				strBldr.append(" - "); 								  // Delimiter
				strBldr.append(status.getStatus().getText());     
			}else{
				// The users account is protected
				strBldr.append("protected");
			}
			// Contents of the tweet
			strBldr.append("\n");								  // Newline
		}
		// Return the String from the StringBuilder strBldr
		return strBldr.toString();
	}
}
