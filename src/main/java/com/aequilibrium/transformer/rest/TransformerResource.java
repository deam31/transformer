/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.rest;

import com.aequilibrium.transformer.service.TransformerService;
import com.aequilibrium.transformer.service.dto.TransformerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransformerResource {

    private final TransformerService transformerService;

    public TransformerResource(final TransformerService transformerService) {
        this.transformerService = transformerService;
    }

    @GetMapping("/transformers")
    public ResponseEntity<List<TransformerDTO>> getAll() {
        System.out.println("called first");
        final List<TransformerDTO> transformers = transformerService.findAll();
        return ResponseEntity.ok().body(transformers);
    }

    @PostMapping("/transformer")
    public ResponseEntity<Void> createTransformer(@RequestBody final TransformerDTO transformerDTO) {
        transformerService.createOrUpdate(transformerDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/transformer/{id}")
    public ResponseEntity<TransformerDTO> deleteTransformer(@PathVariable final long id) {
        transformerService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/transformer")
    public ResponseEntity<Void> updateTransformer(@RequestBody final TransformerDTO transformerDTO) {
        transformerService.createOrUpdate(transformerDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/transformers/battle")
    public ResponseEntity<String> battle(@RequestParam final List<Long> ids) {
        final String result = transformerService.battle(ids);
        return ResponseEntity.ok(result);
    }
}