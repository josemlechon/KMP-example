# KMP-example

link to docs:
https://www.tldraw.com/r/v2BG8XIe2_Re1uahBsofOOp?viewport=0,0,1920,970&page=page:rM3NRHPrzMDfmP8tD2O3Q 


# Build Gradle
## TOML for dependencies

Advantages

    Readability: TOML is designed to be easy to read and write. It has a clear syntax which can make your configuration files more user-friendly, especially for those who are new to the project.

    Structure: TOML allows you to create a well-structured file with sections and comments, which can help organize dependencies and other configurations in a more manageable way.

    Consistency Across Platforms: For Kotlin Multiplatform projects, having a consistent way to manage dependencies for all targets can simplify the build process. TOML could provide a unified format for this.

    Community Adoption: With Gradle 7.0 and above supporting the use of TOML for version catalogs, it's becoming a more commonly used option in the JVM ecosystem.

Considerations

    Learning Curve: For teams or individuals not familiar with TOML, there might be a learning curve. However, TOML's design aims to be minimal and easy to understand.

    Tooling Support: Ensure that your IDE and other tools used in the development process have good support for TOML. While support is growing, it might not be as extensive as for other formats like Groovy or Kotlin DSL.

    Integration with Existing Projects: If you're integrating TOML into an existing project, consider the effort required to migrate your current configuration. This includes not just the technical migration but also getting your team up to speed.

    Ecosystem Compatibility: While TOML is becoming more popular, check if all the tools and plugins you use in your project are compatible with configurations defined in TOML.

    Advanced Gradle Features: Ensure that TOML meets all your needs, especially if you're using advanced Gradle features. While it's great for defining dependencies, some complex configurations might still be better suited to the traditional Groovy or Kotlin DSL.

## Code Analyser Detekt 
Code smell analysis for Kotlin Projects
[detekt web page](https://detekt.dev/docs/intro)

The configuration is stored in the directory _tools/_

To add it into a build.gradle.kts just add the following: 

```
apply("../tools/detekt.gradle")
tasks.named("check").configure {
    this.setDependsOn(this.dependsOn.filterNot {
        it is TaskProvider<*> && it.name == "detekt"
    })
}
```

To apply it on demand we have disabled it to be executed when the CHECK task is executed.
[more info here](https://detekt.dev/docs/gettingstarted/gradle#disabling-detekt-from-the-check-task)

# App Default
## Logging
Napier https://github.com/AAkira/Napier

# Data layer


## Network
### Ktor
- Asynchronous client: https://ktor.io/
- Testing: https://ktor.io/docs/testing.html
Mocked Fake data: 
 - https://restcountries.com/
 - https://restful-api.dev/

## testing
ktor docs for testing https://ktor.io/docs/http-client-testing.html

# Examples

https://github.com/ktorio/ktor-documentation/blob/2.3.7/codeSnippets/snippets/tutorial-client-kmm 

test example: https://medium.com/@maruchin/kmm-architecture-7-testing-93efd01f3952


