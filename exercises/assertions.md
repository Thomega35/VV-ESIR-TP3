# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. This assertion fails because "3*.4" equals something like "1.2000000002" instead of "1.2". This due to a problem of representation of float in Java (but also in the other languages). The right way to do it is by using `assertEquals`.

2. AsserEquals check if the objects has the same value while assertSame check if the objets are the sames :

```java
Integer i1 = new Integer(1);
Integer i2 = new Integer(2);
assertEquals(i1, i2); // => True
assertSame(i1, i2); // => False
assertSame(i1, i1); // => True
```

3. `fail` can be also used to make failed a test. For example if a value has to be lower than another but it is not. In this case we can use `fail` :

```java
maxVal = 50;
if(res > maxVal) {
        fail("Result cannot be greater than 50");
}
```

To finnish with it can used when an exception is catched to show that it failed :
```java
    try{
        okMethod();
    }cacth(Exception e){
        fail('okMethod should not have failed')
    }
```

4. It allows to be able to wait several exception.