package com.radhe

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    val client = HttpClient(Apache) {
    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        get("/employee") {
            val emp = EmployeeProto.Employee.newBuilder()
                .setId("111")
                .setName("Radhe")
                .setEmail("radhey.jrs@gmail.com")
                .build()

            call.respondBytes(emp.toByteArray())
        }
    }
}

