package com.example.plugins

import io.github.smiley4.ktorswaggerui.SwaggerUI
import io.ktor.server.application.Application
import io.ktor.server.application.install

fun Application.configureOpenApi() {
    install(SwaggerUI) {
        server {
            url = "/"
            description = "Actual Server"
        }
    }
}