curl https://start.spring.io/starter.zip -o order-service-CNSIA.zip -d type=gradle-project -d dependencies=devtools,actuator,data-r2dbc,webflux,validation -d groupId=cnsia -d description="CNSIA: Ch08, Reactive Spring. Purchasing books" -d bootVersion=3.1.6 -d packageName=com.cnsia.orderservice -d artifactId=order-service-CNSIA -d name=order-service-CNSIA -d javaVersion=17


#List of all available dependencies
curl -H 'Accept: application/json' https://start.spring.io | jq '.dependencies.values[].values[].id'
