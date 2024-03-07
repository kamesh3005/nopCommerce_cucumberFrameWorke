Feature: Registation featue
@sanity @regression
	Scenario: validate the registation functionality
		Given user launch browser
		And open url "https://demo.nopcommerce.com/"
		When click on register link
		And click on toggle gender 
		When enetr the first name and last name
		And Select the data of birth
		When enter the email id
		And enter the company name
		And enter password and conform password
		Then click registation button
		
		

