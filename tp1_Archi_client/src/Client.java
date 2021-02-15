import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/

public class Client  {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		 try {
			 
			String path = "tp1_Archi_client/src/security.policy";
			File f = new File(path);
			if(!f.exists()) f = new File("src/security.policy");
		    if(!f.exists()) System.out.println("Veuillez modifier le path pour qu'il positionne sur security.policy");
			System.out.println(f.getAbsolutePath());
		    System.setProperty("java.security.policy",f.getAbsolutePath());
		    SecurityManager securityManager = new SecurityManager();
		    System.setSecurityManager(securityManager);
			Registry registry = LocateRegistry.getRegistry(null);
		    Cabinet c =(Cabinet) registry.lookup("Cabinet");
		    System.out.println("Login : \nVeuillez saisir votre nom :");
		    String name= scanner.nextLine();
		    Iclient l = new Login(name);
		    c.register(l);
		    String n = c.search("Rox","Dala");
		    System.out.println(n);
			System.out.println("L'ajout d'un l'animal");
		    c.addPatient("Rox", "Dala", "Suivie Dala",new SousEspece("Chat", 12),"Chartreux");
			//Recupération de l'animale ajouter
			Animal a = c.getAnimal("Rox", "Dala", "Chartreux");
			//Recuperation du dossier de l'animal
			if(a!=null){
			System.out.println("Affichage de l'animal ajouter :");
			System.out.println(a.affichier());
			System.out.println("Affichage du dossier de l'animal " + a.getName()+" :");
			DossierSuivi d =a.getDossier();
			System.out.println(d.getSuivie());
			}
		 } catch (Exception e) {
			 e.printStackTrace();
		}
	 
}

	
}
