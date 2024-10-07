
# BinaryTree Library

A simple binary search tree implementation in Java.

## Features
- Supports standard operations: create, insert, search
- Supports validation of binary search tree properties
- Supports maximum depth calculation
- Supports maximum value retrieval

## Check Out the Code

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/hw3-peihsuanlin.git
   ```
2. Navigate to the project directory:
   ```bash
   cd hw3-peihsuan-lin/binarytree
   ```
## Build, Generate Reports, Javadoc, and Package
### Single Command to Run All Tasks
Run the following command to clean, build, run tests, generate Javadoc, perform code style checks, run static analysis, and package the project:
   ```
   mvn clean package
   ```
This command will:
-  Compile the code.
-  Run unit tests and generate a code coverage report in `target/site/jacoco/`.
-  Check code style using Checkstyle (based on the Google Java Style Guide).
-  Run static analysis using OpenRewrite.
-  Generate Javadoc in the `target/site/apidocs/` directory.
-  Package the project into a JAR file, located in `target/`.

### Key Phases And Plugins
| Phase    | Plugins                                  |
|----------|------------------------------------------|
| validate | Checkstyle, OpenRewrite (Static Analysis)     |
| compile  |                                          |
| test     | JaCoCo (Test Coverage), Unit Tests       |
| package  | Javadoc, Maven Package (JAR Creation)    |
| verify   |                                          |
| install  |                                          |
| deploy   |                                          |

### Explicit Commands for Specific Tasks
If you want to run individual tasks separately, here are the commands:

#### Run Unit Tests
```
mvn test
```
#### Generate Javadoc
```bash
mvn javadoc:javadoc
```
#### Generate Code Coverage Report
```bash
mvn jacoco:report
```
#### Check Code Style (Checkstyle)
```bash
mvn checkstyle:check
```
#### Run Static Analysis (OpenRewrite)
Check without altering the codebase:
```
mvn rewrite:dryRun
```
Performs the analysis and applies the changes to the code:
```
mvn rewrite:run
```
#### Package the Project
```bash
mvn clean package
```
## Maven Central
The project is available on [Maven Central](https://central.sonatype.com/artifact/io.github.peihsuan-lin/hw3)