/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.controller;

import com.sg.superpeoplesightings.dao.LocationDao;
import com.sg.superpeoplesightings.dao.OrganizationDao;
import com.sg.superpeoplesightings.dao.PredefinedQueryDao;
import com.sg.superpeoplesightings.dao.SightingDao;
import com.sg.superpeoplesightings.dao.SuperPersonDao;
import com.sg.superpeoplesightings.dao.SuperPowerDao;
import com.sg.superpeoplesightings.model.Location;
import com.sg.superpeoplesightings.model.Organization;
import com.sg.superpeoplesightings.model.Sighting;
import com.sg.superpeoplesightings.model.SuperPerson;
import com.sg.superpeoplesightings.model.SuperPower;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jstuart15
 */
@CrossOrigin
@Controller
public class RESTController {

    private SuperPersonDao superPersonDao;
    private PredefinedQueryDao queryDao;
    private LocationDao locationDao;
    private SuperPowerDao superPowerDao;
    private OrganizationDao orgDao;
    private SightingDao sightingDao;

    @Inject
    public RESTController(SuperPersonDao superPersonDao, SightingDao sightingDao,
            PredefinedQueryDao queryDao, LocationDao locationDao,
            SuperPowerDao superPowerDao, OrganizationDao orgDao) {
        this.superPersonDao = superPersonDao;
        this.queryDao = queryDao;
        this.locationDao = locationDao;
        this.superPowerDao = superPowerDao;
        this.orgDao = orgDao;
        this.sightingDao = sightingDao;
    }

    //SUPER POWER PATHS
    @RequestMapping(value = "/superpowers", method = RequestMethod.GET)
    @ResponseBody
    public List<SuperPower> getAllSuperPowers() {
        return superPowerDao.getAllSuperPowers();
    }

    @RequestMapping(value = "/superpower/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SuperPower getSuperPower(@PathVariable("id") int id) {
        return superPowerDao.getSuperPowerById(id);
    }

    @RequestMapping(value = "/superpower", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SuperPower createSuperPower(@Valid @RequestBody SuperPower superPower) {
        return superPowerDao.addSuperPower(superPower);
    }

    @RequestMapping(value = "/superpower/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSuperPower(@PathVariable("id") int id) {
        superPowerDao.deleteSuperPower(id);
    }

    //SUPER PERSON(S) PATHS
    @RequestMapping(value = "/superpeople", method = RequestMethod.GET)
    @ResponseBody
    public List<SuperPerson> getAllSuperPeople() {
        return superPersonDao.getAllSuperPeople();
    }

    @RequestMapping(value = "/superperson/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SuperPerson getSuperPerson(@PathVariable("id") int id) {
        return superPersonDao.getSuperPersonById(id);
    }

    @RequestMapping(value = "/superperson", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SuperPerson createSuperPerson(@Valid @RequestBody SuperPerson superPerson) {
        return superPersonDao.addSuperPerson(superPerson);
    }

    @RequestMapping(value = "/superperson/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSuperPerson(@PathVariable("id") int id) {
        superPersonDao.deleteSuperPerson(id);
    }

    //LOCATION PATHS
    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> getAllLocations() {
        return locationDao.getAllLocations();
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Location getLocation(@PathVariable("id") int id) {
        return locationDao.getLocationById(id);
    }

    @RequestMapping(value = "/location", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Location createLocation(@Valid @RequestBody Location location) {
        return locationDao.addLocation(location);
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@PathVariable("id") int id) {
        locationDao.deleteLocation(id);
    }

    //ORGANIZATION PATHS
    @RequestMapping(value = "/organizations", method = RequestMethod.GET)
    @ResponseBody
    public List<Organization> getAllOrganizations() {
        return orgDao.getAllOrganizations();
    }

    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Organization getOrganization(@PathVariable("id") int id) {
        return orgDao.getOrganizationById(id);
    }

    @RequestMapping(value = "/organization", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Organization createOrganization(@Valid @RequestBody Organization organization) {
        return orgDao.addOrganization(organization);
    }

    @RequestMapping(value = "/organization/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("id") int id) {
        orgDao.deleteOrganization(id);
    }

    //SIGHTING PATHS
    //@todo - high - make this return a fully formed object
    @RequestMapping(value = "/sightings", method = RequestMethod.GET)
    @ResponseBody
    public List<Sighting> getAllSightings() {
        return sightingDao.getAllSightings();
    }

    @RequestMapping(value = "/sighting/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Sighting getSighting(@PathVariable("id") int id) {
        return sightingDao.getSightingById(id);
    }

    @RequestMapping(value = "/sighting", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Sighting createSighting(@Valid @RequestBody Sighting sighting) {
        return sightingDao.addSighting(sighting);
    }

    @RequestMapping(value = "/sighting/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSighting(@PathVariable("id") int id) {
        sightingDao.deleteSighting(id);
    }

    //PREDEFINED QUERIES
    @RequestMapping(value = "/superpeoplebylocation/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<SuperPerson> getAllSuperPeopleForALocation(@PathVariable("id") int id) {
        return queryDao.getAllSuperPeopleForALocation(id);
    }

    
}
