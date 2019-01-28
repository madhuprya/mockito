package com.stackroute.springboot.service;

import com.stackroute.springboot.domain.Track;
import com.stackroute.springboot.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.exception.TrackNotFoundException;
import com.stackroute.springboot.repository.TrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService {


    private TrackRepo trackRepo;

    @Autowired
    public TrackServiceImpl(TrackRepo trackRepo) {
        this.trackRepo = trackRepo;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepo.existsById(track.getTId())){
            throw new TrackAlreadyExistsException("already there!!");
        }
        Track trackSaved=trackRepo.save(track);
        if(trackSaved==null){
            throw new TrackAlreadyExistsException("cannot accept null");
        }
        return trackSaved;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepo.findAll();
    }

    @Override
    public Track deleteTrack(int id) throws TrackNotFoundException {

        if(!trackRepo.existsById(id))
        {
            throw new TrackNotFoundException("track is not in the database");
        }
        trackRepo.deleteById(id);
        return deleteTrack(id);
    }

    @Override
    public Track updateTrack(Track track) {
        track.setTName(track.getTName());
        track.setTComment(track.getTComment());
        return trackRepo.save(track);
    }

    @Override
    public Track trackFindByName(String name) {
        System.out.println(trackRepo.findBytName(name));
        return trackRepo.findBytName(name);
    }
}
