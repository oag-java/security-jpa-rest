package org.oag.securityjparest.controller.state;

import org.oag.securityjparest.entity.state.StateEntity;
import org.oag.securityjparest.model.dto.state.StateDto;
import org.oag.securityjparest.model.response.ApiResponse;
import org.oag.securityjparest.service.state.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/state")
public class StateController {
    @Autowired
    StateServiceImpl stateService;

    @PostMapping
    public HttpEntity<?> addState(@RequestBody StateDto stateDto) {
        ApiResponse apiResponse = stateService.addState(stateDto);
        return ResponseEntity.status(apiResponse.getSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping()
    public HttpEntity<?> getStatePage(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
        return ResponseEntity.ok(stateService.getProductPage(page, sortBy));
    }

    @GetMapping("/{id}")

    public HttpEntity<?> getStateById(@PathVariable Long id) {
        StateEntity stateById = stateService.getStateById(id);
        return ResponseEntity.status(stateById == null ? 404 : 200).body(stateById);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editState(@RequestBody StateDto stateDto, @PathVariable Long id) {
        ApiResponse apiResponse = stateService.editState(stateDto, id);
        return ResponseEntity.status(apiResponse.getSuccess() ? 201 : 404).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteStateById(@PathVariable Long id) {
        ApiResponse apiResponse = stateService.deleteStateById(id);
        return ResponseEntity.status(apiResponse.getSuccess() ? 201 : 404).body(apiResponse);
    }

}
