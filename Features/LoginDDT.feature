Feature: Login Data Driven Test

Scenario Outline: Login with different credentials

Given User launch the chromebrowser
When User open the URL "http://localhost:5000/admin"
And User enetrs email as "<email>" and password as "<password>"
And Click on Login
Then User should see "<result>"
And close browser

Examples:
| email                  | password | result  |
| admin@yourStore.com    | admin    | Success |
| admin@yourStore.com    | admin123 | Failure |
| wrong@gmail.com        | admin    | Failure |
|                        | admin    | Failure |
| admin@yourStore.com    |          | Failure |