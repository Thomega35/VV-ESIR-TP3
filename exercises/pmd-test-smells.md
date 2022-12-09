# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

The antipattern piggybacking is checked by `JUnitTestContainsTooManyAsserts` which looks the number of `assert` per methods.
The antipattern useless assert path is checked by `UnnecessaryBooleanAssertion` because it will check useless assertion.

We ran the rule `JUnitTestContainsTooManyAsserts` on `Apache Commons Collections` and we found several placies where there is this bad smell.

Exemple on `PatriciaTrieTest`:

```java
@Test
    public void testPrefixMapClearNothing() {
        final Trie<String, Integer> trie = new PatriciaTrie<>();
        final SortedMap<String, Integer> prefixMap = trie.prefixMap("And");
        assertEquals(new HashSet<String>(), prefixMap.keySet());
        assertEquals(new ArrayList<Integer>(0), new ArrayList<>(prefixMap.values()));

        prefixMap.clear();
        assertTrue(prefixMap.isEmpty());
        assertTrue(prefixMap.isEmpty());
        assertTrue(prefixMap.isEmpty());
        assertEquals(new HashSet<String>(), trie.keySet());
        assertEquals(new ArrayList<Integer>(0), new ArrayList<>(trie.values()));
    }
```

Here they are too many `assertTrue`. We can correct it like that :

```java
...

assertTrue(prefixMap.isEmpty());
assertEquals(new HashSet<String>(), trie.keySet());
assertEquals(new ArrayList<Integer>(0), new ArrayList<>(trie.values()));

```

It could be possible to do more by using one method per `assert`
