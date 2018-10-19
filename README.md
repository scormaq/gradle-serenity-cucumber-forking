Example of forking Serenity-Cucumber tests with Gradle.

Find full documentation with details here: https://serenity-bdd.github.io/theserenitybook/latest/serenity-parallel.html

##### Motivation
The documentation above describes a different approaches to parallel `Serenity-Cucumber` tests using Maven. There are 2 strategies to parallel tests: *batching* (parallelization across different machines) and *forking* (parallelization within 1 machine), which can be either combined or not.

It is pretty obvious how to apply batching strategy, but is not very clear how to use *forking*, because for forking specific `maven-failsafe-plugin` mechanizm is used.

With a little glue code & Gradle configuration it's simple to use forking with Gradle without failsafe plugin (just create enough copies of cucumber runner classes).

##### Description
Demo project contains 2 feature files - one with 9 scenarios & one with 1 scenario. Each scenario consists of 1 step with 2 sec delay.

As described in documentation above, create some Cucumber runner classes, and also attach to them plugin `com.github.scormaq.SerenityCucumberForker` (the trick with plugin allows us to use `@BeforeAll` mechanizm, so we will set `serenity.fork.number` at runtime (sic!) but before slicing starts)

##### Demo
Run command:
```cmd
gradlew clean test -Dserenity.fork.count=5
```
(`serenity.fork.count` is intentionally incorrect - as there only 3 Cucumber runners exist, fork count will be reduced to 3 in gradle build script).
<details><summary>Output</summary>
<p>

```cmd
com.github.scormaq.FeatureSlicedRunner3 STANDARD_OUT

    3 Scenarios (3 passed)
    3 Steps (3 passed)
    0m8.656s


com.github.scormaq.FeatureSlicedRunner2 STANDARD_OUT

    4 Scenarios (4 passed)
    4 Steps (4 passed)
    0m10.331s


com.github.scormaq.FeatureSlicedRunner1 STANDARD_OUT

    3 Scenarios (3 passed)
    3 Steps (3 passed)
    0m8.437s

[..]

BUILD SUCCESSFUL in 34s
```
</p>
</details>


And without forking:
```cmd
gradlew clean test
```
<details><summary>Output</summary>
<p>

```cmd
com.github.scormaq.FeatureSlicedRunner1 STANDARD_OUT

    10 Scenarios (10 passed)
    10 Steps (10 passed)
    0m21.190s

[..]

BUILD SUCCESSFUL in 48s
```
</p>
</details>