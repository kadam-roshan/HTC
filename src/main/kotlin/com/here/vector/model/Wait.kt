package com.here.vector.model

class Wait(var type: String, var timeout: Int, var fields: List<Field>) {
    constructor() : this("", 0, listOf())
}