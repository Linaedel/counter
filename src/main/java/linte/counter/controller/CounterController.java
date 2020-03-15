package linte.counter.controller;

import linte.counter.service.CounterService;
import linte.counter.view.incoming.CreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/", produces = APPLICATION_JSON_VALUE)
public class CounterController {

    private final CounterService service;

    @Autowired
    public CounterController(CounterService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity createCounter(@RequestBody CreationRequest request){
        return ResponseEntity.ok(service.create(request.getName()));
    }

    @PutMapping("/{name}")
    public ResponseEntity incrementCounter(@PathVariable String name){
        return ResponseEntity.ok(service.increment(name));
    }

    @GetMapping("/{name}")
    public ResponseEntity getCounterValue(@PathVariable String name){
        return ResponseEntity.ok(service.getValue(name));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteCounter(@PathVariable String name){
        return ResponseEntity.ok(service.delete(name));
    }

    @GetMapping("/total")
    public ResponseEntity getTotalValue() {
        return ResponseEntity.ok(service.getTotalValue());
    }

    @GetMapping("/list")
    public ResponseEntity getCountersList() {
        return ResponseEntity.ok(service.list());
    }
}
