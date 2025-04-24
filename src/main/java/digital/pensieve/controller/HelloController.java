package digital.pensieve.controller;


import digital.pensieve.data.HelloDataAccess;
import digital.pensieve.model.RecordData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;
import java.util.HashMap;
import java.util.Map;


@RestController
@EnableWebMvc
public class HelloController {

    @Autowired
    HelloDataAccess repository;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public Map<String, String> ping1() {
        Map<String, String> pong = new HashMap<>();
        pong.put("pong1", "Hello, World!");
        return pong;
    }


    @RequestMapping(path = "/hello2", method = RequestMethod.POST)
    public String hello() {
        return "hello2";
    }

    @RequestMapping(path = "/add/record", method = RequestMethod.POST)
    public RecordData addRecord(@RequestBody RecordData data) {
        RecordData output = repository.save(data);
        return output;
    }

    @RequestMapping(path = "/add/record2", method = RequestMethod.GET)
    public RecordData addRecord2(
        @RequestParam Integer id,
        @RequestParam String device,
        @RequestParam String deviceName,
        @RequestParam String username,
        @RequestParam(required = false) String notes
    ) {
        RecordData data = new RecordData();
        data.setId(id);
        data.setDevice(device);
        data.setDeviceName(deviceName);
        data.setUsername(username);
        data.setNotes(notes);
        RecordData output = repository.save(data);
        return output;
    }


    @RequestMapping(path = "/put/record", method = RequestMethod.PUT)
    public RecordData putRecord(
            @RequestBody RecordData recordData
    ) {
        RecordData output = repository.save(recordData);
        return output;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<RecordData> listRecords(
    ) {
        return repository.findAll();
    }
}
