/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacadesSplitPay.NegocioFinalDebtResolution;

import Entities.Transaccion;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Viviana
 */
@Remote
public interface TransaccionFacadeRemote {

    void create(Transaccion transaccion);

    void edit(Transaccion transaccion);

    void remove(Transaccion transaccion);

    Transaccion find(Object id);

    List<Transaccion> findAll();

    List<Transaccion> findRange(int[] range);

    int count();
    
}
