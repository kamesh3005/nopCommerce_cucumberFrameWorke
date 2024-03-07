Feature:  Valoidate the login functionality passing multiple set of data



	Scenario Outline: login with Data driven test
		Given user launch browser
		And open url "https://demo.nopcommerce.com/"
		When click to login menu
		And user enter email as "<username>" and password as "<password>"
		And click on login button
		Then user navigate to my accout page
		
		Examples:
		|						username							|				password						|
		|		kameshkam3094@gmail.com				|		Kamesh@30								|
		|		charuck1430@gmail.com					|		Charu@1430							|
		