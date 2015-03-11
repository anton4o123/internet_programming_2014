package org.elsysbg.ip.jsonplaceholder;

import org.elsysbg.ip.jsonplaceholder.service.PostsService;

public class Services {
	private static PostsService postsService;
	
	public synchronized static PostsService getPostService() {
		if (postsService == null) {
			postsService = new PostsService();
		}
		return postsService;
	}
	
	static void setPostsService(PostsService postsService) {
		Services.postsService = postsService;
	}
}