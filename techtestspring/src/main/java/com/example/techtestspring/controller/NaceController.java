package com.example.techtestspring.controller;

import com.example.techtestspring.mapper.Nacedto;
import com.example.techtestspring.modal.NaceDetails;
import com.example.techtestspring.util.NaceHelper;
import com.example.techtestspring.util.ResponseMessage;
import com.example.techtestspring.service.NaceService1;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;


@RestController
@Api(tags = {"controller"})
@RequestMapping("/api/nace")
public class NaceController {

    @Autowired
    private NaceService1 naceService;
    @Autowired
    private ModelMapper modelMapper;
    public NaceController(NaceService1 naceService) {
        super();
        this.naceService = naceService;
    }

    @ApiOperation(value="load csv data in to db", response = ResponseMessage.class)
    @ApiResponses(
            value={
                    @ApiResponse (code = 400, message = "BAD_REQUEST"),
                    @ApiResponse (code = 409, message = "CONFLICT"),
                    @ApiResponse (code = 201, message = "SUCCESS"),
            }
    )
@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/putNaceDetails")
    public ResponseEntity<ResponseMessage> putNaceDetails(
            @ApiParam(value = "FILE", required= true)
            @RequestParam("file") MultipartFile file) {
        String message = "";

        if (NaceHelper.hasCSVFormat(file)) {
            try {
                naceService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();

                /*String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/nace/download/")
                        .path(file.getOriginalFilename())
                        .toUriString();*/

                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,""));
            } catch (Exception e) {
                //e.printStackTrace();
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
    }

    @GetMapping("/naceDetails")
    public ResponseEntity<List<NaceDetails>> getAllDetails() {
        try {
            List<NaceDetails> details = naceService.getAllDetails();

            if (details.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(details, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value="gets NaceDetails by Order ID", response = Nacedto.class)
    @ApiResponses(
            value={
                    @ApiResponse (code = 400, message = "BAD_REQUEST"),
                    @ApiResponse (code = 409, message = "Order not found"),
                    @ApiResponse (code = 200, message = "SUCCESS"),
            }
    )
    @GetMapping("/getNaceDetails/{id}")
    public ResponseEntity<Nacedto>getNaceDetails(@PathVariable(value="id")long id) {
        try {
            Optional<NaceDetails> details = naceService.getNaceDetails(id);

            if (details.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            NaceDetails nace=details.get();
            Nacedto naceResponse=modelMapper.map(nace,Nacedto.class);

            return new ResponseEntity<Nacedto>(naceResponse,HttpStatus.OK);
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
