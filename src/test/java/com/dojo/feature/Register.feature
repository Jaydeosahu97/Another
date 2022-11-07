Feature: Registration in Bank Management System
Customer should be able to register in bank when all the requied fields are filled properly

Scenario: Registration with all the details filled
Given Customer provide valid details
When customer submit the details
Then Registration will be successful

Scenario: Registration with wrong password pattern
