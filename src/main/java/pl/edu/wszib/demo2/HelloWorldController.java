package pl.edu.wszib.demo2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/helloworld")
@RestController
public class HelloWorldController {

    @GetMapping("/get{asdf}/prefix/{super}")
    public String helloWorld(@PathVariable("asdf") String param,
                             @PathVariable("super") String param2) {
        return "Hello World " + param + param2;
    }
    @GetMapping("/get/upper/{tekst}")
    public String upper(@PathVariable("tekst") String param) {
        return param.toUpperCase();
    }


    @PostMapping("/{param2}")
    public String wypisz(@RequestParam(value = "tekst", required = false) String[] param,
                         @PathVariable String param2) {
        String out = "";
//        return "Hello World POST -> " + param;
        for (String t : param) {
        out += t;
        }
        return out;
    }

  public static class ObiektDoWyslania {
        private int numer;
        private String tekst;
        private float zmiennoprzecinkowa;

      @Override
      public String toString() {
          return "ObiektDoWyslania{" +
                  "numer=" + numer +
                  ", tekst='" + tekst + '\'' +
                  ", zmiennoprzecinkowa=" + zmiennoprzecinkowa +
                  '}';
      }

      public int getNumer() {
            return numer;
        }

        public void setNumer(int numer) {
            this.numer = numer;
        }

        public String getTekst() {
            return tekst;
        }

        public void setTekst(String tekst) {
            this.tekst = tekst;
        }

        public float getZmiennoprzecinkowa() {
            return zmiennoprzecinkowa;
        }

        public void setZmiennoprzecinkowa(float zmiennoprzecinkowa) {
            this.zmiennoprzecinkowa = zmiennoprzecinkowa;
        }
    }
    //?obiekt.number=1&Obiekt.tekst=costam&...
    @PostMapping("/obiekt")
    public String dodajObiekt(@RequestParam ObiektDoWyslania obiekt) {
        return obiekt.numer + obiekt.tekst + obiekt.zmiennoprzecinkowa;
    }


    @PatchMapping("/")
    public String wypisz2() {
        return "Hello World PATCH";
    }

    @PatchMapping
    public String wypisz3(@RequestBody ObiektDoWyslania param) {
        return "Hello World PATCH -> " + param;
    }


    @PutMapping("/")
    public String put() {
        return "Hello World PUT";
    }

    @DeleteMapping("/")
    public String delete() {
        throw new MojWyjatek();
//        return "Hello World DELETE";
    }

    @PutMapping
    public String wypisz4(@RequestHeader("Testheaher") String param) {

        return "Hello World Put -> " + param;
    }

    @ExceptionHandler
    public String obsluz(NullPointerException e) {
        return "Cos tam nie dziala";
    }
    @ExceptionHandler
    public ResponseEntity blad(MojWyjatek e) {
//        return "nie dziel przez zero";
//        throw new MojWyjatek();
//        return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body("hey, korzystam z body");
    }





}
