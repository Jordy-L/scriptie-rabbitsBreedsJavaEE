/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.libbrechtjordy.rabbitsbreedsjavaee.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import org.libbrechtjordy.rabbitsbreedsjavaee.dao.RabbitsBreedDao;
import org.libbrechtjordy.rabbitsbreedsjavaee.entity.RabbitsBreed;

/**
 *
 * @author JordyL
 */
@Named
//@RequestScoped
@SessionScoped
public class RabbitsBreedController implements Serializable{
    
    @Inject
    private RabbitsBreedDao rabbitsBreedRepository;

    private DataModel<RabbitsBreed> rabbitsBreeds;
    private RabbitsBreed currentRabbitsBreed = new RabbitsBreed();

    public RabbitsBreedController (){}
    
    public RabbitsBreed getCurrentRabbitsBreed(){
        if (currentRabbitsBreed==null){
            currentRabbitsBreed = new RabbitsBreed();
        }
        return currentRabbitsBreed;
    }  
    
    public String prepareRabbitsBreedsOverview(){
        this.recreateRabbitsBreedsModel();
        return "rabbitsBreedsOverview";
    }
    
    public String viewRabbitsBreed(){
        currentRabbitsBreed = (RabbitsBreed)getRabbitsBreeds().getRowData();
        return "viewRabbitsBreed";
    }
     
    public String prepareCreateRabbitsBreed(){
        currentRabbitsBreed = new RabbitsBreed(); 
        return "createRabbitsBreed";
    }

    public String createRabbitsBreed() {
        try {
            this.rabbitsBreedRepository.insert(currentRabbitsBreed);
            return this.prepareRabbitsBreedsOverview(); 
        } catch (Exception e) {
            return null;
        }
    }
    
    public String prepareEditRabbitsBreed(){
        currentRabbitsBreed = (RabbitsBreed)getRabbitsBreeds().getRowData();
        return "editRabbitsBreed";
    }
    
    public String editRabbitsBreed() {
        try {
            this.rabbitsBreedRepository.update(currentRabbitsBreed);
            //JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ContactCreated"));
            return this.prepareRabbitsBreedsOverview();
        } catch (Exception e) {
            //JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    
    public String deleteRabbitsBreed() {
        currentRabbitsBreed = (RabbitsBreed)getRabbitsBreeds().getRowData();
        //selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDeleteRabbitsBreed();
        this.recreateRabbitsBreedsModel();
        return "rabbitsBreedsOverview";
    }
    
    private void performDeleteRabbitsBreed() {
        try {
            rabbitsBreedRepository.delete(currentRabbitsBreed);
            //JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ContactDeleted"));
        } catch (Exception e) {
            //JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }
    
    public DataModel getRabbitsBreeds() {
        if (rabbitsBreeds == null) {
            rabbitsBreeds = new ListDataModel<>(rabbitsBreedRepository.findAll());
        }
        return rabbitsBreeds;
    }

    private void recreateRabbitsBreedsModel() {
        rabbitsBreeds = null;
    }
    
    
    
}
