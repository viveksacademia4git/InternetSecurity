
# Protection of Public-Facing Interfaces

- It is very essential to protect public-facing interfaces from outside(untrusted and public). Having an interface in the open view makes them a clear target and susceptible to malicious attacks.
- The ways through which they can be encapsulated from being in open are:
    - Set incoming NAT rules for the IP addresses. Create NAT rules to forward the traffic into your network.
    - A firewall implementation separates the trusted traffic and untrusted traffic. Proper firewall implementation creates two basic security zones, known as inside and outside.
    - Allow only application or application units within the network to have direct contact with these interfaces.
    - For administration purpose provide another secured interface or VPN with strict rights.
    - It may be possible that the Public Facing Interfaces can be exploited indirectly through the authorized application or application unit which in result might release the information that can be malicious for attackers, therefore, it is essential to have the 'unit tests' and component vulnerability test.
