repositories {
    mavenCentral()
}

plugins {
    id("com.gradle.plugin-publish") version "1.2.1"
    `embedded-kotlin`
}

group = "com.uselessmnemonic"
version = "0.9.0"

gradlePlugin {
    website = "https://github.com/UselessMnemonic/jasm-plugin"
    vcsUrl = "https://github.com/UselessMnemonic/jasm-plugin"
    plugins {
        create("jasm-plugin") {
            id = "com.uselessmnemonic.jasm-plugin"
            implementationClass = "com.uselessmnemonic.gradle.jasm.JasmPlugin"
            displayName = "Jasm Plugin"
            description = "Plugin supporting the Jasm assembler"
            tags = listOf("jasm", "assembler")
        }
    }
}

dependencies {
    implementation("org.ow2.asm:asm:9.3")
    implementation("com.roscopeco.jasm:jasm:0.7.0")
    implementation("com.beust:jcommander:1.78")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name = "jasm-plugin"
                description = "Jasm JVM Assembler plugin for Gradle"
                url = "https://github.com/UselessMnemonic/jasm-plugin"
                licenses {
                    license {
                        name = "MIT"
                        url = "https://github.com/UselessMnemonic/jasm-plugin/blob/main/LICENSE.md"
                    }
                }
                developers {
                    developer {
                        id = "roscopeco"
                        name = "Ross Bamford"
                        email = "roscopeco AT gmail DOT com"
                    }
                    developer {
                        id = "UselessMnemonic"
                        name = "Christopher Madrigal"
                        email = "chrisjmadrigal AT gmail DOT com"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/UselessMnemonic/jasm-plugin"
                    url = "https://github.com/UselessMnemonic/jasm-plugin"
                }
            }
        }
    }
}
