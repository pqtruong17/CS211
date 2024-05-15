# Project 2: Deus Ex Machina

###  CS 211: Object Oriented Programming - Spring 2024 

The purpose of this assignment is to familiarize you with generics through the use of `ArrayList` within a package. Your tasks involve:

- Creating a set of types for the `sublime` package, necessitating a grasp of generics, interfaces, exceptions, and enumerations.
- Learning about two types from the Java `collections` framework.
- Becoming familiar with reading the JavaDocs of the `westworld` package.
- Running tests via the template class `DoloresTest.java`.

## ChangeLog

- `03/12/2024 10:45 AM` Uploading your solution: Removed group instructions, it is an individual project.
- `03/12/2024 02:50 PM` `Dolores.freezeAllMotorFunctions()`: removed the freeze-wipe logic confusion. Dolores ain't Freezable. 
- `03/12/2024 09:00 PM` `NarrativeLoop.wipeNarrativeLoop()`: added missing method specification, and visibility modififiers.
- `03/13/2024 08:20 AM` `Bernard` class: added missing class specification, it "manages" `SystemWhole`s. `Host.wipe()`: Phrasing: "on" to "of the narrativeLoop field".
- `03/13/2024 02:15 PM` `Dolores` and `Host`: all methods have public visibility. **Careful:** done to simplify testing, this totally exposes the `sublime` API in production =(.
- `03/14/2024 03:10 PM` `NarrativeLoop.updateNarrativeLoops()`: clarified what the logic for adding `SystemWhole`s to the lists is.
- `03/20/2024 10:00 AM` `compilation and execution commands`: Updated java version `11` to `14` added `enable-preview`.
- `04/05/2024 01:00 PM` `FordTest.java "typo"`: `memorySnapshot.getSimulationMemory()` is `memorySnapshot.simulationMemory()`.
  
## Prelude

As you embark on Project 2 (P2), you're building upon the foundation laid in Project 1 (P1), with reduced complexity, where you've already started working with JSON-like strings to represent parts of a `Machine` within Exercise 2's (E2) `Robot`.

To guide you through this project, we included the easter eggs in P1. The aim is to ensure that the instructions are clear and the level of difficulty is manageable. The primary focus will be on structuring your code correctly, which will account for 50% of the project. The remaining 50% will involve algorithmic challenges within `NarrativeLoop`.

**Scripts for compiling your code and executing your tests are also provided.**


## Rules
0. **This project is an individual effort; the Honor Code applies.**
1. Do not modify the structure of the directories nor the code for the package `westworld`. 
2. You may import the following types from `java.util`: `ArrayList`, `List`; `westworld`: all. Other imports are not allowed.
3. The `main` method is no longer recommended; you will now required to put the "main" logic in unit tests.
4. Comment your code, especially any parts that are not obvious what you're doing. Consider explaining your loops and methods. 
5. Class fields should not in general be visible to other classes (unless otherwise specified). Create getter methods instead.
6. You may add your own helper methods or data fields, but they must be declared `private`.

## Download the source code 

Click on green button `<> code` at the top-right of this page and select **Download ZIP**. 

![image](https://github.com/luminaxster/CS211-Spring2024-P2/assets/6577822/5b85c309-12d8-493e-963e-d22220a65b3d)

### The directory  `CS211_P2` contains the directories `westworld`, `sublime`, and `lib`.

### All are required to compile and run your code.


## WestWorld package [DO NOT MODIFY]
Refer to the JavaDoc located at `westworld/docs/index.html` or `westworld\docs\index.html` to explore the API; it's unnecessary to review the code to utilize the package. However, if you're interested in potential solutions for P1 and E2, you're encouraged to examine them.

Now, you'll need to employ the `Robot` class for your `sublime` package implementation. While reading the documentation, note that four easter eggs have been incorporated within P1, illustrating how E1's Robot has become extremely powerful, albeit abstractly.

# DO NOT PROCEED WITHOUT READING THE DOCUMENTATION
# MAKE SURE YOUR JAVA VERSION IS equals or greater than 14
# Do not use deprecated types or members


---

## Sublime package [YOUR PROJECT]

Remember:

  - Yes, there is a lot of text, overwhelming even. **Your code will not be, we promise.**
  - **Start now! Do not undestimate the effort it takes to navigate the logic.**
  - Be precise with the names and types in every abstraction you work on.
  - Prefer copying from the description rather than transcribing.
  - Be mindful of naming conventions and case sensitivity.
  - Compile and run your code (including tests) **locally**. Your test class `DoloresTest.java` is located in `src.test`. More details in Compilation and Running Tests. Refrain from using GradeScope directly.
  - Do not shy away from the shell (terminal, command prompt).
  - **You are a computer scientist, you are in control of tech not the other way around.**

#### All your work must be located in the directory matching the `src.main` package (`CS211_P2/sublime/src/main/` or `CS211_P2\sublime\src\main\`)
![image](https://github.com/luminaxster/CS211-Spring2024-P2/assets/6577822/75e28ecb-71b4-46a2-9129-d5daa3679438)
### Implement the types to spec from A to J. Each type on a separate file.
#### `Bernard.java` is the only file there so far.



### Bernard Class [DO NOT MODIFY]
The `Bernard` class provides a static utility method for analyzing emergences, represented as strings, and encapsulating them within a `SystemWhole` instance. All `SystemWhole` instances are 'analyzed' here before being used for narrative purposes (`NarrativeLoop`).  

#### Methods
##### `public static final SystemWhole analysis(String[] emergences)`

- **Purpose**: This method takes an array of strings, each representing an "emergence", and creates a `SystemWhole` object from it. 
- **Process**: It directly constructs a new `SystemWhole` instance, passing the `emergences` array to its constructor. 
- **Return Value**: The method returns the newly created `SystemWhole` instance, which now encapsulates the provided emergences.

### A.  Realm Enum
The enum `Realm` is integral to a narrative management system, specifically used within the `NarrativeLoop` class to categorize narrative processes.

Enum Details:

  - `EMULATION`: Represents high-fidelity replications of the original system.
  - `SIMULACRA`: Denotes abstracted or distorted representations, not directly tied to the original.
  - `SIMULATION`: Indicates simplified models for exploring system behaviors.

### B. Abstract NarrativeLoop Class

Implement the `NarrativeLoop` class and include logic for filtering `SystemWhole` parts by kind, then populating the three `ArrayList`s (`emulation`, `simulacra`, `simulation`). Then, we'll focus on the `updateNarrativeLoops` method and related logic.

#### Fields

The `NarrativeLoop` class includes three fields, all `final` and `protected`, `List` of `SystemWhole`s initialized to new `ArrayList`s:

- **emulation**
- **simulacra**
- **simulation**

#### Methods

In this class, you will process **simple** emergences, each characterized by a single `kind` property contained within a string. For example, emergences like `["{'kind': 'Square'}", "{'kind': 'Box'}"]` will be used.

**Make sure that you:**

- Implement logic in the `NarrativeLoop` class to categorize emergences into three `ArrayLists`: `emulation`, `simulacra`, and `simulation`, based on their `kind`.
- Provide test values for each list to adequately exercise the categorization logic.



##### void wipeNarrativeLoops()
This public method clear the lists. The method resets the narrative environment by clearing the `emulation`, `simulacra`, and `simulation` lists, removing all `SystemWhole` instances from each realm. For more details, check the [`List.clear()` API docs](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html#:~:text=void%C2%A0clear,this%20call%20returns.).

Now, to implement the `NarrativeLoop` class methods, follow these steps closely, the flow, ensuring each part is executed as described:

##### Step 1: updateNarrativeLoops(SystemWhole[] emulationContext, SystemWhole[] simulacraContext)

To implement this final and public method:

- Begin by iterating over each `SystemWhole` in the `emulationContext` array.
  - For each `SystemWhole`, iterate through the `Machines` it contains.
  - Invoke `determineRealm` with the `Machine`'s kind and both context arrays as parameters.
  - If `determineRealm` returns `Realm.EMULATION` and `containsKind` confirms the `emulation` list doesn't already include a `Machine` of this kind or the same `SystemWhole` reference, add the `SystemWhole` to `emulation`.
- Repeat the process for the `simulacraContext` array. Including checking for the `SystemWhole` reference already in the list, or any of its `Machine`s kinds. 
  - For `Realm.SIMULACRA`, add `SystemWhole`s to `simulacra`.
  - For `Realm.SIMULATION`, add `SystemWhole`s to `simulation`.

##### Step 2: determineRealm(String kind, SystemWhole[] emulationContext, SystemWhole[] simulacraContext)

To implement this final and private method:

- Check for the presence of the `Machine` kind in both `emulationContext` and `simulacraContext` using `isInContext`.
- Assign `Realm.SIMULATION` if the kind is found in both contexts.
- Assign `Realm.SIMULACRA` if the kind is found only in `simulacraContext`.
- Default to `Realm.EMULATION` if neither of the above conditions is met.

##### Step 3: isInContext(String kind, SystemWhole[] context)

To implement this final and private method:

- Iterate through the `SystemWhole` array provided as `context`.
  - Within each `SystemWhole`, iterate through its `Machines`.
  - Return `true` if any `Machine` matches the specified kind.
- Return `false` if no match is found.

##### Step 4: containsKind(List`<SystemWhole>` list, String kind)

To implement this final and private method:

- Iterate over the provided `list` of `SystemWhole` instances.
  - For each `SystemWhole`, iterate through its `Machines`.
  - Return `true` if any `Machine` within the `SystemWhole` matches the specified kind.
- Return `false` if no matching `Machine` kind is found within any `SystemWhole` in the list.


### C. MazeLoop Class (inherits from NarrativeLoop)

`MazeLoop` is a subclass of `NarrativeLoop`, designed for narratives centered around `Dolores` alone.

  - It overrides the `wipeNarrativeLoops()` method to implement maze-specific narrative wiping logic, which is just not allow the inherited wipe behavior.

### D. HostLoop Class (inherits from NarrativeLoop)

`HostLoop` is a subclass of `NarrativeLoop`, designed for narratives centered around `hosts`. 
  - It inherits the functionalities of `NarrativeLoop` as is.

### E. MemorySnapshot Record

`MemorySnapshot` is defined as a [`record`](https://docs.oracle.com/en/java/javase/17/language/records.html), encapsulating the memory states of `SystemWhole` instances across three realms: EMULATION, SIMULACRA, and SIMULATION. Each component of the record holds a list of `SystemWhole` instances relevant to its realm.

#### Components (fields generated by the record API)

They are **copies** (see Dolores class) of `NarrativeLoop` fields:

- `emulationMemory`: A list of `SystemWhole` instances for the EMULATION realm.
- `simulacraMemory`: A list for the SIMULACRA realm.
- `simulationMemory`: A list for the SIMULATION realm.

Opting for a record, similar to the approach in `westworld.src.main.PartState`, offers benefits like immutability, simplicity in state representation, and an inbuilt pattern of equality and hashing, making it an ideal choice for data structures intended to hold snapshot information.

### F. Freezable Interface

The `Freezable` interface is designed to provide a standardized **specification** for objects that require the functionality to temporarily suspend their operations. This interface mandates the implementation of a specific behavior to "freeze" ongoing processes, ensuring the safe cessation of activities.

#### Methods

##### `boolean freeze()`

The implementing classes providea behavior according to the interface **specification**.

### G. Analyzable Interface

The `Analyzable` interface is crafted to establish a uniform **specification** for objects that necessitate the capability to be analyzed, yielding insights or data snapshots of their current state. This interface obligates the concrete implementation of an analysis routine that scrutinizes the object's state or behavior.

#### Methods

##### `MemorySnapshot analyze()`

The method to be implemented as per the interface **specification** mandates that implementing classes provide a behavior that analyzes the current state or condition of the object and returns a `MemorySnapshot`.

### H. Wipeable Interface (inherits from Analyzable)

The `Wipeable` interface extends the `Analyzable` interface, introducing **specifications** for objects that not only require analytical capabilities but also the ability to reset or clear their state. This extension ensures that objects adhering to this interface can both be analyzed and have their data or operations "wiped" to a clean state.

#### Methods

##### `void wipe()`

In alignment with the interface **specification**, implementing classes are tasked with defining a behavior for the `wipe` method. This method, when invoked, should clear or reset the state of the object.

### I. Dolores Class (inherits from Robot and is Wipeable)

The `Dolores` class, extending `Robot` (from the `westworld` package) and implementing the `Wipeable` interface.

#### Fields

  - **narrativeLoops:** this field is a private list that holds instances of the `NarrativeLoop` type. It's initialized to an empty array list, allowing for the dynamic addition of narrative loop objects. 

#### Methods

##### Constructor: `Dolores()`

Initializes `Dolores`, which is public method, with characteristics such as emergences, serial number, and capabilities (flies, autonomous, teleoperated), leveraging the `Robot` superclass constructor. Provide **defaults** for the parent; they are vestigial wirings from the old system:

```java
String[] emergences, int serialNumber, boolean flies, boolean autonomous, boolean teleoperated
```

##### `void addNarrativeLoop(NarrativeLoop narrativeLoop)`

This method, final and  public, allows for the addition of `NarrativeLoop` instances to `Dolores`'s internal list, enabling the management and tracking of various narrative states.

##### `Machine[] getAbsoluteCapabilities()`

This method, final and public, throws an `UnsupportedOperationException`, indicating that fetching absolute capabilities directly is not supported.

##### `boolean freezeAllMotorFunctions()`

This public method implements the freeze-like operation. This method is intended to halt all operations and activities, akin to a freeze command in a control system, returning `true` if successful.
**It is ineffective on Dolores, it just returns false.**

##### `MemorySnapshot analyze()`

Overrides the `analyze` method (public) from the `Analyzable` interface via `Wipeable`. It is designed to protect Dolores' memory from being wiped and to log each memory wipe.

- **Check for Empty List**: Initially, verify if `narrativeLoops`, the list holding narrative states, is empty. If so, return `null` to indicate there are no narratives to analyze.
- **Obtain the last NarrativeLoop**: If the list isn't empty, obtain the last `NarrativeLoop` from `narrativeLoops`. This represents the most recent narrative state.
- **Create a MemorySnapshot**: Using the last `NarrativeLoop`, construct a `MemorySnapshot` that includes the states from the `emulation`, `simulacra`, and `simulation` lists within the narrative loop. However, the lists in the parameters are [defense copies](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#:~:text=capacity%20of%20ten.-,ArrayList(Collection%3C%3F%20extends%20E%3E%C2%A0c),collection%2C%20in%20the%20order%20they%20are%20returned%20by%20the%20collection%27s%20iterator.,-ArrayList(int%C2%A0initialCapacity)).

##### `void wipe()`

Implements the wipe functionality required by the `Wipeable` interface. The public method's body is to be defined with logic for resetting or clearing `Dolores`'s state, with a focus on handling narrative loops and memory states.
**Dolores does nothing with this method, an empty implementation is all there is.**

### J. Host Class (inherits from Dolores)

The `Host` class represents a nuanced entity capable of engaging with narrative structures and responding to control commands, equipped with mechanisms for narrative analysis, memory management, and operational control.

#### Fields

  - **narrativeLoop:** this field is a private instance of the `NarrativeLoop` type. It's initialized in the constructor. 


#### Methods

##### Constructor: `Host(NarrativeLoop narrativeLoop)`

Make sure this public method calls its the `Dolores` superclass's constructor.
- The `narrativeLoop` argument is directly assigned to the `Host` class's `private final NarrativeLoop narrativeLoop` field. This field holds a reference to the `NarrativeLoop` instance associated with this `Host`.
- `addNarrativeLoop(narrativeLoop);` adds the provided `NarrativeLoop` instance to a collection within `Dolores`, ensuring it's part of Dolores's narrative management.

##### `boolean freezeAllMotorFunctions()`

This public method: 

- Mimics a command to halt all of the host's operations and activities.
- The method consistently returns `true`, indicating that the freeze command was successful every time it's called.

##### `MemorySnapshot analyze()`

This public method: 

- Begins by checking if the `narrativeLoop` field is `null`. If it is, the method returns `null`, indicating there's no narrative loop to analyze.
- If `narrativeLoop` is not `null`, the method creates and returns a new `MemorySnapshot` instance. This snapshot is constructed using the `emulation`, `simulacra`, and `simulation` lists from the `narrativeLoop` field.

##### `void wipe()`

This public method: 

- Calls the `wipeNarrativeLoops()` method of the `narrativeLoop` field. This action is meant to reset or clear the narrative states within the loop, aligning with the intended functionality of a wipe operation in a narrative management context.

##### `boolean freeze()`

This public method: 

- Implements the `freeze` method from the `Freezable` interface by invoking `freezeAllMotorFunctions()`. This ensures that the freeze behavior defined specifically in the `Host` class is used for the `Freezable` interface's freeze operation.
- The return value of `freezeAllMotorFunctions()` (which is always `true`) is also the return value of this `freeze` method, indicating the success of the freeze operation.

## Compilation and Running Tests:

You are responsible for ensuring your code functions correctly according to the description provided above. A validation checker will be made available on gradescope which will try to catch errors that would prevent the autograder from running. Passing this validation check does not guarantee that all of the required logic has been implemented correctly. You should write your own tests which exercise all of the required functionality in a variety of different situations in order to verify that your code operates as you expect it to. Code which does not compile or fails any of the validation checks may receive zero credit.

### DoloresTest Class

Your test class `DoloresTest.java` in located in `src.test`. It is a test class "test: Hello World!", with a single test method. Some hints are given to run your code.

**It will not be graded, but future projects and exercises will. Start mastering JUnit now.**

#### All commands require the current directory (folder) in your CLI (terminal, cmd) to be at `CS211_P2`

#### Compile your code bundle (Java versions > 14)

##### Unix-Like (Linux, MacOS)

```bash
javac -cp .:lib/junit-jupiter-api-5.10.2.jar:lib/junit-vintage-engine-5.10.2.jar:lib/apiguardian-api-1.1.2.jar:lib/junit-platform-console-standalone-1.10.2.jar -d bin westworld/**/*.java sublime/**/*.java
```
##### MS Windows
```cmd
javac -cp ".;lib\junit-jupiter-api-5.10.2.jar;lib\junit-vintage-engine-5.10.2.jar;lib\apiguardian-api-1.1.2.jar;lib\junit-platform-console-standalone-1.10.2.jar" -d bin westworld\src\main\*.java sublime\src\main\*.java sublime\src\test\*.java
```

#### Compilation for Java versions <=14

If the commands above did not work, perhaps the Java version in your machine may be the reason. Check it with this command.

```bash
java --version
```

If the version is not greater than 14, you will have use these commands instead. Do not forget to replace the `--release` number. The following commmands assume a Java 14 version in the machine.


```bash
javac --enable-preview --release 14 -cp .:lib/junit-jupiter-api-5.10.2.jar:lib/junit-vintage-engine-5.10.2.jar:lib/apiguardian-api-1.1.2.jar:lib/junit-platform-console-standalone-1.10.2.jar -d bin westworld/**/*.java sublime/**/*.java
```
##### MS Windows
```cmd
javac --enable-preview --release 14 -cp ".;lib\junit-jupiter-api-5.10.2.jar;lib\junit-vintage-engine-5.10.2.jar;lib\apiguardian-api-1.1.2.jar;lib\junit-platform-console-standalone-1.10.2.jar" -d bin westworld\src\main\*.java sublime\src\main\*.java sublime\src\test\*.java
```

#### Run your code via `JUnit` tests:

##### Unix-Like (Linux, MacOS)

```sh
java -cp bin:lib/junit-jupiter-api-5.10.2.jar:lib/junit-vintage-engine-5.10.2.jar:lib/apiguardian-api-1.1.2.jar:lib/junit-platform-console-standalone-1.10.2.jar org.junit.platform.console.ConsoleLauncher execute --scan-class-path
```
##### MS Windows
```cmd
java -cp "bin;lib\junit-jupiter-api-5.10.2.jar;lib\junit-vintage-engine-5.10.2.jar;lib\apiguardian-api-1.1.2.jar;lib\junit-platform-console-standalone-1.10.2.jar" org.junit.platform.console.ConsoleLauncher execute --scan-class-path
```

## Uploading your solution: Only .java files in the `sublime` directory

The instructions are as follows (up to **5pts** penalty for not following the below instructions). No exceptions this time (pun intended). **It is automatically verified now.**

Upload all of your source files (*.java) in the `sublime/src/main` directory (`sublime\src\main` folder) to the P2 assignment on [Gradescope](https://www.gradescope.com/). Do not include anything else (no .class file, no blank templates, not this file, no .zip files).
At the top of each source file, include the following information in a comment: Name, gmu netID, g#, lecture section, and lab section. Here's an example:
```java
/*
* Name: Donald Knuth
* netID: dknuth
* G#: 00123456
* Lecture section: 004
* Lab section: 213
*/
```

**Verify your submission:** Go back to Gradescope, download the files you just submitted, double-check their contents, rerun your tests. If something is wrong, you can resubmit as many times as you want before the deadline expires.
Make a backup of your files on OneDrive (use your mason account).

---
# FAQ

## Imports, Packages and IDE Configuration

### Why am I getting import errors when using the `westworld` package?

Make sure your project files are in the `CS211_P2/sublime/src/main/` directory (Linux, macOS, and other Unix-based operative systems)  or `CS211_P2\sublime\src\main\` folder (Windows).

### For my Dolores.java file, I cannot seem to import `westworld` correctly?

That is `VS Code` assistance issue, not Java imports, I believe there is config file in the project: `CS211_P2/P2.code-workspace`. Opening it will configure your VS Code's project source paths.

Alternatively, try saving your workspace, and make sure your config looks like this:

```js
{
    "folders": [
        {
            "path": "."
        }
    ],
    "settings": {
        "java.project.sourcePaths": [
            "sublime",
            "westworld"
        ]
    }
}
```

### While working on `SystemWhole`'s `reify()` to get the `Machine`, but then I couldn't use the `getKind()` since it is protected, where should I place the file?

Oh! All your files should be placed at `sublime/src/main`. `Bernard.java` should be there to lead the way.

## `sublime` Types 

## NarrativeLoop Hierarchy

### How do `MazeLoop` and `HostLoop` subclasses function and interact in `NarrativeLoop` logic?

In the context of `MazeLoop` and `HostLoop`, both subclasses of `NarrativeLoop`, here's a breakdown focusing on the **overriding** implications in OOP:

1. **Parent Behavior (`NarrativeLoop`)**: The `NarrativeLoop` class has a method called [`wipeNarrativeLoops()`](https://github.com/luminaxster/CS211-Spring2024-P2/blob/main/README.md#void-wipenarrativeloops). This method is like a default action plan that clears out certain lists, essentially resetting its fields.

2. **Child Behavior - `MazeLoop`**:
   - `MazeLoop` takes this inherited action plan but decides to change it. When we say it's going to "implement maze-specific narrative wiping logic, which is just not allow the inherited wipe behavior," it means `MazeLoop` is using its own set of rules for clearing things out, ignoring the inherited method provided by `NarrativeLoop`.
   - This overriding in `MazeLoop` implies it's deliberately choosing **not** to follow the parent's instructions. Instead, it introduces its own approach tailored for maze scenarios, wich is an empty code block.

3. **Child Behavior - `HostLoop`**:
   - Unlike `MazeLoop`, `HostLoop` doesn't change the original action plan. It sticks with the default method from `NarrativeLoop` for clearing the lists, meaning it follows the parent's instructions without any modifications.

## Compilation and Running Tests

## I cannot seem to get my tests to work, where do I start?

If you reached here, take this test file as a [token of appreciation](CS211_P2/sublime/src/test/FordTest.java).
