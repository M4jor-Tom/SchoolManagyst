package PresentationTier;
import java.rmi.RemoteException;
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
		setLogicInterface(logicInterface);
		setScanner(new Scanner(System.in));
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
			try
			{
				switch(mainMenu.display("Mais... que faire ?\n"))
				{
				case 0:
					for(int i = 0; i < getLogicInterface().getPromotions().size(); i++)
						System.out.println(getLogicInterface().getPromotion(i).getAcronym());
					break;
					
				case 1:
					System.out.print("Acronyme: ");
					Promotion found = getLogicInterface().getPromotion(_scanner.next());
					if(found.isNull())
						System.out.println("Aucune promotion trouvée");
					else
						System.out.println(found);
					break;
					
				case 2:
					System.out.println("Nouvelle promotion: \nIntitulé: ");
					String entitled = getScanner().next();
					System.out.println("\nAcronyme: ");
					String acronym = getScanner().next();
					getLogicInterface().addPromotion(new Promotion(entitled, acronym));
					break;
				
				case 3:
					if(getLogicInterface().getPromotions().size() > 0)
					{
						//Student grabbing part
						System.out.println("Créer un élève\nPrénom: ");
						String firstName = getScanner().next();
						System.out.println("Nom: ");
						String lastName = getScanner().next();
						
						//Promotion menu part 
						Menu promotionsMenu = new Menu();
						for(int i = 0; i < getLogicInterface().getPromotions().size(); i++)
							promotionsMenu.addChoice(getLogicInterface().getPromotion(i).getAcronym());
						
						//User selection of a promotion part
						Studient toAdd = new Studient(firstName, lastName);
						int promotionIndex = promotionsMenu.display("Choisissez une promotion où inscrire " + toAdd);
						long promotionId = getLogicInterface().getPromotion(promotionIndex).getId();
						
						for(Promotion promotion: getLogicInterface().getPromotions())
							System.out.println("Promotion: " + promotion + " promotionIndex = " + promotionIndex);
						
						getLogicInterface().addToPromotion(promotionId, toAdd);
					}
					else
					{
						System.out.println("Aucune promotion n'existe, veuillez d'abord en créer.\n");
						getScanner().next();
					}
					break;
					
				case 4:
					for(int i = 0; i < getLogicInterface().getPromotions().size(); i++)
						System.out.println(getLogicInterface().getPromotion(i));
					break;
				}
			}
			catch(RemoteException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public LogicInterface getLogicInterface()
	{
		return _logicInterface;
	}
	
	public void setLogicInterface(LogicInterface logicInterface)
	{
		_logicInterface = logicInterface;
	}
	
	public Scanner getScanner()
	{
		return _scanner;
	}
	
	public void setScanner(Scanner scanner)
	{
		_scanner = scanner;
	}
}