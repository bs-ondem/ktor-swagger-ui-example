package com.example.plugins

import io.github.smiley4.ktorswaggerui.dsl.get
import io.github.smiley4.ktorswaggerui.dsl.route
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.response.respond
import io.ktor.server.routing.routing
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    routing {
        route(
            path = "/v1/organizations",
            { tags = listOf("organizations") }
        ) {
            get({
                request {}
                response {
                    HttpStatusCode.OK to {
                        description = "Test endpoint"
                        body<PagedResponse<Organization>> { mediaType(ContentType.Application.Json) }
                    }
                }
            }) {
                val organizations = PagedResponse(
                    items = listOf(Organization(1L, "org1"), Organization(2L, "org2")),
                    options = mapOf("opt1" to "value1")
                )

                call.respond(status = HttpStatusCode.OK, message = organizations)
            }
        }
    }
}


@Serializable
data class Organization(val id: Long, val name: String)

@Serializable
data class PagedResponse<T>(val items: List<T>, val options: Map<String, String>)

