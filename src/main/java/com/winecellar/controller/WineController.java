package com.winecellar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winecellar.repository.WineRepository;
import com.winecellar.repository.entity.WineEntity;

@RestController
public class WineController {

    @Value("${text.copyright: Default Copyright}")
    private String copyright;

    @Autowired
    private WineRepository wineRepository;

    @RequestMapping(value = "/wines", method = RequestMethod.GET)
    public List<WineEntity> getWines() throws Exception {
        return wineRepository.findAll();
    }

    @RequestMapping(value = "/wines/{id}", method = RequestMethod.GET)
    public WineEntity getWine(@PathVariable(value = "id") Long id) {
        return wineRepository.findById(id).get();
    }

    @RequestMapping(value = "/wines", method = RequestMethod.POST)
    public WineEntity saveWine(@RequestBody WineEntity wine) throws Exception {
        return wineRepository.save(wine);
    }

    @RequestMapping(value = "/wines/{id}", method = RequestMethod.PUT)
    public WineEntity updateWine(@PathVariable(value = "id") Long id, @RequestBody WineEntity wine) throws Exception {
        return wineRepository.save(wine);
    }

    @RequestMapping(value = "/wines/{id}", method = RequestMethod.DELETE)
    public void deleteWine(@PathVariable(value = "id") Long id) {
        wineRepository.deleteById(id);
    }

    @RequestMapping("/show-config")
    public String showConfig() {
        String configInfo = "Copyright: " + copyright;
        return configInfo;
    }

}
