/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacadesSplitPay.NegocioFinalDebtResolution;

import Entities.Transaccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Viviana
 */
@Stateless
public class TransaccionFacade extends AbstractFacade<Transaccion> implements FacadesSplitPay.NegocioFinalDebtResolution.TransaccionFacadeRemote {

    @PersistenceContext(unitName = "SplitPayManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionFacade() {
        super(Transaccion.class);
    }
    
}
