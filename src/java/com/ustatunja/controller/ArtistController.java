package com.ustatunja.controller;

import com.ustatunja.entity.Artist;
import com.ustatunja.entity.ProductType;
import com.ustatunja.facade.ArtistFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ArtistController {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ArtistFacade objFacade;
    private Artist objCurrent;
    
    public ArtistController() {
    }
    
    public String add(Artist object) {
        String title, detail;
        
        try {
            title = "¡Exito! \n";
            detail = "Se ha guardado correctamente";
            getObjFacade().add(object);
            return title + detail;
            
        } catch (Exception e) {
            title = "¡Error! \n";
            detail = "Ha ocurrido un error al guardar.";
            return title + detail;
        }
        
    }
    
    public List<Artist> list() {
        return getObjFacade().loadAll();
    }
    
    public ArtistFacade getObjFacade() {
        return objFacade;
    }
    
    public String deleteArtist(Artist objectArtist) {
        String title, detail;
        
        if (objectArtist.getArtOrderCollection().size() == 0) {
            try {
                this.objCurrent = objectArtist;
                title = "¡Exito! \n";
                detail = "Se ha borrado correctamente";
                
                getObjFacade().delete(objectArtist);
                this.objCurrent = new Artist();
                return title + detail;
                
            } catch (Exception e) {
                title = "¡Error! \n";
                detail = "Ha ocurrido un error al eliminar.";
                return title + detail;
            }
            
        } else {
            title = "¡Error! \n";
            detail = "Hay objetos asociados a este artista.";
            return title + detail;
            
        }
    }
    
    public String updateArtist(Artist objectArtist) {
        String title, detail;
        try {
            
            title = "¡Exito! \n";
            detail = "Se ha actualizado correctamente";
            getObjFacade().update(objectArtist);
            return title + detail;
            
        } catch (Exception e) {
            title = "¡Error! \n";
            detail = "Ha ocurrido un error al actualizar.";
            return title + detail;
        }
        
    }
    
    public Artist findArtist(Integer id) {
        return getObjFacade().find(id);
    }
    
}
