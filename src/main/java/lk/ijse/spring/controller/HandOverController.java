package lk.ijse.spring.controller;


import lk.ijse.spring.dto.HandOverDTO;
import lk.ijse.spring.service.HandOverService;
import lk.ijse.spring.util.StandradResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/handover")
@CrossOrigin
public class HandOverController {

    HandOverService handOverService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addDiverShedule(@RequestBody HandOverDTO dto) {
        handOverService.saveHandOver(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    //getall
    @GetMapping
    public ResponseEntity getAllCustomershedule() {
        List<HandOverDTO> allDrivers = handOverService.getAllHandOver();
        return new ResponseEntity(new StandradResponse(200, "Success", allDrivers), HttpStatus.OK);
    }

}
