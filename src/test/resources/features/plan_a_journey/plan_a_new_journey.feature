Feature: Plan a new journey

  Scenario: Plan a new journey
    Given that Connie is a London commuter
    When she plans a journey from Waterloo to Canary Wharf departing at 09:00
    Then she should see that the fastest train departs at 08:59

  Scenario Outline: Plan many a journey
    Given that Connie is a London commuter
    When she plans a journey from <departure> to <destination> departing at <plannedDepartureTime>
    Then she should see a trip on the <line> line departing at <departureTime>
    Examples:
      | departure     | destination  | line                         | plannedDepartureTime | departureTime |
      | Waterloo      | Canary Wharf | Jubilee line to Canary Wharf | 09:00                | 08:59         |
      | London Bridge | Moorgate     | Northern line to Moorgate    | 10:00                | 09:59         |

  Scenario: Coordinating journeys
    Given that Connie is a London commuter
    And that Charles is a London commuter
    When Connie plans a journey from Waterloo to Canary Wharf departing at 09:00
    And Charles plans a journey from London Bridge to Moorgate departing at 10:00
    Then Connie should see a trip on the Jubilee line to Canary Wharf line departing at 08:59
    And Charles should see a trip on the Northern line to Moorgate line departing at 09:59

