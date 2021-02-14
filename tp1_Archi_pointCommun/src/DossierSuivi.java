
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/

public interface DossierSuivi extends Remote{

	public String getSuivie()throws RemoteException ;
	public void addSuivie(String s)throws RemoteException ;
}
