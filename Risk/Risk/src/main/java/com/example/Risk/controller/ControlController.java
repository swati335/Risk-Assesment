package com.example.Risk.controller;

import com.example.Risk.model.Control;
import com.example.Risk.repository.ControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controls")
public class ControlController {

    @Autowired
    private ControlRepository controlRepository;

    @GetMapping
    public List<Control> getAllControls() {
        return controlRepository.findAll();
    }

    @GetMapping("/{controlId}")
    public ResponseEntity<Control> getControlById(@PathVariable Long controlId) {
        Optional<Control> control = controlRepository.findById(controlId);
        return control.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Control> createControl(@RequestBody Control control) {
        Control savedControl = controlRepository.save(control);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedControl);
    }

    @PutMapping("/{controlId}")
    public ResponseEntity<Control> updateControl(@PathVariable Long controlId, @RequestBody Control updatedControl) {
        return controlRepository.findById(controlId).map(existingControl -> {
            updatedControl.setId(controlId);
            Control savedControl = controlRepository.save(updatedControl);
            return ResponseEntity.ok(savedControl);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{controlId}")
    public ResponseEntity<Void> deleteControl(@PathVariable Long controlId) {
        controlRepository.deleteById(controlId);
        return ResponseEntity.noContent().build();
    }
}
