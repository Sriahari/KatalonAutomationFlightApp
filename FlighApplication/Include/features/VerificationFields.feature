Feature: Validate the Mandatory Fields

  @Test1
  Scenario: TC01_Verify the Mandatory filed present in the page
    Given Open Browser
    When Verify the Mandatory fields
    Then Verify the dropdown values of Soultions

  #@Test2
  #Scenario: TC02_Verify the Shop Now Field on application
    #Given Open Browser
    #When Click on Solutions Tab
    #Then Verify the dropdown values of Soultions
    #Then Verify the Shop Now Field on Solutions Tab
#
  #@Test3
  #Scenario: TC03_Verify the Flight Field Section and Contact Us
    #Given Open Browser
    #When Verify the Contact Us Section
    #Then Navigate back
    #Then Verify the Flight Feed Section
