import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/

public class Login extends UnicastRemoteObject implements Iclient{
    private String name;
	public Login(String name) throws RemoteException {
		
		this.name=name;
	}

	@Override
	public void inform(int i) {
		System.out.println(name +" Le cabinet a "+i+" patient !");
		
	}

}
