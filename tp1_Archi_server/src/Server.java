import java.io.File;
import java.net.URL;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/
public class Server {
	
	public static void setPolicy() {
		
		String path = "tp1_Archi_server/src/security.policy";
	    File file = new File(path);
	    if(!file.exists()) file = new File("src/security.policy");
	    if(!file.exists()) System.out.println("Veuillez modifier le path pour qu'il positionne sur security.policy");
        System.setProperty("java.security.policy",file.getAbsolutePath());
        SecurityManager securityManager = new SecurityManager();
        System.setSecurityManager(securityManager);
    
	}
	public static void main(String[] args) {
		try {
			
			String path = "./tp1_Archi_client/bin/";
			File f= new File(path);
			if(!f.exists()) {
				f= new File("../tp1_Archi_client/bin/");
			}
		    if(!f.exists()) System.out.println("Veuillez modifier le path pour qu'il positionne sur le bin du client");
			URL file= new File(f.getCanonicalPath()).toURI().toURL();
			System.out.println(file);
			System.setProperty("java.rmi.server.codebase",file.toString());
			CabinetImp cab = new CabinetImp();
			//AnimalImp animal1 = new AnimalImp("eduard","rox",new DossierSuiviImp("Dossier Suivie1 .."),new Espece("Chat", 12),"Chartreux");
			//cab.add(animal1);
			//AnimalImp animal2 = new AnimalImp("dvd","roix",new DossierSuiviImp("Dossier Suivie2 .."),new Espece("Chat", 12),"Chartreux");
			//cab.add(animal2);
			setPolicy();
			Registry registry = LocateRegistry.createRegistry(1099);
			if(registry == null)
				System.err.println("RmiRegistry not found");
			else
			{
			registry.bind("Cabinet",cab);
			System.out.println("Server ready !");
			}
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}
}
