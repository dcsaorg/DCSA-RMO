# DCSA RMO - Reefer Monitoring Operational

## Build and Run the Project

```
mvn clean package

java -jar application/target/dcsa-rmo-application.jar

curl http://localhost:9090/rmo/v3/events?equipmentReference=APZU4812090
```

## Security Considerations

This reference implementation does not do any authentication/authorization and should not be used in production as is. Using this as is in production would expose data for all parties to all other parties without checking whether they should have access.

