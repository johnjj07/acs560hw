window.onload = function() {
	var para = document.createElement("p");
	var helloDiv = document.getElementById("hello");
	helloDiv.appendChild(para);
	var message = document.createTextNode("Hello ACS560!");
	para.appendChild(message);
}
