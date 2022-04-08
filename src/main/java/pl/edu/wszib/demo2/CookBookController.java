package pl.edu.wszib.demo2;

//Create
//Read
//Update
//Delete

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/cookbook")
@RestController
public class CookBookController {


    private Integer idCounter = 1;
    private Map<Integer, CookBook> kontener = new HashMap<>();

    @PostMapping
    public CookBook create(@RequestBody CookBook cookBook, @RequestParam String nazwa,
                           @RequestParam Integer duration) {
        cookBook.setId(idCounter++);
        cookBook.setNazwa(nazwa);
        cookBook.setDuration(duration);
        kontener.put(cookBook.getId(), cookBook);
        return cookBook;
    }

//    @GetMapping
//    public List<CookBook> list(@RequestParam(required = false)  ) {
//        if (Ingredients == null) {
//            return new ArrayList<>(kontener.values());
//        }
//        List<CookBook> pasuja = new ArrayList<>();
//        for (CookBook cookBook : kontener.values()) {
//            if (cookBook.getIngredients == ingredients) {
//                pasuja.add(cookBook);
//            }
//        }
//        return pasuja;
//    }

    @GetMapping
    public CookBook[] list() {

        return kontener.values().toArray(new CookBook[0]);
    }


    @GetMapping("{id}")
    public CookBook get(@PathVariable Integer id) {
        return kontener.get(id);
    }
    @PutMapping
    public CookBook update(@RequestBody CookBook cookBook) {
       if (kontener.containsKey(cookBook.getId())) {
           kontener.put(cookBook.getId(), cookBook);
           return cookBook;
       }
       return null;
    }
//    @PatchMapping
//    public Zasob update(@RequestBody Zasob zasob, List<String> paths) {
//        if (paths.contains("dowod.imie")) {
//
//        }
//        if (paths.contains("pesel")) {
//
//        }
//    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
    kontener.remove(id);
    }
}
