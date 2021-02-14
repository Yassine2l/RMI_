import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/

public interface Iclient extends Remote{
  void inform(int i) throws RemoteException;
}
