package PresentationTier;
import LogicTier.LogicInterface;
import MenuPackage.Menu;

public class Presentation
{
	private LogicInterface _logicInterface;
	
	public Presentation(LogicInterface logicInterface)
	{
		_logicInterface = logicInterface;
	}
	
	public void menu()
	{
		Menu mainMenu = new Menu();
		mainMenu.addChoice("Afficher les acronymes de chaque promotion");
		mainMenu.addChoice("Rechercher une promotion par son acronyme");
		mainMenu.addChoice("Ajouter une nouvelle promotion");
		mainMenu.addChoice("Créer, puis inscrire un étudiant à une promotion");
		mainMenu.addChoice("Voir tous les étudiants de l'école");
		mainMenu.addExit("Quitter");
		while(!mainMenu.leaving())
		{
			switch(mainMenu.display("Mais... que faire ?\n"))
			{
			
			}
		}
	}
}