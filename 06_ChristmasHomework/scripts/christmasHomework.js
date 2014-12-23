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
		newElement.text(post.title);
		list.append(newElement);
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
	};
	$("button#addbutton").click(checkForText);
});
