# purchase order processor
Attaching UML model diagrams
PurchaseOrderProcessor-Sequence Diagram.pdf
PurchaseOrderProcessor-Class Diagram.pdf

How to run:
Its springboot restful API application serving purchase order processing business rules.
•	BR1. If the purchase order contains a membership, it has to be activated in the customer account immediately.
•	BR2. If the purchase order contains a physical product a shipping slip has to be generated.

Import into editor like eclipse, 
click Run as Java application on PurchaseOrderProcessor.java file which is starting point of application.
Use Advance Rest Client or Postman,
Send POST request to http://localhost:8080/processPurchaseOrder
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


OUTPUT:
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