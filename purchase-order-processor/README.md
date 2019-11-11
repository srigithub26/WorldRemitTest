::Purchase order processor::

Design and implement a rule processing engine based on given rules for purchase orders.

Purchase order contains details about customer, product line items.
After that I have created rules processing engine for given two rules. This engine is extendable for any number of rules.

Design:
Attaching UML design diagrams
PurchaseOrderProcessor-Sequence Diagram.pdf
PurchaseOrderProcessor-Class Diagram.pdf

Implement
This rules engine consumes Spring boot restful API given in this folder structure and gives the intended results
when request comes from client like Advanced Rest Client or Postman.

Details of URL and request format and response are given below.


How to run:

Its springboot restful API application serving purchase order processing business rules.
•	BR1. If the purchase order contains a membership, it has to be activated in the customer account immediately.
•	BR2. If the purchase order contains a physical product a shipping slip has to be generated.

1)Import into editor like eclipse, 
2)Select project and right click -> Run As->maven build
give mvn clean install
It will clean build the project and creates .jar file of purchase-order-processor-0.0.1-SNAPSHOT.jar

This .jar file is our application to be run as spring boot microservice.

3)click Run as Java application on PurchaseOrderProcessor.java file which is starting point of application.
4)Use Advance Rest Client or Postman,
Select Method:POST 
Request URL:  http://localhost:8080/processPurchaseOrder
Body content type: application/json
Json Body: 
{
  "id": 3344656,
  "total": 48.50,
  "customer": {
    "id": 4567890,
    "loyaltyPoints": 0
  },
  "lineItems": [
    {
      "productCategory": 0,
      "productType": 1,
      "productName":"Comprehensive First Aid Training",
      "shippingSlipGenerated":false
    },
    {
      "productCategory": 0,
      "productType": 0,
      "productName":"The Girl on the train",
      "shippingSlipGenerated":false
    },
    {
      "productCategory": 1,
      "productType": 0,
      "productName":"Club Membership",
      "shippingSlipGenerated":false
    },
    {
      "productCategory": 2,
      "productType": 0,
      "productName":"Club Membership",
      "shippingSlipGenerated":false
    }
  ]
}

click SEND

5) we get output as below:

{
"id": 3344656,
"total": 48.5,
"customer": {
"id": 4567890,
"membership": "PREMIUM",
"loyaltyPoints": 0
},
"lineItems": [
  {
"productCategory": "PHYSICAL",
"productType": "VIDEO",
"productName": "Comprehensive First Aid Training",
"shippingSlipGenerated": true
},
  {
"productCategory": "PHYSICAL",
"productType": "BOOK",
"productName": "The Girl on the train",
"shippingSlipGenerated": true
},
  {
"productCategory": "BOOK_CLUB",
"productType": "BOOK",
"productName": "Club Membership",
"shippingSlipGenerated": false
},
  {
"productCategory": "VIDEO_CLUB",
"productType": "BOOK",
"productName": "Club Membership",
"shippingSlipGenerated": false
}
],
}

Explanation: Here we sent 4 line items(physical video, physical book, book club membership, video club membership)
The microservice ran the rules BR1: which tells we need to activate respective membership for customer
and BR2: which tellls we need to generate shippingSlip or shippingSlipGenerated becomes true;

Thus this application gives output for given two rules as expected. Its flexible to honour other new rules with minimum effort of changing
or adding to .drl file(s).