import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("com.github.node-gradle.node") version "5.0.0"
}

val buildWithNpm = tasks.register<NpmTask>("buildWithNpm") {
    dependsOn(tasks.npmInstall)
    npmCommand.set(listOf("run", "build"))
}

val testFrontend = tasks.register<NpmTask>("testFrontend") {
    dependsOn("compileWebClient")
    args.set(listOf("test"))
}