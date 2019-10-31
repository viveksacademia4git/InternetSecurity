# Man In The Middle Attack using Java

## Approach

- Create atleast 2 users who will perform communication
- Create Man in the Middle (Attacker)

## Create atleast 2 user who will communicate
 - We will use the names of the Matrix characters as names of the Java Program for the educational programming and will cite them :)
    * Neo - will be 1 user
    * Morpheus - will be another user
    * Trinity - is also a user who can communicate

## Create Man In The Middle (Attacker)
 - Agent Smith
    * Will be the attacker who will perform Man In the Middle
    * He silently interepts the communication between the Matrix Users
    

## Project Implementation and Execution
 1. Clone Git
    * git clone https://github.com/viveksacademia4git/InternetSecurity/tree/master/JavaManInTheMiddleAttack
 2. Add Gradle if not added (Follow step 2 (a) to check this)
    * (a) Right Click Project > Look for the option > `Gradle`
    * (b) If Gradle nature if not added: Right Click Project > `Configure` > `Add Gradle Nature`
    * (c) Now perform the step 2 (a) to view the 
 3. Load Dependencies: Right Click Project > `Gradle` > `Refresh Gradle Project`
 4. Now Execute the Unit Test Class > 


## Program Execution and Output:

Exeucte >> `edu.srh.is.CommunicationApplicationTest.java` in the test source directory

In the application when the Neo speaks with Morpheus, Agent Smith is listening to their conversation. He silently decrypts the encrypted message from Neo and understand the message. After listening he forwards the request to the Morpheus. Morpheus thinks that nobody has listened to this conversation.

```

---------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------

EAV Key Neo: 138514284961393236670308402131874837154564382176134406942797344806827078517864
Neo key: 138514284961393236670308402131874837154564382176134406942797344806827078517864
EAV Key Morpheus: 99466608988573795380284683835877173992845441700776665088728517568595046439187
Morpheus key: 99466608988573795380284683835877173992845441700776665088728517568595046439187

---- Neo is sending a message ----
Message: Neo >> Morpheus
Cipher: OWSn�`CP-�����

---- Agent Smith Got Message From Neo ----
Cipher Morpheus: OWSn�`CP-�����
Message: Neo >> Morpheus
Cipher Morpheus: N��;4B �.��]
�

---- Morpheus Received Message ----
Cipher: N��;4B �.��]
�
Message: Neo >> Morpheus

---------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------

EAV Key Morpheus: 14329514315563603043507990536753592465077625144176237418313790302960651336674
Morpheus key: 14329514315563603043507990536753592465077625144176237418313790302960651336674
EAV Key Neo: 106543264337876484951801135684234160182121081435435751096295455535865652052942
Neo key: 106543264337876484951801135684234160182121081435435751096295455535865652052942

---- Morpheus is sending a message ----
Message: Morpheus >> Neo
Cipher: R�E�3!�>Q�Sc�A�

---- Agent Smith Got Message From Morpheus ----
Cipher Neo: R�E�3!�>Q�Sc�A�
Message: Morpheus >> Neo
Cipher Neo: M��)���MI��g-

---- Neo Received Message ----
Cipher: M��)���MI��g-
Message: Morpheus >> Neo

---------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------

EAV Key Neo: 194083629674020681674432145452637271907604836497746879718550123806645160264016
Neo key: 194083629674020681674432145452637271907604836497746879718550123806645160264016
EAV Key Trinity: 59812298406611412422496803725893293720624329163058441269683847703664209571086
Trinity key: 59812298406611412422496803725893293720624329163058441269683847703664209571086

---- Neo is sending a message ----
Message: Neo >> Trinity
Cipher: O�xQ7f��t��6

---- Agent Smith Got Message From Neo ----
Cipher Trinity: O�xQ7f��t��6
Message: Neo >> Trinity
Cipher Trinity: N�S��c�F���}H

---- Trinity Received Message ----
Cipher: N�S��c�F���}H
Message: Neo >> Trinity

```



## Reference:
1. The Matrix: Movies. (n.d.). Retrieved from https://www.warnerbros.com/movies/matrix/.
2. Application Reference From: https://github.com/ceteke/maninthemiddle

