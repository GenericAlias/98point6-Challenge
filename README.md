# 98point6-Challenge
Drop token coding challenge done for 98point6

<h2>Files</h2>
The repository holds the following important files:

<ul>
<li>DropToken.java - The file containing the code that runs the game</li>
<li>DropTokenTest.java - The file containing test code for the more complex functionality of DropToken.java. Can be run after properly setting up a project within an IDE such as IntelliJ or Eclipse. Depends on JUnit4 in order to run tests.</li>
</ul>

<h2>Running instructions</h2>
After cloning the repository, the challenge code can be run from the command line on a machine with the “javac”/“java” commands as follows:

```
$ javac DropToken.java
$ java DropToken
```

Alternatively, the code can also be run by creating a project out of the code provided in the repository within an IDE such as IntelliJ or Eclipse. The commands used to play the game, as provided in the project specification, are as follows:

<ul>
<li>PUT - (column) (OK | ERROR | WIN | DRAW)</li>
<li>GET - List of columns that have been successfully put to</li>
<li>BOARD - a 4x4 matrix that shows the board state</li>
<li>EXIT - Exits the game</li>
</ul>
