# Summary
An inventory management web-app using Java and the Spring MVC framework with CRUD functionality. Although this web-app implements session control, the database does not persist and reverts back to the original state of pre-loaded inventory when the server is restarted.

<img src="#" height="350">
<img src="#" height="350">

## In This Document
1. [How to Execute](#how-to-execute)
2. [Class Structure Overview](#class-structure-overview)

## How to Execute
- The web-app is hosted on: insert URL <a href="http://52.43.150.156:8080/InventoryMGRSpringMVCCRUD/">**here**</a>
- Download the entire program as a .war file <a href="InventoryMGRSpringMVCCRUD.war">**here**</a>

## Instructions
1. User arrives on landing page.
2. User menu:
    - View All Products
    - View Details of a Product
    - Add New Product
    - Delete Product

## Class Structure Overview
- The **ProductIMSController** class is the controller and interacts with the **ProductDAOImpl** class which implements methods declared in the **ProductDAO** interface. The product and list objects are constructed using information from the **Product** class and accompanying .csv file pre-loaded with inventory information.
- The **ProductIMSController** provides information back through **.jsp** files for the user to view and manipulate.

<img src="WebContent/images/chart.png" height="400">

## Code Examples
**example of some code**
