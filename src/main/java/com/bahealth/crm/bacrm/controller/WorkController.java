package com.bahealth.crm.bacrm.controller;

import com.bahealth.crm.bacrm.data.dto.user.UserDto;
import com.bahealth.crm.bacrm.data.exception.ResourceNotFoundException;
import com.bahealth.crm.bacrm.data.exception.ValidationException;
import com.bahealth.crm.bacrm.service.WorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("api/work")
@Api(tags = "Works")
public class WorkController {
    private final WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {this.workService = workService;}

    @ApiOperation(value = "Assign work to the user(s).", notes = "Assign work to the user(s).")
    @ApiResponses({@ApiResponse(code = 200, message = "Operation successful."), @ApiResponse(code = 404, message = "User(s) are not found.")})
    @PostMapping(value = "/{workId}")
    public ResponseEntity<?> assignWorkToUsers(
            @ApiParam(name = "id", value = "the id of the patient.", example = "1", required = true) @PathVariable("workId") Long workId,
            @ApiParam(name = "users", value = "User(s) to be assigned to work.", required = true) @RequestBody List<UserDto> users) {
        try {
            workService.assignWorkToUsers(workId, users);
        } catch (ValidationException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
