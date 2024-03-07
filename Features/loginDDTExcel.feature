Feature:  Login Data driven with excel



	Scenario Outline: Login Data driven with excel
		Given user launch browser
		And open url "https://demo.nopcommerce.com/"
		When click to login menu
		Then cheek user has navigates to MyAccount page by passing Email and Password with excel row "<row_index>"
		
		Examples:
			|row_index|
			|1|
			|2|
			|3|
			|4|
			|5|
			 