package br.com.macorin.sales.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/sales")
public class SalesResource {

    @Value("${sales.response.value}")
    private String value;

    @GetMapping()
    public ResponseEntity<String> getSales() {
        log.info("Request >>>>>>>>>>>>>>>");
        return ResponseEntity.ok(value);
    }
}
