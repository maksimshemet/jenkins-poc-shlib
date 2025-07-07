# Jenkins Shared Library

This repository contains a Jenkins Shared Library that provides reusable code for Jenkins pipelines. It includes global variables, classes, and resources that can be utilized in your Jenkinsfiles.

## Structure

The library is organized as follows:

- **vars/**: Contains global variables and functions that can be used directly in Jenkins pipelines.
  - `exampleVar.groovy`: Defines a global variable `exampleVar`.

- **src/**: Contains Groovy classes that encapsulate functionality.
  - `org/foo/ExampleClass.groovy`: Defines the `ExampleClass` with methods that can be called in Jenkins pipelines.

- **resources/**: Contains resources that can be accessed by the shared library.
  - `org/foo/exampleResource.txt`: A resource file that may include configuration data or other text.

- **test/**: Contains unit tests for the library.
  - `org/foo/ExampleClassTest.groovy`: Unit tests for the `ExampleClass`.

## Usage

To use this shared library in your Jenkins pipeline, you need to include it in your Jenkinsfile. Here’s an example of how to do that:

```groovy
@Library('your-shared-library-name') _
```

After including the library, you can call the global variable and methods defined in the library:

```groovy
exampleVar() // Calls the global variable function

def exampleClassInstance = new org.foo.ExampleClass()
exampleClassInstance.exampleMethod() // Calls a method from ExampleClass
```

## Testing

To run the tests for this shared library, you can use the Jenkins pipeline or a local Groovy environment. Ensure that all tests in the `test/` directory pass before deploying the library.

## Contribution

Feel free to contribute to this library by adding new features, fixing bugs, or improving documentation. Please ensure that you follow the coding standards and include tests for any new functionality.