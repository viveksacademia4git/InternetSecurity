# Conduct SQL Injection on Altoro Mutual

## Use a SQL-Injection to log in as admin user

First we will check whether or not SQL Injection is possible. We have used the following credentials to login.
 - Username: ' or 1=1 --
 - Password: 1234  
<div style="text-align: right"> ...Input 1 </div>
Lets assume that the query executed on the server is something similar to
```
SELECT * FROM [some_users_table] WHERE username='[input_username]' AND password='[input_password]';
```
<div style="text-align: right"> ...Query 1 </div>

Now after we send credentials to the server, through the login process, the assummed query formed on the server's web application might be:
```
SELECT * FROM [some_users_table] WHERE username='' OR 1=1 -- AND password='[input_password]';
```
<div style="text-align: right"> ...Query 2 </div>

The result (output of SQL query exection) of the manipulated Query 2, through SQL Injection, will return the list (rows) of all the users. From these respective records, one of the record (probabily the first record) is picked up the application's code section, for user authentication, to provide free passage within the application.