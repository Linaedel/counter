package linte.counter.controller;

import linte.counter.service.CounterService;
import linte.counter.view.out.ErrorView;
import linte.counter.view.inc.CreationRequest;
import linte.counter.view.out.ListResponse;
import linte.counter.view.out.ValueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return service.create(request.getName())?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(new ErrorView("Counter with [" + request.getName() + "] name is already exists."),HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{name}")
    public ResponseEntity incrementCounter(@PathVariable String name){
        return service.increment(name)?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(new ErrorView("Counter with [" + name + "] name does not exist."),HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{name}")
    public ResponseEntity getCounterValue(@PathVariable String name){
        String counterValue = service.getValue(name);
        return counterValue.equals("")?
                new ResponseEntity<>(new ErrorView("Counter with [" + name + "] name does not exist."),HttpStatus.BAD_REQUEST):
                new ResponseEntity<>(new ValueResponse(counterValue), HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteCounter(@PathVariable String name){
        return service.delete(name)?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(new ErrorView("Counter with [" + name + "] name does not exist."),HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/total")
    public ResponseEntity getTotalValue() {
        return ResponseEntity.ok(new ValueResponse(service.getTotalValue()));
    }

    @GetMapping("/list")
    public ResponseEntity getCountersList() {
        return ResponseEntity.ok(new ListResponse(service.list()));
    }
}
