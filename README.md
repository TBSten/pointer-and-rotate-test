# graphicsLayer.rotationZ is misaligned with tap gesture



#### [`expected` rotationZ sample code](https://github.com/TBSten/pointer-and-rotate-test/blob/76188bd745dd2446b805c5206dd5673fd947f44f/app/src/main/kotlin/your/projectPackage/app/Case1_Expected.kt#L20-L38)

```kt
Column(
    Modifier
        .graphicsLayer {
            rotationZ = 70f
        }
        .background(Color.Red.copy(0.1f))
        .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
) {
    repeat(3) {
        Box(
            Modifier
                .clickable { }
                .background(Color.Red.copy(0.2f * (it + 1)))
                .size(150.dp)
        )
    }
}
```


#### [`unexpected` rotationX sample code](https://github.com/TBSten/pointer-and-rotate-test/blob/76188bd745dd2446b805c5206dd5673fd947f44f/app/src/main/kotlin/your/projectPackage/app/Case2_Unexpected.kt#L20-L38)


```kt
Column(
    Modifier
        .graphicsLayer {
            rotationX = 70f
        }
        .background(Color.Blue.copy(0.1f))
        .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
) {
    repeat(3) {
        Box(
            Modifier
                .clickable { }
                .background(Color.Blue.copy(0.2f * (it + 1)))
                .size(150.dp)
        )
    }
}
```

### issue tracker

https://issuetracker.google.com/issues/396007117


#### Sample Video

<video src="https://github.com/user-attachments/assets/83729e52-54ab-42fd-9a2e-fc4ad86b5d13" width="400" />

