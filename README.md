# hw-14
Employees class: ID , name , age , position , onLeave, employmentYear ,annualLeave

Validation :

ID :
Cannot be null

Length more than 2

name :
Cannot be null

Length more than 4

age :
Cannot be null

It has to be number

It must be more than 25

position :
Cannot be null

must be supervisor or coordinator only

onLeave :
must be false

employmentYear :
Cannot be null

it has to be number

must be a valid year

annualLeave:
Cannot be null

it has to be number

Endpoints :<br>
Get all the Employees<br>
Add new Employee<br>
Update Employee<br>
Delete Employee<br>
Employees apply for an annual leave and and turn their onLeave status to true and reduce annualLeave by 1 (Check if employee is on leave return bad request, if employee applies for leave and has 0 days return bad request)
