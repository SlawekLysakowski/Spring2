package pl.edu.wszib.demo2;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/kalkulator")
@RestController
public class Kalkulator {

    @PostMapping("/dodaj")
    public int dodaj(@RequestHeader Integer a, @RequestHeader Integer b) {
        return a + b;
    }

    @PostMapping("/odejmij")
    public int odejmij(@RequestHeader Integer a, @RequestHeader Integer b) {
        return a - b;
    }

    @PostMapping("/podziel")
    public int podziel(@RequestHeader Integer a, @RequestHeader Integer b) {

        return a / b;
    }

    @PostMapping("/pomnoz")
    public int pomnoz(@RequestHeader Integer a, @RequestHeader Integer b) {
        return a * b;
    }

    @PostMapping("/potega")
    public Integer potega(@RequestHeader Integer a, @RequestHeader Integer b) {
        return (int) Math.pow(a, b);
    }

    @ExceptionHandler
    public ResponseEntity blad(MojWyjatek e) {
//        return "nie dziel przez zero";
//        throw new MojWyjatek();
        return ResponseEntity.notFound().build();
    }

}