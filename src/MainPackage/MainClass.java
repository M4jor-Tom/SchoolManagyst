package MainPackage;

//3-Tier Implementation
import PresentationTier.Presentation;
import LogicTier.LogicInterface;
import DataTier.DataInterface;

//Menu implementation
import MenuPackage.Menu;

public class MainClass
{
	public static void main(String[] args)
	{
		Menu mainMenu = new Menu();
		mainMenu.addChoice("Afficher les acronymes de chaque promotion");
		mainMenu.addChoice("Rechercher une promotion par son acronyme");
		mainMenu.addChoice("Ajouter une nouvelle promotion");
		mainMenu.addChoice("Créer, puis inscrire un étudiant à une promotion");
		mainMenu.addChoice("Voir tous les étudiants de l'école");
		mainMenu.addExit("Quitter");
		while(!mainMenu.leaving())
			mainMenu.display("Mais... que faire ?\n");
	}
}