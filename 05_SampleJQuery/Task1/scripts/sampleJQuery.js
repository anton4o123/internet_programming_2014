$(document).ready(function() {
	"use strict"

	var ell1 = $("#list1");
	var i = 3;

	$("#butt").click(function() {
		ell1.append("<li>item" + i + "</li>");
		i++;
	});
});