Feature:  Login by using dataTable



	Scenario: successfully login by using data table
		Given user launch browser
		And open url "https://demo.nopcommerce.com/"
		When click to login menu
		And user enter emailand password
		|kameshkam3094@gmail.com| Kamesh@3012|
		And click on login button
		Then user navigate to my accout page