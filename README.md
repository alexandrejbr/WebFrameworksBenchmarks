```
wrk -t 2 -c 100 --latency -d 60s <URL>
```

## JSON Scores:
```
---------------------------------  --------
Spray: ..........................  51395.19
Play Framework (spray): .........  39422.97
Play Framework: .................  33765.12
Node.js: ........................  24966.17

```

## Plain Text Scores:
```
---------------------------------  --------
Spray: ..........................  61071.58
Play Framework: .................  46682.91
Node.js: ........................  27114.60

```