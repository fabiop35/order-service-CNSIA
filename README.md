CNSIA: CH08 Order-Service, Feature that eneables the possibility to purchasing Books using Reactive Spring, WebFlux, Spring Data R2DBC,and WebClient.

#Create an independent DB in order to store order's info. database-per-service approach.
pg_ctl -D ~/postgres_data -l ~/logfile start
createdb polardb_order

#Submitting an Order
curl http://localhost:9002/orders -d '{"isbn":"1234567890", "quantity":3}' -H "Content-Type: Application/json"

http POST :9002/orders isbn=1234567890 quantity=3

http POST :9002/orders isbn=1234567891 quantity=3

