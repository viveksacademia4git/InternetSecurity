# Perform Man In The Middle (MITM) attach using Javascript

## Install yarn and dependencies through 'yarn' or 'npm'

I prefer yarn over npm, but npm can be used as well. Whenever you wish to execute the command just replace 'npm' with 'yarn'.

Install dependencies through yarn:  
`yarn install`

## Lite-Server

Upon executing `yarn install` command, it installs the `lite-server` package/library in the project (node_modules).

***Lite-Server*** as the name suggests is the very light web server with minimum execution facility, purely meant to display web pages.

## Configuration

***package.json*** consists of project management and tunning configuration. We have defined two lite-server for our purpose for attacker and victim. 


## Execute Hacker 'Lite-Server'

We have configured the project (in package.json) to execute the lite-server for the attacker using command `yarn run lite-server` using the `bs-config.json`.

