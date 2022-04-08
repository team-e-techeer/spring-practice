package net.schoolvery.schoolveryserver.controller;

import net.schoolvery.schoolveryserver.dto.request.HelloRequestDto;
import net.schoolvery.schoolveryserver.dto.response.HelloResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping()
    public ResponseEntity<HelloResponseDto> getHello() {

        HelloResponseDto response = HelloResponseDto.builder()
                .result("Hello ")
                .build();

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("/name")
    public ResponseEntity<HelloResponseDto> getHelloQuery(@RequestParam String name) {

        HelloResponseDto response = HelloResponseDto.builder()
                .result("Hello " + name)
                .build();

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("/{name}")
    public ResponseEntity<HelloResponseDto> getHelloPath(@PathVariable String name) {

        HelloResponseDto response = HelloResponseDto.builder()
                .result("Hello " + name)
                .build();

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping
    public ResponseEntity<HelloResponseDto> getHelloBody(@RequestBody HelloRequestDto helloDto) {

        HelloResponseDto response = HelloResponseDto.builder()
                .result(helloDto.getName())
                .build();

        return ResponseEntity.ok()
                .body(response);
    }
}
