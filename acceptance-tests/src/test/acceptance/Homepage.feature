Feature: Fonctionnalités de ma page d'accueil
	Scenario: Vérification du titre et de la description
		Given je suis sur la homepage
		Then le titre doit être "Partagez vos passions | Meetup"
		And la description doit être "Partagez vos passions et faites bouger votre ville ! Meetup vous aide à rencontrer des personnes près de chez vous, autour de vos centres d'intérêt."

	Scenario: Vérification des punchlines
		Given je suis sur la homepage
		Then le header doit être "Vous avez une passion ?"
		And la sous punchline doit être "Lancez-vous avec Meetup"

	Scenario: Accéder aux événements près de chez soi depuis la page d'accueil
		Given je suis sur la homepage
		And le bloc des meetups près de chez soi est présent
		When je clic sur le bouton "voir tout"
		Then je suis sur la page "https://www.meetup.com/fr-FR/find/"
		And la recherche est initialisé sur un rayon de "5km" autour de "Bagneux, FR"

