package PresentationTier;
import java.util.ArrayList;
import java.util.Scanner;

import LogicTier.LogicInterface;
import MenuPackage.Menu;
import MainPackage.Promotion;
import MainPackage.Studient;

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
				for(int i = 0; i < _logicInterface.getPromotions().size(); i++)
					System.out.println(_logicInterface.getPromotion(i).getAcronym());
				break;
				
			case 1:
				System.out.print("Acronyme: ");
				Promotion found = _logicInterface.getPromotion(_scanner.next());
				if(found.isNull())
					System.out.println("Aucune promotion trouv�e");
				else
					System.out.println(found);
				break;
				
			case 2:
				System.out.println("Nouvelle promotion: \nIntitul�: ");
				String entitled = _scanner.next();
				System.out.println("\nAcronyme: ");
				String acronym = _scanner.next();
				_logicInterface.addPromotion(new Promotion(entitled, acronym));
				break;
			
			case 3:
				if(_logicInterface.getPromotions().size() > 0)
				{
					//Student grabbing part
					System.out.println("Cr�er un �l�ve\nPr�nom: ");
					String firstName = _scanner.next();
					System.out.println("Nom: ");
					String lastName = _scanner.next();
					
					//Promotion menu part 
					Menu promotionsMenu = new Menu();
					for(int i = 0; i < _logicInterface.getPromotions().size(); i++)
						promotionsMenu.addChoice(_logicInterface.getPromotion(i).getAcronym());
					
					//User selection of a promotion part
					Studient toAdd = new Studient(firstName, lastName);
					int promotionIndex = promotionsMenu.display("Choisissez une promotion o� inscrire " + toAdd);
					
					_logicInterface.addToPromotion(promotionIndex, toAdd);
				}
				else
				{
					System.out.println("Aucune promotion n'existe, veuillez d'abord en cr�er.\n");
					_scanner.next();
				}
				break;
				
			case 4:
				for(int i = 0; i < _logicInterface.getPromotions().size(); i++)
					System.out.println(_logicInterface.getPromotion(i));
				break;
			}
		}
	}
}