package org.oag.securityjparest.controller.state;

import org.oag.securityjparest.entity.state.StateEntity;
import org.oag.securityjparest.model.dto.state.StateDto;
import org.oag.securityjparest.model.response.ApiResponse;
import org.oag.securityjparest.service.state.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/state")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StateController {
    @Autowired
    StateServiceImpl stateService;

    //DIRECTOR
    @PreAuthorize(value = "hasAuthority('ALL')")
    @PostMapping
    public HttpEntity<?> addState(@RequestBody StateDto stateDto) {
        ApiResponse apiResponse = stateService.addState(stateDto);
        return ResponseEntity.status(apiResponse.getSuccess() ? 201 : 409).body(apiResponse);
    }

    //DIRECTOR,MANAGER
    @PreAuthorize(value = "hasAnyAuthority('ALL','READ_ALL')")
    @GetMapping()
    public HttpEntity<?> getStatePage(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
        return ResponseEntity.ok(stateService.getProductPage(page, sortBy));
    }

    //MANAGER,DIRECTOR,USER
    @PreAuthorize(value = "hasAnyAuthority('ALL','READ_ALL','READ_ONE')")
    @GetMapping("/{id}")
    public HttpEntity<?> getStateById(@PathVariable Long id) {
        StateEntity stateById = stateService.getStateById(id);
        return ResponseEntity.status(stateById == null ? 404 : 200).body(stateById);
    }

    //DIRECTOR
    @PreAuthorize(value = "hasAuthority('ALL')")
    @PutMapping("/{id}")
    public HttpEntity<?> editState(@RequestBody StateDto stateDto, @PathVariable Long id) {
        ApiResponse apiResponse = stateService.editState(stateDto, id);
        return ResponseEntity.status(apiResponse.getSuccess() ? 201 : 404).body(apiResponse);
    }

    //DIRECTOR
    @PreAuthorize(value = "hasAuthority('ALL')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteStateById(@PathVariable Long id) {
        ApiResponse apiResponse = stateService.deleteStateById(id);
        return ResponseEntity.status(apiResponse.getSuccess() ? 201 : 404).body(apiResponse);
    }

}
