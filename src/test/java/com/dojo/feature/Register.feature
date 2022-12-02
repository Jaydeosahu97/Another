Feature: Registration in Bank Management System
  Customer should be able to register in bank when all the requied fields are filled properly

  Scenario Outline: Customer Registration with valid details
    Given Customer provide <detail> details
    When customer submit the details
    Then Registration <status>

    Examples: 
      | detail   | status     |
      | new      | successful |
      | existing | failure    |
      | empty    | failure    |

  Scenario Outline: Customer Provide invalid details
    Given Customer provide invalid <field>
    When customer submit the details
    Then Error message with bad Request shown

    Examples: 
      | field    |
      | password |
      | pan      |
      | email    |
