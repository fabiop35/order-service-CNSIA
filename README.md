CNSIA: CH08 Order-Service, Feature that eneables the possibility to purchasing Books using Reactive Spring, WebFlux, Spring Data R2DBC,and WebClient.

#Create an independent DB in order to store order's info. database-per-service approach.
pg_ctl -D ~/postgres_data -l ~/logfile start
createdb polardb_order

#Submitting an Order
curl http://localhost:9002/orders -d '{"isbn":"1234567891", "quantity":3}' -H "Content-Type: Application/json"

http POST :9002/orders isbn=1234567890 quantity=3

http POST :9002/orders isbn=1234567891 quantity=3

#get orders
curl http://localhost:9002/orders

#Added Provider class: OrderService Method: publishOrderAcceptedEvent. 
#Produces an event when the order is accepted.

#Adder consumer class: OrderFunctions Method: dispatchOrder.
#Updates the order status.

#Create a JWt (ToDo)
curl http://localhost:8080/realms/PolarBookshop/protocol/openid-connect/token -u edge-service:polar-keycloak-secret -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=password&username=isabelle&password=password"
