
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/
public class DossierSuiviImp extends UnicastRemoteObject implements DossierSuivi  {

	String suivie ;
	protected DossierSuiviImp(String s) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.suivie="["+LocalDate.now()+"] :"+ s ;
	}


	@Override
	public String getSuivie() throws RemoteException {
		// TODO Auto-generated method stub
		return suivie;
	}


	@Override
	public void addSuivie( String s) throws RemoteException {
		// TODO Auto-generated method stub
		this.suivie = this.suivie +"\n["+LocalDate.now()+"] :"+ s ;
	}
	
	
}
