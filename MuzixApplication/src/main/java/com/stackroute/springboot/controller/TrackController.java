package com.stackroute.springboot.controller;

import com.stackroute.springboot.domain.Track;
import com.stackroute.springboot.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.exception.TrackNotFoundException;
import com.stackroute.springboot.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
@Api(value = "Songs Track" , description = "manage songs track")
public class TrackController {
    private TrackService trackService;
    ResponseEntity responseEntity;

    @Autowired
    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }

        @ApiOperation(value = "save the track",response = ResponseEntity.class)
        @ApiResponses(value = {
                @ApiResponse(code=201 , message="successfully retrieved"),
                @ApiResponse(code=401, message="not authorized to see the track")
        })


        @PostMapping("track")

    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException

    {


     //   try {

            trackService.saveTrack(track);

            responseEntity = new ResponseEntity<Track>(track, HttpStatus.CREATED);

       // }catch (TrackAlreadyExistsException ex)
        //{
          //  responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        //}

        return responseEntity;



    }


    @ApiOperation(value = "Returns save track" , response = ResponseEntity.class)
@ApiResponses(value = {
        @ApiResponse(code=200 , message="successfully retrieved"),
        @ApiResponse(code=401, message="not authorized to see the track")
})
    @GetMapping("track")

    public ResponseEntity<?> getAllTracks()

    {

        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);

    }

    @ApiOperation(value = "Updtaed save track")

    @PutMapping("track")

    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException{
       // try{
            trackService.updateTrack(track);
            responseEntity=new ResponseEntity<Track>(track,HttpStatus.CREATED);
        //}
        //catch (Exception e) {
        //}
        return responseEntity;

    }


    @ApiOperation(value = "Delete save track")

    @DeleteMapping("track/{tId}")
    public ResponseEntity<?> deleteTrack(@PathVariable("tId") int tId) throws TrackNotFoundException{
    //    try{
        trackService.deleteTrack(tId);
        responseEntity=new ResponseEntity("deleted",HttpStatus.OK);
    //}
        //catch (TrackNotFoundException t){
          //  responseEntity=new ResponseEntity(t.getMessage(),HttpStatus.GONE);
        //}
        return responseEntity;
    }

    @GetMapping("track/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name)
    {
        trackService.trackFindByName(name);
        responseEntity= new ResponseEntity<Track>(trackService.trackFindByName(name),HttpStatus.FOUND);
        return responseEntity;
    }

}
