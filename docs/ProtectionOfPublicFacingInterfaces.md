
# Protection of Public-Facing Interfaces

## Public-Facing Interfaces

- The software can be of different types, it could be a single unit working independently or it could be a combination of different units. When the multiple units involved in the entire software or an application, these units are assigned with an individual task and in order to provide a service these units require a point to interact with each. This point is called the public interface[1].
- The multiple units working together must individually be stable, robust, updated and adaptable for changes in the future.
- There are various guidelines while developing public interfaces such:
    - Through planning with a proper procedure and architecture design.
    - Adhere standards for: coding, good documentation with the plan for software release and deprecating obsolete interfaces (or sections), insulation of classes and compile-time dependencies 
- In order to have a good interface best practise must be always exercised throughout the development phase and the support phase.
- For information related to example using c++ interface go to following link [https://en.wikipedia.org/wiki/Public_interface#Examples](https://en.wikipedia.org/wiki/Public_interface#Examples)[1].
- From the development perspective, hide the implementation and provide the explicit implementation of the interface. Abstraction in Java can be viewed as an example of the stated scenario[2][3].


## Protection
- We are clear till now, what are public-facing interfaces and how important they are! Therefore, it is very essential to protect them from public view. Having an interface in the open view makes them a clear target and susceptible to malicious attacks.
- The ways through which they can be encapsulated from being in open are:
    - Hide them behind the company or organization network.
    - Allow only application or application units to have contact with these interfaces.
    - Allow people to connect them from within LAN. For administration purpose provide another secured interface or VPN with strict rights[4].
    - It may be possible that the Public Facing Interfaces can be exploited indirectly through the authorized application or application unit which in result might release the information that can be malicious for attackers, therefore, it is essential to have the unit tests and component vulnerability test.


## References

1. “Public Interface.” Wikipedia. Wikimedia Foundation, January 4, 2016. https://en.wikipedia.org/wiki/Public_interface.
2. Dotnet. “Hide Interface Members of Derived Interface (on Interface Level) · Issue #1163 · Dotnet/Csharplang.” GitHub. Accessed October 23, 2019. https://github.com/dotnet/csharplang/issues/1163.
3. nannan 9, Jaroslav JandekJaroslav Jandek 8, JonathanJonathan 10k44 gold badges4848 silver badges8484 bronze badges, harpoharpo 31.3k1313 gold badges8484 silver badges123123 bronze badges, JanJan 6, mgronbermgronber 3, DypplDyppl 9, and Manish BasantaniManish Basantani 8. “How to Hide Some Members of an Interface.” Stack Overflow, June 1, 1961. https://stackoverflow.com/questions/5284750/how-to-hide-some-members-of-an-interface.
4. Wills, Mike WillsMike. “Should the Admin Interface of a Public-Facing Webapp Be Accessible Externally?” Software Engineering Stack Exchange, January 1, 1962. https://softwareengineering.stackexchange.com/questions/113670/should-the-admin-interface-of-a-public-facing-webapp-be-accessible-externally.