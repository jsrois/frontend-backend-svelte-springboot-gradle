plugins {
    id("org.springframework.boot") version "3.1.0" apply false
    id("io.spring.dependency-management") version "1.1.0" apply false
    kotlin("jvm") version "1.8.21" apply false
    kotlin("plugin.spring") version "1.8.21" apply false
    id("com.github.node-gradle.node") version "5.0.0" apply false
}

val copyFrontend = tasks.register<Copy>("copyFrontend") {
    dependsOn(":frontend:buildWithNpm")
    from("./frontend/dist")
    into("./backend/src/main/resources/static")
}

getAllTasks(true)[project("backend")]
        ?.find{ it.name == "processResources"}
        ?.dependsOn(copyFrontend)
