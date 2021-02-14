import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/

public interface Animal extends Remote{
   String getName() throws RemoteException;
   String getMaitre() throws RemoteException;
   void setDossier(DossierSuivi dossier) throws RemoteException;
   DossierSuivi getDossier() throws RemoteException;
   Espece getEspece() throws RemoteException;
   String getRace() throws RemoteException;
}
