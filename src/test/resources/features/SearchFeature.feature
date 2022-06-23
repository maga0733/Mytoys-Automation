
 Feature: Search and add item


   Background:
     Given the customer is on Homepage


     Scenario: Search an item
       When  the customer serach for "trampolin"
       Then the customer clicks search button
       And the customer sorts by "Höchster Preis"



     Scenario: Add an item to shopping cart
       When  the customer serach for "trampolin"
       Then the customer clicks search button
       And the customer sorts by "Höchster Preis"
       When the customer clicks preis dropdown
       And the customer set the price between "500" and "1000"
       Then the customer selects "1" product


   @wip
     Scenario Outline: Item should be in the right category
       When  the customer serach for "<search item>"
       And the customer clicks search button
       Then the search result should contain "<search item>"
     Examples:
       |search item  |
       | trampolin   |


