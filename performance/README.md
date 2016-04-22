# Run performance tests


**Reactive - constant load**
```
sbt "run-main au.com.nab.account.ReactiveListRunner"
```

---

**Traditional - constant load**
```
sbt "run-main au.com.nab.account.TraditionalListRunner"
```

---

**Reactive - spike load**
```
sbt "run-main au.com.nab.account.ReactiveListSpikeRunner"
```

---

**Traditional - spike load**
```
sbt "run-main au.com.nab.account.TraditionalListSpikeRunner"
```
