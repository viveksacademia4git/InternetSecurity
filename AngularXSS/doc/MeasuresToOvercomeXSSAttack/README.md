# Measure to Overcome the XSS

In order to Overcome the XSS following checks can adhered for the safety.

## Check Incoming Request Source

The web applications specially the login (login page and authentication) must always verify for the incoming http request, for e.g. URL check. If there any such outlier request source initiater discovered by the web-server, there can be alert mechanism placed to notify the authentic user of any such event (like Google has such kind of mechanism).

## Parameter Check

If the value of the parameter is being posted directly on the web-page, by the web application, it should be made sure that the parameters are sanitized. The sanitization can be further subdivided according the input type of the value such: 
- Alphabet
- Number
- Alphabet and Number
- Email
- Phone Number
- Plain Text (Take extra precautions)


## Sanitization Libraries

There are many open source Sanitization libraries available to perform the Sanitization of input values. Many organization prefer have their own Sanitization libraries, or may be to customize the public Sanitization library.

Custom Sanitization is nothing but having extra sanitization on top of any sanitization library or modify existing public sanitization function from the library according to desired flavour. 


## Refer OWASP

In case if user is unware about the details and implementation tips about any vulnerability, they can always refer to the [OWASP documentation](https://cheatsheetseries.owasp.org/cheatsheets/Cross_Site_Scripting_Prevention_Cheat_Sheet.html) carefully for discovery and prevention
