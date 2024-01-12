package org.dcsa.rmo.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.dcsa.rmo.exception.DomainError;
import org.dcsa.rmo.exception.RequestFailureTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${spring.application.context-path}")
public class EventController {

  @GetMapping(path = "/events")
  @ResponseStatus(HttpStatus.OK)
  public Object getEvent(
      @RequestParam("equipmentReference") String equipmentReference, HttpServletRequest request) {

    // Return a "not found" response if the sample equipment reference was not provided.
    if (!equipmentReference.equals("APZU4812090")) {

      final RequestFailureTO failureTO =
          new RequestFailureTO(
              request.getMethod(),
              request.getRequestURI(),
              List.of(
                  new DomainError(
                      "No record found with equipment reference '" + equipmentReference + "'")),
              HttpStatus.NOT_FOUND);

      return new ResponseEntity<>(failureTO, HttpStatus.NOT_FOUND);
    }

    // Otherwise, return the sample response.
    return """
{
  "alarms": {
    "activeAlarmCount": 0,
    "activeAlarms": [
      {
        "alarmDate": "2023-10-23T15:40:28Z",
        "alarmNumber": "N999",
        "alarmSeverity": "ALARM"
      }
    ]
  },
  "controller": {
    "dateTime": "2023-10-23T15:40:28Z",
    "hardwareVersion": "1.1.1",
    "maker": "900",
    "model": "N99",
    "operatingState": "1",
    "serialNumber": "123456789",
    "softwareVersion": "1.1.1"
  },
  "equipmentReference": "APZU4812090",
  "equipmentOptions": [
    "N00",
    "N05"
  ],
  "geoLocation": {
    "latitude": "48.858550",
    "longitude": "2.294492"
  },
  "isConnectedToPowerSource": true,
  "lastDefrostDateTime": "2023-10-23T15:40:28Z",
  "measurements": {
    "ambientTemperature": 12,
    "temperature": 5,
    "temperatureUnit": "CEL",
    "o2": 20,
    "co2": 25,
    "relativeHumidity": 98,
    "airExchange": 0,
    "airExchangeUnit": "MQH",
    "cargoProbe1Temperature": 6,
    "cargoProbe2Temperature": 6,
    "cargoProbe3Temperature": 6,
    "currentPhaseA": 15,
    "currentPhaseB": 15,
    "currentPhaseC": 15,
    "dischargePressure": 21,
    "dischargeTemperature": 10,
    "evaporatorTemperature": 10,
    "lineFrequency": 60,
    "lineVoltage": 400,
    "returnProbe1Temperature": 10,
    "returnProbe2Temperature": 10,
    "returnTemperature": 10,
    "suctionPressure": 60,
    "suctionTemperature": 10,
    "supplySensor1Temperature": 10,
    "supplySensor2Temperature": 10,
    "supplyTemperature": 10
  },
  "setpoints": {
    "temperature": -15,
    "temperatureUnit": "CEL",
    "o2": 20,
    "co2": 25,
    "humidity": 96
  },
  "reeferSettings": {
    "controlledAtmosphereMode": "ON",
    "isDefrosting": false,
    "efficiencySetting": 2
  },
  "unitModel": "N00",
  "device": {
    "deviceDateTime": "2023-12-10T10:34:12Z",
    "model": "100",
    "receivedDateTime": "2023-12-10T10:34:12Z",
    "isDeviceConnectedToPower": true,
    "brand": "2"
  },
  "inspection": [
    {
      "inspectionType": "REMOTE",
      "inspectionDate": "2023-12-10T10:34:12Z",
      "expiryDate": "2023-12-10T10:34:12Z",
      "inspectionResult": "PASSED"
    }
  ]
}
""";
  }
}
