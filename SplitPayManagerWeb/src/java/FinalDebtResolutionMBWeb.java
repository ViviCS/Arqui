/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entities.Grupo;
import FacadesSplitPay.NegocioFinalDebtResolution.FachadaFinalDebtResolutionRemote;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Viviana
 */
@Named(value = "finalDebtResolutionMBWeb")
@Dependent
public class FinalDebtResolutionMBWeb {
    private int id;
    private List<Grupo> grupos;
    /**
     * Creates a new instance of FinalDebtResolutionMBWeb
     */
    public FinalDebtResolutionMBWeb() {
        grupos = new ArrayList<Grupo>();
        listarGrupos();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    public void listarGrupos(){
           
//        List<Grupo> grupos;
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SplitPayManagerPU");
//        EntityManager em = emf.createEntityManager();        
//        Query q = em.createQuery("SELECT g FROM Grupo g");
//        grupos = new ArrayList<Grupo>();
//        grupos = (List<Grupo>)q.getResultList();
//        return grupos;
        try {
            System.out.println("Hola1");
            InitialContext ic = new InitialContext();
            FachadaFinalDebtResolutionRemote bean = (FachadaFinalDebtResolutionRemote) ic.lookup("global\\SplitPayManager\\FachadaFinalDebtResolution!FacadesSplitPay.NegocioFinalDebtResolution.FachadaFinalDebtResolutionRemote");
            
            grupos = bean.listarGrupos();
            
        } catch (Exception ex) {
            Logger.getLogger(FinalDebtResolutionMBWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
}
