
# Protection of Public-Facing Interfaces

It is very essential to protect public-facing interfaces from outside(untrusted and public zone). Network in an open view makes them a clear target and susceptible to malicious attacks. Public facing interface is interface towards the public internet connecting to the ISP.

- A firewall implementation provides security and contains the Public Facing Interface that separates the trusted traffic and untrusted traffic. Proper firewall implementation creates two basic security zones, known as inside and outside.
- Set incoming NAT rules for the IP addresses if there is no Public Facing Interface. Create NAT rules to forward the traffic into your network.
- Allow only applications or application units within the network to have direct contact with these interfaces.
- For administration purpose provide another secured interface or VPN with strict rights.
- It may be possible that the Public Facing Interfaces can be exploited indirectly through the authorized applications by revealing information that can be malicious, therefore, it is essential to have the 'unit tests' and application vulnerability test.
