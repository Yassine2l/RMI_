import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/

public interface Cabinet extends Remote{
  String search(String name,String master) throws RemoteException;
  void addPatient(String name, String Master, String Dossier, Espece e,String race) throws RemoteException;
  void register(Iclient client) throws RemoteException;
  void unregister(Iclient client) throws RemoteException;
  void alert() throws RemoteException;
  void remove(String nom,String Master)throws RemoteException;
  Animal getAnimal(String name,String master,String Race) throws RemoteException;
}
