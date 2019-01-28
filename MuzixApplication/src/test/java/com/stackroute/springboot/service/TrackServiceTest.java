package com.stackroute.springboot.service;

import com.stackroute.springboot.domain.Track;
import com.stackroute.springboot.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.globalexception.GlobalException;
import com.stackroute.springboot.repository.TrackRepo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


public class TrackServiceTest {

    Track track;
    @Mock
    TrackRepo trackRepo;
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTId(10);
        track.setTName("Madhu");
        track.setTComment("ok ");
        list = new ArrayList<>();
        list.add(track);


    }

    @After
    public void tearDown() throws TrackAlreadyExistsException {
    }
    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepo.save((Track)any())).thenReturn(track);
        Track savedUser = trackService.saveTrack(track);
        Assert.assertEquals(track,savedUser);
        verify(trackRepo,times(1)).save(track);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveTrackTestFailure() throws TrackAlreadyExistsException {
        when(trackRepo.save((Track)any())).thenReturn(null);
        Track savedTrack = trackService.saveTrack(track);
        System.out.println("savedTrack" + savedTrack);
        Assert.assertEquals(track,savedTrack);


    }

    

    @Test
    public void getAllUser(){

        trackRepo.save(track);
        //stubbing the mock to return specific data
        when(trackRepo.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        Assert.assertEquals(list,tracklist);
    }

}