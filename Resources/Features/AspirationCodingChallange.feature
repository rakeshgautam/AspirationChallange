Feature: Aspiration Coding Challange
@AspirationTest
  Scenario Outline: Task1
    Given User is on the Aspiration home page
    When User clicks on Spead and Save 
    Then User should be able to see all products <ProductList>
    When User clicks on Get Aspiration link
    Then User should be able to see Email signbox box
    When User clicks on Get AspirationPlus link
    Then User should be able to see all Monthly <MonthlyPlan> and Yearly plan <YearlyPlan> 
    Examples: 
    |ProductList                     |MonthlyPlan|YearlyPlan|
    |"AspirationCard,Aspiration Plus"|"$7.99"    |"$71.88"  |
  
 @AspirationTest   
  Scenario Outline: Task2
    Given User sends get request to SWAPI people method
    When User gets success response with Status code as <StatusCode>
    Then People having Height greater than Two Hundereds is <MoreThan200Height>
    Then Verify returned name conatins <PeoplesName>
    Then Verify Total number of people Count <TotalPeopleCount>
    Examples: 
    |StatusCode  |MoreThan200Height|PeoplesName                                                                                                             |TotalPeopleCount|
    |"200"       |"1"              |"Luke Skywalker,C-3PO,R2-D2,Darth Vader,Leia Organa,Owen Lars,Beru Whitesun lars,R5-D4,Biggs Darklighter,Obi-Wan Kenobi"|"82"            |
    
    