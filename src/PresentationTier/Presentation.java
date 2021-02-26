package PresentationTier;
import java.util.ArrayList;
import java.util.Scanner;

import LogicTier.LogicInterface;
import MenuPackage.Menu;
import MainPackage.Promotion;

public class Presentation
{
	private LogicInterface _logicInterface;
	private Scanner _scanner;
	
	public Presentation(LogicInterface logicInterface)
	{
		_logicInterface = logicInterface;
		_scanner = new Scanner(System.in);
	}
	
	public void menu()
	{
		Menu mainMenu = new Menu();
		mainMenu.addChoice("Afficher les acronymes de chaque promotion");
		mainMenu.addChoice("Rechercher une promotion par son acronyme");
		mainMenu.addChoice("Ajouter une nouvelle promotion");
		mainMenu.addChoice("Cr�er, puis inscrire un �tudiant � une promotion");
		mainMenu.addChoice("Voir tous les �tudiants de l'�cole");
		mainMenu.addExit("Quitter");
		while(!mainMenu.leaving())
		{
			switch(mainMenu.display("Mais... que faire ?\n"))
			{
			case 0:
				break;
				
			case 1:
				System.out.print("Acronyme: ");
				Promotion found = _logicInterface.getPromotion(_scanner.next());
				if(found.isNull())
					System.out.println("Aucune promotion trouv�e");
				else
					System.out.println(found);
				break;
			}
		}
	}
}