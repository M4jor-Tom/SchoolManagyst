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
		mainMenu.addChoice("Cr�er, puis inscrire un �tudiant � une promotion");
		mainMenu.addChoice("Voir tous les �tudiants de l'�cole");
		mainMenu.addExit("Quitter");
		while(!mainMenu.leaving())
			mainMenu.display("Mais... que faire ?\n");
	}
}