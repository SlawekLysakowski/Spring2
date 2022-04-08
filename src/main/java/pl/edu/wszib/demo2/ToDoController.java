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

@RequestMapping("/todo")
@RestController
public class ToDoController {


    private Integer idCounter = 1;
    private Map<Integer, ToDo> kontener = new HashMap<>();

    @PostMapping
    public ToDo create(@RequestBody ToDo toDo) {
        toDo.setId(idCounter++);
        kontener.put(toDo.getId(), toDo);
        return toDo;
    }

    @GetMapping
//    public ToDo[] list() {
    public List<ToDo> list(@RequestParam(required = false) ToDo.Status status) {
//            return kontener.values().toArray(new ToDo[0]);
        if (status == null) {
            return new ArrayList<>(kontener.values());
        }
        List<ToDo> pasuja = new ArrayList<>();
        for (ToDo toDo : kontener.values()) {
            if (toDo.getStatus() == status) {
                pasuja.add(toDo);
            }
        }
        return pasuja;
    }


    @GetMapping("{id}")
    public ToDo get(@PathVariable Integer id) {
        return kontener.get(id);
    }
    @PutMapping
    public ToDo update(@RequestBody ToDo toDo) {
       if (kontener.containsKey(toDo.getId())) {
           kontener.put(toDo.getId(), toDo);
           return toDo;
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
