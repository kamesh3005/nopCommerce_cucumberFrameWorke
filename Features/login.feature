Feature:  Login with valid credentials


@sanity
	Scenario: successfully login with valid credentials
		Given user launch browser
		And open url "https://demo.nopcommerce.com/"
		When click to login menu
		And user enter email as "kameshkam3094@gmail.com" and password as "Kamesh@30"
		And click on login button
		Then user navigate to my accout page



