package kz.iitu.itse1902.var1_nurkhan.controller;

import kz.iitu.itse1902.var1_nurkhan.model.Warning;
import kz.iitu.itse1902.var1_nurkhan.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warnings")
public class WarningController {
    @Autowired
    private WarningService warningService;

    @PostMapping("/")
    public ResponseEntity createTodo(@RequestBody Warning warning,
                                     @RequestParam Long userId){
        try{
            return ResponseEntity.ok(warningService.createWarning(warning, userId));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error creating warning");
        }
    }

    @PutMapping("/complete/{id}")
    public ResponseEntity completeWarning(@RequestParam Long id){
        try{
            return ResponseEntity.ok(warningService.complete(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error complete warning");
        }
    }
}
