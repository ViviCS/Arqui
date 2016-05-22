/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacadesSplitPay.NegocioFinalDebtResolution;

import Entities.Grupo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Viviana
 */
@Remote
public interface FachadaFinalDebtResolutionRemote {
     public List<Grupo> listarGrupos();        
}
