package com.stackroute.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.springboot.domain.Track;
import com.stackroute.springboot.service.TrackService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TrackControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Track track;
    @MockBean
    private TrackService trackService;
    @InjectMocks
    private TrackController trackController;

    private List<Track> list ;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
        track = new Track();
        track.setTId(10);
        track.setTName("Madhu");
        track.setTComment("priya");
        list = new ArrayList();

        list.add(track);
    }

    @After
    public void tearDown() throws Exception {
    }

    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void saveTrack() throws Exception{
        when(trackService.saveTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    public void getAllTracks() throws Exception{

        when(trackService.getAllTracks()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateTrack() throws Exception {
        when(trackService.updateTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void deleteTrack() throws Exception {
        when(trackService.deleteTrack(anyInt())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getByName() throws Exception {
        when(trackService.trackFindByName(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isFound())
                .andDo(MockMvcResultHandlers.print());

    }
}