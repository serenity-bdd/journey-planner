Feature: Plan a new journey

  In order to get to waste less time in public transport
  As a London commuter
  I want to know the quickest way to get between any two tube stations

  Scenario: Plan a new journey
    Given that Connie is a London commuter
    When she plans a journey from Waterloo to Canary Wharf departing at 09:00 next MONDAY
    Then she should see that the fastest train departs at 08:59

  Scenario Outline: Plan many a journey
    Given that Connie is a London commuter
    When she plans a journey from <departure> to <destination> departing at <plannedDepartureTime> next <departureDay>
    Then she should see a trip on the <line> line departing at <departureTime>
    Examples:
      | departure     | destination  | line                         | plannedDepartureTime | departureTime | departureDay |
      | Waterloo      | Canary Wharf | Jubilee line to Canary Wharf | 09:00                | 08:59         | MONDAY       |
      | London Bridge | Moorgate     | Northern line to Moorgate    | 10:00                | 09:59         | TUESDAY      |

  @coordinated
  Scenario: Coordinating journeys
    Given that Connie is a London commuter
    And that Connor is a London commuter
    When Connie plans a journey from Waterloo to Canary Wharf departing at 09:00 next MONDAY
    And Connor plans a journey from London Bridge to Moorgate departing at 10:00 next TUESDAY
    Then Connie should see a trip on the Jubilee line to Canary Wharf line departing at 08:59
    And Connor should see a trip on the Northern line to Moorgate line departing at 09:59

