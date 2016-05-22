/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacadesSplitPay.NegocioFinalDebtResolution;

import Entities.Grupo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Viviana
 */
@Stateless
public class FachadaFinalDebtResolution implements FachadaFinalDebtResolutionRemote {

    @Resource(mappedName = "jms/ColaPushNotification")
    private Queue colaPushNotification;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;
    private String mensaje;
    public FachadaFinalDebtResolution() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public void send(){
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        try {
//             sendJMSMessageToMyQueue(mensaje);
//             FacesMessage facesMessage = new FacesMessage("Message sent: " + mensaje);
//             facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
//             facesContext.addMessage(null, facesMessage);
//        } catch (Exception jmse) {
//             FacesMessage facesMessage = new FacesMessage("Message NOT sent: " + mensaje);
//             facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
//            facesContext.addMessage(null, facesMessage);
//        }
    }

    private void sendJMSMessageToColaPushNotification(String messageData) {
        context.createProducer().send(colaPushNotification, messageData);
    }

    @Override
    public List<Grupo> listarGrupos() {        
        List<Grupo> grupos;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SplitPayManagerPU");
        EntityManager em = emf.createEntityManager();        
        Query q = em.createQuery("SELECT g FROM Grupo g");
        grupos = new ArrayList<Grupo>();
        grupos = (List<Grupo>)q.getResultList();
        return grupos;
    }
    
}
