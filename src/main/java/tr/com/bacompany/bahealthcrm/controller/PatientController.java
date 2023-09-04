package tr.com.bacompany.bahealthcrm.controller;

import tr.com.bacompany.bahealthcrm.data.dto.PatientDto;
import tr.com.bacompany.bahealthcrm.data.exception.ResourceNotFoundException;
import tr.com.bacompany.bahealthcrm.data.exception.ValidationException;
import tr.com.bacompany.bahealthcrm.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("api/patient")
@Api(tags = "Patients")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ApiOperation(value = "Create or update the patient.", notes = "Create or update the patient.")
    @ApiResponses({@ApiResponse(code = 200, message = "Operation successful.")})
    @PostMapping(value = "/")
    public ResponseEntity<?> save(
            @ApiParam(name = "patientDto", value = "Patient information to be created or updated.", required = true) @RequestBody
            PatientDto patientDto) {
        try {
            return ResponseEntity.ok(patientService.save(patientDto));
        } catch (ValidationException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @ApiOperation(value = "Get the list of patients", notes = "A list of zero or more patients are returned.", response = List.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Operation successful. List of patient list is returned.", response = PatientDto.class,
                                responseContainer = "List")})
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        try {
            Page<PatientDto> patientPage = patientService.getAll(page, size);
            Map<String, Object> response = new HashMap<>();
            response.put("patientList", patientPage.getContent());
            response.put("currentPage", patientPage.getNumber());
            response.put("totalItems", patientPage.getTotalElements());
            response.put("totalPages", patientPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @ApiOperation(value = "Get the list of patients", notes = "A patient is returned by given id. If there is not 404 is returned.",
                  response = List.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Operation successful. List of patient list is returned.", response = PatientDto.class),
            @ApiResponse(code = 404, message = "A patient with the given 'id' does not exist.", response = PatientDto.class)})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(
            @ApiParam(name = "id", value = "the id of the patient.", example = "1", required = true) @PathVariable("id") Long id) {
        Optional<PatientDto> optPatient = patientService.get(id);
        if (!optPatient.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optPatient.get());
    }
}
