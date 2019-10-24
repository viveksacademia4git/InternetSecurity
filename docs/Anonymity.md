
# Anonymity
Anonymity is being anonymous on the internet concealing the identity of a person or a system to promote privacy. Anonymity is essential for a being to avoid becoming a target of activity such as marketing (which create biasness by changing the outlook or perception that might further result into a successful campaign that can be, misleading or propaganda) and persevere freedom. There are various ways to exploit and preserve anonymity. Anonymous communication over the internet can be achieved through TOR or VPN.



## TOR
Tor is free and open-source software that establishes anonymous communication over the internet. TOR hides users' location and usage through 'The Onion Router' making it difficult to perform traffic analysis or network surveillance[1]. In order for TOR to work, volunteers are required to be part of the overlay network. This kind of setup makes it difficult to keep a track of internet footprints achieving confidentiality and freedom from being monitored.



## VPN
Virtual Private Network or VPN provides a private network across a public network making it possible to communicate on the public network in an encapsulated manner. To enable VPN on a device it is required to have authenticated access of the private network through VPN service providers[2]. Since the connection is encrypted through the VPN, therefore, no one can intercept, monitor, or alter the communication except the point of origin and the endpoint of the VPN tunnel. Companies provide a VPN tunnel for its employees for the purpose of security and accessibility of the organization's internal network.



## Difference Between TOR and VPN Tools

|               | TOR           | VPN   |
|:-------------:|:-------------:| -----:|
| Concept | Onion Network | Virtual Private Network |
| Implementation | TOR browser and TOR network  | VPN Services like **IPredator** |
| Encryption      |  Encryption of data underneath layers of encryption using the randomly selected Tor relays      |   Encryption at the level of VPN Tunnel  [2][3] |
| Networking      | Bounces the connection across multiple proxy & relay connections between the starting point and the end point[1].      |   VPN Tunnel provides a connection through the secure protocol to the VPN service’s gateway |
| Snooping | Prevented      | Prevented |
| Performance | Slow (Due to layers of encryption and decryption)      | Fast (Due to abstraction through the private network) |
| Exploits | Javascript and Plugins, Exit Node in TOR, Cookies (read below live example)   | WAP, Bait, Cookie Theft |


## Exploits

#### Javascript and Plugins (TOR)
The browser comes with the JavaScript engine and plugin execution capability by default. Javascript and plugins like Adobe Flash can be used to leak the IP address through a web-page (that has capability to acquire IP address)

#### Exit Node in TOR
Volunteers vouch for running relays. Tor relay is used to pass the network traffic back and forth in an encrypted way within the TOR network. Traffic coming out of the exit relay can be used to trace the IP Address running the exit node. There is no problem if everything is ethical but it can be harmful if the TOR network is used for conducting illicit activity

#### WAP (VPN)
This techniques uses the fake wireless network. Setting up the router in a public space and creating an open connection. Devices connected to this network are vulnerable because the private information can be stolen by hackers by injecting malware

#### Bait (VPN)
There are lot of ads on the webpages over the internet. A malicious website can inject malware that performs online tracking, there are many live examples among my friend who experience that, another webpage opens even when they click on Google or Wikipedia. This technique is called 'bait and switch'


#### Cookie Theft (TOR and VPN)
The cookies are stored by the browser through websites for identification and performance. Stealing cookie information can reveal a lot information that can be used later to compromise the security.

**Cookies Example >>> One of the main entity responsible for running 'silk road (marketplace)' was traced through a cookie, after many of hiding and precautions**



--------------------------------------------


## References

1. “Tor (Anonymity Network).” Wikipedia. Wikimedia Foundation, October 12, 2019. https://en.wikipedia.org/wiki/Tor_(anonymity_network).

2. “Virtual Private Network.” Wikipedia. Wikimedia Foundation, October 23, 2019. https://en.wikipedia.org/wiki/Virtual_private_network.

4. “What's the Difference between VPN and TOR?” Quora. Accessed October 23, 2019. https://www.quora.com/Whats-the-difference-between-VPN-and-TOR.

