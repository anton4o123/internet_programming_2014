package org.elsysbg.ip.jsonplaceholder.service;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.elsysbg.ip.jsonplaceholder.model.Post;

public class PostsService {
	private final List<Post> posts = new LinkedList<Post>();
	private long lastPostId = 0;
	
	public List<Post> getPosts() {
		return posts;
	}
	public Post getPost(long postId) {
		for (Post next : posts) {
			if (next.getId() == postId) {
				return next;
			}
		}
		return null;
	}
	public synchronized Post createPost(Post post) {
		lastPostId++;
		
		post.setId(lastPostId);
		posts.add(post);
		return post;
	}
	public Post updatePost(long postId, Post post) {
		final Post fromDb = getPost(postId);
		
		fromDb.setTitle(post.getTitle());
		fromDb.setBody(post.getBody());
		return fromDb;
	}
	@DELETE
	@Path("/{postId}")
	public void deletePost(@PathParam("postId") long postId) {
		final Post toBeDeleted = getPost(postId);
		posts.remove(toBeDeleted);
	}
}