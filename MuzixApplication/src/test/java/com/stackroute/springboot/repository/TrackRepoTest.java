package com.stackroute.springboot.repository;

import com.stackroute.springboot.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataMongoTest

public class TrackRepoTest {

@Autowired
TrackRepo trackRepo;
Track track;

    @Before
    public void setUp() throws Exception {

        track = new Track();
        track.setTId(10);
        track.setTName("Madhu");
        track.setTComment("bimar hai");
    }

    @After
    public void tearDown() throws Exception {
        trackRepo.deleteAll();
    }

    @Test
    public void testSaveTrack(){
        trackRepo.save(track);
        Track fetchTrack = trackRepo.findById(track.getTId()).get();
        Assert.assertEquals(10,fetchTrack.getTId());
    }
    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new Track(34,"Harry123","where are you?");
        trackRepo.save(track);
        Track fetchTrack = trackRepo.findById(track.getTId()).get();
        Assert.assertNotSame(testTrack,fetchTrack);

    }




    @Test
    public void testGetAllTrack(){
        Track t1 = new Track(10,"Madhu","bimar hai");
        Track t2 = new Track(11,"Madhupriya","bimar nhi hai");
        trackRepo.save(t1);
        trackRepo.save(t2);

        List<Track> list = trackRepo.findAll();
        Assert.assertEquals("Madhu",list.get(0).getTName());
    }




}