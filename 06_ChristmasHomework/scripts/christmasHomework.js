$(document).ready(function() {
	"use strict"
	console.log($(".tu").attr("title"));
	console.log($("#col1 p").text());

	$("#menu-top-level-menu").append($("<li/>").append($("<a/>").text("new button")));
	$("div#footer").prepend($("<div/>").attr("id", "dynamiccontent"));
	$("div#dynamiccontent").append($("<input/>").attr("id", "textinput"));
	$("div#dynamiccontent").append($("<button/>").attr("id", "addbutton"));
	$("div#dynamiccontent").append($("<ul/>").attr("id", "posts"));

	$("#menu-top-level-menu li a").last().click(function() {
		alert("hello world");
		$("#col2").insertBefore($("#col1"));
	});

	function handleError(error) {
		console.error("error", error, arguments);
	}
	function appendToList(list, post) {
		var newElement = $("<li/>");
		var newButton = $("<button/>");

		newElement.text(post.title);
		newButton.text("X");

		newButton.click(function() {
			if(confirm("deleting")) {
				$.ajax({
					url: "http://jsonplaceholder.typicode.com/posts/" + post.id,
					type: "DELETE",
					success: function() {
						$(".post-" + post.id).remove();
					}
				});
			}
		});

		newElement.attr("class", "post-" + post.id);
		newButton.attr("class", "post-" + post.id);
		list.append(newElement.add(newButton));
	}
	function processResponse(response) {
		var list = $("ul#posts");
		var i = 0;

		$.each(response, function() {
			appendToList(list, this);
			if(++i >= 5) {
				return false;
			}
		});
	}
	$.ajax("http://jsonplaceholder.typicode.com/posts", {
		method: "GET"
	}).then(processResponse, handleError);

	var checkForText = function() {
		var name = $("input#textinput").val();
		
		if(!name) {
			alert("you must enter text");
			return;
		}
		$("input#textinput").val("");
		$.post("http://jsonplaceholder.typicode.com/posts", {
			userId: 1,
			title: name,
			body: ''
		}).then(function(data) {
			$.ajax("http://jsonplaceholder.typicode.com/posts/" + data.id, {
				method: "GET"
			}).then(function(data) {
				appendToList($("#posts"), data);
			});
		});
	};
	$("button#addbutton").click(checkForText);

	var processNewResponse = function(response) {
		$.each(response, function() {
			appendToList($("ul#posts"), this);
		});
	};

	$("#posts").before($("<input/>").attr("id", "specialInput"));
	$("#specialInput").change(function() {
		var input = $("#specialInput").val();

		$("ul#posts li").remove();
		$("ul#posts button").remove();
		$.ajax("http://jsonplaceholder.typicode.com/posts?userId=" + input, {
			method: "GET"
		}).then(processNewResponse, handleError);
	});
});
