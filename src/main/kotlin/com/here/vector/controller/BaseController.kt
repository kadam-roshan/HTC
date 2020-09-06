package com.here.vector.controller

import com.here.vector.model.TestCase
import org.springframework.web.bind.annotation.*


@RestController
class BaseController {
    @PostMapping("/vector/task")
    fun submitTask(@RequestBody testCase: TestCase) {
        testCase.getTestSteps()
    }
}